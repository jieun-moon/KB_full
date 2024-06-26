package ch12.sec04;

public class ErrExample {
    public static void main(String[] args) {
//        콘솔 출력
        try{
            int value = Integer.parseInt("1oo");
        } catch (NumberFormatException e){
//        System.err: 콘솔에서 에러 내용을 출력해주는 기능
            System.out.println("[에러 내용]");
            System.out.println(e.getMessage());
        }
    }
}
