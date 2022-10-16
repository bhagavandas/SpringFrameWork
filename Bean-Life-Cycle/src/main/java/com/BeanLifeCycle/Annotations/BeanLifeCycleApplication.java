package com.BeanLifeCycle.Annotations;

import java.sql.SQLException;

public class BeanLifeCycleApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// SpringApplication.run(BeanLifeCycleApplication.class, args);

		StudentDAO dao = new StudentDAO();
		dao.selectAllRows();
		dao.deleteRecord();
	}

}
