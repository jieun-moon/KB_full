package org.scoula.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor //final과 짝꿍
@RequestMapping("/api/member")
public class MemberController {
    final MemberService service;

//    @PathVariable: 경로 상의 username을 변수 처리(이름 일치해야 함)
    @GetMapping("/checkusername/{username}")
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username){
//        주어진 사용자 이름의 중복 여부 체크하고 결과를 ResponseEntity로 반환
        return ResponseEntity.ok().body(service.checkDuplicate(username));
        //ResponseEntity: 추가 정보 담아주려고 사용
//        ok: 상태표시(200)
//        <Boolean>에 들어가는건 body의 리턴값
    }

    @PostMapping("")
    public ResponseEntity<MemberDTO> join(MemberJoinDTO member){
//        ok 안에 body 넣은거랑 같은 코드
//        회원 가입 처리하고 가입된 회원 정보를 ResponseEntity로 반환
        return ResponseEntity.ok(service.join(member));
    }

}
