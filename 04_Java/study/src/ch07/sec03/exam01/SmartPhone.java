package ch07.sec03.exam01;

//phone 클래스의 자식 클래스
public class SmartPhone extends Phone {
    //필드선언
    public boolean wifi;

    //생성자 선언
    public SmartPhone(String model, String color) {
        //super 키워드로 부모의 기본 생성자를 호출해줌
        //해당 코드는 없어도 기본적으로 동작함
        super();
        this.model = model;
        this.color = color;
        System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
    }
}
