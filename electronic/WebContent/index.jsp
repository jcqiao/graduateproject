<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>最家</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
   	<style>
   		.contest {position:relative;float:left;text-align:center;}
    	.contest p{position:absolute;bottom:0;left:0;text-align:center;width:100%;}
   	</style>
    	
   
    
</head>
<body><!------------------------------head------------------------------>
<%@ include file="hearderr.jsp" %>

<!-------------------------banner--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                <div class="slide"><img style="width:100%;height:403px;text-align:center;" src="img/bg2.png"/></div>
            </li>
            <li>
                <div class="slide"><img style="width:100%;height:403px;" src="img/bg1.png"/></div>
            </li>
        </ul>
    </div>
</div><!------------------------------thImg------------------------------>
<div class="thImg">
    <div class="clearfix" style="height:230px"><a href="#"><img src="img/news2.jpg"/></a><a href="#"><img
            src="img/news3.jpg"/></a><a href="#2"><img src="img/news4.jpg"/></a></div>
</div><!------------------------------news------------------------------>
<div class="news">
    <div class="wrapper"><h2><img src="img/ih1.jpg"/></h2>
        <div class="top clearfix ">
        <div class="contest"><h3>竞赛简介</h3><a href="/monkey/admin_donewselect"><img src="img/news.jpg"/>
           <p>竞赛简介</p></a>
            </div>
        
            
            <div class="contest"><h3>竞赛公告</h3> <a href="/monkey/admin_donewbulletin"><img style="width:400px;height:284px;"  src="img/bulletin.jpg"/><p>竞赛公告</p></a></div>
           <div class="contest"><h3>竞赛内容</h3> <a href="/monkey/admin_donewcontent"><img style="width:600px;" src="img/content.jpg"/>
            <p>竞赛内容</p></a></div>
             <div class="contest"><h3>报名须知</h3><a href="/monkey/admin_donewinfo"><img style="width:400px;height:284px;" src="img/info.jpg"/>
            <p></p></a></div>
            </div>
           
           
       
    </div>
</div><!------------------------------ad------------------------------><!--返回顶部-->
<div class="gotop"><a href="cart.html">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.html">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!-------------------login-------------------------->

<!-- ---竞赛简介 ----  -->
<%-- <div>
	<h3>竞赛简介</h3>
	<tr>
		<td>  ${n.NEWS_ID} </td>
		<td>  ${n.NEWS_INTRO } </td>
		<!-- 这样点击修改就跳到ToUserUpdate servlet中 --> 
		<td><a class="link-update" href="admin_touserupdate?id=${u.USER_ID }">查看</a></td>
	</tr>
</div> --%>

    
    <!--footer-->
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
</body>
</html>