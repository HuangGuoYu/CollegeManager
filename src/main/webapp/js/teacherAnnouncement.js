console.log("sssssssssssss");
var data =  {
    "pDate":"2018-01-01",
    "pUserid":1,
    "pIden":2,
    "pTitle":"邓帅嫖娼又被抓",
    "pContrent":"邓帅",
    "pStu":3
};
$('#btn_teacher_post').click(function () {
        console.log("点击了添加公告");
        $.ajax({
            url:'/tf/addAnnouncement',
            type:"POST",
            dataType:"json",
            data:JSON.stringify(data),
            success:function(data) {
                if (data.code == 200){
                    console.log("添加数据成功");
                }
            },
            error:function (data) {
                alert("添加失败"+data.code);
            }
        });
    }
);

function getTeacherAnnouncementEvents() {


}