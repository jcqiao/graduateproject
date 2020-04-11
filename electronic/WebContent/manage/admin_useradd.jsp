<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="admin_menu.jsp" %>

    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/monkey/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/electronic/manage/admin_douseradd" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required" id="title" onfocus="FocusItem(this)" onblur="CheckItem(this)" name="userName" size="50" value="" type="text">
                               	<span></span>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>用户姓名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>登陆密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="passWord" onfocus="FocusItem(this)" onblur="CheckItem(this)" size="50" value="" type="text">
                                	 	<span></span>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>确认密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="repassWord" onfocus="FocusItem(this)" onblur="CheckItem(this)" size="50" value="" type="text">
                                	<span></span>
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
                                <th><i class="require-red">*</i>手机号码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="mobile" onfocus="FocusItem(this)" onblur="CheckItem(this)"  size="50" value="" type="text"><span></span>
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
    <script src="../js/jquery-1.12.4.min.js"></script>
<script src="../js/calendar.js"></script>
<script src="../js/function.js"></script>
</body>
</html>