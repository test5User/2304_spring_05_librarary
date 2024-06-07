<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Library Info</title>
</head>
<body>
  <h1>Library ${library.name}</h1>
  <h2>${library.address}</h2>
  <h1>Books:</h1>
  <table border="1">
      <tr>
          <th>Title</th>
          <th>Author</th>
          <th>Pages</th>
          <th>Action</th>
      </tr>
      <c:forEach var="book" items="${library.books}">
          <tr>
              <td>${book.title}</td>
              <td>${book.author}</td>
              <td>${book.pages}</td>
              <td>
                  <a href="/deleteBook/${book.id}/${library.id}">Delete</a>
                  <a href="/deleteBookSecond/${book.id}">DeleteSecond</a>
                  <a href="/pages/upd-book-old.jsp?id=${book.id}&title=${book.title}&author=${book.author}&pages=${book.pages}&library=${library.id}">Update</a>
              </td>
          </tr>
      </c:forEach>
  </table>
  <p>
      <a href="/addBook/${library.id}">Add new book</a>
  </p>
  <p>
      <a href="/pages/add-book-old.jsp?library_id=${library.id}">Add new book Old</a>
  </p>
  <p>
    <a href="/">Back</a>
  </p>
</body>
</html>
