<%@page import="com.article.bean.UserBean"%>
<%@page import="utils.StringUtils"%>
<%@page import="service.LoginService" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

    //设置请求的编码
    //request.setCharacterEncoding("UTF-8");
    //获取客户端传递过来参数
    String username = request.getParameter("username");
    String password = request.getParameter("password");
	if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
		out.print("-1");    //用户名或密码不能为空
	}else{
		UserBean ub=LoginService.getUser(username);
		if(ub==null){
			out.print("-2"); //用户名不存在
		}else if(!ub.password.equals(password)){
			out.print("-3");   //用户名或密码错误
		}else{
			out.print("0");
			session.setAttribute("username", username);
			session.setAttribute("pwd", password);
			session.setAttribute("user", ub);
		}
	}    
%>