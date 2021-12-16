<%--
  Created by IntelliJ IDEA.
  User: Gavin
  Date: 2021/12/16
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<meta charset="UTF-8">
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/RegisterUser.do" method="post">

    账号:<input type="text" name="name" placeholder="请输入用户名"/>
    密码:<input type="password" name="pwd" placeholder="请输入账号密码"/>
    <input type="submit" value="注册"/>


</form>


</body>
</html>
