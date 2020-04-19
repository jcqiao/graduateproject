package com.electronic.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.electronic.dao.Basedao;
import com.electronic.entity.ELECTRONIC_SUSER;



public class ELECTRONIC_SUSERDao {
	public static int insert(ELECTRONIC_SUSER uu) {
		String sql = "insert into ELECTRONIC_SUSER values(?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?,?,?)";
		Object[] params = {
				uu.getUSER_ID(),
				uu.getUSER_NAME(),
				
				uu.getUSER_SEX(),
				uu.getUSER_BIRTHDAY(),
				uu.getUSER_IDENITY_CODE(),
				uu.getUSER_EMAIL(),
				uu.getUSER_MOBILE(),
				uu.getUSER_ADDRESS(),
				uu.getUSER_STATUS(),
                uu.getUSER_COMPETE(),
                uu.getUSER_FILENAME()
				} ;
		return Basedao.execuIUD(sql, params);
	}
	public static int update(ELECTRONIC_SUSER u) {
		String sql = "update ELECTRONIC_SUSER set USER_NAME=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?,'%Y-%m-%d')"
				+ ",USER_IDENITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=? ,USER_COMPETE=?, USER_FILENAME=? where USER_ID=?";
		
		//把页面数据拿到
		Object[] params = {
				
				u.getUSER_NAME(),
				
				u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(),
				u.getUSER_IDENITY_CODE(),
				u.getUSER_EMAIL(),
				u.getUSER_MOBILE(),
				u.getUSER_ADDRESS(),
				u.getUSER_STATUS(),
                u.getUSER_COMPETE(),
                u.getUSER_FILENAME(),
				u.getUSER_ID()
				} ;
		return Basedao.execuIUD(sql, params);
	}
	
	public static int del(String id) {
		String sql = "delete from ELECTRONIC_SUSER where USER_ID = ? ";
		Object[] params = {id};
		return Basedao.execuIUD(sql, params);
	}

