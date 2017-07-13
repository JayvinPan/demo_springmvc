<%--
  Created by IntelliJ IDEA.
  User: Pan
  Date: 2017/7/13
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/demo_springmvc/user/login" method="post">
        Username:<input type="text" name="username"/><br/>
        Password:<input type="password" name="password"/><br/>
        <input type="submit"/>
    </form>
</body>
</html>
