package com.electronic.servlet.suser;


import java.io.IOException;
import java.io.InputStreamReader;
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
 * Servlet implementation class DoUserSignUp
 */
@WebServlet("/user_dousersignup")
public class DoUserSignUp extends HttpServlet {
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//创建SmartUpload对象
			SmartUpload su = new SmartUpload();
			//初始化
			su.initialize(this.getServletConfig(), request, response);
		   // 设置工厂
//		    DiskFileItemFactory factory = new DiskFileItemFactory(); 
//			ServletFileUpload upload = new ServletFileUpload(factory);
			         
//			            upload.setHeaderEncoding("utf-8");
			//处理上传
			try {
				su.upload();
			} catch (ServletException | IOException | SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//获取上传对象
			Files fs = su.getFiles();
			File f =fs.getFile(0);
			 
			//获取文件名
			 String fname = f.getFileName();
			 
			 try {
				su.save("file/suser");
			} catch (ServletException | IOException | SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 Request req1 = su.getRequest();
			  String username = req1.getParameter("userName");
				String name = req1.getParameter("name");
				String code = req1.getParameter("code");
				String sex = req1.getParameter("sex");
				String year = req1.getParameter("birthday"); 
				String email = req1.getParameter("email");
				String mobile = req1.getParameter("mobile");
				String address = req1.getParameter("address");
				String compete = req1.getParameter("compete");
				System.out.println(username);
//			//创建用户实体
			ELECTRONIC_SUSER u = new ELECTRONIC_SUSER(username, name, sex, year, code, email, mobile, address, 1,compete,fname);
//			//加入到数据库的用户表中
			int count = ELECTRONIC_SUSERDao.insert(u);
			PrintWriter out = response.getWriter();		
//			//成功失败重定向到哪里
			if(count>0) {
				out.print("<script type='text/javascript'>alert('success');");
	            out.print("location.href='/electronic/index.jsp';");
	            out.print("</script>");
			//	response.sendRedirect("/monkey/user_success.jsp");
			}else {
				
	            out.print("<script type='text/javascript'>alert('failed');");
	            out.print("location.href='/electronic/user_signup.jsp';");
	            out.print("</script>");
			}
				
		
	}
}

