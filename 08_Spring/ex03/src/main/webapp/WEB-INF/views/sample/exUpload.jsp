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
