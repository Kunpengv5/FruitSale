<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>test</title>
</head>
<body>
    <div style="align-content: center">
    <form action="findUserDemo.action" method="post">
        用户名称：<input type="text"  name="name"/>
    <input type="submit" value="查询">
    </form>
    <table width="300px" border="1">
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>账号</td>
        <td>电话</td>
    </tr>
        <c:forEach items="${userList}" var="user" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${user.name}</td>
                <td>${user.username}</td>
                <td>${user.telphone}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
</body>
</html>
