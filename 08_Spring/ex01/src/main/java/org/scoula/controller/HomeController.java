package org.scoula.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//Java Bean으로 등록이 됨(이전에는 Component라는 어노테이션 사용)
@Slf4j //Lombok 제공, log()라는 멤버 변수가 생긴다
public class HomeController {
//    @GetMapping: GET 메소드로 "/"에 접근 시 home() 실행
    @GetMapping("/")
    public String home() {
        //informnation 레벨로 출력하라
        log.info("=================> HomeController /");
        return "index"; //View의 이름

        //System.out.println(); 이제부터 안씀
        //콘솔 출력은 개발자를 위한 설정이므로
    }
}
