<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="manage/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="manage/css/main.css"/>
     <style>
     h2{margin-left:300px;}
     .crumb-wrap{width:800px;height:431px;}
    	.error {
    		display:inline-block;
    		border:1px solid #ff855a;
    		background-color:#ffe8e0;
    		height:25px;
    		font-size:15px;
    		line-height:25px;
    		padding:0px 20px;
    		margin-left:20px;
    	}
    	
    </style>
   <!-- 	<style>
   		.contest {position:relative;float:left;text-align:center;}
    	.contest p{position:absolute;bottom:0;left:0;text-align:center;width:100%;}
   	</style> -->
</head>
<body>
<%@ include file="hearderr.jsp" %>

  <!--/sidebar-->
    <div class="main-wrap">
		<h2>请确保信息无误再提交</h2>
        <div class="crumb-wrap">
            
        <div class="result-wrap">
            <div class="result-content">
            <!-- 更改  去manage-->
                <form action="/monkey/user_dousersignup" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required" id="title" onfocus="FocusItem(this)" onblur="Check(this)" name="userName" size="50" value="" type="text"><span></span>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>用户姓名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>身份证号：</th>
                                <td>
                                    <input class="common-text required" id="title" onfocus="FocusItem(this)" name="code" size="50" value="" type="text"><span></span>
                                </td>
                            </tr>
                           
                            <tr>
                                <th>性别：</th>
                                <td>
                                    <input type="radio" name="sex"  value="T" checked="checked">男
                                    <input type="radio" name="sex"  value="F">女
                                </td>
                            </tr>
                            <tr>
                                <th>出生日期：</th>
                                <td>
                                    <input class="common-text required" onfocus="c.show(this)" id="title" name="birthday" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>电子邮箱：</th>
                                <td>
                                    <input class="common-text required" id="title" name="email" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>手机号码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="mobile" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>送货地址：</th>
                                <td>
                                    <input class="common-text required" id="title" name="address" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                           
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/function.js"></script>
 <script src="js/calendar.js"></script>
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