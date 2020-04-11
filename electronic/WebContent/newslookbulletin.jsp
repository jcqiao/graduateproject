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
   <!--  <style>
    .sdiv{width:80%;margin-left:144px;}
    	h1{width:100%;height:50px;text-align:center;font-size:30px;margin-bottom:50px;margin-top:15px;background-color:#0066CC;}
    	.ssection{border:2px solid #ddd;width:100%;height:1000px;}
    	p{width:80%;margin-left:116px;text-indent:2em;line-height: 40px;font-size:1.71em;}
    	
    </style> -->
</head>
<body>
<%@ include file="hearderr.jsp" %>
<div style="width:80%;margin-left:144px;">
 <h1 style="width:100%;height:50px;text-align:center;font-size:30px;margin-bottom:50px;margin-top:15px;background-color:#0066CC;">竞赛公告</h1>
<section style="border:2px solid #ddd;width:100%;height:1000px;">
<p style="width:80%;margin-left:116px;text-indent:2em;line-height: 40px;font-size:1.71em;">${news.NEWS_BULLETIN }</p>
</section>
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
</div>
</body>
</html>