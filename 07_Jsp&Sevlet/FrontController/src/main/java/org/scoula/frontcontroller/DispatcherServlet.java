package org.scoula.frontcontroller;

import org.scoula.frontcontroller.command.Command;
import org.scoula.frontcontroller.controller.HomeController;
import org.scoula.frontcontroller.controller.TodoController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static jdk.vm.ci.code.RegisterAttributes.createMap;

//@WebServlet 어노테이션은 부모클래스에 못 붙임(어노테이션은 상속되지 않음)
//annotaion은 자식이 붙이는 것
public class DispatcherServlet extends HttpServlet {
    //Map이 2개인 이유: 요청별로 가짐
    Map<String, Command> getMap; //Get 요청 mapping
    Map<String, Command> postMap; //Post 요청 mapping

    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";


    @Override
    public void init() {
        //CLI에서 menu 역할
        getMap = new HashMap<>();
        postMap = new HashMap<>();
        //CLI framework에서 createMenu의 구조와 동일
        createMap(getMap, postMap);
        //CLI에서 add Menu에 해당. "/"일때 homeController::getIndex 실행해야 한다
    }

    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {

    }

    //후속처리(redirect인지, forward인지 판정)
    public void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //viewName: 리턴되는게 문자열 => view의 이름을 나타냄(어느 view로 forwarding 할건가)
        String viewName = command.execute(request, response);

        if(viewName.startsWith("redirect:")) { //redirect 처리
            //redirect 뒷 부분 추출
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else { //forward 처리
            String view = prefix + viewName + suffix;
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = getCommand(request);
        if (command != null) {
            execute(command, request, response);
        } else { //404 에러 처리
            String view = prefix + "404" + suffix;
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    private String getCommandName(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest request) {
        //request를 담당하는 Command 객체를 return
        String commandName = getCommandName(request);

        Command command = getMap.get(commandName);
        if(request.getMethod().equalsIgnoreCase("GET")) {
            command=getMap.get(commandName);
        } else { //404에러의 경우 null이 됨
            command=postMap.get(commandName);
        }
        return command;
    }
}
