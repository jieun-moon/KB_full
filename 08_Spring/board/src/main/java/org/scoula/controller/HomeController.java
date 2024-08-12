package org.scoula.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//Java Bean으로 등록이 됨(이전에는 Component라는 어노테이션 사용)
@Slf4j
public class HomeController {
    @GetMapping("/")
    public String home() {
        //informnation 레벨로 출력하라
        log.info("=================> HomeController /");
        return "index"; //View의 이름
//        return "redirect:/board/list";
        //System.out.println(); 이제부터 안씀
        //콘솔 출력은 개발자를 위한 설정이므로
    }
}
