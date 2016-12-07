<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
</head>
		<frameset rows="80px,*" border="1px">
		<frame src="${pageContext.request.contextPath}/top.jsp" scrolling="no" noresize /> 
		<frameset cols="240px,*">
			<frame noresize src="${pageContext.request.contextPath}/left.jsp" scrolling="yes" /> 
			<frame noresize name="right" src="${pageContext.request.contextPath}/right.jsp" scrolling="yes" /> 
		</frameset>
	</frameset>
	<noframes>
		<body>
			你的浏览器不支持框架布局，推荐你使用<a href="http://www.firefox.com.cn/download/" style="text-decoration: none;">火狐浏览器</a>,
			<a href="http://www.google.cn/intl/zh-CN/chrome/" style="text-decoration: none;">谷歌浏览器</a>
		</body>
	</noframes>

</html>