<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update library page</title>
</head>
<body>
<sf:form method="post" action="/save" modelAttribute="library">
    <sf:input path="id" type="hidden"/><br>
    <sf:input path="name"/><br>
    <sf:input path="address"/><br>
    <input type="submit" value="Update">
</sf:form>
</body>
</html>
