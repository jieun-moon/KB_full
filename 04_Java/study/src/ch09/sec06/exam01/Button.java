package ch09.sec06.exam01;

public class Button {
    //정적 멤버 인터페이스
    public static interface ClickListener {
        //추상 메소드
        //인터페이스는 디폴트로 추상메소드
        //추상 메소드는 구현체가 없음
        void onClick();
    }
}
