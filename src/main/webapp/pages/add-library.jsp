<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add library page</title>
</head>
<body>
  <sf:form method="post" action="/save" modelAttribute="library">
    <sf:input path="name" placeholder="Name"/><br>
    <sf:input path="address" placeholder="Address"/><br>
    <input type="submit" value="Save">
  </sf:form>
</body>
</html>
