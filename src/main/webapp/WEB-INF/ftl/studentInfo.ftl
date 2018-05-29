<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <style>
        .course_table{
            width: 100%;
            border-spacing: 0;
        }
        .course_table th{
            height: 2.5em;
            background: #f3f8f8;
            color: #6d8498;
            font-weight: 400;
            font-size: 0.95em;
        }
        .course_table td{
            font-size:0.925em;
            height: 8em;
            border-bottom: 2px solid #eee;
            border-right: 2px solid #eee;
            text-align: center;
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
            width: 50%;
        }

    </style>
</head>
<body>
<table class="course_table">
    <tbody id="course_html">
    <tr>
        <td>姓名</td>
        <td><div>${user.stu_name!}</div></td>
    </tr>
    <tr>
        <td>性别</td>
        <td><div>${user.stu_gender!}</div></td>
    </tr>
    <tr>
        <td>电话</td>
        <td><div>${user.stu_tel!}</div></td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td><div>${user.sys_email!}</div></td>
    </tr>
    <tr>
        <td>班级</td>
        <td><div>${user.class_name!}</div></td>
    </tr>
    <tr>
        <td>辅导员</td>
        <td><div>${user.sys_name!}</div></td>
    </tr>
    </tbody>
</table>
</body>
</html>
