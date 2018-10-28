<%--
  Created by IntelliJ IDEA.
  User: miaohualin
  Date: 2018/5/5
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <link type ="text/css" rel="stylesheet" href="css/xueliindex.css">
    <title>学位外语考试信息核对</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div id="main">
    <h1 id="title">学位外语考试信息核对</h1>

    <form action="/checkInfo" method="post" >

        <input class="form-control" placeholder="姓名" name="name" type="text" autofocus>
        <br>
        <input class="form-control" placeholder="身份证号" name="sfzh" type="text">
        <br>
        <input class="btn btn-lg btn-success btn-block" id="submit" type="submit" value="查询"/>
    </form>

</div>
<div >
    <a href="#">管理员登陆</a>
    <a href="#">显示信息界面</a>
</div>
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>
