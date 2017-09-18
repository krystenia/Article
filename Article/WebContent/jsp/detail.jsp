<%@page import="service.CommentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="service.ArticleService"%>
<%@page language="java" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="common/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="${basePath}/css/common.css" />
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"
	type="text/javascript"></script>
<title>Article</title>
</head>
<body>
	<%@include file="common/header.jsp"%>
	<%
		String id = request.getParameter("id");
		Map<String, Object> article = ArticleService.getArticleById(id);
		pageContext.setAttribute("article", article);
		pageContext.setAttribute("id", id);
	%>
	<div class="content">
		<div class="detail-title">${article.NAME}</div>
		<div class="author">
			<span class="title">作者：</span><span class="info">${article.AUTHOR}</span>
		</div>
		<div class="publish">
			<span class="title">发布时间:</span><span class="info">${article.CREATE_TIME}</span>
		</div>
		<hr class="line" />
		<div class="article-content">
			<p>${article.CONTENT}</p>
		</div>
	</div>
	<%
		List<Map<String, Object>> comments = CommentService.getCommentsById(id);
		System.out.println(comments);
		pageContext.setAttribute("comments", comments);
	%>
	<div class="comment">
		<div>
			<ul>
				<c:forEach items="${comments}" var="item" varStatus="status">
					<li class="comment-box"
						style="border: 1px solid #E8F2FE; margin: 10px 20px; padding: 5px 5px; list-style: none;">
						<div class="index" style="display: inline-block; color: #6FBC4C">#${
							status.index + 1}楼</div>
						<div style="float: right; display: inline-block;">
							<span class="userid" style="color: #6FBC4C;">${item.USER_ID}</span>
							<span>|</span> <span class="updatetime">${item.CREATE_TIME}</span>
						</div>
						<div class="content">${item.CONTENT}</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="ml20">评论</div>
		<div class="center">
			<textarea class="comment-area" id="comment-area" rows="3" cols="20"></textarea>
		</div>
		<div class="right">
			<button class="comment-btn" onclick="comment()">提交</button>
		</div>
	</div>
	<%@include file="common/footer.jsp"%>
	<script type="text/javascript">
		function comment() {
			var txt = $("#comment-area").val();
			var id='<%=id%>';
			$.post("${basePath}/jsp/controller/CommentController.jsp", {
				txt : txt,
				articleID:id
			}, function(data) {
				data = data.trim();
				if (data == '-1') {
					alert('请先登录！');
				}else{
					document.location.reload();
				}
			}); 
		}
	</script>
</body>
</html>