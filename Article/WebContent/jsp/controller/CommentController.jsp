<%@page import="service.CommentService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.UUID"%>
<%@page import="com.article.bean.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.article.bean.UserBean"%>
<%
	UserBean user = (UserBean) session.getAttribute("user");
	if (user == null) {//代表用户没有登陆
		out.print("-1");
		return;
	}
	String txt = request.getParameter("txt").toString();
	String articleId=request.getParameter("articleID").toString();
	Date d=new Date();
	String dateStr=d.getTime()+"";
	Comment comment=new Comment(UUID.randomUUID().toString(),user.id,txt,articleId,dateStr,dateStr,1);
	CommentService.saveComment(comment);
%>
