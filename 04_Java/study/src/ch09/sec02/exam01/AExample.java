package ch09.sec02.exam01;

public class AExample {
    public static void main(String[] args) {
        //A객체 생성
        A a = new A();

        //B객체 생성
        //A클래스 내에 있는 B클래스 타입이므로 A.B로 표시
        //인스턴스 멤버는 객체 이름으로 접근해야 하기 때문에 a.new B()
        A.B b = a.new B();
    }
}
