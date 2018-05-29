<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
		<script src="/jquery/jquery-3.3.1.min.js"></script>
		<style type="text/css">
			tr{
				height: 100px;
				font-size: 50px;
				line-height: 100px;
				text-align: center;
			}
		</style>
	</head>

	<body>
		<!--	<div style="height: 160px;background: #438EB9;font-size: 60px;line-height: 160px;">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true" ></span>
				 我的资料 
			</div>-->
 
		<div class="table-responsive" style="    padding-top: 20px;">
			<table class="table table-striped table-bordered table-hover">
				<tbody>
					<tr >
						 <td >姓名</td>
						 <td >${user.stu_name}</td>
					</tr>
					<tr >
						 <td >性别</td>
						 <td >${user.stu_gender}</td>
					</tr>
					<tr >
						 <td >电话</td>
						 <td >${user.stu_tel}</td>
					</tr>
					<tr >
						 <td >邮箱</td>
						 <td >${user.sys_email}</td>
					</tr>
					<tr >
						 <td >班级</td>
						 <td >${user.class_name}</td>
					</tr>
					<tr >
						 <td >辅导员</td>
						 <td >${user.sys_name}</td>
					</tr>
				</tbody>
			</table>
		</div>

	</body>

</html>