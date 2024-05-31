<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upd library page</title>
</head>
<body>
<form method="post" action="/upd-old">
    <input name="id" value="<%=request.getParameter("id")%>" type="hidden"><br>
    <input name="name" value="<%=request.getParameter("name")%>"><br>
    <input name="address" value="<%=request.getParameter("address")%>"><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
