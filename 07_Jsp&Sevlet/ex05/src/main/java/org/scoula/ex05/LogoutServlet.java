package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        Member member = new Member("홍길동", request.getRequestedSessionId());
        session.removeAttribute(member.getUserid());

        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        if(session != null){
            session.removeAttribute(request.getRemoteUser());
        } else {
            out.print("로그아웃에 실패했습니다."+"<br>");
        }
        out.print("</body></html>");


        request.getRequestDispatcher("/logout.jsp").forward(request, response);
    }

}
