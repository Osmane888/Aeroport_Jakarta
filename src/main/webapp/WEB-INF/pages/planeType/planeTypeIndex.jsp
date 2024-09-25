<%--
  Created by IntelliJ IDEA.
  User: Osmane
  Date: 24/09/2024
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <ul>
        <c:forEach var="planeType" items="${planeTypes}">
            <li>${planeType.name}</li>
        </c:forEach>
    </ul>

</body>
</html>
