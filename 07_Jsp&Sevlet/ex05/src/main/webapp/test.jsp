<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-31
  Time: 오전 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--지역변수:int age = 10--%>
<%--request.setAttribute("age", 40): request scope에 age라는 key로 저장--%>
<%--위와 아래의 age는 다른 변수들--%>
<%
    Integer age = null; //지역변수
    request.setAttribute("age", null); //request scope
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Integer age = null; 키가 없다면 컴파일 에러--%>
<%--스크립트릿 언어--%>
<%--지역 변수를 가져온다--%>
<%--null 설정시 그대로 "null"이란 글자가 나온다--%>
변수 age: <%= age%><br>
<%--request.setAttribute("age", null); 이 키가 없어도 EL은 빈 값으로 출력--%>
<%--EL(Expression Language--%>
<%--작은 범위부터 타고 올라가면서 해당 값을 찾는다--%>
<%--page->request->session->application--%>
<%--nuill일 경우 알아서 공백으로 처리해준다--%>
EL age: ${age}
</body>
</html>
