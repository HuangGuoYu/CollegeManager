function BottomRight(url){	
	$.ajax({	
		type:"get",
		url:url,
		success:function(dates){			 
			$("#bottom-right").html(dates);
		}
	});
}

/*弹窗局部加载*/
function TcBottom(url){	
	$.ajax({	
		type:"get",
		url:url,
		success:function(dates){			 
			$("#tc-bottom").html(dates);
		}
	});
}

/*显示弹窗*/
function showBallWindow() {
	$('.tc-mask').fadeIn(100);
	$('.tc-html').slideDown(200);
}

/*--------------------教师端----------------------*/

/*查看课程信息*/
function doCourseInfo() {
	BottomRight("courseInfo.html");
}

/*查看出勤*/
function doFind() {
	showBallWindow("courseInfoOne.html");
}

/*查看历史出勤*/
function doHistorySign() {
	TcBottom("courseInfoOne.html");
}

/*开始点名*/

/*发布公告*/ 
function doTeacherAnnouncement() {
	BottomRight("teacherAnnouncement.html");
}

/*查看公告*/
function doTeacherSeeAnnouncement() {
	BottomRight("teacherSeeAnnouncement.html");
}


/*--------------------辅导员端----------------------*/

/*学生返校*/
function doStuBSchool() {
	BottomRight("stuBSchool.html");
}

/*请假批准*/
function doLeaveApproval() {
	BottomRight("leaveApproval.html");
}

/*查看请假学生*/
function doSeeStuLeave() {
	BottomRight("seeStuLeave.html");
}

/*发布公告*/
function doInstructoAnnouncement() {
	BottomRight("instructoAnnouncement.html");
}

/*查看公告*/
function doInstructoSeeAnnouncement() {
	BottomRight("instructoSeeAnnouncement.html");
}
