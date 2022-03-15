<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/8
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        登陆系统
    </title>
</head>
<body>
    <pre>
        <form action="loginServlet" method="post">

    姓名：<input type="text" name="username">

    密码：<input type="password" name="passwd">

                <button>登陆</button>
            <span style="color: darkred;font-size: 20px"><% String msg = (String) request.getAttribute("msg");
            if (msg != null){
                out.println(msg);
            }
        %>
            </span>
        </form>

    </pre>
</body>
</html>
