package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

//@RestController: 모든 메서드에 @ResponseBody를 자동 추가
@RestController //@Controller: view 사용
//모든 메소드에 @ResponseBody 추가해줌 > 응답을 json으로 받아온다
@RequestMapping("/api/board") // 메소드들의 공통 url
@RequiredArgsConstructor //final이 붙은 필드로 생성자 만들어줌
@Slf4j //console창에 log찍어줌(log4j와 비슷). 로깅을 위한 어노테이션
public class BoardController {
    private final BoardService service;

//    GET :: http://localhost:8080/api/board
//    GetMapping안에 따옴표는 생략가능
//    @GetMapping("")
//    public List<BoardDTO> getList(){
//        return service.getList();
//    }

//    GET :: http://localhost:8080/api/board
    @GetMapping("")
    public ResponseEntity<List<BoardDTO>> getList(){ //리턴타입: BoardDTO의 List
//        상태코드가 200이고 body 타입이 List<BoardDTO>인 응답 객체를 리턴
        return ResponseEntity.ok(service.getList());
    }

//    GET :: http://localhost:8080/api/board/1
//    특정 게시글 조회
    @GetMapping("/{no}")
//    Long: 첫글자가 대문자 이므로 wrapper 클래스
//    no에 해당하는 목록 하나 가져오기
    public ResponseEntity<BoardDTO> getById(@PathVariable Long no){
        //        상태코드가 200이고 body 타입이 BoardDTO인 응답 객체를 리턴
        return ResponseEntity.ok(service.get(no));
    }

    //    POST :: http://localhost:8080/api/board/1
//    메소드가 다르면 주소가 중복돼도 상관 없음
//    새 게시글 생성
    @PostMapping("") //생성, Body 있음
//    json일때는 RequestBody(첨부파일 있어서 multipart 올때는 붙이면 안됨)
    public ResponseEntity<BoardDTO> create(BoardDTO board){
//        객체를 json 데이터 형태로 보낼 때는 @RequestBody 사용
//        post 요청시 대부분 사용
        return ResponseEntity.ok(service.create(board));
    }

    //    POST :: http://localhost:8080/api/board/26
//    기존 게시글 수정
    @PutMapping("/{no}") //수정, Body 있음
    //    @PathVariable int in로 하면, 405 에러 혹은 500 에러나므로 아래와 같이 수정!
//    @PathVariable int no (O)
//    @PathVariable("no") int no (O)
    public ResponseEntity<BoardDTO> update(@PathVariable Long no, BoardDTO board){
//        no 번호의 게시글을 @RequestBody에 담아온 데이터로 수정
//        mapper.xml 부분의 #{} 내에 있는 필드 값은 @RequestBody에 추가해 줄 것
//        소문자로 시작하는 primitive 타입은 null 값이 들어가면 예외 발생하기 때문에 되
//        도록이면 대문자로 시작하는 wrapper 객체 사용 권장(int > Long)
//        @PathVariable 변수 이름이 경로와 다를 경우 @PathVariable("no") Long id와 같이 이름 명시 필요
        return ResponseEntity.ok(service.update(board));
    }

    //    DELETE :: http://localhost:8080/api/board/26
//    기존 게시글 삭제
    @DeleteMapping("/{no}")
//    int: primitive type
//    만약 제시한 데이터가 실제로 없을 경우, null 배정 불가 => 명시적 에러
//    wrapper class type(Long, Integer) => null 배정 가능(에러 없이 넘어가면 됨)
//    보통 페이지 번호 넘길때 페이지가 전달 안됨
    public ResponseEntity<BoardDTO> delete(@PathVariable Long no){
        return ResponseEntity.ok(service.delete(no));
//        service.delete(no);
//        return ResponseEntity.ok().build();
//        이렇게 바꾸면 body 없이 상태 코드가 바뀜 => 제너릭 확장도 <BoardDTO>에서 ?표 변경
//        ?: 뭐든지 상관 없다
    }

    @GetMapping("/download/{no}")
    public void download(@PathVariable Long no, HttpServletResponse response) throws Exception {
        BoardAttachmentVO attachment = service.getAttachment(no);
        File file = new File(attachment.getPath());
        UploadFiles.download(response, file, attachment.getFilename());
    }

    @DeleteMapping("/deleteAttachment/{no}")
    public ResponseEntity<Boolean> deleteAttachment(@PathVariable Long no) throws Exception {
        return ResponseEntity.ok(service.deleteAttachment(no));
    }
}

