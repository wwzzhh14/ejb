<%--
  Created by IntelliJ IDEA.
  User: wzh
  Date: 24/12/2016
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="user" uri="/WEB-INF/tlds/user.tld" %>

<user:checkSession></user:checkSession>
<jsp:useBean id="UserNumBean" scope="application" type="bean.UserNumBean">
</jsp:useBean>

<html>
<head>
    <title>登录</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.1.1/css/bootstrap.css">
</head>

<body>

<div style="padding-right: 10px;height: 20px">
    <span class="label label-default"style="float: right;margin-left: 10px">登录人数:
        <jsp:getProperty name="UserNumBean" property="user"></jsp:getProperty>
    </span>
    <span class="label label-default" style="float: right;margin-left: 10px">游客人数:
        <jsp:getProperty name="UserNumBean" property="visitor"></jsp:getProperty>
    </span>
    <span class="label label-default" style="float: right;margin-left: 10px">总人数:
        <jsp:getProperty name="UserNumBean" property="sum"></jsp:getProperty>
    </span>
</div>
<div style="width: 80%;margin-left: 10%" >
    <form role="form" method="post" action="/login" >
        <div class="form-group">
            <label for="userId">学号</label>
            <input  class="form-control" id="userId" placeholder="Account" name="userId">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" placeholder="Password" name="password">
        </div>
        <button type="submit" class="btn btn-default">登录</button>
    </form>
</div>

<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>
