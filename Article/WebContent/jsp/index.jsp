<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="service.ArticleService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article</title>
<link rel="stylesheet" type="text/css" href="../css/common.css" />
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"
	type="text/javascript"></script>
</head>
<%@ include file="common/taglib.jsp"%>
<body style="background: #96B6D2;">
	<%@include file="common/header.jsp"%>
	<div class="logo-f">好的故事,令人难忘</div>
	<div class='h600' style='border: 1px solid #ccc'>
		<%
			//查询出编程代码类的相关文章
			List<Map<String, Object>> articles1 = ArticleService.getArticleByCategory("连载小说");
			pageContext.setAttribute("articles1", articles1);
		%>
		<div class='category'>
			<div class='title'>连载小说</div>
			<ul class='items'>
				<c:forEach items="${articles1}" var="item">
					<li class="item" onclick="location.href='${basePath}/jsp/detail.jsp?id=${item.ID}'">
						<div class="">
							<img src="item-icon" alt=""></img>
						</div>
						<div class="item-name">${item.NAME}</div>
						<div class="item-author">@${item.AUTHOR} 著</div>
						<div class='item-description'>${item.DESCRIPTION}</div>
					</li>
				</c:forEach>
				<div style='clear: both'></div>
			</ul>
		</div>
		<%
			//查询出编程代码类的相关文章
			List<Map<String, Object>> articles2 = ArticleService.getArticleByCategory("编程技术");
			pageContext.setAttribute("articles2", articles2);
		%>
		<div class='category'>
			<div class='title'>编程代码类</div>
			<ul class='items'>
				<c:forEach items="${articles2}" var="item">
					<li class="item" onclick="location.href='${basePath}/jsp/detail.jsp?id=${item.ID}'">
						<div class="">
							<img src="item-icon" alt=""></img>
						</div>
						<div class="item-name">${item.NAME}</div>
						<div class="item-author">@${item.AUTHOR} 著</div>
						<div class='item-description'>${item.DESCRIPTION}</div>
					</li>
				</c:forEach>
				<div style='clear: both'></div>
			</ul>
		</div>
	</div>
	<%@ include file="common/footer.jsp"%>
</body>
<script type="text/javascript">
	function toDetails(id){
	}
</script>
</html>