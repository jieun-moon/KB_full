package org.scoula.frontcontroller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TodoController {
    //todo 리스트 가져오기 메소드
    //상속받는것 없음. 역시 POJO
    public String getList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //getList할 떄 문자열 Arrays 준비. "todoList"라는 이름으로 list 넣기(view에 전달할 데이터 넣기)
        //${todoList}로 접근
        //todo 변수명이 EL의 변수명
        List<String> list = Arrays.asList("Todo 1", "Todo 2", "Todo 3");
        //todo 리스트를 만들어서 request scope 내에 세팅
        request.setAttribute("todoList", list);
        System.out.println("GET/todo/list");
        return "todo/list";
        // "todo/list": /WEB-INF/views/todo/list.jsp가 됨
    }

    //todo 리스트 상세보기 메소드
    public String getView(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET/todo/view");
        return "todo/view";
    }

    //todo 생성하기 메소드
    public String getCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET/todo/create");
        return "todo/create";
    }

    //todo 생성하기 메소드(리스트 목록으로 리다이렉트)
    public String postCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("POST/todo/create");
        return "redirect:/todo/list";
    }

    //todo 수정하기 메소드
    public String getUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET/todo/update");
        return "todo/update";
    }

    //todo 수정하기 메소드(리스트 목록으로 리다이렉트)
    public String postUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("POST/todo/update");
        return "redirect:/todo/list";
    }

    //todo 삭제하기 메소드(리스트 목록으로 리다이렉트)
    public String postDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("POST/todo/delete");
        return "redirect:/todo/list";
    }
}
