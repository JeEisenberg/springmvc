<%--
  Created by IntelliJ IDEA.
  User: Gavin
  Date: 2021/12/19
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<meta charset="UTF-8"/>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/delEmp.do">

    <input type="checkbox" name="ids" value="7369">SMITH<br>
    <input type="checkbox" name="ids" value="7499">ALEEN<br>
    <input type="checkbox" name="ids" value="7521">WARD<br>
    <input type="submit" value="提交">

</form>

</body>
</html>
