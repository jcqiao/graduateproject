package com.electronic.servlet.news;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electronic.service.ELECTRONIC_NEWSDao;
import com.electronic.service.ELECTRONIC_USERDao;

/**
 * Servlet implementation class DoNewsDel
 */
@WebServlet("/manage/admin_donewsdel")
public class DoNewsDel extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");
		
		int count = ELECTRONIC_NEWSDao.del(id);
		//成功失败重定向到哪里
				if(count > 0) {
					response.sendRedirect("admin_donewsselect?cp=" + request.getParameter("cpage"));
				} else {
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alert('新闻删除失败')");
					out.write("location.href='manage/admin_donewsselect?cp="+request.getParameter("cpage")+"'");
					out.write("</script>");
				}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		// 每一个复选框都叫id[]全部获取到存入数组  数组应该是values
		String ids[] = request.getParameterValues("id[]");
		for(int i=0;i<ids.length;i++) {
			int count = ELECTRONIC_NEWSDao.del(ids[i]);
		}
		//成功重定向到哪里
				
		response.sendRedirect("/monkey/manage/admin_donewsselect" );
	}
	}



