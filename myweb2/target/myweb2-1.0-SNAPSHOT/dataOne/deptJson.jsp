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


    部门号:<input type="text" name="deptno" id="deptno"/><br>

    <input type="button" value="查询" onclick="testJson()"/><br>

<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js">

</script>
<script type="text/javascript">

    function testJson() {
        var deptno= $("#deptno").val();
        console.log(deptno);
        $.ajax({
                url: "${pageContext.request.contextPath}/DeptNo.do/"+deptno,
                type: "get",
                contentType: "application/json ;charset=UTF-8",
                dataType: "json",
                success: function (data) {
                    alert("Success");
                  alert("查询的部门信息为:"+data.deptno+":"+data.dname+":"+data.loc+data.empOfDept );

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
