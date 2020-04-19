<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/electronic/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增作品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/electronic/manage/admin_donewscontentadd" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr >
                                <th><i class="require-red">*</i>竞赛id：</th>
                                <td>
                                    <input class="common-text required" id="title" name="newsid" onfocus="FocusItem(this)" onblur="CheckNews(this)" size="50" value="" type="text"><span></span>
                                </td>
                                
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>竞赛标题：</th>
                                <td>
                                    <input class="common-text required" id="title" name="title" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>竞赛内容：</th>
                                <td>
                                    <input class="common-text required" id="title" name="content" size="50" value="" type="text">
                                </td>
                            </tr>
                         
                           <tr>
                                <th><i class="require-red">*</i>添加时间：</th>
                                <td>
                                    <input class="common-text required" onfocus="c.show(this)" id="title" name="time" size="50" value="" type="text">
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
    <script src="../js/function.js"></script>
</body>
</html>