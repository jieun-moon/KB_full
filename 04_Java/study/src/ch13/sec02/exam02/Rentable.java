package ch13.sec02.exam02;

public interface Rentable<P> {
    //함수 뒤에 중괄호가 없다(구현체가 없음)
    //상속 받아서 쓰려고 하는 애라 껍데기만 있음
    //P타입으로 리턴하겠다는 리턴값
    //인터페이스는 객체가 없음
    //무조건 인터페이스에 넣어준 타입을 리턴해줘야 하는 메소드
    P rent();
}
