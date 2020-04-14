package com.electronic.servlet.suser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electronic.entity.ELECTRONIC_SUSER;
import com.electronic.service.ELECTRONIC_SUSERDao;


/**
 * Servlet implementation class DoSuserAdd
 */
@WebServlet("/manage/admin_dosuseradd")
public class DoSuserAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//与数据库字段取得联系
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String sex = request.getParameter("sex");
		String year = request.getParameter("birthday"); 
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String compete = request.getParameter("compete");
		//创建用户实体
		ELECTRONIC_SUSER u = new ELECTRONIC_SUSER(username, name, sex, year, code, email, mobile, address, 1,compete);
		//加入到数据库的用户表中
		int count = ELECTRONIC_SUSERDao.insert(u);
		
		//成功失败重定向到哪里
		if(count > 0) {
			
			response.sendRedirect("admin_dosuserselect");
		} else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户添加失败')");
			out.write("location.href='manage/admin_suseradd.jsp'");
			out.write("</script>");
		}
	}


}
