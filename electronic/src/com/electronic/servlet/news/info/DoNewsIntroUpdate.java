package com.electronic.servlet.news.info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electronic.entity.ELECTRONIC_NEWS;
import com.electronic.entity.ELECTRONIC_NEWS_INFO;
import com.electronic.entity.ELECTRONIC_NEWS_INTRO;
import com.electronic.service.ELECTRONIC_NEWSDao;
import com.electronic.service.ELECTRONIC_NEWS_INFODao;
import com.electronic.service.ELECTRONIC_NEWS_INTRODao;

/**
 * Servlet implementation class DoNewsUpdate
 */
@WebServlet("/manage/admin_donewsinfoupdate")
public class DoNewsIntroUpdate extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//与数据库字段取得联系
		int newsid =Integer.parseInt(request.getParameter("newsid"));
		String newsinfo = request.getParameter("info");
		
		String newstime = request.getParameter("time");
		System.out.println(newstime);
		
		//newsid!!!!!
		ELECTRONIC_NEWS_INFO news = new ELECTRONIC_NEWS_INFO( newsid, newsinfo,newstime);
		int count = ELECTRONIC_NEWS_INFODao.update(news);
		
		if(count>0) {
			
			response.sendRedirect("admin_donewsinfoselect?cp="+request.getParameter("cpage"));
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户新闻失败')");
			out.write("location.href='manage/admin_tonewsinfoupdate?id="+newsid+"'");
			out.write("</script>");
		}
}



}
