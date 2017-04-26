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
    <!--第一步：引入Javascript / CSS （CDN）-->
    <!-- DataTables CSS -->
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
</head>
<body class="container">

<h1 align="right">Welcome <font color="red">${sessionScope.get("uname")}</font></h1>
<h2 align="right"><a href="${path}/jsp/form.jsp">表单提交</a></h2>

<input type="button" value="刷新" onclick="refreshTable()"/>
<table class="display" id="table">
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
    </tbody>
</table>

<script type="text/javascript" src="${path}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
<script>
    <!--第三步:初始化Datatables-->
    $(document).ready(function () {
        $('#table').DataTable({
            ajax: '${path}/user/findAll',
            dataSrc: "data",
            columns: [
                {data: 'id'},
                {data: 'username'},
                {data: 'password'},
                {data: 'sex'},
                {data: 'description'},
                {data: 'description'}
            ],
            oLanguage: {
                "sProcessing": "正在加载中......",
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "对不起，查询不到相关数据！",
                "sEmptyTable": "表中无数据存在！",
                "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                "sInfoFiltered": "数据表中共为 _MAX_ 条记录",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上一页",
                    "sNext": "下一页",
                    "sLast": "末页"
                }
            }
        });
    });
</script>
</body>
</html>
