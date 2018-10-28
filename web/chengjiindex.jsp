<%@ page import="Dao.StudentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="Dao.Cj_recordDao" %>
<%@ page import="Entity.cj_record" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: miaohualin
  Date: 2018/5/5
  Time: 18:46
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
            var password = document.getElementById("sfzh").value;
            var pici = document.getElementById("testpici").value;
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
            var url = "search?name="+name+"&id="+password+"&pici="+pici;
            xmlHttpReq.open("get",url,true);
            xmlHttpReq.send(null);
        }
        function handle() {
            //懒得写注释了，明年这个代码看不看得懂就看你的造化了
            if(xmlHttpReq.readyState==4) {
                if(xmlHttpReq.status==200) {
                    var res = xmlHttpReq.responseText;
                    var re = res.trim();
                    if (re.length>20){
                        var result = document.getElementById("plm");
                        var str = result.innerHTML;
                        result.innerHTML = str+"<font>" + res + "</font>";
                    }else {
                        var result = document.getElementById("result");
                        result.innerHTML = "<font color=red>" +res + "</font>";
                    }
                }
            }
        }
    </script>

</head>
<%
    Cj_recordDao cj_recordDao = new Cj_recordDao();
    List<cj_record> picis = cj_recordDao.queryAll();
    List<String> piciList = new ArrayList<String>();
    for (int i = 0; i<picis.size();i++){
        piciList.add(picis.get(i).getTablename().substring(2));
    }
    request.getSession().setAttribute("piciList",piciList);
%>
<body>
<div  id="a">
    <div class="container">
        <h1 id="title">考试信息查询系统</h1>
        <div class ="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form action="/search" method="get">

                    <input class="form-control" placeholder="姓名" id="name" type="text" autofocus>
                    <br>
                    <input class="form-control" placeholder="身份证号" id="sfzh" type="text">
                    <br>
                    <select id="testpici" class="selectpicker show-tick form-control">
                        <option value ="0">请选择考试日期</option>
                        <c:forEach var="pici" items="${piciList}">
                        <option value ="${pici}">${pici}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <button type="button" class="btn btn-info" name="search" id="btSearch" onclick="checkName()">查询</button>
                    <br> <br>
                    <span id="result"></span>
                    <br> <br> <br>
                </form>
            </div>
            <div class="col-md-4"></div>
        </div>
        <table class="table table-condensed" id="plm">
            <tr id="type">
                <th>姓名</th>
                <th>身份证号</th>
                <th>专业名称</th>
                <th>考试科目</th>
                <th>成绩</th>
                <th>考试日期</th>
                <th>报名单位</th>
            </tr>
                    <%--<td>${student.xm}</td>
                    <td>${student.sfzh}/td>
                    <td>${student.zymc}</td>
                    <td>
                        <c:if test="${studnet.km1dm}==${a}">英语</c:if>
                        <c:if test="${studnet.km1dm}==${b}">日语</c:if>
                        <c:if test="${studnet.km1dm}==${c}">俄语</c:if>
                    </td>
                    <td>${student.kmlcj}</td>
                    <td>${student.riqi}</td>
                    <td>东北大学</td>--%>


        </table>

    </div>
</div>


<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
