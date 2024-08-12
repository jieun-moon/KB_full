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
    private List<BoardAttachmentVO> attaches;
    //아래 두개는 이름이 다름(DB의 이름과 VO 객체의 이름이 다름)
    // MyBatis에게 알려줘야함
    private Date regDate;
    private Date updateDate;
}
