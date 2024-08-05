package org.scoula;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data //기본생성자 + Getter + Setter
@RequiredArgsConstructor //final이 붙은 필드를 무조건 생성자에 넣겠다
public class Restaurant {
    //Chef가 Bean으로 등록되어있어야 함
//    @Autowired //외부에서 의존성 주입해서 자동 연결하겠다
    //Autowired: private member여도 상관없음(자바의 reflection 기능 활용해서 외부에서 설정 가능하도록 함)
    //Reflection: private member 일지라도 외부에서 설정 가능
    final private Chef chef;
    //멤버 변수의 의존객체 Chef를 설정하는 방법
    //일반적인 의존 객체 설정법 (채워지지 않은 마름모로 유연하게 나타냄 ◇→)
    //Spring을 안썼으면 생성자 주입 => Restaurant(Chef chef);
    //Setter를 통해서 => void set Chef(Chef chef);

    //과거에는 생성자 앞에 @Autowired가 붙여졌음
    //Restaurant(chef chef) 생성자 만들어짐
    //만약, 생성자가 하나뿐이면, 매개변수에 주입.
    //Spring 4버전부터 추가된 기능
    //생성자가 한개인 경우에만 지원되는 기능
}
