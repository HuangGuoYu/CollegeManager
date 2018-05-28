<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>主界面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <style>
        .box {
            display: box;
            display: -moz-box;
            display: -webkit-box;
        }

        .box-ver {
            box-orient: vertical;
            -moz-box-orient: vertical;
            -webkit-box-orient: vertical;
        }

        .flex1 {
            flex: 1;
            -webkit-box-flex: 1;
            -moz-box-flex: 1;
        }

        .flex2 {
            flex: 2;
            -webkit-box-flex: 2;
            -moz-box-flex: 2;
        }

        .flex5 {
            flex: 15;
            -webkit-box-flex: 15;
            -moz-box-flex: 15;
        }
    </style>
</head>
<div >
    <div id="top">
        <ul class="layui-nav" style="text-align: right">
            <li class="layui-nav-item">
                欢迎您：
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;"><img src="http://t.cn/RCzsdCq" class="layui-nav-img">${user.sysName}</a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/system/outLogin">退出登录</a></dd>
                </dl>
            </li>
        </ul>·
    </div>
    <div id="bottom" class="box" style="height: 90%">
        <div id="bottom-left" style="width: 200px">
            <ul class="layui-nav layui-nav-tree  layui-nav-side" lay-filter="demo"
                style="margin-right: 10px;margin-top: 60px; ">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">签到管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:open('${pageContext.request.contextPath}/teacher/test');" onclick="">查看签到信息</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
        <div id="bottom-right" class="flex1" >
            <iframe style="width: 100%;height: 100%;" src="${pageContext.request.contextPath}/supplier/allBookPage"></iframe>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('element', function () {
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function (elem) {
            console.log(elem)
           // layer.msg(elem.text());
        });
    });
    function open(url){
        console.log(url);
        $("#bottom-right iframe").attr("src",url);
    };
</script>
</body>
</html>
