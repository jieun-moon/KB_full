<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--메뉴에는 html태그, head 태그 들어가면 안됨--%>
<%--md: medium--%>
<%--sticky-top 클래스의 경우 스크롤시 상단에 고정시켜준다--%>
<nav class="navbar navbar-expand-md bg-primary navbar-dark sticky-top">
    <a class="navbar-brand" href="#"><i class="fa-solid fa-house"></i> Backend</a>

<%--    data-: data를 저장. bs-toggle이라는 이름이 collapse를 저장--%>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">
<%--        좌측 메뉴 구성--%>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">메뉴1</a>
            </li>
            <li class="nav-item">
<%--                # 대신 javascript:void(0)으로 막아두기도 함--%>
                <a class="nav-link" href="#">메뉴2</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">메뉴3</a>
            </li>
        </ul>
<%--        우측 메뉴--%>
        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <img src="https://randomuser.me/api/portraits/women/79.jpg" class="avatar-sm" />
                    admin
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fa-solid fa-right-from-bracket"></i> 로그아웃
                </a>
            </li>
        </ul>
    </div>
</nav>
