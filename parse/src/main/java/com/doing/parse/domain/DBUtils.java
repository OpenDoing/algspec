package com.doing.parse.domain;

import java.sql.*;
import java.util.Properties;

public class DBUtils {

	private static Connection ct = null;

	private static PreparedStatement ps = null;

	private static ResultSet rs = null;

	public static Connection getCon() {
		Connection con = null;
		Properties properties = new Properties();
		try {
//			properties.load(DBUtils.class.getResourceAsStream("db.properties"));
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/asdb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
			String user = "root";
			String password = "yitar";
              //debian-sys-maint
			  //kCQz0xNzrKWRgvi2
			//System.out.println(user+"   "+password);
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection ct, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ct != null) {
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ct != null) {
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs, Statement ps, Connection ct) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps = null;
		}
		if (null != ct) {
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ct = null;
		}
	}
	
	//查询
	public static ResultSet executeQuery(String sql, String[] parameters) {
		try {
			ct = getCon();
			ps = ct.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
		//	close(ct, ps, null);
		}
		return rs;
	}
	//删除
	public static boolean delete(String sql, String[] parameters){
		try {
			ct = getCon();
			ps = ct.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			//throw new RuntimeException(e.getMessage());
		} finally {
		//	close(ct, ps, null);
		}
		return true;
	}

	public static ResultSet executeQuery(String sql) {
		try {
			ct = getCon();
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
	//		close(ct, ps, null);
		}
		return rs;
	}

	public static void executeUpdate(String sql, String... parameters) {
		try {
			ct = getCon();
			ps = ct.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}

			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close(ct, ps, null);
		}
	}
	/**
	 * @param sql
	 * @param Index
	 * @param parameters
	 * @return
	 */
	public static ResultSet executeQuery1(String sql,int[] Index,String...parameters) {
		try {
			ct = getCon();
			ps = ct.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}

			}
			if(Index!=null){
				for(int j=0;j<Index.length;j++){
					ps.setInt(parameters.length+1+j,Index[j]);
				}
			}
			
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
	//		close(ct,ps,null);   20151023add
		}
		return rs;
	} 
	
	public static void executeUpdate(String sql, int axIndex,int eqIndex,String ...parameters)
	{
		try {
			ct = getCon();
			ps = ct.prepareStatement(sql);
			if (parameters != null) {
				ps.setInt(1, axIndex);
				ps.setInt(2,eqIndex);
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 3, parameters[i]);
				}
			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();// �����׶�
			// �׳��쳣
			// ���Դ��?Ҳ���Բ�����
			throw new RuntimeException(e.getMessage());
		} finally {
			close(ct,ps,null);
		}
	}
	
	public static void InsertOpDomain(String sql,int index,String...parameters) {
		Connection ct =null;
		PreparedStatement ps =null;
		try {
			ct= DBUtils.getCon();
			ps= ct.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
				ps.setInt(parameters.length+1, index);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();// �����׶�
			// �׳��쳣
			// ���Դ��?Ҳ���Բ�����
			throw new RuntimeException(e.getMessage());
		} finally {
			DBUtils.close(ct, ps, null);
		}
	}
	public static void insert(String sql,String...parameters) {
		Connection ct =null;
		PreparedStatement ps =null;
		try {
			ct= DBUtils.getCon();
			ps= ct.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			DBUtils.close(ct, ps, null);
		}
	}
	public static void executeUpdate1(String sql, int axIndex,int eqIndex,int subeqIndex,int condIndex,String ...parameters)
	{
		try {
			ct = getCon();
			ps = ct.prepareStatement(sql);
			if (parameters != null) {
				ps.setInt(1, axIndex);
				ps.setInt(2,eqIndex);
				ps.setInt(3,subeqIndex);
				ps.setInt(4, condIndex);
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 5, parameters[i]);
				}
				

			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();// �����׶�
			// �׳��쳣
			// ���Դ��?Ҳ���Բ�����
			throw new RuntimeException(e.getMessage());
		} finally {
			close(ct,ps,null);
		}
	}
	
	//ontology
	public static Boolean isnotExit(String sql) throws SQLException {
		try {
			ct = getCon();
			ps = ct.prepareStatement(sql);
			System.out.println("database"+sql);
		    rs = ps.executeQuery();
		    System.out.println("database");
		
		if(rs.next()){
            return false;
		}
		else
		{
			return true;
		}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally {
			close(ct,ps,null);
		} 
	}

	public static void executeUpdate(String sql, int metric, String ...parameters) {
		// TODO Auto-generated method stub
		try {
			ct = getCon();
			ps = ct.prepareStatement(sql);
			if (parameters != null) {
				ps.setInt(1, metric);
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 2, parameters[i]);
				}
				

			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();// 开发阶段
			// 抛出异常
			// 可以处理，也可以不处理
			throw new RuntimeException(e.getMessage());
		} finally {
			close(ct,ps,null);
		}
	}
    
	
	public static void executeUpdate(String sql, double metric, String ...parameters) {
		// TODO Auto-generated method stub
		try {
			ct = getCon();
			ps = ct.prepareStatement(sql);
			if (parameters != null) {
				ps.setDouble(1, metric);
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 2, parameters[i]);
				}
				

			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();// 开发阶段
			// 抛出异常
			// 可以处理，也可以不处理
			throw new RuntimeException(e.getMessage());
		} finally {
			close(ct,ps,null);
		}
	}
	//ontology
 
	
}