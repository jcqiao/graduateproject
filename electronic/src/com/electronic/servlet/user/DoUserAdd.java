package com.electronic.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electronic.entity.ELECTRONIC_USER;
import com.electronic.service.ELECTRONIC_USERDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manage/admin_douseradd")
public class DoUserAdd extends HttpServlet {
	
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
		String pwd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		
		String mobile = request.getParameter("mobile");
	
		System.out.println(name);
		//创建用户实体
		ELECTRONIC_USER u = new ELECTRONIC_USER(username, name, pwd, sex, mobile, 1);
		//加入到数据库的用户表中
		int count = ELECTRONIC_USERDao.insert(u);
		
		//成功失败重定向到哪里
		if(count > 0) {
			
			response.sendRedirect("admin_douserselect");
		} else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户添加失败');");
			out.write("location.href='manage/admin_useradd.jsp';");
			out.write("</script>");
		}
	}

}

