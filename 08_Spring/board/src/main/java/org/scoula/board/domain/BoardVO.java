package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {
    private Long no;
    private String title;
    private String content;
    private String writer;
//    List:<Collection>이라는 태그를 써서 mapping 시킨다
//    게시글 하나에 여러개의 첨부파일이 추가될 수 있다
//    BoardVO: 게시글, BoardAttachmentVO: 첨부파일
    private List<BoardAttachmentVO> attaches;
//select문의 결과를 어떻게 채울 수 있나. join의 결과를 attaches로 구성
    private Date regDate;
    private Date updateDate;
    //아래 두개는 이름이 다름(DB의 이름과 VO 객체의 이름이 다름)
    // MyBatis에게 알려줘야함


}
