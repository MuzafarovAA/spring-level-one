<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<body>

<h1>Products List</h1>
<table>
    <tr><th>ID</th><th>TITLE</th><th>COST</th></tr>
    <c:forEach var="item" items="${productsList}">
        <tr><td>${item.id}</td><td>${item.title}</td><td>${item.cost}</td></tr>
    </c:forEach>
</table>

</body>
</html>