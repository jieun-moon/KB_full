package org.scoula.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

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
        File dest = new File(baseDir, UploadFileName.getUniqueName(fileName));
//        getUniqueName: timeStamp 찍은 새로운 파일명
//        new File(부모디렉토리, 파일명)
        part.transferTo(dest); //MultipartFile에 이미 파일로 저장돼있음(서블릿에 의해) 지정한 경로로 업로드 파일 이동
//        IO 작업이므로 part.transferTo(dest)에서 예외 발생할 수 있음. 그래서 throws IOException로 던지기

        return dest.getPath(); //저장된 서버상의 경로로 파일 경로 리턴
//        dest.getPath(): table의 Path 컬럼에 저장
    }

//    Math.log(size): 자리수
    public static String getFormatSize(Long size){
        if(size <= 0)
            return "0";
        final String[] units = new String[]{"Bytes", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
//        #,##0.#: 소숫점 이하 한자리만 출력
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
