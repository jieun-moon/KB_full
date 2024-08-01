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
    //Map은 인터페이스로 New Map할 수 없음
    //그러므로 구현 클래스인 HashMap으로 객체 생성
    Map<String, Command> getMap; //Get 요청 mapping
    Map<String, Command> postMap; //Post 요청 mapping

    //뷰의 기본 경로와 확장자를 설정해준다
    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";


    //servlet 초기화 메소드
    @Override
    public void init() {
        //CLI에서 menu 역할
//        HashMap은 Map을 구현한 거니까 하위 맵이므로 upcasting
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
        //Command의 실행결과는 jsp의 이름으로 받아옴
        // Command에서 리턴해주는 같은 값으로 리턴해줘야함
        //viewName: 리턴되는게 문자열 => view의 이름을 나타냄(어느 view로 forwarding 할건가)
        String viewName = command.execute(request, response);

        if(viewName.startsWith("redirect:")) { //redirect 처리
            //redirect 뒷 부분 추출
            //redirect로 처리할 경우 view의 경로에서 "redirect:"를 제외하고 띄운다
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else { //forward 처리
            //가지고 온 뷰의 이름에 "/views/"를 앞에, ".jsp"를 뒤에 붙여준다.
            String view = prefix + viewName + suffix;
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }
    }

    //Get 요청을 처리해주는 메소드
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

    //요청 URL에서 식별값만 잘라서 return 해주는 메소드
    private String getCommandName(HttpServletRequest request) {
        String requestURI = request.getRequestURI(); //"/context값/식별값"
        String contextPath = request.getContextPath(); //"context값"
        //subString(시작인덱스): 해당 인덱스부터 문자열을 잘라준다
        return requestURI.substring(contextPath.length()); //"/식별값"
    }

    //요청 URL에서 식별값에 해당하는 Command를 return 해주는 메소드
    private Command getCommand(HttpServletRequest request) {
        //request에서 command 이름만 추출
        //request를 담당하는 Command 객체를 return
        String commandName = getCommandName(request);

        Command command = getMap.get(commandName);
        //equalsIgnoreCase("GET"): "get"이라는 단어와 대소문자 구분 없이 비교하겠다
        //request에서 받아온 메서드가 GET이면 getMap에서 command 찾기
        if(request.getMethod().equalsIgnoreCase("GET")) {
            command=getMap.get(commandName);
        } else { //404에러의 경우 null이 됨
            //request에서 받아온 메서드가 POST면 postMap에서 command 찾기
            command=postMap.get(commandName);
        }
        return command;
    }
}
