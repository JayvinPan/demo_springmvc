<%--
  Created by IntelliJ IDEA.
  User: Pan
  Date: 2017/7/13
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>显示用户</title>
</head>
    <body>
        Username:${user.username}<br/>
        Password:${user.password}<br/>
        Nickname:${user.nickname}<br/>
        Email:${user.email}<br/>
    </body>
</html>
