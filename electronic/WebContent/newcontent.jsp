<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
   
<style>

.hide{display:none;}
h1{font-size: 2.17em; text-align:center;}
/* 
ul{width:80%;margin-left:100px;position:relative;}
ul li{list-style:none; width:30px;}


	  */
</style>
</head>
<body>
<%@ include file="hearderr.jsp" %>

<div style="width:80%;margin-left:200px;position:relative;">
	<h1>竞赛内容</h1>
	<c:forEach var="n" items="${newslist}">
		<div style="margin-bottom:30px;  ">
			<ul style="width:80%;position:relative;height:45px;line-height:45px;margin-left: 100px;">
			<li><span class="hide">  ${n.NEWS_ID}</span>
			<!-- <div style="display:inline-block;position:relative; width overflow:hidden;"> -->
			<span class="specspan" style="display:inline-block; width:400px;height:45px; overflow:hidden;"> ${n.NEWS_CONTENT }</span>
			<!-- </div> -->
			<div class="diva" style="display: inline-block;position:absolute;right:0;"><a class="btn btn-primary" role="button" href="admin_tonewslookcontent?id=${n.NEWS_ID }">${n.NEWS_TIME }查看</a></div>
			
			</li>
			</ul>
		
		</div>
	</c:forEach>
</div>
<div class="footer">
 
    <p class="dibu">monkey 电子竞赛平台&copy;2020-2020公司版权所有 京ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
	<%-- <h1>竞赛内容</h1>
	
	<c:forEach var="n" items="${newslist}">
		
		<tr>
			<td ><span class="hide">  ${n.NEWS_ID}</span> </td>
		<td>  ${n.NEWS_CONTENT} </td>
		<!-- 这样点击修改就跳到ToUserUpdate servlet中 --> 
		<td><a class="link-update" href="admin_tonewslookcontent?id=${n.NEWS_ID }">查看</a></td><br/>
	</c:forEach>
	 --%>
</body>
</html>