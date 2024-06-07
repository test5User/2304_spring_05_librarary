<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upd book page</title>
</head>
<body>
<form method="post" action="/upd-book-old">
    <input name="id" value="<%=request.getParameter("id")%>" type="hidden"><br>
    <input name="title" value="<%=request.getParameter("title")%>"><br>
    <input name="author" value="<%=request.getParameter("author")%>"><br>
    <input name="pages" value="<%=request.getParameter("pages")%>"><br>
    <input name="library" value="<%=request.getParameter("library")%>" type="hidden"><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
