<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="admin_menu.jsp" %>

    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/electronic/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">用户报名管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/electronic/manage/admin_dosuseradd" enctype="multipart/form-data" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required" id="title" onfocus="FocusItem(this)" onblur="Check(this)" name="userName" size="50" value="" type="text">
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
                                <th><i class="require-red">*</i>身份证号：</th>
                                <td>
                                    <input class="common-text required" id="title" name="code"  onfocus="FocusItem(this)" onblur="Check(this)" size="50" value="" type="text">
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
                                <th>出生日期：</th>
                                <td>
                                    <input class="common-text required" onfocus="c.show(this)" id="title" name="birthday" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>电子邮箱：</th>
                                <td>
                                    <input class="common-text required"  id="title" name="email"  onfocus="FocusItem(this)" onblur="Check(this)" size="50" value="" type="text"><span></span>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>手机号码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="mobile" onfocus="FocusItem(this)" onblur="Check(this)" size="50" value="" type="text"><span></span>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>送货地址：</th>
                                <td>
                                    <input class="common-text required" id="title" name="address" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>参赛项目：</th>
                                <td>
                                   <select id="selec" name="compete">
                                   		<option value="音频信号分析仪">音频信号分析仪</option>
                                   		<option value="无线识别装置">无线识别装置</option>
                                   		<option value="数字示波器">数字示波器</option>
                                   		<option value="开关稳压电源">开关稳压电源</option>
                                   </select>
                                </td>
                            </tr>
                            
                              <tr>
                                <th><i class="require-red">*</i>上传文件：</th>
                                <td>
                                    <input class="common-text required" id="title" name="file" size="50" value="" type="file">
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