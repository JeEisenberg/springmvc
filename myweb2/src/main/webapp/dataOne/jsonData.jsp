<%--
  Created by IntelliJ IDEA.
  User: Gavin
  Date: 2021/12/21
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transition//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

    <title>json数据交互</title>

</head>

<body>


    账号:<input type="text" name="name" id="name" /><br>

    密码:<input type="password" name="pwd" id="pwd" /><br>
    <input type="button" value="测试" onclick="testJson()"/><br>

<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js">

</script>
<script type="text/javascript">
    function testJson() {
        console.log("你好" + name + pwd);
        $.ajax({
                url: "${pageContext.request.contextPath}/testJson.do",
                type: "POST",
                contentType: "application/json ;charset=UTF-8",
                //  data: [{"name": $("#name").val()},{"pwd":$("#pwd").val()}],
                data: JSON.stringify({name: $("#name").val(), pwd: $("#pwd").val()}),
                //   data:{"name":name},
                dataType: "json",
                success: function (data) {
                    alert("Success");
                    alert(data.name + data.pwd)

                },
                err: function () {
                    alert("发生了错误");
                }
            }
        );

    }


</script>

</body>
</html>
