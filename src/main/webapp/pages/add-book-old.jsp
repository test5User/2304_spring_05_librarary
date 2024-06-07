<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book page</title>
</head>
<body>
    <form method="post" action="/add-book-old">
        <input name="title" placeholder="Title"><br>
        <input name="author" placeholder="Author"><br>
        <input name="pages" placeholder="Pages"><br>
        <input name="library_id" type="hidden" value="<%=request.getParameter("library_id")%>"><br>
        <input type="submit" value="Add">
    </form>
</body>
</html>
