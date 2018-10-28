<%--
  Created by IntelliJ IDEA.
  User: miaohualin
  Date: 2018/5/4
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>成绩录入系统</title>

  <!-- Bootstrap Core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- MetisMenu CSS -->
  <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="css/sb-admin-2.css" rel="stylesheet">

  <!-- Morris Charts CSS -->
  <link href="vendor/morrisjs/morris.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  <style>
    input {
      margin-bottom: 5px;
      margin-top: 5px;
      font-size: 20px;
    }
  </style>
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
      <a class="navbar-brand" href="index.html">成绩录入系统</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">

      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
          <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">

          <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> 登出</a>
          </li>
        </ul>
        <!-- /.dropdown-user -->
      </li>
      <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->


  </nav>

  <div id="page-wrapper">
    <div class="row">
      <h2 align="center">上传文件</h2>
    </div>
    <!-- /.row -->
    <%--<div class="row">
      <form action="/download" method="post" enctype="multipart/form-data">
        <label>录取信息上传</label>
        <input type="file" name="file" accept=".xlsx"/><br>
        <button type="submit" class="btn btn-success">upload</button>
      </form>
    </div>
    <div class="row">
      <form action="/DownloadSecondServlet" method="post" enctype="multipart/form-data">
        <label>外语成绩信息上传</label>
        <input type="file" name="filesecond" accept=".xlsx"/><br>
        <button type="submit" class="btn btn-success">upload</button>
      </form>
    </div>
    <div class="row">
      <form action="/scoreUpdate" method="post" enctype="multipart/form-data">
        <label>外语考试核对信息上传</label>
        <input type="file" name="file1" accept=".xlsx"/><br>
        <button type="submit" class="btn btn-success">upload</button>
      </form>
    </div>
    <div class="row">
      <form action="/photoUpdate" method="post" enctype="multipart/form-data">
        <label>外语考试照片上传</label>
        <input type="file" name="file2" accept="application/zip"/><br>
        <button type="submit" class="btn btn-success">upload</button>
      </form>
    </div>
  </div>--%>
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
<script src="js/sb-admin-2.js"></script>

</body>

</html>

