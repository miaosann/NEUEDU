<%@ page import="Dao.Excel_recordDao" %>
<%@ page import="Entity.Excel_record" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: miaohualin
  Date: 2018/5/5
  Time: 18:34
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

    <title>成绩录入系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
        var xmlHttpReq;
        //创建一个XmlHttpRequest对象
        function createXmlHttpRequest() {
            if(window.XMLHttpRequest) {
                xmlHttpReq = new XMLHttpRequest();//非IE浏览器
            }else{
                try {
                    xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");//IE浏览器
                }catch (e){
                    try{
                        xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
                    }catch (e){

                    }
                }
            }
        }
        function checkName() {
            var name = document.getElementById("name").value;
            var password = document.getElementById("password").value;
            if(name=="") {
                alert("用户名必须填写！");
                return false;
            }
            if(password=="") {
                alert("密码必须填写！");
                return false;
            }
            createXmlHttpRequest();
            xmlHttpReq.onreadystatechange=handle;
            var url = "LoginServlet?name="+name+"&password="+password;
            xmlHttpReq.open("get",url,true);
            xmlHttpReq.send(null);
        }
        function handle() {
            //懒得写注释了，明年这个代码看不看得懂就看你的造化了
            if(xmlHttpReq.readyState==4) {
                if(xmlHttpReq.status==200) {
                    var res = xmlHttpReq.responseText;
                    var re = res.trim();
                    if (re=="qwer"){
                        window.location.href="admitinfo.jsp";
                    }else if (re=="admin"){
                        window.location.href="index.jsp";
                    } else {
                        var result = document.getElementById("result");
                        result.innerHTML = "<font color=red>" + res + "</font>";
                    }
                }
            }
        }
    </script>
</head>

<body>
<%
    Excel_recordDao excel_recordDao = new Excel_recordDao();
    List<Excel_record> excel_records = excel_recordDao.queryAll();
    String pici = null;
    if (excel_records.size()>0){
        String str = excel_records.get(0).getPici();
        pici= str.substring(3);
    }
%>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" style="text-align: center">东北大学网络教育第<%= pici %>批次招生录取查询</h3>
                </div>
                <div class="panel-body">
                    <form role="form" method="get" action="/LoginServlet">
                        <fieldset>
                            <div class="form-group">
                                <!-- 帐号密码分别叫做name password -->
                                <input class="form-control" placeholder="帐号" type="name" id="name" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码" id="password" type="text" value="">
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <button class="btn btn-lg btn-success btn-block" type="button" onclick="checkName();">登录</button>
                            <span id="result"></span>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="js/sb-admin-2.js"></script>

</body>

</html>
