<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--${}로 넣어진 애들은 model에서 받아오는 애들--%>
    <div>
        <h2>${city}</h2>
        오늘의 날씨: ${weather.weather[0].description} <img src="${iconUrl}"/>
    </div>
    <div>
        온도: ${weather.main.temp}° / 습도: ${weather.main.humidity}%
    </div>
</body>
</html>
