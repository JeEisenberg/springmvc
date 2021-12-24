<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.gavin.pojo.Emp" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>欢迎使用员工管理系统</title>
    <style type="text/css">
        table {
            border: 4px solid black;
            width: 70%;

            margin: 0 auto;
            mso-cellspacing: 0;
        }

        td {
            border: 2px solid black;

        }

        th {
            border: 2px solid black;

        }

    </style>
</head>
<body>

<div>
    <table cellpadding="0" cellspacing="0">

        <tr>
            <th>部门号</th>
            <th>员工号</th>
            <th>员工姓名</th>
            <th>职位</th>
            <th>上级编号</th>
            <th>雇佣日期</th>
            <th>基本工资</th>
            <th>奖金</th>

        </tr>
   <%--     <%
            List<Emp> emps = (ArrayList<Emp>) request.getAttribute("empInfo");
            for (Emp emp : emps) {
                pageContext.setAttribute("emp", emp);
        %>
--%>
 <%--       <tr>

            &lt;%&ndash;这里跟添加到list中的属性字段一致&ndash;%&gt;
            <td>${emp.DEPTNO} </td>
            <td>${emp.EMPNO} </td>
            <td>${emp.ENAME}</td>
            <td>${emp.JOB}</td>
            <td>${emp.MGR}</td>
            <td><fmt:formatDate value="${emp.HIREDATE}" pattern="yyyy-MM-dd"/> </td>
            <td>${emp.SAL}</td>
            <td>${emp.COMM}</td>

        </tr>--%>

     <%--   <%
            }
        %>
        --%>
        <c:forEach items="${deptInfo}" var="dept"  varStatus="deptStatus">

            <tr>

                    <%--这里跟添加到list中的属性字段一致--%>
                <td>${dept.DEPTNO} </td>
                <td>${dept.EMPNO} </td>
                <td>${dept.ENAME}</td>
                <td>${dept.JOB}</td>
                <td>${dept.MGR}</td>
                <td><fmt:formatDate value="${dept.HIREDATE}" pattern="yyyy-MM-dd"/> </td>
                <td>${dept.SAL}</td>
                <td>${dept.COMM}</td>

            </tr>



        </c:forEach>


    </table>
</div>
</body>
</html>