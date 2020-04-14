package com.electronic.servlet.suser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electronic.service.ELECTRONIC_SUSERDao;


/**
 * Servlet implementation class AdminSuserNameCheck
 */
@WebServlet("/manage/susernamecheck")
public class AdminSuserNameCheck extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		
		int count = ELECTRONIC_SUSERDao.selectByName(name);
	
		
		PrintWriter out = response.getWriter();
		if(count >0 ){
			out.print("false");
		}else{
			out.print("true");
		}
		
	
		
		out.close();
	}

}
