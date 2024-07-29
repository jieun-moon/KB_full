package org.scoula.ex03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        POST 메소드의 경우 기본값 인코딩은 한글이 깨지므로 UTF-8 변경 필수!
        request.setCharacterEncoding("UTF-8"); //한글 깨짐 방지 - 있을 때와 없을 때 결과 확인
//        GET 메소드와 동일한 로직을 처리하고 싶으므로 doGet 재호출
        doGet(request, response);
    }

    //    GET 메소드로 보낸 데이터를 받아오기 위해서는 doGet 메소드 사용
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //요청에서 파라미터 얻기
        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");


        //응답얻기
        response.setContentType("text/html;charset=UTF-8");

        //자바I/O
        PrintWriter out = response.getWriter();

        //html 작성 및 출력
        out.print("<html><body>");
        out.print("아이디값: " + userid + "<br>");
        out.print("비밀번호값: " + passwd + "<br>");
        out.print("</body></html>");
    }
}
