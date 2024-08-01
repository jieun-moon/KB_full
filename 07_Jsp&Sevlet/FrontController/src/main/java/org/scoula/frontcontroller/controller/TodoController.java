package org.scoula.frontcontroller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TodoController {
    //상속받는것 없음. 역시 POJO
    public String getList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //getList할 떄 문자열 Arrays 준비. "todoList"라는 이름으로 list 넣기(view에 전달할 데이터 넣기)
        //${todoList}로 접근
        //todo 변수명이 EL의 변수명
        List<String> list = Arrays.asList("Todo 1", "Todo 2", "Todo 3");
        request.setAttribute("todoList", list);
        System.out.println("GET/todo/list");
        return "todo/list";
        // "todo/list": /WEB-INF/views/todo/list.jsp가 됨
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET/todo/view");
        return "todo/view";
    }

    public String getCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET/todo/create");
        return "todo/create";
    }

    public String postCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("POST/todo/create");
        return "redirect:/todo/list";
    }

    public String getUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET/todo/update");
        return "todo/update";
    }

    public String postUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("POST/todo/update");
        return "redirect:/todo/list";
    }

    public String postDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("POST/todo/delete");
        return "redirect:/todo/list";
    }
}
