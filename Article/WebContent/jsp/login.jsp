<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article</title>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"
	type="text/javascript"></script>
</head>
<%@ include file="common/taglib.jsp" %>
<body style="background:#96B6D2;">
	<%@include file="common/header.jsp" %>
	<div class="logo-f">
		写出动人的故事
	</div>
	<div class="logo-s">
		原来如此简单
	</div>
	<div class="inputBox">
	<div class="mt50">用户登录</div>
	<div class='mt50 ml32'>
		<input type="text" id="username" autofocus="autofocus"
			autocomplete="off" maxlength="20" placeholder="请输入账号/邮箱/手机号">
		<i style='font-size: 20px; margin-left: -32px; opacity: 0.8;'
			class='iconfont icon-yonghuming'></i>
	</div>
	<div class='mt50 ml32'>
		<input type="password" id="password" autofocus="autofocus"
			autocomplete="off" maxlength="10" placeholder="请输入密码"> <i
			style='font-size: 20px; margin-left: -32px; opacity: 0.8;'
			class='iconfont icon-mima'></i>
	</div>

	<div class='mt50 ml32'>
		<button class="login_btn" onclick="login()">登陆</button>
	</div>
</div>
	<%@ include file="common/footer.jsp" %>
</body>
<script type="text/javascript">
	function login(){
		var name=$("#username").val();
		var pwd=$("#password").val();
		$.ajax({
			type:"post",//请求方式
	        url:"${basePath}/jsp/controller/loginController.jsp",//请求地址
	        data:{"username":name,"password":pwd},//传递给controller的json数据
	        error:function(){
	            alert("登陆出错！");
	        },
	        success:function(data){ //返回成功执行回调函数。
	        	if(data == -1){
                    alert('用户名和密码不能为空！');
                }else if(data == -2){
                    alert('用户名不存在！');
                }else if(data == -3){
                    alert('用户名或密码错误！');
                }else{
                    //登录成功后返回首页
                    window.location.href = "<c:url value='/jsp/index.jsp'/>"; 
                }
	        }
		});
	}
</script>
</html>