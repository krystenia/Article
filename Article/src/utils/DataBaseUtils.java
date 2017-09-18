package utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DataBaseUtils {
	private static String dbname;
	private static String username;
	private static String password;

	static {
		config("jdbc.properties");
	}

	public static void config(String path) {
		InputStream inputStream = DataBaseUtils.class.getClassLoader().getResourceAsStream(path);
		Properties p = new Properties();
		try {
			p.load(inputStream);
			username = p.getProperty("jdbc.username");
			password = p.getProperty("jdbc.password");
			dbname = p.getProperty("jdbc.url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 连接数据库
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = dbname;
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param connection
	 * @param statement
	 * @param rs
	 */
	public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			e.fillInStackTrace();
		}
	}

	public static boolean update(String sql, Object... obj) {
		Connection conn = getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				statement.setObject(i + 1, obj[i]);
			}
			statement.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(conn, statement, null);
		}
		return true;
	}

	public static List<Map<String, Object>> queryForList(String sql, Object... obj) {
		Connection conn = getConnection();
		PreparedStatement statement = null;
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				statement.setObject(i + 1, obj[i]);
			}
			rs = statement.executeQuery();
			while (rs.next()) {
				ResultSetMetaData rsd = rs.getMetaData();
				Map<String, Object> map = new HashMap<String, Object>();
				int count = rsd.getColumnCount(); // 获取列数
				for (int i = 0; i < count; i++) {
					map.put(rsd.getColumnName(i + 1), rs.getObject(rsd.getColumnName(i + 1)));
				}
				result.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, statement, rs);
		}
		return result;
	}

	public static Map<String, Object> queryForMap(String sql, Object... objects) throws SQLException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> list = queryForList(sql, objects);
		if (list.size() != 1) {
			return null;
		}
		result = list.get(0);
		return result;
	}

	public static <T> T queryForBean(String sql, Class clazz, Object... objects) {
		T obj = null;
		Map<String, Object> ressultMap = null;
		try {
			obj = (T) clazz.newInstance();
			ressultMap = queryForMap(sql, objects);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if (ressultMap == null) {
			return null;
		}
		try {
			Field[] fields = clazz.getDeclaredFields();
			int length = fields.length;
			for (int i = 0; i < length; i++) {
				fields[i].setAccessible(true);
				String name = fields[i].getName().toUpperCase();
				String fieldType = fields[i].toString().split(" ")[1];
				Object value = ressultMap.get(name);
				if (value != null) {
					String valueType = value.getClass().getName();
					if (!fieldType.equalsIgnoreCase(valueType)) {
						if (fieldType.equalsIgnoreCase("java.lang.Integer")) {
							value = Integer.parseInt(String.valueOf(value));
						} else if (fieldType.equalsIgnoreCase("java.lang.String")) {
							value = String.valueOf(value);
						} else if (fieldType.equalsIgnoreCase("java.util.Date")) {
							value = String.valueOf(value);
						}
					}
				}
				fields[i].set(obj, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
