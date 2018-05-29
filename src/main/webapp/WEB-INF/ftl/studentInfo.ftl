<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script src="/jquery/jquery-3.3.1.min.js"></script>
    <style>
        #div1 {
            width: 100%;
            height: auto;
        }

        table {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
            width: 100%;
        }

        table td,
        table th {
            border: 1px solid #cad9ea;
            color: #666;
            height: 30px;
        }

        table thead th {
            background-color: #CCE8EB;
            width: 100px;
        }

        table tr:nth-child(odd) {
            background: #fff;
        }

        table tr:nth-child(even) {
            background: #F5FAFA;
        }

        td {
            width: 50%;
            height: 48px;
            border: 1px solid black;
        }

        @media screen and (max-width: 480px) {
            #div1 {
                height: 400px;
                width: 300px;
            }
        }
    </style>
</head>

<body>

<div id="div1">
    <table style="border: 1px solid black;">
        <tr>
            <td>姓名</td>
            <td>${user.stu_name}</td>
        </tr>
        <tr>
            <td>性别</td>
            <td>${user.stu_gender}</td>
        </tr>
        <tr>
            <td>电话</td>
            <td>${user.stu_tel}</td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>${user.sys_email}</td>
        </tr>
        <tr>
            <td>班级</td>
            <td>${user.class_name}</td>
        </tr>
        <tr>
            <td>辅导员</td>
            <td>${user.sys_name}</td>
        </tr>
    </table>
</div>

</body>


</html>