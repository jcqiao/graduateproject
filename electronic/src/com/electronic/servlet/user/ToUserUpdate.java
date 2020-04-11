package com.electronic.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electronic.entity.ELECTRONIC_USER;
import com.electronic.service.ELECTRONIC_USERDao;

/**
 * Servlet implementation class ToUserUpdate
 */
@WebServlet("/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//有数据传来传去要设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		
		//通过id在数据里查找
		ELECTRONIC_USER user = ELECTRONIC_USERDao.selectById(id);
		request.setAttribute("user", user);
		request.setAttribute("cpage", request.getParameter("cpage"));
		//重定向
		request.getRequestDispatcher("admin_usermodify.jsp").forward(request, response);
	}

	

}
