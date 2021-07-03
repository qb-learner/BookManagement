package bookManagement;

import java.sql.*;

public class connect {
	public Connection cnt() throws SQLException, ClassNotFoundException {
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=BookManagement";//test为你的数据库名
		String userName="sa";//你的数据库用户名
		String userPwd="123456";//你的密码
		Class.forName(driverName);
		return DriverManager.getConnection(dbURL,userName,userPwd);
	}
}
