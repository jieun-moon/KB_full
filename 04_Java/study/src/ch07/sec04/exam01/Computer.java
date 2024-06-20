package ch07.sec04.exam01;



public class Computer extends Calculator {
    //override 단축키: ctrl + o(영문 o)
    @Override
    public double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        return super.areaCircle(r);
    }
//    @Override
//    public double areaCircle(double r) {
//        System.out.println("Computer 객체의 areaCircle() 실행");
//    }

}
