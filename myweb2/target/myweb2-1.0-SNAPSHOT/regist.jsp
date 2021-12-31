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
<form method="post" action="addPlayer.do">

    账号:<input type="text" name="name" id="name" placeholder="请输入账号"/>
    <dev>${Info}</dev><!--检查信息-->
    <br>
    密码:<input type="password" name="pwd" id="pwd" placeholder="请输入密码"/>
    <dev>${Info}</dev>
    <br>
    昵称:<input type="text" name="nickname" placeholder="请输入昵称"><br>
    头像:<input type="file" id="upFile">
    <a href="javascript:void(0)" id="uploadFile" onclick="uploadPic()">立即上传</a>
    <br>
    <div id="divimg" style="width: 150px;height: 200px">
        <img src="${pageContext.request.contextPath}/static/img/zzy.jpg"/>
    </div>
    <input type="submit" value="注册"/>
</form>
<script type="text/javascript">
    function uploadPic() {
        /* console.log($("#upFile")[0].files[0]);
         console.log($("#upFile")[0].files[0].type);
 */
// 将变量保存下来
        var photoFile = $("#upFile")[0].files[0];
// 如果该变量压根就没传
        if (photoFile == undefined) {
            // 实际上会给一个默认头像,但是这里简化一下必须上传
            alert("请上传文件!");
            return;
        }
        var photoType = $("#upFile")[0].files[0].type;
        var photoSize = $("#upFile")[0].files[0].size;
// 如果数据不是图片
        if ("image/jpeg" != photoType) {
            alert("请上传图片!!!");
            return;
        }
        // 如果数据大小超过
        if (photoSize > 1600000) {
            alert("上传图片大小不得高于1600K!!!");
            return;
        }
// 将文件传到这个对象中
        var formData = new FormData();
        // name:valued方法的参数为name:value形式的json对象  key:value
// 这个key其实就是要接受该数据的controller的参数名称
        formData.append("headerPic", photoFile);
// 接着发送异步请求
        $.ajax({
                url: "${pageContext.request.contextPath}/fileUpload.do",
                data: formData,
                type: "post",
                processData: false,//告诉浏览器发送的是一个对象   请求数据
                contentType: false,//告诉浏览器 请求数据的类型 二进制类型
                // dataType: "json",
                success: function (data) {//接收返回来的数据并修改img标签里的内容
                    console.log(data);
                    window.location.reload();
                }
            }
        )
    }

</script>

</body>
</html>
