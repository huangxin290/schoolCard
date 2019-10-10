package org.StudentCard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/studentcard?characterEncoding=utf-8";
	private static final String USERNAME = "root";
	private static final String PWD = "123456";
	public static PreparedStatement preparedStatement = null;
	public static Connection connection = null;
	public static ResultSet rSet = null;

	//ͨ�û�ȡ���Ӷ���
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return connection = DriverManager.getConnection(URL, USERNAME, PWD);
	}
	
	public static PreparedStatement createPreparedStatement(String sql, Object[] params) throws SQLException, ClassNotFoundException {
		preparedStatement = getConnection().prepareStatement(sql);
		preparedStatement = connection.prepareStatement(sql);
		
		// ?�ĸ���������ĸ���һ��
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				preparedStatement.setObject(i + 1, params[i]);
			}
		}
		
		return preparedStatement;
	}
	
	public static void closeAll(ResultSet rSet,Statement statement,Connection connection) {
		try {
			if(rSet!=null) {
				rSet.close();
			}if (preparedStatement != null) {
				preparedStatement.close();
			}if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��ѯ����
	public static int getTotalCount(String sql) {
		int count=-1;
		try {
			preparedStatement=createPreparedStatement(sql, null);
			
			// ����ͨ��
			rSet = preparedStatement.executeQuery();
			if (rSet.next()) {
				count=rSet.getInt(1);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null,preparedStatement,connection);
		}
		return count;
	}
	
	
	// ͨ�õ���ɾ��
	public static boolean executeUpdate(String sql, Object[] params) {
		try {
			preparedStatement=createPreparedStatement(sql, params);
			
			// ����ͨ��
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeAll(null,preparedStatement,connection);
		}
	}

	// ͨ�õĲ�,�ʺ����κβ�ѯ
	public static ResultSet executeQuery(String sql, Object[] params) {
		try {
			preparedStatement=createPreparedStatement(sql, params);
			rSet = preparedStatement.executeQuery();

			return rSet;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
