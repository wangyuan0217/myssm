<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/29
  Time: 10:18
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

    <title>主页</title>
    <!--引入bootstrap样式-->
    <link href="${path}/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body class="container">

<h1 align="right">Welcome <font color="red">${sessionScope.get("uname")}</font></h1>
<h2 align="right"><a href="${path}/jsp/form.jsp">表单提交</a></h2>

<input type="button" value="刷新" onclick="refreshTable()"/>
<table class="table table-bordered table-hover">
    <caption>边框表格布局</caption>
    <thead>
    <tr>
        <th width="10%">Id</th>
        <th width="15%">用户名</th>
        <th width="15%">用户密码</th>
        <th width="15%">性别</th>
        <th width="35%">描述</th>
        <th width="10%">操作</th>
    </tr>
    </thead>
    <tbody>
    <%--<c:forEach items="user" var="list_user" varStatus="status">--%>
    <c:forEach items="${sessionScope.list_user}" var="user" varStatus="status">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.sex}</td>
            <td>${user.description}</td>
            <td>
                <a onclick="edit()">编辑</a>
                <a onclick="del()">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div hidden="hidden">
    <span>${sessionScope.list_user}</span>
</div>

<h5 align="center" hidden="hidden">
    <ul class="pagination">
        <li><a href="#">&laquo;</a></li>
        <li class="active"><a href="#">1</a></li>
        <li class="disabled"><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>
    </ul>
</h5>

<script type="text/javascript" src="${path}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.ajaxfileupload.js"></script>
<script>
    //    $(function () {
    //        $('table tr td').click(function () {
    //            var td = this.parentNode, tr = td.parentNode;
    //            alert('行号：' + tr.rowIndex + '\n列号：' + td.cellIndex);
    //        })
    //    });
    function refreshTable() {
        $.ajax({
            type: "get",
            url: "${path}/user/findAll",
            success: function () {
            },
            error: function () {
                alert("error");
            }
        });
    }
    function edit() {

        alert($("table tr:eq(3) td:eq(4)").text())
    }
    function del() {
        alert(this.nodeValue);
    }
</script>
</body>
</html>
