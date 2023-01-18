package com.greatLearning.crm.dbconfig;

import java.sql.SQLException;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class DBConfig {
	
	static SimpleDriverDataSource simpleDriverDataSource;
	static String USERNAME = "root";
	static String PASSWORD = "root";
	static String URL = "jdbc:mysql://localhost:3306/customer_relationship_management";
	
	public static SimpleDriverDataSource getDatabaseConnection() {
        simpleDriverDataSource = new SimpleDriverDataSource();
        try {
            simpleDriverDataSource.setDriver(new com.mysql.cj.jdbc.Driver());
            simpleDriverDataSource.setUrl(URL);
            simpleDriverDataSource.setUsername(USERNAME);
            simpleDriverDataSource.setPassword(PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return simpleDriverDataSource;
    }

}
