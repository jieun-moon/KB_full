package org.scoula.ex04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request_redirect")
public class RequestRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //속성 설정
        //아래 정보는 아무 의미가 없어져버림
//        아래 정보는 세션에 저장
        //해당 요청은 내부에서 쓰이지 않으므로 무의미하다
        request.setAttribute("username", "홍길동");
        request.setAttribute("useraddress", "서울");

        //redirect
        //response_redirect URL로 리다이렉트 시킨다
        //response_redirect: 상대 경로
        response.sendRedirect("response_redirect");

    }
}
