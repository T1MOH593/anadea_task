<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
</head>
<body>
    Published pages:<br>
    <c:forEach var="page" items="${publishedPages}">
        <a href="${page.getMenuLabel()}">${page.getMenuLabel()}</a><br>
    </c:forEach><br>
    Unpublished pages: <br>
    <c:forEach var="page" items="${unpublishedPages}">
        <a href="${page.getMenuLabel()}">${page.getMenuLabel()}</a><br>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/pages">
        <button type="button">New Page</button>
    </a>
</body>
</html>