package com.BeanLifeCycle.Annotations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/addressbook_service";
	private String userName = "root";
	private String password = "root";

	public void selectAllRows() throws ClassNotFoundException, SQLException {
		// load drivers
		Class.forName(driver);

		// get connection
		Connection con = DriverManager.getConnection(url, userName, password);

		// execute query
		Statement stmt = (Statement) con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM addressbook;");

		while (rs.next()) {

			String firstName = rs.getString(1);
			String lastName = rs.getString(2);
			String address = rs.getString(3);

			System.out.println("Student first name:" + firstName + " Last name :" + lastName + " Address: " + address);
		}

	}

	public void deleteRecord() throws ClassNotFoundException, SQLException {

		// load drivers
		Class.forName(driver);

		// get connection
		Connection con = DriverManager.getConnection(url, userName, password);

		// execute query
		Statement stmt = (Statement) con.createStatement();

		stmt.executeUpdate("delete from addressbook where lastname= 'R' ");
		System.out.println("Record is deleted");
	}

}
