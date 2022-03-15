<%--
  User: Administrator
  Date: 2022/3/10
  Time: 16:05

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div style="text-align: center" >
    <form action="login" method="post" id="loginForm">
        账户：<input name="username" type="text" id="username" value="${messageModel.object.userName}"><br>
        <br>
        密码：<input name="pwd" type="password" id="pwd"><br>
        <span id="msg" style="font-size: 15px;color: crimson">${messageModel.msg}</span><br>
        <button type="button" id="submitButton" >登陆</button>
        <button type="button">Help</button>
    </form>
</div>
</body>
<!--引入jquery的js文件-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" >

    $("#submitButton").click(function (){
        var uname = $("#username").val();
        var pwd = $("#pwd").val();
        if (isEmpty(uname)){
            $("#msg").html("用户名不能为空")
            return;
        }
        if (isEmpty(pwd)){
            $("#msg").html("密码不能为空")
            return;
        }
        $("#loginForm").submit();
    });


    function isEmpty(str){
        if (str == null || str.trim() == ""){
            return true;
        }
        return false;
    }
</script>
</html>
