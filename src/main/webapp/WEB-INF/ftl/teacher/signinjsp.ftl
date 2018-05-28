<html>
<head>
    <meta charset="utf-8">
    <title>签到</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<table class="layui-hide" id="test"></table>


<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'/teacher/signin/'
            ,cols: [[
                {field:'courseId', width:80, title: 'ID', sort: true}
                ,{field:'courseName', width:80, title: '用户名'}
                ,{field:'courseSysname', width:80, title: '性别', sort: true}
                ,{field:'courseAddress', width:80, title: '城市'}
                ,{field:'courseTime',  width:80,title: '签名', minWidth: 150}
            ]]
            ,page: true
        });
    });
</script>

</body>
</html>