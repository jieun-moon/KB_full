package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.common.util.UploadFiles;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j
public class BoardAttachmentVO {
    private Long no; //
    private Long bno; //FK: Board의 no => FK가 있으므로 join처리 필요
    private String filename; //원본 파일명
    private String path; //서버에 저장된 파일 경로
    private String contentType; //파일 mime-type(신경쓰기) 테이블에서는 content_type(컬럼명)
    private Long size; //파일의 크기
    private Date regDate; // 등록일(신경쓰기) reg_date(컬럼명) => 카멜케이스는 mybatis에 설정해둠! 자동처리됨

    //팩토리 메서드 of 추가
//    part, bno, path 세가지 값을 받아서 BoardAttachmentVO 객체 생성
    public static BoardAttachmentVO of(MultipartFile part, Long bno, String path) { //path: 업로드된 파일 경로
        return builder()
                .bno(bno)
                .filename(part.getOriginalFilename())
                .path(path)
                .contentType(part.getContentType())
                .size(part.getSize())
                .build();
    }

//    EL에서는 size로 출력
//    getFileSize: property명
//    사이즈를 보기 쉬운 포맷 형식으로 변환해준다
    public String getFileSize(){
        return UploadFiles.getFormatSize(size);
    }
}
