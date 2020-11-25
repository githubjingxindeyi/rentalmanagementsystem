<%--
  Created by IntelliJ IDEA.
  User: 86152
  Date: 2020/11/25
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    div {
        margin-left: 700px;
        margin-top: 100px;
        width: 400px;
        height: 220px;
        text-align: center;
        border: 1px solid LightGrey;
    }
</style>
<script type="text/javascript" src="../../static/js/jquery-1.7.2.js"></script>
<body>
<div>
<h1>房产信息查询系统</h1>
<table>i
    <form action="/login2.do" method="post">
        <p>请输入身份证号：<input type="text" name="cardd"><p id="cardid"></p></p>
        <p>密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><p id="password"></p></p>
        <input type="submit" value="注册"><input type="button" value="返回" onclick="javascript:window.history.back(-1);">
    </form>
</table>
</div>
</body>
</html>
