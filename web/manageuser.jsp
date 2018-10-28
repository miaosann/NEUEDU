<%--
  Created by IntelliJ IDEA.
  User: miaohualin
  Date: 2018/5/15
  Time: 10:59
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

    <title>ManageUser</title>

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

        <!-- /.col-lg-12 -->
        <div class="row">
            <div class="col-lg-6 col-md-offset-3 text-center"  >
                <div class="login-panel panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">修改密码</h3>
                    </div>

                    <div class="panel-body">

                        <form class="form-horizontal" role="form" action="UpdateUserServlet" method="post">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">账号</label>
                                <div class="col-sm-10">
                                    <input class="form-control" id="user" type="text" name="zhanghao" placeholder="请输入账号..." value="" >
                                </div>
                            </div>


                            <div class="form-group">
                                <label for="Password" class="col-sm-2 control-label">旧密码</label>
                                <div class="col-sm-10">
                                    <input class="form-control" id="password" type="password" name="password" placeholder="请输入密码..." value="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="Password" class="col-sm-2 control-label">新密码</label>
                                <div class="col-sm-10">
                                    <input class="form-control" id="check_password2" type="password" name="password1" placeholder="请再次输入密码..." value="">
                                </div>
                            </div>



                            <button type="submit" class="btn btn-lg btn-success btn-block center-block" style="width: 300px">提交</button>

                        </form>

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

    <script src="bootstrapvalidator/dist/js/bootstrapValidator.min.js"></script>
    <script src="bootstrapvalidator/dist/js/language/zh_CN.js"></script>
    <script>
        $(function () {
            $('form').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    new_username: {
                        message: '用户名验证失败',
                        validators: {
                            notEmpty: {
                                message: '用户名不能为空'
                            }
                        }
                    },
                    new_password:{
                        validators:{
                            notEmpty: {
                                message: '密码不能为空'
                            }
                        }

                    },
                    check_password:{
                        validators:{
                            notEmpty: {
                                message: '验证密码不能为空'
                            },
                            identical: {
                                field: 'new_password',
                                message:'两次密码输入不一致'
                            }
                        },


                    }

                }
            });
        });

    </script>
</body>

</html>
