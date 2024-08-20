package org.scoula.controller;

import lombok.extern.log4j.Log4j;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Log4j
@RequestMapping("/security")
@Controller
public class SecurityController {
    @GetMapping("/all") //모두 접근 가능
    public void doAll(){
        log.info("do all can access everybody");
    }

//    @GetMapping("/member") //MEMBER 또는 ADMIN 권한 필요
//    public void doMember(){
//        log.info("logined Member");
//    }

//    @GetMapping("/admin") //ADMIN 권한 필요
//    public void doAdmin(){
//        log.info("admin only");
//    }

    @GetMapping("/login")
    public void login(){
        log.info("login page");
    }

    @GetMapping("/logout")
    public void logout(){
        log.info("logout page");
    }

//    name 추출하는 방법(Principal 사용)
//    @GetMapping("/member")
//    public void doMember(Principal principal){
//        log.info("username = " + principal.getName());
//    }
//
//    UserDetails 추출하는 방법(Authentication 사용)
    @GetMapping("/member")
    public void doMember(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        log.info("username= " + userDetails.getUsername());
    }
//커스텀한 User 정보 추출하는 방법(@AuthenticationPrincipal 사용)
    @GetMapping("/admin")
    public void doAdmin(@AuthenticationPrincipal CustomUser customUser){
        MemberVO member = customUser.getMember();

        log.info("username= " + member);
    }


}
