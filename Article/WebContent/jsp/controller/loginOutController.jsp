<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	session.removeAttribute("username");
	session.removeAttribute("pwd");
	session.invalidate();
	String path = request.getContextPath();
    //获取端口
    int port = request.getServerPort();
    String basePath  = null;
    if(port==80){
        basePath = request.getScheme()+"://"+request.getServerName()+path;
    }else{
        basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    }
	response.sendRedirect(basePath + "/jsp/login.jsp");
%>
