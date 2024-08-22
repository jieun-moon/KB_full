<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>환영합니다.</h1>

<%--    로그인 안한 경우--%>
    <sec:authorize access="isAnonymous()">
        <a href="/security/login">로그인</a>
    </sec:authorize>

<%--    로그인 한 경우--%>
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username"/>
        <form action="/security/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="로그아웃"/>
<%--            로그아웃은 post 요청--%>
<%--     post로 로그아웃시 csrf token이 없으면 cs 요청에서 403에러 발생--%>
        </form>
    </sec:authorize>

</body>
</html>
