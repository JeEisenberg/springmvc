<%--
  Created by IntelliJ IDEA.
  User: Gavin
  Date: 2021/12/19
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>
<meta charset="UTF-8"/>
<head>
    <title>Title</title>
</head>
<body>

<form method="get" action="${pageContext.request.contextPath}/addDept.do">
    <table>
        <tr>

            <td>部门号</td>
            <td>部门名</td>
            <td>部门地址</td>
        </tr>

        <tr>
            <td> <input type="checkbox" name="deptList[0].deptno" value="40">40 </td>
            <td> <input type="checkbox" name="deptList[0].dname" value="SaleManager"> SaleManager</td>
            <td> <input type="checkbox" name="deptList[0].loc" value="YSTL"> YSTL</td>
        </tr>
        <tr>
            <td> <input type="checkbox" name="deptList[1].deptno" value="50"> 50</td>
            <td> <input type="checkbox" name="deptList[1].dname" value="ClerkManager">ClerkManager </td>
            <td> <input type="checkbox" name="deptList[1].loc" value="HLVS"> HLVS</td>
        </tr>

    </table>

    <input type="submit" value="添加">


</form>
</body>
</html>
