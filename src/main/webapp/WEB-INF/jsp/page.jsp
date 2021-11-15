<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <meta charset="UTF-8" name="${page.getDescription()}">
    <title>${page.getTitle()}</title>
</head>
<body>
    <h1>${page.getH1()}</h1><br>
    ${page.getContent()}
    <footer><a href="${pageContext.request.contextPath}/pages/edit/${page.getSlug()}">
        <button type="button">Edit Page</button></a><br>
        <a href="${pageContext.request.contextPath}/pages/delete/${page.getSlug()}">
            <button type="button">Delete Page</button></a>
    </footer>
</body>
</html>