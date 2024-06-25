package ch09.sec06.exam03;

import java.awt.event.ActionListener;

public class ButtonExample {
    public static void main(String[] args) {
        //Ok 버튼 객체 생성
        Button btnOk = new Button();

        //Ok 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
        //로컬 클래스: 메소드 혹은 생성자 안에 있으면 로컬 클래스
        //main 메소드 내에 위치한 클래스
        class OkListener implements Button.ClickListener {
//          //ClickListener의 onClick 메소드를 오버라이딩
            @Override
            public void onClick() {
                System.out.println("Ok 버튼을 클릭했습니다.");
            }
        }

        //Ok 버튼 객체에 ClickListener 구현 객체 주입
//      //OkListener는 ClickListener를 상속받았기 때문에 ClickListener 타입으로 주입 가능(업케스팅)
        btnOk.setClickListener(new OkListener());

        //Ok 버튼 클릭하기
        btnOk.click();

        //Cancel 버튼 객체 생성
        Button btnCancel = new Button();

        //Cancel 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
        class CancelListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("Cancel 버튼을 클릭했습니다.");
            }
        }

        //Cancel 버튼 객체에 ClickListener 구현 객체 주입
        btnCancel.setClickListener(new CancelListener());

        //Cancel 버튼 클릭하기
        btnCancel.click();
    }
}
