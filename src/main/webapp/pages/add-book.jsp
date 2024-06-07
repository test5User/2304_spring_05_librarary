<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Book page</title>
</head>
<body>
    <sf:form method="post" action="/saveBook" modelAttribute="book">
        <sf:input path="title" placeholder="Title"/><br>
        <sf:input path="author" placeholder="Author"/><br>
        <sf:input path="pages" placeholder="pages"/><br>
        <sf:input path="library_id" type="hidden"/>
        <input type="submit" value="Save">
    </sf:form>
</body>
</html>
