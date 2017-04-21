<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/21
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Title</title>
    <!--引入bootstrap样式-->
    <link href="${path}/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body style="margin-left: 500px;margin-right: 500px">
<br/>
<h1 align="center">提交</h1>
<form class="myform" action="${path}/user/addUser" method="post">
    <div style="margin-top: 20px">
        <label class="" for="username">用户名: </label>
        <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
    </div>
    <div style="margin-top: 30px">
        <label class="">密码: </label>
        <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
    </div>
    <div style="margin-top: 30px">
        <label class="">性别: </label>
        <input type="text" class="form-control" id="sex" name="sex" placeholder="请选择性别">
    </div>
    <div style="margin-top: 30px">
        <label class="">描述: </label>
        <textarea class="form-control" id="description" name="description" placeholder="请输入描述" rows="3"></textarea>
    </div>
    <div align="center" style="margin-top: 40px">
        <button type="submit" class="btn btn-default btn-lg btn-block"> 提 交</button>
    </div>
    <div align="center">
        <label font="color:red">${message}</label>
    </div>
</form>


<script type="text/javascript" src="${path}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
</body>
</html>
