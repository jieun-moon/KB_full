package ch15.sec03.exam02;

import lombok.AllArgsConstructor;

//생성자 생략된 경우 사용하면 됨
@AllArgsConstructor

public class Member {
    public String name;
    public int age;

    //생성자 생략..
//    public Member(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

    //hashCode 재정의
    //hashCode를 재정의한걸 주석처리하면 총 객체 수는 2가 출력
    @Override
    public int hashCode() {
        return name.hashCode()+age;
    }

    //equals 재정의
    @Override
    public boolean equals(Object obj) {
//        obj가 Member 타입일 경우 target이란 이름의 객체로 다운캐스팅해줌
        if(obj instanceof Member target) {
            return target.name.equals(name) && (target.age==age);
        }else{
            return false;
        }
    }
}
