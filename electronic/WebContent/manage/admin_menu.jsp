<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
     <style>
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
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="/electronic/manage/admin_index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="/electronic/manage/admin_index.jsp">首页</a></li>
                <li><a href="/electronic/index.jsp" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">管理员:${name.USER_ID }</a></li>
                <li><a href="admin_touserupdate?id=${name.USER_ID }&cpage=${cpage}">修改密码</a></li>
                <li><a href="/electronic/manage/admin_logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                    <!-- 访问注解 -->
                        <li><a href="/electronic/manage/admin_douserselect"><i class="icon-font">&#xe008;</i>用户注册管理</a></li>
                        <li><a href="/electronic/manage/admin_dosuserselect"><i class="icon-font">&#xe005;</i>报名管理</a></li>
                        
                        <li><a href="/electronic/manage/admin_donewsintroselect"><i class="icon-font">&#xe052;</i>新闻简介管理</a></li>
                        <li><a href="/electronic/manage/admin_donewsbulletinselect"><i class="icon-font">&#xe052;</i>新闻公告管理</a></li>
                          <li><a href="/electronic/manage/admin_donewscontentselect"><i class="icon-font">&#xe052;</i>新闻内容管理</a></li>
                        <li><a href="/electronic/manage/admin_donewsinfoselect"><i class="icon-font">&#xe052;</i>新闻报名须知管理</a></li>
                    </ul>
                </li>
                
            </ul>
        </div>
    </div>