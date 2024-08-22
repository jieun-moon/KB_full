<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h1>/security/member page</h1>
<%--    _csrf.token: 보안필터에서 csrf Filter가 제일 앞에 있어서 토큰이 없으면 넘어가지도 않음--%>
    <form action="/security/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="submit" value="로그아웃"/>
    </form>
</body>
</html>
