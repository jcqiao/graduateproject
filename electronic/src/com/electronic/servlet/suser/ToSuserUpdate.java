////package com.electronic.servlet.suser;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.electronic.entity.ELECTRONIC_SUSER;
//import com.electronic.service.ELECTRONIC_SUSERDao;
//
//
///**
// * Servlet implementation class ToSuserUpdate
// */
//@WebServlet("/manage/admin_tosuserupdate")
//public class ToSuserUpdate extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//有数据传来传去要设置字符集
//				request.setCharacterEncoding("UTF-8");
//				response.setContentType("text/html;charset=utf-8");
//				
//				String id = request.getParameter("id");
//				
//				//通过id在数据里查找
//				ELECTRONIC_SUSER user = ELECTRONIC_SUSERDao.selectById(id);
//				request.setAttribute("user", user);
//				System.out.println(user.getUSER_ID());
//				System.out.println(user.getUSER_NAME());
//				System.out.println(user.getUSER_SEX());//身份证
//				System.out.println(user.getUSER_BIRTHDAY());//性别
//				System.out.println(user.getUSER_IDENITY_CODE());//生日
//				System.out.println(user.getUSER_EMAIL());
//				System.out.println(user.getUSER_MOBILE());
//				System.out.println(user.getUSER_ADDRESS());
//				System.out.println(user.getUSER_COMPETE());
//				request.setAttribute("cpage", request.getParameter("cpage"));
//				//重定向
//				request.getRequestDispatcher("admin_susermodify.jsp").forward(request, response);
//	}
//
//
//}
