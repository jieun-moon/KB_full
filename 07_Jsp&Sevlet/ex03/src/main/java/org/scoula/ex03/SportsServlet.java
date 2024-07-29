package org.scoula.ex03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sports")
public class SportsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //한글 깨짐 방지 - 있을 때와 없을 때 결과 확인

//        sports에 저장되어있는 값이 여러개이므로 getParameterValuse를 통해 배열로 받아옴
        String[] sports = request.getParameterValues("sports");
        String sex = request.getParameter("sex");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.print("<html><body>");
        if(sports != null){
            for(String sport : sports) {
//                체크된 값들을 돌면서 하나씩 출력한다
                out.print("좋아하는 운동: " + sport + "<br>");
            }
        }
//        라디오값은 하나밖에 선택이 안되므로 배열 처리할 필요 없음
        out.print("성별: " + sex + "<br>");
        out.print("</body></html>");
    }
}
