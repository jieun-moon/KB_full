<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Firefly</title>

<%--    외부 라이브러리(font-awesome css) 스타일 먼저 제시--%>
    <link rel="stylesheet" href ="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
<%--    bootstrap css 삽입--%>
    <link href ="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel ="stylesheet">

<%--    우리가 작성한 스타일 시트 제시--%>
    <link rel="stylesheet" href ="/resources/css/main.css" />

<%--    부트스트랩 JS 먼저 배정--%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<%--    우리가 작성한 main.js 제시--%>
    <script src ="/resources/js/main.js"></script>

</head>
<body>
    <header class="jumbotron mb-0 rounded-0">
        <h1>Backend Study</h1>
        <p>자바 기반의 백엔드 기술을 배웁니다.</p>
    </header>

    <%@include file="menu.jsp"%>

<%--    각 페이지 별로 시작되는 부트 스트랩--%>
<%--    container: 중앙 정렬 시켜주는 반응형 웹--%>
    <div class="container my-5">
