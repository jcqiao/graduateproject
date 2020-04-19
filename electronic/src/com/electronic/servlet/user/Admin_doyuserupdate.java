package com.electronic.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electronic.entity.ELECTRONIC_USER;
import com.electronic.service.ELECTRONIC_USERDao;


/**
 * Servlet implementation class Admin_doyuserupdate
 */
@WebServlet("/doyuserupdate")
public class Admin_doyuserupdate extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//接收数据
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String pwd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		
		String mobile = request.getParameter("mobile");
		
		String userStatus = request.getParameter("userStatus");
		
		int status = 1;
		if(userStatus !=null) {
			status = Integer.parseInt(userStatus);
		}
		//创建用户实体
		ELECTRONIC_USER user = new ELECTRONIC_USER(username, name, pwd, sex,  mobile,  status);
		//加入到数据库的用户表中
		int count = ELECTRONIC_USERDao.update(user);
		PrintWriter out = response.getWriter();
		//成功失败重定向到哪里
		if(count > 0) {

			out.write("<script>");	
			out.write("alert('修改成功');");
			out.write("location.href='mygrxx.jsp';");
			out.write("</script>");
		} else {
			
			out.write("<script>");	
			out.write("alert('用户修改失败');");
			out.write("location.href='manage/admin_toyuserupdate?id="+username+"';");
			out.write("</script>");
		}
	}
}
