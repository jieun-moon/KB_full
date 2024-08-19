package org.scoula.common.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.File;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.io.IOException;

public class UploadFiles {
    public static String upload(String baseDir, MultipartFile part) throws IOException {
        //기본 디렉토리가 있는지 확인, 없으면 새로 생성
//        String baseDir: 어디에 저장할지 고정할 수 없으므로 변수 처리
        File base = new File(baseDir);
        if (!base.exists()) {
            base.mkdirs(); //중간에 존재하지 않는 디렉토리까지 모두 생성
//            mkdis: /a/b/c에서 중간에 b가 없으면 실패
//            mkdirs: 중간에 없는 디렉토리도 함께 만들어라
        }

        String fileName = part.getOriginalFilename();
        //getOriginalFilename: 원본 파일명
//        base 디렉토리 내에 고유한 이름을 가지는 파일 생성
        File dest = new File(baseDir, UploadFileName.getUniqueName(fileName));
//        getUniqueName: timeStamp 찍은 새로운 파일명
//        new File(부모디렉토리, 파일명)
        part.transferTo(dest); //MultipartFile에 이미 파일로 저장돼있음(서블릿에 의해) 지정한 경로로 업로드 파일 이동
//        IO 작업이므로 part.transferTo(dest)에서 예외 발생할 수 있음. 그래서 throws IOException로 던지기

        return dest.getPath(); //저장된 서버상의 경로로 파일 경로 리턴
//        dest.getPath(): table의 Path 컬럼에 저장
    }

//    Math.log(size): 자리수
//    파일 크기를 사람이 읽기 쉬운 형식으로 변환
//    1,225,957 바이트 > "1.2MB"
//    class는 static으로 접근. static이 아닐 경우 new로 생성자, 객체 만들어서 접근
    public static String getFormatSize(Long size){
//        파일 크기가 0 이하일 경우 "0"을 반환
        if(size <= 0)
            return "0";
//        파일 크기를 나타낼 단위를 정의(Bytes, KB, MB, GB, TB)
        final String[] units = new String[]{"Bytes", "KB", "MB", "GB", "TB"};
//        파일 크기가 어느 단위에 속하는지 계산(예: KB, MB 등)
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
//        #,##0.#: 소숫점 이하 한자리만 출력
//        파일 크기를 계산된 단위로 변환하고 포맷팅하여 문자열로 반환
        return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

//    controller에서 다운받을때 과정을 담은 코드
//    파일의 다운로드를 처리해주는 메소드
    public static void download(HttpServletResponse response, File file, String orgName) throws IOException {
//        response의 contentType을 다운로드 파일로 설정
//        응답 헤더의 일부
        response.setContentType("application/download");
//        파일의 크기를 response에 설
        response.setContentLength((int)file.length()); //length: 파일 크기

//        한글 파일명을 URL 인코딩(필수)
        String filename = URLEncoder.encode(orgName, "UTF-8"); //한글 파일명인 경우 인코딩 필수
//        일반 헤더 설정(첫번째 인자: 헤더의 key, 두번째 인자: 값)
//        Content-Disposition: 디폴트 파일명 제시
//        주의사항: url 인코딩은 UTF-8
//        response 헤더에 파일 다운로드 정보 설정
//        따로 함수가 없는 경우에는 setHeader 함수에 정보를 설정해줘야 한다
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
//여기까지가 헤더 설정

//        우리가 보낼 파일이 텍스트인지, 이미지인지 모름 =>
//          outputStream:
//        response의 형태를 알 수 없기 때문에 OutputStream 사용
        try(OutputStream os = response.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os)) {
            //        (원본 파일의 Path, outputstream)
//            copy: 여기서는 복사보다는 전송의 개념으로 사용
//            원본 파일을 스트림으로 전송(복사)
            Files.copy(Paths.get(file.getPath()), bos);
        }
    }
}
