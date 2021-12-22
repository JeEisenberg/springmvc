<%--
  Created by IntelliJ IDEA.
  User: Gavin
  Date: 2021/12/17
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="get" action="${pageContext.request.contextPath}/searchEmpByDept.do">
    员工编号:<input type="text" placeholder="请输入员工编号" name="EMPNO">
    员工姓名:<input type="text" placeholder="请输入员工姓名" name="ENAME">
    员工部门地址:<input type="text" placeholder="请输入部门地址" name="dept.loc">
    <input type="submit" value="查询"/>
</form>
</body>
</html>
