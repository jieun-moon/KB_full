package org.scoula.ex03.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller: Java Bean으로 등록됨
@Controller
//@Slf4j: Lombok 제공, log()라는 멤버 변수가 생긴다
@Slf4j
public class HomeController {
    //@GetMapping: Get 메소드로 "/"에 접근시 home() 실행
    @GetMapping("/")
    public String home(Model model) {
        //Model model: Map
        //Model: 결과 데이터를 담아 view에 전달
        //Key와 Value 쌍으로 Model에 저장
        //request scope에 저장되며, view에서 사용 가능
        model.addAttribute("name", "홍길동");
        //"name"(키의 이름): jsp로 넘어감
        return "index"; //View의 이름
    }
}
