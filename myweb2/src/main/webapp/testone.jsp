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
</head>


<body>
<form method="get" action="toInfo.do/10" >
    id号<input type="text" name="id" placeholder="请输入账号"/><br>
    <input type="submit" value="toget" />

</form>
<form method="post" action="toInfo.do/10" >
    id号<input type="text" name="id" placeholder="请输入账号"/><br>
    <input type="submit" value="topost" />

</form>
<form method="post" action="toInfo.do/10" >
    id号<input type="text" name="id"   placeholder="请输入账号"/><br>
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="toput" />

</form>
<form method="get" action="toInfo.do/10" >
    id号<input type="text" name="id"    placeholder="请输入账号"/><br>
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="todel" />

</form>

</body>
</html>
