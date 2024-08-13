package org.scoula.common.util;

public class UploadFileName {
    public static String getUniqueName(String filename){ //filename: 원본 파일명
//        이름 파트, 확정명 파트 분리
//        xx.xx.xx: 뒤에서부터 찾기(lastIndexOf
        int ix = filename.lastIndexOf(".");
        String name = filename.substring(0, ix); //파일명 추출. ix는 포함X
        String ext = filename.substring(ix+1); //확장명 추출. "."뒷부분 부터 +1 끝까지(end가 없으므로)

//        System.currentTimeMillis(): TimeStamp
        return String.format("%s-%d.%s", name, System.currentTimeMillis(), ext);
    }
}
