<%--
  Created by IntelliJ IDEA.
  User: Pan
  Date: 2017/7/13
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<sf:form method="post" modelAttribute="user">
    Username:<sf:input path="username"/><sf:errors path="username" /><br/>
    Password:<sf:input path="password"/><sf:errors path="password"/><br/>
    Nickname:<sf:input path="nickname"/><br/>
    Email:<sf:input path="email"/><sf:errors path="email"/> <br/>
    <%--Attach:<input type="file" name="attachs"/><br/>--%>
    <%--<input type="file" name="attachs"/><br/>--%>
    <%--<input type="file" name="attachs"/><br/>--%>
    <input type="submit" value="添加用户">
</sf:form>
</body>
</html>
