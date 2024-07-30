package org.scoula.ex04.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_delete")
public class CartDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //MIME 타입 설정
        response.setContentType("text/html; charset=UTF-8");

        //자바I/O
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("장바구니 비웠음!!");

        //세션객체 얻기
        HttpSession session = request.getSession(false);
        if(session != null) {
            //세션에 있는 모든 속성을 제거
            //로그인 유지하면서, 장바구니만 비우겠다: removeAttribute("product")
            //아래 코드는 로그아웃까지 시켜버림
            session.invalidate();
        }else{
            out.print("세션 없음" + "<br>");
        }
        out.print("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
        out.print("</body></html>");
    }
}
