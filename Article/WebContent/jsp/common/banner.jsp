<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="banner">
	<div class="content">
		<i class='btn_left' onclick="left()"></i>
		<ul>
			<li><a href="javascript:void(0)"><img alt=""
					src="image/5.jpg"></img></a></li>
			<li><a href="javascript:void(0)"><img alt=""
					src="image/1.jpg"></img></a></li>
			<li><a href="javascript:void(0)"><img alt=""
					src="image/2.jpg"></img></a></li>
			<li><a href="javascript:void(0)"><img alt=""
					src="image/3.jpg"></img></a></li>
			<li><a href="javascript:void(0)"><img alt=""
					src="image/4.jpg"></img></a></li>
			<li><a href="javascript:void(0)"><img alt=""
					src="image/5.jpg"></img></a></li>
			<li><a href="javascript:void(0)"><img alt=""
					src="image/1.jpg"></img></a></li>
		</ul>
		<i class='btn_right' onclick="right()"></i>
	</div>
</div>

<script type="text/javascript">
	var index = 0;
	var imgWidth = $(".banner .content ul li").width();
	var len = $(".banner .content ul li").length - 2;
	var timer = null;
	function right() {
		clearTimeout(timer);
		timer = setTimeout(function() {
			index++;
			marquee();
		}, 500);
	}

	function left() {
		clearTimeout(timer);
		timer = setTimeout(function() {
			index--;
			marquee();
		}, 500);
	}
	function marquee() {
		if ($(".banner .content ul").is(":animated"))
			return;
		$(".banner .content ul").animate({
			"margin-left" : -imgWidth * (index + 1)
		}, 1000, function() {
			if (index >= len) {
				$(this).css("margin-Left", -imgWidth);
				index = 0;
			} else if (index <= -1) {
				$(this).css("margin-Left", -imgWidth * len);
				index = len - 1;
			}

		})
	}
</script>