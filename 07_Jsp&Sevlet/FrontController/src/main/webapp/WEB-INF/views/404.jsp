<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            font-size: 120px;
            margin: 0;
            color: #FF6347;
        }
        h3 {
            font-size: 24px;
            font-weight: 400;
            margin: 20px 0;
            color: #555;
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
        .character {
            margin-top: 20px;
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
    <h1>404</h1>
    <h3>요청하신 페이지가 존재하지 않습니다.</h3>
        <a href="/">홈으로 돌아가기</a>
        <div class="character">
            <img src="https://via.placeholder.com/150" alt="Toy Story Character" class="character">
        </div>
    </div>
</body>
</html>
