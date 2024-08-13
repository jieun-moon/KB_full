package org.scoula.common.util;

public class UploadFileName {
    public static String getUniqueName(String filename){ //filename: 원본 파일명
//        이름 파트, 확정명 파트 분리
//        xx.xx.xx: 뒤에서부터 찾기(lastIndexOf
//        lastIndexOf(문자열): 뒤에서부터 해당 문자열을 찾아서 처음 등장하는 인덱스 반환
        int ix = filename.lastIndexOf(".");
//        subString(시작 인덱스, 끝인덱스+1): 시작인덱스부터 끝인덱스까지 문자열을 잘라냄
        String name = filename.substring(0, ix); //파일명 추출. ix는 포함X
//        subString에 시작인덱스만 있을 경우엔 시작인덱스부터 끝까지 잘라낸다
        String ext = filename.substring(ix+1); //확장명 추출. "."뒷부분 부터 +1 끝까지(end가 없으므로)

//        System.currentTimeMillis(): TimeStamp
//        파일명 뒤에 timeStamp를 붙여서 고유한 파일명으로 만들어줌
        return String.format("%s-%d.%s", name, System.currentTimeMillis(), ext);
    }
}
