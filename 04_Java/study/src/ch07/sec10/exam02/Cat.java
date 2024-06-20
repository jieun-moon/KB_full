package ch07.sec10.exam02;

public class Cat extends Animal {
    //중괄호 안에 아무 내용이 써있지 않으면 public~Animal에 빨간 줄
    //alt + enter 눌러서 수정사항 선택(implement methods)
//    @Override
//    public void sound() {
//
//    }
    @Override
    public void sound() {
        System.out.println("야옹");
    }
}
