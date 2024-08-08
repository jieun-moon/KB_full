package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //Controller 기능을 하는 Bean 등록
//Controller는 servletContext에 등록되어야함
@Log4j
@RequestMapping("/board") //url 공통 주소 할당
@RequiredArgsConstructor //생성자 주입
public class BoardController {
    //controller가 의존하는건 service
    final private BoardService service;

//    요청 경로를 뷰 이름으로 대체 board/list(리턴값이 void기 때문에)
//    localhost:8080/board/lsit
    @GetMapping("/list")
    public void list(Model model){
//        return 타입 void:
        log.info("list");
//        ${lsit}
//        "list": 키
//model의 속성에 데이터를 담을 경우 뷰로 전달 가능
        model.addAttribute("list", service.getList());
    }

    @GetMapping("/create")
    public void create(){
        log.info("create");
    }

    //단위테스트는 post만 해주면 됨
    //form 데이터(사용자가 입력한 데이터)를 어떻게 넘기나(body part에 있는 것)
    @PostMapping("/create")
    public String create(BoardDTO board){
//        redirect해야해서 문자열이 리턴타입
        log.info("create: " + board);
//        service > mapper.java > mapper.xml
        service.create(board);
//        redirect할대는 절대 경로이므로 앞에 루트(/) 붙여줘야함
//        게시물 목록 페이지로 redirect
        return "redirect:/board/list";
    }

    @GetMapping({"/get", "/update"})
    public void get(@RequestParam("no") Long no, Model model){
        log.info("/get or update");
        model.addAttribute("board", service.get(no));
    }

    @PostMapping("/update")
    public String update(BoardDTO board){
        log.info("update: " + board);
        service.update(board);
        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no){
        log.info("delete: " + no);
        service.delete(no);

        return "redirect:/board/list";
    }
}
