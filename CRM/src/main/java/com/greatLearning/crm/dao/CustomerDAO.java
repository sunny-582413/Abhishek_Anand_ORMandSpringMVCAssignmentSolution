package com.greatLearning.crm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.greatLearning.crm.dbconfig.DBConfig;
import com.greatLearning.crm.model.Customer;

@Repository
public class CustomerDAO {

	private JdbcTemplate jdbcTemplate;
	
	public List<Customer> listCustomers() {
		jdbcTemplate = new JdbcTemplate(DBConfig.getDatabaseConnection());
		String query = "select * from customer";
		@SuppressWarnings("unchecked")
		List<Customer> customers = jdbcTemplate.query(query, new RowMapper() {
			public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Customer customer = new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setFirstName(resultSet.getString("firstName"));
				customer.setLastName(resultSet.getString("lastName"));
				customer.setEmail(resultSet.getString("email"));
				return customer;
			}
		});
		return customers;
	}
	
	public void deleteCustomer(int id) {
		jdbcTemplate = new JdbcTemplate(DBConfig.getDatabaseConnection());
		String query = "delete from customer where id=?";
		jdbcTemplate.update(query, id);
	}
	
	public void addCustomer(Customer customer) {
		jdbcTemplate = new JdbcTemplate(DBConfig.getDatabaseConnection());
		String query = "Insert into customer (firstName, lastName, email) values(?,?,?)";
		jdbcTemplate.update(query, customer.getFirstName(), customer.getLastName(), customer.getEmail());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Customer getCustomerById(int id) {
		jdbcTemplate = new JdbcTemplate(DBConfig.getDatabaseConnection());
		String query = "select * from customer where id=?";
		return (Customer)jdbcTemplate.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper(Customer.class));
	}
	
	public void updateCustomerById(Customer customer) {
		jdbcTemplate = new JdbcTemplate(DBConfig.getDatabaseConnection());
		String query = "update customer set firstName=?, lastName=?, email=? where id=?";
		jdbcTemplate.update(query, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getId());
	}
	
}
