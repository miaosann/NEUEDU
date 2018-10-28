<%--
  Created by IntelliJ IDEA.
  User: miaohualin
  Date: 2018/5/6
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="css/chenjiindex.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <style type="text/css">
        table tr th{
            text-align : center;
        }
        table tr td{
            text-align : center;
        }
    </style>

</head>

<body>
<div id="a">
    <div class="container">
        <h1 id="title">考试信息查询系统</h1>

        <table  class="table table-condensed">
            <tr id="type">
                <th>姓名</th>
                <th>身份证号</th>
                <th>性别</th>
                <th>专业名称</th>
                <th>培养层次</th>
                <th>学习中心</th>
                <th>批次</th>
                <th>学费(元)</th>
            </tr>
            <c:forEach items="${admits}" var="admit">
                <tr id="search_result">
                    <td>${admit.name}</td>
                    <td>${admit.id}</td>
                    <td>${admit.sex}</td>
                    <td>${admit.major}</td>
                    <td>${admit.peiyang}</td>
                    <td>${admit.school}</td>
                    <td>${admit.pici}</td>
                    <td>${admit.tuition}</td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>


<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
