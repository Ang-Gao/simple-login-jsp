<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/9
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
    <h3>欢迎</h3>
    <%pageContext.setAttribute("uname","page作用域");
request.setAttribute("uname","request作用域");
session.setAttribute("uname","session作用域");
application.setAttribute("uname","application作用域");%>
    <!--无法获取声明在这的局部变量-->
    <h1>${uname}</h1>
&nbsp;page:${pageScope.uname}<br>
&nbsp;request:${requestScope.uname}<br>
&nbsp;session:${sessionScope.uname}<br>
&nbsp;application:${applicationScope.uname}<br>


<%
List<String> list = new ArrayList<>();
list.add("1");
list.add("2");
session.setAttribute("list",list);
HashMap<String, Integer> hashMap = new HashMap<>();
hashMap.put("KeyHere",100);
session.setAttribute("map",hashMap);
%>
${list[0]}
${map.get("KeyHere")}<!--需要存在get方法才能这样使用从而获得值-->
${empty list[10]}
</body>
</html>
