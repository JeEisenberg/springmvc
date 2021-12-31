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
<form method="get" action="toInfo.do/10">
    id号<input type="text" name="id" placeholder="请输入账号"/><br>
    <input type="submit" value="toget"/>

</form>
<form method="post" action="toInfo.do/10">
    id号<input type="text" name="id" placeholder="请输入账号"/><br>
    <input type="submit" value="topost"/>

</form>
<form method="post" action="toInfo.do/10">
    id号<input type="text" name="id" placeholder="请输入账号"/><br>
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="toput"/>

</form>
<form method="get" action="toInfo.do/10">
    id号<input type="text" name="id" placeholder="请输入账号"/><br>
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="todel"/>

</form>


<form method="get" action="testVoid.do">

    <input type="submit" value="testVoid"/>

</form>
<form method="get" action="testForward.do">

    <input type="submit" value="testForward"/>

</form>

<form method="get" action="testForward1.do">

    <input type="submit" value="testForward1"/>

</form>
<form method="get" action="testRedirect.do">

    <input type="submit" value="testRedirect"/>

</form>

<form method="get" action="viewForward.do">

    <input type="submit" value="viewForward"/>

</form>

<form method="get" action="viewForward1.do">

    <input type="submit" value="viewForward1"/>

</form>

<form method="get" action="ModelAndViewForward1.do">

    <input type="submit" value="ModelAndViewForward1"/>

</form>

<form>
    id:<input name="id" id="id" type="text"/>
    姓名:<input name="name" id="name" type="text"/>
    密码:<input name="pwd" id="pwd" type="text"/>
    <input type="button" value="searchUser" onclick="search()"/>

</form>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js" type="text/javascript">

</script>
<script type="text/javascript">
    function search() {
        var str0=$("#id").val();
     var str=$("#name").val();
       var str1=$("#pwd").val();
        $.ajax({
            url: "${pageContext.request.contextPath}/searchUserd.do",
            type:"post",
            data: JSON.stringify({id:$("#id").val(),name:$("#name").val(),"pwd":$("#pwd").val()}),
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                alert(data.id+data.name + data.pwd);
            }
        });
    }
</script>
</body>
</html>
