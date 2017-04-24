<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/24
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <title>Upload</title>
    <!--引入bootstrap样式-->
    <link href="${path}/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<br><br>
<div hidden="hidden">
    <input type="file" name="file"
           id="file" size="28"/>
    <input type="button" value="上传" class="btn btn-default" onclick="upload()"/>
    <span id="temp"></span>
</div>

<script type="text/javascript" src="${path}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.ajaxfileupload.js"></script>
<script>
    function upload() {
        $.ajaxFileUpload({
            url: "${path}/user/uploadPic",
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'file',
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (data) {
                alert(data.message);
                $("#temp").text(data.message);
            }
        })
    }
</script>
</body>
</html>
