<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="/css/DateTimePicker.css"/>
    <script type="text/javascript" src="/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/DateTimePicker.js"></script>
    <style>
        .course_table {
            width: 100%;
            border-spacing: 0;
        }

        .course_table th {
            height: 2.5em;
            background: #f3f8f8;
            color: #6d8498;
            font-weight: 400;
            font-size: 0.95em;
        }

        .course_table td {
            font-size: 0.925em;
            height: 2.5em;
            border-bottom: 2px solid #eee;
            border-right: 2px solid #eee;
            text-align: center;
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
        }

        .course_table tr td:first-child {
            background: #f3f8f8;
            color: #698196;
            border-bottom: none;
            width: 20%;
        }

        input {
            width: 100%;
            height: 2.5em;
            border: 0px;
            border-bottom-style: none;
            border-bottom: #00A862;
            border-bottom: 1px solid rgba(0, 0, 0, 0.12);
            -ms-border-bottom: 1px solid #edebe9;
            border-radius: 0;
            box-sizing: border-box;
            outline: none;
            padding-left: 2em;
        }

        button {
            margin-left: 75%;
            line-height: 24px;
            margin-top: 20px;
            width: 88px;
            background: none;
            border: 1px solid #00A862;
            border-top-color: rgb(0, 168, 98);
            border-right-color: rgb(0, 168, 98);
            border-bottom-color: rgb(0, 168, 98);
            border-left-color: rgb(0, 168, 98);
            box-sizing: border-box;
            color: #00A862;
            display: inline-block;
            font-weight: 500;
            outline: none;
            overflow: hidden;
            padding: 6px 18px;
            transition-duration: 0.1s;
            transition-property: background, border-color, color;
        }


    </style>
</head>
<body>
<form id="leaveForm">
    <table class="course_table">
        <tbody id="course_html">
        <tr>
            <td>原因</td>
            <td><input type="text" name="slReason"></td>
        </tr>
        <tr>
            <td>开始时间</td>
            <td><input type="text" data-field="date" readonly name="slBegindate"></td>
        </tr>
        <tr>
            <td>结束时间</td>
            <td><input type="text" data-field="date" readonly name="slEnddate"></td>
        </tr>
        </tbody>
    </table>

</form>
<button id="submitForm">提交</button>
<div id="dtBox"></div>

<script type="text/javascript">
    $(document).ready(function () {
        $("#dtBox").DateTimePicker({});
    });
    $("#submitForm").click(function () {
        $.ajax({
            type:"POST",
            url:"/student/leave",
            data:$('#leaveForm').serialize(),
            success:function(data){
                if(data.code==200){
                    alert("添加成功");
                }
            }
        })
    })
</script>
</body>
</html>
