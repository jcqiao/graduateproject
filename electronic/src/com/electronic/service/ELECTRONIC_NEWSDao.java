package com.electronic.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.electronic.dao.Basedao;
import com.electronic.entity.ELECTRONIC_NEWS;

public class ELECTRONIC_NEWSDao {
	
		public static int insert(ELECTRONIC_NEWS n) {
			String sql = "insert into ELECTRONIC_NEWS values(?,?,?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'))";
			Object[] params = {
					n.getNEWS_ID(),
					n.getNEWS_INTRO(),
					n.getNEWS_BULLETIN(),
					n.getNEWS_TITLE(), 
					n.getNEWS_CONTENT(),
					n.getNEWS_INFO(),
					n.getNEWS_TIME()
					} ;
			return Basedao.execuIUD(sql, params);
		}
		
		public static int update(ELECTRONIC_NEWS n) {
			String sql = "update ELECTRONIC_NEWS set NEWS_INTRO=?,NEWS_BULLETIN=?,"
					+ "NEWS_TITLE=?,NEWS_CONTENT=?,NEWS_INFO=?,NEWS_TIME=DATE_FORMAT(?,'%Y-%m-%d') where NEWS_ID=?";
			
			Object[] params = {
					
					n.getNEWS_INTRO(),
					n.getNEWS_BULLETIN(),
					n.getNEWS_TITLE(), 
					n.getNEWS_CONTENT(),
					n.getNEWS_INFO(),
					n.getNEWS_TIME(),
					n.getNEWS_ID()
					} ;
			return Basedao.execuIUD(sql, params);
		}
		
		/**
		 * byname
		 * @param id
		 * @return
		 */
		public static int selectByName(String id) {
			int count = 0;
			Connection conn = Basedao.getconn();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			
			
			try {
				String sql = "select count(*) from ELECTRONIC_NEWS where NEWS_ID=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
			    rs = ps.executeQuery();
				 
				 while(rs.next()) {
					 count = rs.getInt(1);
				 }
				 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				Basedao.closeall(rs, ps, conn);
			}
			
			
			
			return count;
		}
		
		public static int del(String id) {
			String sql = "delete from ELECTRONIC_NEWS where NEWS_ID = ?";
			Object[] params = {id};
			return Basedao.execuIUD(sql, params);
		}

	/**
	 * 获取总记录和总页数
	 * @param count
	 * @return
	 */

	public static int[] totalPage(int count,String keyword) {
		//0总记录数 1总页数
		int arr[] = {0,1};
		//连接数据库
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		

		try {
			String sql="";
			if(keyword!=null) {
				sql = "select count(*) from ELECTRONIC_NEWS where NEWS_TITLE like ? or NEWS_ID like ? or NEWS_INTRO like ? or NEWS_BULLETIN like ? or NEWS_CONTENT like ? or NEWS_INFO like ? or NEWS_TIME like ?  ";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				ps.setString(2, "%"+keyword+"%");
				ps.setString(3, "%"+keyword+"%");
				ps.setString(4, "%"+keyword+"%");
				ps.setString(5, "%"+keyword+"%");
				ps.setString(6, "%"+keyword+"%");
				ps.setString(7, "%"+keyword+"%");
				System.out.println(ps);
				
			}else {
				sql = "select count(*) from ELECTRONIC_NEWS";
				ps=conn.prepareStatement(sql);
			}
		
			rs=ps.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				arr[0] = rs.getInt(1);
				if(arr[0]%count == 0) {
					arr[1] = arr[0]/count;
				}else {
					arr[1] = arr[0]/count+1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return arr;
	}
	//返回列表对象
	public static ArrayList<ELECTRONIC_NEWS> selectAll(int cpage,int count,String keyword){
		//创建列表对象
		 ArrayList<ELECTRONIC_NEWS> list = new  ArrayList<ELECTRONIC_NEWS>();
		 //从jbdc获取结果集
		 ResultSet rs = null;
		 //连接数据库 
		 Connection conn = Basedao.getconn();
		 PreparedStatement ps = null;
		
		 try {
			 //用户不一定每次都搜索 所以判断搜索
			 //where 字段 like
			 if(keyword!=null) {
				 String sql ="select * from ELECTRONIC_NEWS where NEWS_TITLE like ? or NEWS_ID like ?"
				 		+ " or NEWS_INTRO like ? or NEWS_BULLETIN like ? or NEWS_CONTENT like ? or NEWS_INFO like ? "
				 		+ "or NEWS_TIME like ?  order by NEWS_ID desc limit ?, ?";
				 	ps = conn.prepareStatement(sql);
					// 每页5条记录 前4页20条记录 第5页应从第20条取
				 	ps.setString(1, "%"+keyword+"%");
					ps.setString(2, "%"+keyword+"%");
					ps.setString(3, "%"+keyword+"%");
					ps.setString(4, "%"+keyword+"%");
					ps.setString(5, "%"+keyword+"%");
					ps.setString(6, "%"+keyword+"%");
					ps.setString(7, "%"+keyword+"%");
					ps.setInt(8, (cpage-1)*count); //第一个占位符
					ps.setInt(9, count);//第二个占位符
					
			 }else {
				 String sql ="select * from ELECTRONIC_NEWS order by NEWS_ID desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
					// 每页5条记录 前4页20条记录 第5页应从第20条取
				 ps.setInt(1, (cpage-1)*count); //第一个占位符
				 ps.setInt(2, count);//第二个占位符
			 }
			//执行结果集 ps进行查询 把从数据库中查询到的数据存入结果集
			rs = ps.executeQuery();
			
			//如果结果集还有列表就循环
			while(rs.next()) {
				ELECTRONIC_NEWS n = new ELECTRONIC_NEWS(
						rs.getInt("NEWS_ID"),
						rs.getString("NEWS_INTRO"),
						rs.getString("NEWS_BULLETIN"),
						rs.getString("NEWS_TITLE"),
						rs.getString("NEWS_CONTENT"),
						rs.getString("NEWS_INFO"),
						rs.getString("NEWS_TIME"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		 return list;
	}
	public static ELECTRONIC_NEWS selectById(int id){
		 ELECTRONIC_NEWS n = null;
		 //从jbdc获取结果集
		 ResultSet rs = null;
		 //连接数据库 
		 Connection conn = Basedao.getconn();
		 PreparedStatement ps = null;
		
		 try {
			 String sql = "select m.* , DATE_FORMAT(m.news_time,'%Y-%m-%d')time from ELECTRONIC_NEWS m where NEWS_ID=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			
			//执行结果集
			rs = ps.executeQuery();
			
			//如果结果集还有列表就循环
			while(rs.next()) {
				 n = new ELECTRONIC_NEWS(
						rs.getInt("NEWS_ID"),
						rs.getString("NEWS_INTRO"),
						rs.getString("NEWS_BULLETIN"),
						rs.getString("NEWS_TITLE"),
						rs.getString("NEWS_CONTENT"),
						rs.getString("NEWS_INFO"),
						rs.getString("time"));
				// System.out.println(n.getNEWS_TIME());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		 return n;
	}
	

}
