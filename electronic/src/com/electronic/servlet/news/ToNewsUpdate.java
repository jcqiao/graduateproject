package com.electronic.servlet.news;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electronic.entity.ELECTRONIC_NEWS;
import com.electronic.service.ELECTRONIC_NEWSDao;

/**
 * Servlet implementation class ToNewsUpdate
 */
@WebServlet("/manage/admin_tonewsupdate")
public class ToNewsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		ELECTRONIC_NEWS news = ELECTRONIC_NEWSDao.selectById(id);
		//将参数放到请求域中
		request.setAttribute("news", news);
	
		request.setAttribute("cpage", request.getParameter("cpage"));
		//重定向
		request.getRequestDispatcher("admin_newsmodify.jsp").forward(request, response);
		
	}

	
}
