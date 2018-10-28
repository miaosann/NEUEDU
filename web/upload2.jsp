<%--
  Created by IntelliJ IDEA.
  User: miaohualin
  Date: 2018/5/15
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Manage</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">XXXXX系统</a>
        </div>
        <!-- /.navbar-header -->
        <!--右侧上面小按钮选人物-->
        <ul class="nav navbar-top-links navbar-right">

            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="#"><em class="fa fa-users fa-fw"></em> 用户管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="adduser.jsp"><em class="fa fa-plus"> 增加用户</em></a>
                            </li>
                            <li>
                                <a href="manageuser.jsp"><em class="fa fa-pencil-square-o"> 修改密码</em></a>
                            </li>
                            <li>
                                <a href="delete.jsp"><em class="fa fa-dashboard"> 删除用户</em></a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="malogin.jsp"><i class="fa fa-user fa-fw"></i> 管理员登录</a>
                    </li>
                    <li>
                        <a href="#"><em class="fa fa-plus fa-fw"></em> 文件上传<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="upload1.jsp"><em class="fa fa-plus"> 录取信息上传</em></a>
                            </li>
                            <li>
                                <a href="upload2.jsp"><em class="fa fa-plus"> 外语成绩上传</em></a>
                            </li>
                            <li>
                                <a href="upload3.jsp"><em class="fa fa-plus"> 外语核对信息上传</em></a>
                            </li>
                            <li>
                                <a href="upload4.jsp"><em class="fa fa-plus"> 外语核对照片上传</em></a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <!-- Page Content -->
    <div id="page-wrapper">
        <!--upload model-->
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3" >
                <div class="login-panel panel panel-default">
                    <div class="panel-body">
                        <form role="form" action="DownloadSecondServlet" method="post" enctype="multipart/form-data">
                            <input id="lefile" type="file" accept=".xlsx" name="filesecond" style="display:none" onchange="$('input[id=photoCover]')[0].value=this.value;">
                            <div class="input-append" style="margin-bottom:50px;">
                                <label for="lefile">外语成绩上传</label><br>
                                <div class="col-lg-8">
                                    <input id="photoCover" class="form-control" type="text"  disabled>
                                </div>
                                <button type="button" class="btn btn-default" onclick="$('input[id=lefile]').click();">上传</button>
                            </div>

                            <button type="submit" class="btn btn-primary btn-block">提交</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="vendor/metisMenu/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="vendor/raphael/raphael.min.js"></script>
<script src="vendor/morrisjs/morris.min.js"></script>
<script src="data/morris-data.js"></script>

<!-- Custom Theme JavaScript -->
<script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
