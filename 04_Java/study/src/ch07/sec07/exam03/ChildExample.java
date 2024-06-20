package ch07.sec07.exam03;

public class ChildExample {
    public static void main(String[] args) {
        //객체 생성 및 자동 타입 변환
        Parent parent = new Parent();

        //Parent 타입으로 필드와 메소드 사용
        parent.field1="data1";
        parent.method1();
        parent.method2();
        /* //부모로 만든 객체는 자식의 필드와 메소드 접근 불가능
        parent.filed2 = "data2"; //(불가능)
        parent.method3(); //(불가능)
         */

        //강제 타입 변환
        //Child 타입으로 바꾸고 나서는 자식의 필드 메소드 접근 가능
        Child child = (Child) parent;

        //Child 타입으로 필드와 메소드 사용
        child.field2 = "data2"; //(가능)
        child.method3(); //(가능)
    }
}
