package org.scoula.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.board.domain.BoardVO;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    private Long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;

    //static 메소드. of: 이름, 리턴: BoardDTO
    //static: 클래스로 접근
    //VO -> DTO 변환
    public static BoardDTO of(BoardVO vo){
    //VO가 null이면 null 반환, null이 아니면 BoardDTO로 변환해줌
        return vo == null ? null : BoardDTO.builder()
                .no(vo.getNo())
                .title(vo.getTitle())
                .writer(vo.getWriter())
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
                .content(content)
                .writer(writer)
                .regDate(regDate)
                .updateDate(updateDate)
                .build();
    }
}
