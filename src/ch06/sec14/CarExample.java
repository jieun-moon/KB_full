package ch06.sec14;

import com.sun.security.jgss.GSSUtil;

public class CarExample {
    public static void main(String[] args) {
        //객체 생성
        Car myCar = new Car();

        //잘못된 속도 변경
        //잘못된 값이 들어갔을 경우 set 메소드에서 0으로 처리해준다
        //사용자들은 해당 로직을 알 필요가 없으므로 캡슐화해줌
        myCar.setSpeed(-50);
        System.out.println("현재 속도: " + myCar.getSpeed());

        //올바른 속도 변경
        myCar.setSpeed(60);
        System.out.println("현재 속도: " + myCar.getSpeed());

        //멈춤
        if(!myCar.isStop()){
            myCar.setStop(true);
        }
        System.out.println("현재 속도: " + myCar.getSpeed());
    }
}