	public static int selectByName(String id) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "select count(*) from ELECTRONIC_SUSER where USER_ID=?";
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
				sql = "select count(*) from ELECTRONIC_SUSER where USER_ID like ? or USER_NAME like ? or USER_SEX like ? or USER_EMAIL like ? or USER_MOBILE like ? or USER_IDENITY_CODE like ? or USER_COMPETE like ?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				ps.setString(2,"%"+keyword+"%");
			 	ps.setString(3,"%"+keyword+"%");
			 	ps.setString(4,"%"+keyword+"%");
			 	ps.setString(5,"%"+keyword+"%");
			 	ps.setString(6,"%"+keyword+"%");
                 ps.setString(7,"%"+keyword+"%");
			}else {
				sql = "select count(*) from ELECTRONIC_SUSER";
				ps=conn.prepareStatement(sql);
			}
		
			rs=ps.executeQuery();
			
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
	public static ArrayList<ELECTRONIC_SUSER> selectAll(int cpage,int count,String keyword){
		//创建列表对象
		 ArrayList<ELECTRONIC_SUSER> list = new  ArrayList<ELECTRONIC_SUSER>();
		 //从jbdc获取结果集
		 ResultSet rs = null;
		 //连接数据库 
		 Connection conn = Basedao.getconn();
		 PreparedStatement ps = null;
		
		 try {
			 //用户不一定每次都搜索 所以判断搜索
			 //where 字段 like
			 if(keyword!=null) {
				 String sql1 ="select * from ELECTRONIC_SUSER where USER_ID like ? or USER_NAME like ? or USER_SEX like ? or USER_EMAIL like ? or USER_MOBILE like ? or USER_IDENITY_CODE like ? or USER_COMPETE like ? order by USER_COMPETE desc limit ?, ?";
				 	ps = conn.prepareStatement(sql1);
					// 每页5条记录 前4页20条记录 第5页应从第20条取
				 	ps.setString(1,"%"+keyword+"%");
				 	ps.setString(2,"%"+keyword+"%");
				 	ps.setString(3,"%"+keyword+"%");
				 	ps.setString(4,"%"+keyword+"%");
				 	ps.setString(5,"%"+keyword+"%");
				 	ps.setString(6,"%"+keyword+"%");
                     ps.setString(7,"%"+keyword+"%");
				 	
					ps.setInt(8, (cpage-1)*count); //第一个占位符
					ps.setInt(9, count);//第二个占位符
					
					
			 }else {
				 String sql ="select * from ELECTRONIC_SUSER order by USER_COMPETE desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
					// 每页5条记录 前4页20条记录 第5页应从第20条取
				 ps.setInt(1, (cpage-1)*count); //第一个占位符
				 ps.setInt(2, count);//第二个占位符
			 }
			//执行结果集
			rs = ps.executeQuery();
			
			//如果结果集还有列表就循环
			while(rs.next()) {
				ELECTRONIC_SUSER u = new ELECTRONIC_SUSER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						
						rs.getString("USER_SEX"),
						rs.getString("USER_BIRTHDAY"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS"),
                        rs.getString("USER_COMPETE"),
                        rs.getString("USER_FILENAME")
						);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		 return list;
	}
	
	
	//通过id查找用户  修改按钮
	//返回不是列表 只有一条记录
	public static ELECTRONIC_SUSER selectById(String id){
		//创建列表对象
		ELECTRONIC_SUSER u = null;
		 //从jbdc获取结果集
		 ResultSet rs = null;
		 //连接数据库 
		 Connection conn = Basedao.getconn();
		 PreparedStatement ps = null;
		
		 try {
			 
			 String sql = "select m.* , DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from ELECTRONIC_SUSER m where USER_ID=?";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,id);
			
			//执行结果集
			rs = ps.executeQuery();
			
			//如果结果集还有列表就循环
			while(rs.next()) {
			 u = new ELECTRONIC_SUSER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_SEX"),
						rs.getString("birthday"),
						rs.getString("USER_IDENITY_CODE"),		
						rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS"),
                        rs.getString("USER_COMPETE"),
                        rs.getString("USER_FILENAME")
						);
				//因为只有一条记录所以不用添加到列表
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		 return u;
	}

	public static int selectByNM(String username,String pwd) {
		int count=0;
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "select count(*) from ELECTRONIC_SUSER where USER_ID=? and USER_PASSWORD=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pwd);
		    rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 //获取结果集的第一个值
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
	
	/**
	 * 通过用户名密码查询信息
	 * @param username
	 * @param pwd
	 * @return
	 */
	public static ELECTRONIC_SUSER selectAdmin(String name, String pwd) {
		ELECTRONIC_SUSER u = null;
			
			//声明结果集
			ResultSet rs = null;
			//获取连接对象
			Connection conn = Basedao.getconn();
			
			PreparedStatement ps = null;
			
			
			
			try {
				String sql = "select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')birthday  from ELECTRONIC_SUSER m where USER_ID=? and USER_PASSWORD=?";
				
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, name);
				 ps.setString(2, pwd);
				 
				 rs = ps.executeQuery();
				 
				 while(rs.next()) {
					 u = new ELECTRONIC_SUSER(
							 	rs.getString("USER_ID"),
							 	rs.getString("USER_NAME"),
							 	
							 	rs.getString("USER_SEX"),
							 	rs.getString("birthday"),
							 	rs.getString("USER_IDENITY_CODE"),
							 	rs.getString("USER_EMAIL"),
							 	rs.getString("USER_MOBILE"),
							 	rs.getString("USER_ADDRESS"),
							 	rs.getInt("USER_STATUS"),
							 	rs.getString("USER_COMPETE"),
							 	rs.getString("USER_FILENAME")
				
							 );
					 
					 
					
					 
				 }
				 
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				Basedao.closeall(rs, ps, conn);
			}
			
			
			
			return u;
			
			
		}
}
