<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Title</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Comic Sans MS', 'Chalkboard SE', 'Comic Neue', sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-color: #87CEEB;
            color: #333;
            text-align: center;
            overflow: hidden;
        }
        .container {
            text-align: center;
            max-width: 600px;
            padding: 20px;
            background-color: #fff;
            border-radius: 20px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        h1 {
            font-size: 40px;
            margin: 0;
            color: #FF6347;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            font-size: 20px;
            margin: 10px 0;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #FF6347;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #FF4500;
        }
        .clouds {
            position: absolute;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            overflow: hidden;
            z-index: -1;
        }
        .cloud {
            position: absolute;
            background: white;
            border-radius: 50%;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .cloud:before, .cloud:after {
            content: '';
            position: absolute;
            background: white;
            border-radius: 50%;
        }
        .cloud:nth-child(1) {
            width: 100px;
            height: 60px;
            top: 10%;
            left: 10%;
            animation: float 8s ease-in-out infinite;
        }
        .cloud:nth-child(1):before {
            width: 50px;
            height: 50px;
            top: -25px;
            left: 10px;
        }
        .cloud:nth-child(1):after {
            width: 50px;
            height: 50px;
            top: -20px;
            right: 10px;
        }
        .cloud:nth-child(2) {
            width: 150px;
            height: 80px;
            top: 30%;
            left: 60%;
            animation: float 10s ease-in-out infinite;
        }
        .cloud:nth-child(2):before {
            width: 75px;
            height: 75px;
            top: -35px;
            left: 15px;
        }
        .cloud:nth-child(2):after {
            width: 75px;
            height: 75px;
            top: -30px;
            right: 15px;
        }
        .cloud:nth-child(3) {
            width: 80px;
            height: 50px;
            top: 50%;
            left: 20%;
            animation: float 7s ease-in-out infinite;
        }
        .cloud:nth-child(3):before {
            width: 40px;
            height: 40px;
            top: -20px;
            left: 5px;
        }
        .cloud:nth-child(3):after {
            width: 40px;
            height: 40px;
            top: -15px;
            right: 5px;
        }
        @keyframes float {
            0% {
                transform: translateY(0);
            }
            50% {
                transform: translateY(-20px);
            }
            100% {
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>
    <div class="clouds">
        <div class="cloud"></div>
        <div class="cloud"></div>
        <div class="cloud"></div>
    </div>
    <div class="container">
    <h1>Todo 목록 보기</h1>
    <div>
<%--        EL을 사용해서 todoList 접근--%>
        <ul>
            <c:forEach var="todo" items="${todoList}" varStatus="state">
                <li>${todo}</li>
            </c:forEach>
        </ul>

<%--    상대경로기 때문에 todo 폴더를 접근할 필요 없음--%>
            <a href="view">상세보기</a>
    </div>
    <div>
        <a href="create">새 Todo</a>
    </div>
    </div>
</body>
</html>
