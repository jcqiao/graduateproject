package com.electronic.servlet.news;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electronic.entity.ELECTRONIC_NEWS;
import com.electronic.service.ELECTRONIC_NEWSDao;

/**
 * Servlet implementation class DoNewsAdd
 */
@WebServlet("/manage/admin_donewsadd")
public class DoNewsAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				//与数据库字段取得联系
				int newsid =Integer.parseInt(request.getParameter("newsid"));
				String newsintro = request.getParameter("introduce");
				String newsbulletin = request.getParameter("bulletin");
				String newstitle = request.getParameter("title");
				String newscontent = request.getParameter("content");
				String newsinfo = request.getParameter("info");
				String newstime = request.getParameter("time");
				//System.out.println(newstime);
				
				//newsid!!!!!
				ELECTRONIC_NEWS n = new ELECTRONIC_NEWS( newsid, newsintro, newsbulletin, newstitle, newscontent, newsinfo, newstime);
				int count = ELECTRONIC_NEWSDao.insert(n);
				
				if(count>0) {
					
					response.sendRedirect("admin_donewsselect");
				}else {
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alert('新闻添加失败');");
					out.write("location.href='manage/admin_donewsadd.jsp';");
					out.write("</script>");
				}
	}

}
