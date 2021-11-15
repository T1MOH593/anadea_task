<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>New page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/pages/edit/${page.getSlug()}" method="post">
    <label for="title">Title
        <input type="text" value="${page.getTitle()}" name="title" id="title">
    </label><br>
    <label for="description">Description
        <input type="text" name="description" value="${page.getDescription()}" id="description">
    </label><br>
    <label for="h1">H1
        <input type="text" name="h1" value="${page.getH1()}" id="h1">
    </label><br>
    <label for="content">Content
        <input type="text" name="content" value="${page.getContent()}" id="content">
    </label><br>
    <label for="publishedAt">Published at
        <input type="datetime-local" name="publishedAt" value="${page.getPublishedAt()}" id="publishedAt">
    </label><br>
    <label for="priority">Priority
        <input type="number" name="priority" value="${page.getPriority()}" id="priority">
    </label><br>
    <button type="submit">Edit page</button>
</form>
</body>
</html>