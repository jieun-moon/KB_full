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

    public static void download(HttpServletResponse response, File file, String orgName) throws IOException {
        response.setContentType("application/download");
        response.setContentLength((int)file.length());

        String filename = URLEncoder.encode(orgName, "UTF-8"); //한글 파일명인 경우 인코딩 필수
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        try(OutputStream os = response.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os)) {
            Files.copy(Paths.get(file.getPath()), bos);
        }
    }
}
