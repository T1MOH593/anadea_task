<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>New page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/pages" method="post">
    <label for="title">Title
        <input type="text" name="title" id="title">
    </label><br>
    <label for="description">Description
        <input type="text" name="description" id="description">
    </label><br>
    <label for="slug">Slug
        <input type="text" name="slug" id="slug">
    </label><br>
    <label for="h1">H1
        <input type="text" name="h1" id="h1">
    </label><br>
    <label for="content">Content
        <input type="text" name="content" id="content">
    </label><br>
    <label for="publishedAt">Published at
        <input type="datetime-local" name="publishedAt" id="publishedAt">
    </label><br>
    <label for="priority">Priority
        <input type="number" name="priority" id="priority">
    </label><br>
    <button type="submit">Add page</button>
</form>
</body>
</html>