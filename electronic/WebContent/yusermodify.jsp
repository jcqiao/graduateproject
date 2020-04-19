<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
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
</head>
<body><!------------------------------head------------------------------>
<%@ include file="hearderr.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

         <div class="main-wrap">
        <div class="result-wrap">
            <div class="result-content">
                <form action="/electronic/doyuserupdate" method="post" id="myform" name="myform" >
                   <input type="hidden" name="userStatus" value="${user.USER_STATUS }">
                    
                    <input type="hidden" name="cpage" value="${cpage }">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr style="display: none">
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="userName" size="50" value="${user.USER_ID }" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>用户姓名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="${user.USER_NAME }" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>修改密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="passWord" size="50" value="${user.USER_PASSWORD}" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th>性别：</th>
                                <td>
                                    <input type="radio" name="sex"  value="T"  ${user.USER_SEX == 'T'?'checked':'' }>男
                                    <input type="radio" name="sex"  value="F" ${user.USER_SEX == 'F'?'checked':'' }>女
                                </td>
                            </tr>
                           
                            <tr>
                                <th><i class="require-red">*</i>手机号码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="mobile" size="50" value="${user.USER_MOBILE }" type="text">
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
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>