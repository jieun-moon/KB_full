package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller //Controller 기능을 하는 Bean 등록
//Controller는 servletContext에 등록되어야함
@Log4j
@RequestMapping("/board") //url 공통 주소 할당
@RequiredArgsConstructor //생성자 주입
public class BoardController {
    //controller가 의존하는건 service
    final private BoardService service;

//    요청 경로를 뷰 이름으로 대체 board/list(리턴값이 void기 때문에)
//    localhost:8080/board/lsit
    @GetMapping("/list")
    public void list(Model model){
//        return 타입 void:
        log.info("list");
//        ${lsit}
//        "list": 키
//model의 속성에 데이터를 담을 경우 뷰로 전달 가능
        model.addAttribute("list", service.getList());
    }

    @GetMapping("/create")
    public void create(){
        log.info("create");
    }

    //단위테스트는 post만 해주면 됨
    //form 데이터(사용자가 입력한 데이터)를 어떻게 넘기나(body part에 있는 것)
    @PostMapping("/create")
    public String create(BoardDTO board){
//        redirect해야해서 문자열이 리턴타입
        log.info("create: " + board);
//        service > mapper.java > mapper.xml
        service.create(board);
//        redirect할대는 절대 경로이므로 앞에 루트(/) 붙여줘야함
//        게시물 목록 페이지로 redirect
        return "redirect:/board/list";
    }

    @GetMapping({"/get", "/update"}) //"/get"과 "/update" 경로를 둘다 처리
    //@RequestParam: 주소 뒤에 ?를 붙여서 쿼리스트링으로 정보를 받아준다
    //("no")과 Long no가 같은 경우 no 생략 가능.
    public void get(@RequestParam("no") Long no, Model model){
        log.info("/get or update");
//        Model 객체는 데이터를 view로 전달하기 위해 사용
        model.addAttribute("board", service.get(no));
    }

    @PostMapping("/update")
    public String update(BoardDTO board){
        log.info("update: " + board);
        service.update(board);

//        수정한 후 목록 페이지로 리다이렉트
        return "redirect:/board/list";
    }

    @PostMapping("/delete") //화면상 상세보기에서 진행되므로 get 요청 없음
    public String delete(@RequestParam("no") Long no){
        log.info("delete..." + no);
        service.delete(no);

        //        수정한 후 목록 페이지로 리다이렉트
        return "redirect:/board/list";
    }

    @GetMapping("/download/{no}")
    @ResponseBody //view를 사용하지 않고, 직접 내보냄.(json 형태로 받아올 때 주로 사용)
//    Response의 Body를 직접 controller가 결정하겠다. forwarding이나, redirect 하지 말라는 의미
    public void download(@PathVariable("no") Long no, HttpServletResponse response) throws Exception{
//        받아온 번호에 해당하는 첨부 파일 가져오기
        BoardAttachmentVO attach = service.getAttachment(no);
        File file = new File(attach.getPath());
//          해당 부분에서 실제 파일 다운로드 작업
        UploadFiles.download(response, file, attach.getFilename());
    }
}
