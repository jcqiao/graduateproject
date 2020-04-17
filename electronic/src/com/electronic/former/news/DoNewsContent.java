package com.electronic.former.news;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electronic.entity.ELECTRONIC_NEWS;
import com.electronic.service.ELECTRONIC_NEWSDao;


/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/admin_donewcontent")
public class DoNewsContent extends HttpServlet {
	
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cpage = 1; //当前页
		int count = 5; //每页显示条数
		
		//获取用户指定页面
		String cp = request.getParameter("cp");
		
		//接受用户搜索的关键字
		String keyword = request.getParameter("keywords");
		
		
		if(cp!=null) {
			cpage = Integer.parseInt(cp);
		}
		int arr[] = ELECTRONIC_NEWSDao.totalPage(count,keyword);
		//selectall返回所有用户对象 使用列表接收 也就是用户实体类型
		//分页跟查询都在selectall执行 查询在全选择完进行查询 where 字段 %keywoerd%
		ArrayList<ELECTRONIC_NEWS>  list = ELECTRONIC_NEWSDao.selectAll(cpage,count,keyword);
		//放到请求对象域里
		request.setAttribute("newslist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		if(keyword!=null) {
			//如果用户搜素就发送一个变量 然后在news.jsp的上一页下一页首页尾页中添加searchParams就可以了
			request.setAttribute("searchParams", "&keywords="+keyword);
		}
		//普通重定向戴不进去 !!!
		request.getRequestDispatcher("newcontent.jsp").forward(request, response);
	}

}