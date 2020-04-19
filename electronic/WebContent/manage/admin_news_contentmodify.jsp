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
                <form action="/electronic/manage/admin_donewscontentupdate" method="post" id="myform" name="myform" >
                    
                    <input type="hidden" name="cpage" value="${cpage }">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr style="display:none;">
                                <th><i class="require-red">*</i>竞赛id：</th>
                                <td>
                                 <input class="common-text required" id="title" name="newsid" size="50" value="${news.NEWS_ID }" type="text"> 
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>新闻标题：</th>
                                <td>
                                 <input class="common-text required" id="title" name="title" size="50" value="${news.NEWS_TITLE }" type="text"> 
                                </td>
                            </tr>
                          <tr>
                                <th><i class="require-red">*</i>竞赛内容：</th>
                                <td>
                                  <textarea rows="10" cols="80" name="bulletin"  style="line-height:25px;">
								${news.NEWS_CONTENT }
								</textarea>
                                    <%-- <input class="common-text required" id="title" name="bulletin" size="50" value="${news.NEWS_BULLETIN} " type="text"> --%>
                                </td>
                            </tr>
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
<script>
var textarea = document.getElementsByTagName("textarea");
console.log(textarea.length);
for(var i = 0; i<textarea.length; i++){
//	textarea[i].contentText.toString();
console.log(textarea[i].textContent);
var str = textarea[i].textContent;
	console.log(typeof str);
	console.log(trim(str));
}
function trim(str){
	var reg = /(^\s*) | (\s*$)/g;
	return str.replace(reg,'')
}

</script>
   <script src="../js/jquery-1.12.4.min.js"></script>
<script src="../js/calendar.js"></script>
<script src="../js/function.js"></script>

</body>
</html>