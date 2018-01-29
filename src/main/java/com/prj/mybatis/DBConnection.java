package com.prj.mybatis;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DBConnection {

	public static Connection getConn() {
		// 1.创建属性对象
		Properties pro = new Properties();
		// 2.获取文件
		File f =new File(DBConnection.class.getResource("/jdbc.properties").getFile());
		try {
			FileInputStream fis = new FileInputStream(f);
			// 3.加载属性文件
			pro.load(fis);
			// 4.获取数据
			String name = pro.getProperty("jdbc.driverClassName");
			String url = pro.getProperty("jdbc.url");
			String user = pro.getProperty("jdbc.username");
			String pwd = pro.getProperty("jdbc.password");
			// 5.操作
			Class.forName(name);
			return (Connection) DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getConn());
	}
}
