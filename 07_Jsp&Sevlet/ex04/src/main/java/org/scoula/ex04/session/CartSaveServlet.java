package org.scoula.ex04.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_save")
public class CartSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //MIME 타입 설정
        response.setContentType("text/html; charset=UTF-8");

        //자바I/O
        PrintWriter out = response.getWriter();

        //d입력 파라미터 얻기
        String product = request.getParameter("product");

        //세션객체 얻기
        //현재 세션을 가져오기
        HttpSession session = request.getSession();
        //속성을 가져올 땐 object로 가져오기 때문에 캐스팅 필요
        ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");

        //첫번째 요청
        if (list == null) {
            //리스트가 null일 경우 리스트를 새로 생성해서 세션에 저장
            list = new ArrayList<String>();
            session.setAttribute("product", list);
        }
        //리스트에 새로운 상품 추가
        list.add(product);

        out.print("<html><body>");
        out.print("Product 추가!!<br>");
        out.print("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_view'>장바구니 보기</a>");
        out.print("</body></html>");
    }
}
