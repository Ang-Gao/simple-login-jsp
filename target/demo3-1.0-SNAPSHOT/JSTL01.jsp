<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/9
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<!--通过taglib引入所需的标签库-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
<!-- value:格式化的数值
    type:number(default),percent,currency
    var:限域变量名，用来接收格式化之后的结果
    scope：范围
    注意：使用var属性之后，标签不会输出结果，需要el表达式才能出结果
-->
<%
request.setAttribute("date",new Date());
%>
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd" var="d"/>
${d}
</body>
</html>
