<%--
  Created by IntelliJ IDEA.
  User: Pan
  Date: 2017/7/13
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" type="text/css">

</head>
<body>
<a href="/demo_springmvc/user/add">添加</a><br/>
---->${loginUser.nickname}<br/>
<c:forEach items="${users}" var = "um">
    ${um.value.username}
    ----<a href="${um.value.username}">${um.value.nickname}</a>
    ----${um.value.password}
    ----${um.value.email}
    ----<a href="${um.value.username}/update">修改</a>
    ----<a href="${um.value.username}/delete">删除</a>
    <br/>
</c:forEach>

</body>
</html>
