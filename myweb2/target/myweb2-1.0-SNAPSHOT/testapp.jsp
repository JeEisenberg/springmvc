<%--
  Created by IntelliJ IDEA.
  User: Gavin
  Date: 2021/12/20
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script>
    var jdbc=

        [
            {"driver":"com.mysql.cj.jdbc.Driver"},
            {"url":"jdbc:mysql://localhost:3306?gavin"},
            {"username":"gavin"},
            {"password":"123456"}
        ]

function wwwww(){

    console.log(jdbc[0].driver);
    jdbc[2].username="lim";
    console.log(jdbc[2].username);
}


</script>

<input type="button" onclick="wwwww()">

</body>
</html>
