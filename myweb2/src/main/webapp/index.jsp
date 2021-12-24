<%--
  Created by IntelliJ IDEA.
  User: Gavin
  Date: 2021/12/20
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js">

    </script>

</head>


<body>
<form method="post" action="toLoginIn.do" >

    账号:<input type="text" name="name" id="username" placeholder="请输入账号"/> <dev>${Info}</dev><br>
    密码:<input type="password" name="pwd" id="userpwd" placeholder="请输入密码"/><dev>${Info}</dev><br>
    <input type="submit" value="提交" />

</form>


</body>
</html>
