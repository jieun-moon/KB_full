package org.scoula.ex04;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //MIME 타입 설정
        
        //자바I/O
        PrintWriter out = response.getWriter();
        
        //html 작성 및 출력
        out.print("<html><body>");
        out.print("");
        out.print("</body></html>");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //한글 깨짐 방지 - 있을 때와 없을 때 결과 확인
        doGet(request, response);
    }
}
