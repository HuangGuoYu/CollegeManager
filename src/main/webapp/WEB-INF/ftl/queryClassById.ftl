<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script src="/jquery/jquery-3.3.1.min.js"></script>
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
        }

        td{
            width: 20%;
        }
    </style>
</head>
<body>
<table class="course_table">
    <tbody id="course_html">
        <tr>
            <th>周一</th>
            <th>周二</th>
            <th>周三</th>
            <th>周四</th>
            <th>周五</th>
        </tr>

    </tbody>
</table>

</body>

<script>

    $(function () {
        var data = '${user.slc_content}';
        var classList=JSON.parse(data);
       $.each(classList,function (index1,item1) {
           var tr=$("<tr></tr>");
            $.each(item1,function (index2,item2) {
                var str=item2.name+item2.teacher+item2.location+item2.range;
                var clssinfo=$("<td></td>").append(str);
                tr.append(clssinfo);
            })
            tr.appendTo("#course_html");
        });

    })
</script>
</html>