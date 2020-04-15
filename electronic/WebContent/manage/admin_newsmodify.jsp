<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/electronic/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_news.jsp">新闻管理</a><span class="crumb-step">&gt;</span><span>新增新闻</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/electronic/manage/admin_donewsupdate" method="post" id="myform" name="myform" >
                    
                    <input type="hidden" name="cpage" value="${cpage }">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                                <th><i class="require-red">*</i>竞赛id：</th>
                                <td>
                                 <input class="common-text required" id="title" name="newsid" size="50" value="${news.NEWS_ID }" type="text"> 
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>竞赛介绍：</th>
                                <td>
                                <textarea rows="10" cols="80" name="introduce" style="line-height:25px;">
								${news.NEWS_INTRO }
								</textarea>

                                
                                  <%--   <input style="height:200px;  width:416px; overflow:scroll; padding:1px;line-height:20px;" class="common-text required" id="title" name="introduce" size="50" value="${news.NEWS_INTRO }" type="text"> --%>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>竞赛公告：</th>
                                <td>
                                  <textarea rows="10" cols="80" name="bulletin"  style="line-height:25px;">
								${news.NEWS_BULLETIN }
								</textarea>
                                    <%-- <input class="common-text required" id="title" name="bulletin" size="50" value="${news.NEWS_BULLETIN} " type="text"> --%>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>竞赛新闻标题：</th>
                                <td>
                                  <textarea rows="10" cols="80" name="title"  style="line-height:25px;">
								${news.NEWS_TITLE }
								</textarea>
                                   <%--  <input class="common-text required" id="title" name="title" size="50" value="${news.NEWS_TITLE } " type="text"> --%>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>竞赛新闻内容：</th>
                                <td>
                                  <textarea rows="10" cols="80" name="content"  style="line-height:25px;">
								${news.NEWS_CONTENT }
								</textarea>
                                  <%--   <input class="common-text required" id="title" name="content" size="50" value="${news.NEWS_CONTENT} " type="text"> --%>
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>报名通知：</th>
                                <td>
                                  <textarea rows="10" cols="80" name="info"  style="line-height:25px;">
								${news.NEWS_INFO }
								</textarea>
                                  <%--   <input class="common-text required" id="title" name="info" size="50" value="${news.NEWS_INFO } " type="text"> --%>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>添加时间：</th>
                                <td>
                                 
                                 <input class="common-text required" onfocus="c.show(this)" id="title" name="time" size="50" value="${news.NEWS_TIME } " type="text"> 
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
   <script src="../js/jquery-1.12.4.min.js"></script>
<script src="../js/calendar.js"></script>
<script src="../js/function.js"></script>
</body>
</html>