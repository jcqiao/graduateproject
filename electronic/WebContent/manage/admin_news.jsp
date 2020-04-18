<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 使用标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">新闻管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/electronic/manage/admin_donewsselect" method="get">
                    <table class="search-tab">
                        <tr>
                           
                            <th width="70">关键字:</th>
                            <!-- 使当前页面停留在关键字这里 value="${param.keyword}" -->
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="/electronic/manage/admin_donewsdel"  id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_newsadd.jsp"><i class="icon-font"></i>新增新闻</a>
                        <a id="batchDel"  href="javascript:delmore('确定删除?','myform')"><i class="icon-font"></i>批量删除</a>
                      <!--   <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a> -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selall(this)" type="checkbox"></th>
                            
                            <th>ID</th>
                            <th>竞赛介绍</th>
                          <th>竞赛公告</th>
                            <th>竞赛新闻标题</th>
                            <th>竞赛新闻内容</th>
                            <th>报名通知</th> 
                            <th>添加时间</th>
                           <!--  <th>创建时间</th> -->
                            <th>操作</th>
                            
                        </tr>
                       <c:forEach var="n" items="${newslist}">
	                        <tr>
	                        <!-- 将数据库元素取出到页面 从用户实体中拿 -->
	                            <td style="width:15px;" class="tc"><input name="id[]" value="${n.NEWS_ID}"  type="checkbox"></td>
	                            <td style="width:15px;" ><div style="height:60px; width:30px; overflow:scroll; padding:1px;">  ${n.NEWS_ID}</div> </td>
	                             <td  style="width:50%;"> <div style="height:60px;  width:100%; overflow:scroll; padding:1px;">  ${n.NEWS_INTRO } </div></td> 
	                              <td><div style="height:60px; width:180px; overflow:scroll; padding:1px;">   ${n.NEWS_BULLETIN } </div></td>
	                               <td> <div style="height:60px; width:180px; overflow:scroll; padding:1px;">  ${n.NEWS_TITLE }</div> </td>
	                                <td> <div style="height:60px; width:180px; overflow:scroll; padding:1px;">  ${n.NEWS_CONTENT }</div> </td>
	                                <td><div style="height:60px;  width:180px; overflow:scroll; padding:1px;"> ${n.NEWS_INFO }</div></td> 
	                             <td  style="width:10%;"><div style="height:40px;  width:94px; overflow:hidden; padding:1px;"> ${n.NEWS_TIME }</div></td>
	                          
	                            <td >
	                            <div style="height:60px; width:30px;  padding:1px;">
	                                <a class="link-update" href="admin_tonewsupdate?id=${n.NEWS_ID }&cpage=${cpage}">修改</a>
	                                <a class="link-del" href="javascript:Delete('你确定要删除${n.NEWS_ID}吗?','/electronic/manage/admin_donewsdel?id=${n.NEWS_ID }&cpage=${cpage }')">删除</a>
	                            </div>
	                            </td>
	                        </tr>
              		</c:forEach>
                    </table>
                    	<script>
              			function Delete(mess,url){
              				if(confirm(mess)){
              					location.href=url;
              				}
              			}
              			function selall(o){
              				var a = document.getElementsByName('id[]');
              				for(var i=0;i<a.length;i++){
              					a[i].checked=o.checked;
              				}
              			}
              			function delmore(mess, formname){
              				if(confirm(mess)){
              					var form = document.getElementById(formname);
              					form.submit();
              				}
              			}
              		</script>
                    <div class="list-page">  
                    	共 ${tsum} 条记录 当前 ${cpage}/${tpage} 
                    	<a href="admin_donewsselect?cp=1${searchParams}">首页</a>
                    	<a href="admin_donewsselect?cp=${(cpage-1<1)?1:cpage-1}${searchParams}">上一页</a>
                    	<a href="admin_donewsselect?cp=${(cpage+1>tpage)?tpage:cpage+1}${searchParams}">下一页</a>
                    	<a href="admin_donewsselect?cp=${tpage}${searchParams}">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>