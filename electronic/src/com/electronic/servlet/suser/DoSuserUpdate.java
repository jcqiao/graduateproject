package com.electronic.servlet.suser;

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
 * Servlet implementation class DoSuserUpdate
 */
@WebServlet("/manage/admin_dosuserupdate")
public class DoSuserUpdate extends HttpServlet {

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
		String code = request.getParameter("code");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String userStatus = request.getParameter("userStatus");
		String compete = request.getParameter("compete");
		
		int status = 1;
		if(userStatus !=null) {
			status = Integer.parseInt(userStatus);
		}
		//创建用户实体
		ELECTRONIC_SUSER user = new ELECTRONIC_SUSER(username, name, sex, birthday, code, email, mobile, address, status,compete);
		//加入到数据库的用户表中
		int count = ELECTRONIC_SUSERDao.update(user);
		
		//成功失败重定向到哪里
		if(count > 0) {
			response.sendRedirect("admin_dosuserselect?cp="+request.getParameter("cpage"));
		} else {
			PrintWriter out = response.getWriter();
			out.write("<script>");	
			out.write("alert('用户修改失败');");
			out.write("location.href='manage/admin_tosuserupdate?id="+username+"';");
			out.write("</script>");
		}
	}

}
