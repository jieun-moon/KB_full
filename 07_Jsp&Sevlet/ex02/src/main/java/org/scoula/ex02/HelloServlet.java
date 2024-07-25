package org.scoula.ex02;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "MyServlet", urlPatterns = {"/xxx", "/yyy"})
public class HelloServlet extends HttpServlet {
    //servlet 제대로 종료됐을 때 불러주는 메소드
    @Override
    public void destroy() {
        System.out.println("destroy 호출");
    }

    //servlet 초기화
    @Override
    public void init() throws ServletException {
        System.out.println("init호출");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("HelloServlet 요청");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello Servlet</h1>");
    }

}