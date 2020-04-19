<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.html"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1">
           <p class="fl"> <input type="text" class="filter" id="filter" style="border:1px solid #000"></p>
            <!--实现登录后不显示登录注册按钮  -->
            <p class="fl"><c:if test="${isLogin != 1}">
            	<a href="login.jsp" id="login">登录</a><a href="#" id="reg">注册</a>
            </c:if>
            <!--普通用户标记位  -->
             <c:if test="${isLogin == 1}">
            	<b>您好：</b><a href="login.jsp" id="login">${name.USER_NAME}</a>
            </c:if>
            <!--管理员标记位  -->
             <c:if test="${isAdminLogin == 1}">
                        <a href="manage/admin_index.jsp">进入后台</a>
            </c:if>
            </p>
               <!--  <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        type="button"/></form> -->
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a>
                        <c:if test="${isLogin == 1}">
                        <a href="cart.html"><img src="img/gwc.png"/></a>
                        </c:if>
                        
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="index.jsp">首页</a></li>
            <li><a href="#">竞赛新闻介绍</a>
                <div class="sList">
                    <div class="wrapper  clearfix"><a href="/electronic/admin_donewslook">
                        <dl>
                            <dt><img style="height:184px;" src="img/news.jpg"/></dt>
                            <dd>竞赛简介</dd>
                        </dl>
                    </a><a href="/electronic/admin_donewbulletin">
                        <dl>
                            <dt><img style="height:184px;" src="img/bulletin.jpg"/></dt>
                            <dd>竞赛公告</dd>
                        </dl>
                    </a><a href="/electronic/admin_donewcontent">
                        <dl>
                            <dt><img style="height:184px;" src="img/content.jpg"/></dt>
                            <dd>竞赛内容</dd>
                        </dl>
                    </a><a href="/electronic/admin_donewinfo">
                        <dl>
                            <dt><img style="height:184px;" src="img/info.jpg"/></dt>
                            <dd>报名须知</dd>
                        </dl>
                    </a></div>
                </div>
            </li>
            <li><c:if test="${isLogin == 1}"><a href="user_signup.jsp"><i class="icon-font"></i>报名入口 </a></c:if></li>
           <li> <a href="manage/admin_index.jsp">进入后台</a></li>
        </ul>
    </div>
</div>