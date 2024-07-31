<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-31
  Time: 오전 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <h1>EL 실습</h1>
    <%--request scope에서 해당 데이터를 찾아온다--%>
    사용자 아이디: ${userid}<br>
    사용자 비밀번호: ${passwd}<br>

    <%--내가 제시해야 하는 건 key값.property명--%>
    <%--Map이나 Java Bean으로 접근할 때는 .으로 안쪽 property 사용 가능--%>
    <%--name을 접근할 때는 getName() 함수를 이용해서 접근한다--%>
    ${login.name}/${login.passwd}


</body>
</html>
