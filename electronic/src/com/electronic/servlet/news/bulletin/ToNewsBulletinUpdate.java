package com.electronic.servlet.news.bulletin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electronic.entity.ELECTRONIC_NEWS;
import com.electronic.entity.ELECTRONIC_NEWS_BULLETIN;
import com.electronic.entity.ELECTRONIC_NEWS_INTRO;
import com.electronic.service.ELECTRONIC_NEWSDao;
import com.electronic.service.ELECTRONIC_NEWS_BULLETINDao;
import com.electronic.service.ELECTRONIC_NEWS_INTRODao;

/**
 * Servlet implementation class ToNewsUpdate
 */
@WebServlet("/manage/admin_tonewsbulletinupdate")
public class ToNewsBulletinUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		ELECTRONIC_NEWS_BULLETIN news = ELECTRONIC_NEWS_BULLETINDao.selectById(id);
		//将参数放到请求域中
		request.setAttribute("news", news);
	
		request.setAttribute("cpage", request.getParameter("cpage"));
		//重定向
		request.getRequestDispatcher("admin_news_bulletinmodify.jsp").forward(request, response);
		
	}

	
}
