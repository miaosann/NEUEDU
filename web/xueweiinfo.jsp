<%@ page import="Entity.Score" %><%--
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
    <title>学位外语考试信息核对</title>
    <link type ="text/css" rel="stylesheet" href="css/xueliinfo.css">
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
<%
    Score score = (Score) request.getSession().getAttribute("check");
    String sss = score.getSex();
    String sex = null;
    if (sss.equals("1")) sex = "男";
    else sex = "女";
    String birth =score.getCsrq();
    String year = birth.substring(0,4);
    String month = birth.substring(4,6);
    String day = birth.substring(6,8);
    int mz = Integer.parseInt(score.getMz());
    String[] nation = {"","汉族","蒙古族","回族","藏族","维吾尔族","苗族","彝族","壮族","布依族","朝鲜族","满族",
    "侗族","瑶族","白族","土家族","哈尼族","哈萨克族","傣族","黎族","僳僳族","佤族","畲族","高山族","拉祜族",
    "水族","东乡族","纳西族","景颇族","柯尔克孜族","土族","达斡尔族","仫佬族","羌族","布朗族","撒拉族","毛难族",
    "仡佬族","锡伯族","阿昌族","普米族","塔吉克族","怒族","乌孜别克族","俄罗斯族","俄罗斯族","崩龙族","保安族",
    "裕固族","京族","塔塔尔族","独龙族","鄂伦春族","赫哲族","门巴族","珞巴族","基诺族"};
    String info = score.getKsly();
    String ksly =null;
    if (info.equals("1")){
        ksly = "成人";
    }else ksly = "自考";
    String nnn = score.getNj();
    String njy = nnn.substring(0,4);
    String njm = nnn.substring(4,6);
    String kkk = score.getKm1dm();
    String subject = null;
    if (kkk.equals("1002"))    subject = "英语";
    else if (kkk.equals("1005"))    subject = "日语";
    else    subject = "俄语";
    String bbb = score.getBmd();
    String bmd = null;
    if (bbb.equals("10145"))    bmd = "沈阳";
    else if(bbb.equals("20145"))    bmd = "大连";
    else if(bbb.equals("30145"))    bmd = "锦州";
    else if(bbb.equals("40145"))    bmd = "抚顺";
    else   bmd = "阜新";
%>
<div class="panel panel-success">
    <div class="panel-heading" id='head'><h1>学位<%=subject%>考试信息核对</h1></div>
    <div class="panel-body">
        <div  id='container'>
            身份证号: <span class='info' id='sfzh'>${check.id}</span><br>
            姓名: <span class='info' id='xm'>${check.name}</span><br>
            性别: <span class='info' id='xb'><%=sex%></span><br>
            出生日期: <span class='info' id='csrq'><%=year%>年<%=month%>月<%=day%>日</span><br>
            民族: <span class='info' id='mz'><%=nation[mz]%></span><br>
            考生来源: <span class='info' id='ksly'><%=ksly%></span><br>
            学位单位：<span class='info'>东北大学</span> <br>
            专业: <span class='info' id='zymc'>${check.zymc}</span><br>
            入学年级: <span class='info' id='nj'><%=njy%>年<%=njm%>月</span><br>
            学制: <span class='info' id='xz'>${check.xz}</span><br>
            通信地址: <span class='info' id='txdz'>${check.txdz}</span><br>
            外语报考号: <span class='info' id='km1bm'><%=subject%></span><br>
            报名点: <span class='info' id='bmd'><%=bmd%></span><br>
        </div>
        <div id="photo">
            <img src="/img/${check.id}.jpg" onerror="javascript:this.src='/img/${check.id}.JPG'" alt="photo" style="width: 100px;height: 140px;">
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>
