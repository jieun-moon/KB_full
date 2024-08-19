package org.scoula.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.domain.BookVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {

    private Integer id;
    private String title;
    private String author;
    private Boolean available;


    public static BookDTO of(BookVO vo){
        //VO가 null이면 null 반환, null이 아니면 BoardDTO로 변환해줌
        return vo == null ? null : BookDTO.builder()
                .id(vo.getId())
                .title(vo.getTitle())
                .author(vo.getAuthor())
                .available(vo.getAvailable())
                .build();
    }

    //인스턴스 메소드
    //반환값: BoardVO
    //DTO -> VO 변환
    public BookDTO toVo(){
        return BookDTO.builder()
                .id(id)
                .title(title)
                .author(author)
                .available(available)
                .build();
    }
//
}
