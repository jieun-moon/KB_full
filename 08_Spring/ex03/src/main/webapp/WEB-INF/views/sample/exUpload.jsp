<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Insert title here</title>
</head>
<body>
<%--enctype="multipart/form-data" 파일 업로드할 때, 반드시 지정해야함. 지정안하면 처리가 안됨--%>
<%--메서드는 반드시 post. (get은 안됨)--%>
  <form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">
    <div>
<%--      해당 input의 name이 받아주는 메소드의 매개변수로 연결된다(중요)--%>
<%--      하나의 input에는 file 하나만 업로드하는 것이 디폴트다--%>
      <input type="file" name="files">
    </div>
    <div>
      <input type="file" name="files">
    </div>
    <div>
      <input type="file" name="files">
    </div>
    <div>
      <input type="file" name="files">
    </div>
    <div>
      <input type="file" name="files">
    </div>
    <div>
      <input type="submit" />
    </div>
  </form>
</body>
</html>
