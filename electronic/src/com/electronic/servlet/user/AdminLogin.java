package com.electronic.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.electronic.entity.ELECTRONIC_USER;
import com.electronic.service.ELECTRONIC_USERDao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/manage/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		int count = ELECTRONIC_USERDao.selectByNM(userName, passWord);
		
		//System.out.println(userName + "##"+passWord);
		
		if(count > 0) {
			
			ELECTRONIC_USER user = ELECTRONIC_USERDao.selectAdmin(userName, passWord);
			HttpSession session = request.getSession();
			session.setAttribute("name", user);
			//前台标记位
			session.setAttribute("isLogin", "1");
			
			//状态码等于2的才是管理员
			if(user.getUSER_STATUS() == 2) {
				//后台标记位isAdminLogin
				session.setAttribute("isAdminLogin", "1");
			//	System.out.println(userName + "##"+passWord);
				response.sendRedirect("/monkey/manage/admin_index.jsp");
			}else{
				
				response.sendRedirect("/monkey/index.jsp");
			}
	
		
			
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户登录失败！');");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
		}
	}

}
