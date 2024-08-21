<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>환영합니다.</h1>

<%--    isAnonymous: 로그인 안된 경우 True, 로그아웃 되어있는 상태를 의미함--%>
    <sec:authorize access="isAnonymous()">
        <a href="/security/login">로그인</a>
    </sec:authorize>

<%--    isAuthenticated: 로그인이 된 경우 True, 로그인되어 있는 상태를 의미함--%>
    <sec:authorize access="isAuthenticated()">
<%--        로그인한 사용자의 정보에 접근해서 username을 출력한다--%>
        <sec:authentication property="principal.username"/>
        <form action="/security/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="로그아웃"/>
<%--            로그아웃은 post 요청--%>
<%--     _csrf.token: 아무나 post 요청 못 보내게 하려고--%>
<%--     post로 로그아웃시 csrf token이 없으면 cs 요청에서 403에러 발생--%>
        </form>
    </sec:authorize>

</body>
</html>
