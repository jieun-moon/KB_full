package ch09.sec04.exam01;

public class A {
    //로컬 클래스는 생성자나 메소드 내에서 선언된 클래스
    //생성자
    A(){
        //로컬 클래스 선언
        class B { }

        //로컬 객체 생성
        B b = new B();
    }

    //위의 생성자 안에 선언된 B는 위의 클래스가 실행된 후 사라지므로,
    //아래 메소드의 B와 다른 클래스
    //메소드
    void method(){
        //로컬 클래스 선언
        class B { }

        //로컬 객체 생성
        B b = new B();
    }
}

