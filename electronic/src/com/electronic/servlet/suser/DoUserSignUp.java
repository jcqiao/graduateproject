//package com.electronic.servlet.suser;
//
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.electronic.entity.ELECTRONIC_SUSER;
//import com.electronic.entity.ELECTRONIC_USER;
////import com.electronic.service.ELECTRONIC_SUSERDao;
//import com.electronic.service.ELECTRONIC_USERDao;
//import com.jspsmart.upload.File;
//import com.jspsmart.upload.Files;
//import com.jspsmart.upload.SmartUpload;
//import com.jspsmart.upload.SmartUploadException;
//
///**
// * Servlet implementation class DoUserSignUp
// */
//@WebServlet("/user_dousersignup")
//public class DoUserSignUp extends HttpServlet {
//	
//		/**
//		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//		 */
//		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			//创建SmartUpload对象
//			SmartUpload su = new SmartUpload();
//			//初始化
//			su.initialize(this.getServletConfig(), request, response);
//			//处理上传
//			try {
//				su.upload();
//			} catch (ServletException | IOException | SmartUploadException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			//获取上传对象
//			Files fs = su.getFiles();
//			File f =fs.getFile(0);
//			//获取文件名
//			 String name = f.getFieldName();
//			 
//			 try {
//				su.save("file/suser");
//			} catch (ServletException | IOException | SmartUploadException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			//			//设置字符集
////			request.setCharacterEncoding("UTF-8");
////			response.setContentType("text/html; charset=utf-8");
////			//取出input值
////			String username = request.getParameter("userName");
////			String name = request.getParameter("name");
////			String code = request.getParameter("code");
////			//String pwd = request.getParameter("passWord");
////			String sex = request.getParameter("sex");
////			String year = request.getParameter("birthday");
////			String email = request.getParameter("email");
////			String mobile = request.getParameter("mobile");
////			String address = request.getParameter("address");
////            String compete = request.getParameter("compete");
////			
////			//创建用户实体
////			ELECTRONIC_SUSER uu = new ELECTRONIC_SUSER(username, name, sex, year, code, email, mobile, address, 1,compete);
////			//加入到数据库的用户表中
////			int count = ELECTRONIC_SUSERDao.insert(uu);
////			PrintWriter out = response.getWriter();
////
////			if(count>0) {
////				out.print("<script type='text/javascript'>alert('报名成功');");
////	            out.print("location.href='/electronic/index.jsp';");
////	            out.print("</script>");
////			
////			}else {
////				
////	            out.print("<script type='text/javascript'>alert('报名失败');");
////	            out.print("location.href='/electronic/index.jsp';");
////	            out.print("</script>");
////			}
////				
////		
//	}
//}
//
