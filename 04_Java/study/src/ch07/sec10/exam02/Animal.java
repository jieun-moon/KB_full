package ch07.sec10.exam02;

public abstract class Animal {
    //메소드 선언
    public void breathe(){
        //아래 sout은 구현이 된 상태
        System.out.println("숨을 쉽니다.");
    }

    //추상 메소드 선언
    public abstract void sound();
}
