package org.scoula.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    private Long no;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updateDate;

    //첨부 파일
    private List<BoardAttachmentVO> attaches;

//    VO와 달라지게 함(MultipartFile에 대한 Lsit)
//    VO랑 다르게 클래스 사용 가능
    List<MultipartFile> files = new ArrayList<>(); //실제 업로드된 파일(Multipart) 목록
//DTO는 form에 대응. files: <input type="file" name="files">
//    files 자체는 board 테이블하고 상관 없음
//    업로드 기능 캡슐화 => 객체 지향에서 중요한 사항
//    캡슐화 시켰으므로 컨트롤러 수정 없음

    //static 메소드. of: 이름, 리턴: BoardDTO
    //static: 클래스로 접근
    //VO -> DTO 변환
    public static BoardDTO of(BoardVO vo){
    //VO가 null이면 null 반환, null이 아니면 BoardDTO로 변환해줌
        return vo == null ? null : BoardDTO.builder()
                .no(vo.getNo())
                .title(vo.getTitle())
                .writer(vo.getWriter())
                .content(vo.getContent())
                .attaches(vo.getAttaches())
                .regDate(vo.getRegDate())
                .updateDate(vo.getUpdateDate())
                .build();
    }

    //인스턴스 메소드
    //반환값: BoardVO
    //DTO -> VO 변환
    public BoardVO toVo(){
        return BoardVO.builder()
                .no(no)
                .title(title)
                .writer(writer)
                .content(content)
                .attaches(attaches)
                .regDate(regDate)
                .updateDate(updateDate)
                .build();
    }
//
}
