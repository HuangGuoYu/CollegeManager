<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/9/16
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <style>
        body{
            background: url('layui/images/background/ef216d2b32a23d502b85656ceac6da6ef7aa2f0013a39-oDX5fm_fw658.jpg')top center no-repeat;
            background-size:cover;
        }
        .loginc{
            /*height: 50%;高度宽度自适应居中*/
            /*width: 30%;*/
            /*top: 25%;*/
            /*left: 35%;*/
            /*或者*/
            /*高度宽度固定居中*/
            height: 350px;
            width: 400px;
            top:0;
            bottom: 0;
            right: 100px;
            margin: auto;
            position: absolute;
            background-color: white;
            border-radius: 15px;/*div四个角尖角变成圆角*/
            font-size: 16px;
            filter:alpha(Opacity=80);
            -moz-opacity:0.8;
            opacity: 0.8;
        }
        .in{
            text-align: center;
            margin-top: 50px;
        }
        .b1{
            display: inline-block;/*设置成行级元素，可放在一行中*/
            margin-left: 87px;;
            margin-top: 50px;
        }
        .sel{
            width: 197.58px;
            height: 22.24px;
        }
    </style>
</head>
<div class="loginc">
    <div class="in" id="acount">
        <lable>登录名：</lable>
        <input value="sa"/>
    </div>
    <div class="in" id="pwd">
        <lable>密&nbsp;&nbsp;&nbsp;码：</lable>
        <input type="password" value="123456"/>
    </div>
    <div class="in" id="identity">
        <label>身&nbsp;&nbsp;&nbsp;份：</label>
            <select id="sel" class = "sel">
                <option value="" selected="">请选择身份</option>
                <option value="3">管理员</option>
                <option value="2">辅导员</option>
                <option value="1">老师</option>
            </select>
    </div>
    <div class="b1">
        <button class="layui-btn layui-btn-normal" id="login">登录</button>
    </div>
    <div class="b1">
        <button class="layui-btn layui-btn-normal">重置</button>
    </div>
</div>
<script src="layui/layui.all.js" charset="utf-8"></script>
<script>
    //登录逻辑
    $(function () {
        $("#login").click(function () {
           var acount = $("#acount input").val();
            var pwd = $("#pwd input").val();
            var sysIdentity =  $("#sel").val();
           // console.log(sysIdentity);
           $.post(
               "${pageContext.request.contextPath}/system/login",
               {
                    "SysUsername":acount,
                    "SysPassword":pwd,
                    "sysIdentity":sysIdentity
               },
               function (data) {
                   if(data.code == 200){
                       console.log(sysIdentity);
                        switch (sysIdentity){
                            case '1':
                                console.log("${pageContext.request.contextPath}/teacher.jsp");
                                window.location.href = "${pageContext.request.contextPath}/teacher.jsp";
                                break;
                            case '2':
                                window.location.href = "${pageContext.request.contextPath}/counselor.jsp";
                                break;
                            case '3':
                                window.location.href = "${pageContext.request.contextPath}/admin.jsp";
                                break;
                            case '4':
                                window.location.href = "${pageContext.request.contextPath}/superadmin.jsp";
                                break;
                        }
                   }
                   else{
                       layer.alert(data.msg);
                   }
               }
           )
        });
    })
</script>
</body>
</html>
