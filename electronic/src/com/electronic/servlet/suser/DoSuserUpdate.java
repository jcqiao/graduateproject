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
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class DoSuserUpdate
 */
@WebServlet("/manage/admin_dosuserupdate")
public class DoSuserUpdate extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建SmartUpload对象
		SmartUpload su = new SmartUpload();
		//初始化
		su.initialize(this.getServletConfig(), request, response);
		//处理上传
		try {
			su.upload();
		} catch (ServletException | IOException | SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取上传对象
		Files fs = su.getFiles();
//		System.out.println(fs);
		File f =fs.getFile(0);
		//获取文件名
		 String fname = f.getFileName();
		 
		 try {
			su.save("file/suser");
		} catch (ServletException | IOException | SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(fname);
		 Request req1 = su.getRequest();
		//设置字符集
//		req1.setCharacterEncoding("UTF-8");
//		req1.setContentType("text/html; charset=utf-8");
//		//与数据库字段取得联系
		     String username = req1.getParameter("userName");
			String name = req1.getParameter("name");
			String code = req1.getParameter("code");
			String sex = req1.getParameter("sex");
			String year = req1.getParameter("birthday"); 
			String email = req1.getParameter("email");
			String mobile = req1.getParameter("mobile");
			String address = req1.getParameter("address");
			String compete = req1.getParameter("compete");
//		//创建用户实体
		ELECTRONIC_SUSER u = new ELECTRONIC_SUSER(username, name, sex, year, code, email, mobile, address, 1,compete,fname);
//		//加入到数据库的用户表中
		int count = ELECTRONIC_SUSERDao.update(u);
//		
//		//成功失败重定向到哪里
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

		
		//		//设置字符集
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=utf-8");
//		//接收数据
//		String username = request.getParameter("userName");
//		String name = request.getParameter("name");
//		String code = request.getParameter("code");
//		String sex = request.getParameter("sex");
//		String birthday = request.getParameter("birthday");
//		String email = request.getParameter("email");
//		String mobile = request.getParameter("mobile");
//		String address = request.getParameter("address");
//		String userStatus = request.getParameter("userStatus");
//		String compete = request.getParameter("compete");
//		System.out.println(username);
//		int status = 1;
//		if(userStatus !=null) {
//			status = Integer.parseInt(userStatus);
//		}
//		//创建用户实体
//		ELECTRONIC_SUSER user = new ELECTRONIC_SUSER(username, name, sex, birthday, code, email, mobile, address, status,compete,null);
//		//加入到数据库的用户表中
//		int count = ELECTRONIC_SUSERDao.update(user);
//		
//		//成功失败重定向到哪里
//		if(count > 0) {
//			response.sendRedirect("admin_dosuserselect?cp="+request.getParameter("cpage"));
//		} else {
//			PrintWriter out = response.getWriter();
//			out.write("<script>");	
//			out.write("alert('用户修改失败');");
//			out.write("location.href='manage/admin_tosuserupdate?id="+username+"';");
//			out.write("</script>");
//		}
//	}

}
