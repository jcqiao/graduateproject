<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 使用标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页 </a><span class="crumb-step">&gt;</span><span class="crumb-name">报名管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/electronic/manage/admin_dosuserselect" method="get">
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
            <form action="/electronic/manage/admin_dosuserdel" id="myyform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_suseradd.jsp"><i class="icon-font"></i>新增报名用户</a>
                        <!--  delmore两个参数 myform表单ming -->
                        <a id="batchDel" href="javascript:delmore('确定删除?','myyform')"><i class="icon-font"></i>批量删除</a>
                       <!--  <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a> -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selall(this)" type="checkbox"></th>
                            
                            <th>ID </th>
                            <th>姓名</th>
                            <th>身份证</th>
                            <th>性别</th>
                            <th>EMAIL</th>
                            <th>手机</th>
                            <th>参赛题目</th>
                             <th>文件</th>
                            <th>操作</th>
                            
                        </tr>
                        <c:forEach var="u" items="${userlist}">
	                        <tr>
	                        <!-- 将数据库元素取出到页面 从用户实体中拿 -->
	                            <td class="tc"><input name="id[]" value="${u.USER_ID}" type="checkbox"></td>
	                            <td>  ${u.USER_ID } </td>
	                             <td>  ${u.USER_NAME } </td>
	                             <td>${u.USER_IDENITY_CODE } </td>
	                              <td>  ${u.USER_SEX =='T'?'男':'女' } </td>
	                               <td>  ${u.USER_EMAIL } </td>
	                                <td>  ${u.USER_MOBILE } </td>
                                     <td>  ${u.USER_COMPETE } </td>
                                      <td> <a href="../file/suser/${u.USER_FILENAME }">${u.USER_FILENAME }</a> </td>
	                          
	                            <td>
	                            <!-- 修改传id参数 之前设置了分页 比如第6页 那还跳回第6页增加参数 当前页-->
	                            <!-- 这样点击修改就跳到ToUserUpdate servlet中 -->
	                                <a class="link-update" href="admin_tosuserupdate?id=${u.USER_ID }&cpage=${cpage}">修改</a>
	                              <%--  <c:if test="${u.USER_STATUS == 1 }"> --%>
	                                <a class="link-del" href="javascript:Delete('你确定要删除${u.USER_NAME}吗?','/electronic/manage/admin_dosuserdel?id=${u.USER_ID }&cpage=${cpage }')">删除</a>
	                            	<%-- </c:if> --%>
	                            </td>
	                        </tr>
              		</c:forEach>
              
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
  			/* function delmore(mess,formname){
  				if(confirm(mess)){
  					var form = document.getElementById('formname');
  					form.submit();
  				}
  			} */
  			function delmore(mess, formname){
  				if(confirm(mess)){
  					var form = document.getElementById(formname);
  					form.submit();
  				}
  			}
		
	              		
        </script>
                    </table>
                    <div class="list-page">  
                    	共 ${tsum} 条记录 当前 ${cpage}/${tpage} 
                    	<a href="admin_dosuserselect?cp=1${searchParams}">首页</a>
                    	<a href="admin_dosuserselect?cp=${(cpage-1<1)?1:cpage-1}${searchParams}">上一页</a>
                    	<a href="admin_dosuserselect?cp=${(cpage+1>tpage)?tpage:cpage+1}${searchParams}">下一页</a>
                    	<a href="admin_dosuserselect?cp=${tpage}${searchParams}">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
		
</body>
</html>