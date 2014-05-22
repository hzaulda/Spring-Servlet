package com.example;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyJdbcDao {
	
	private static final String SAMPLE_SELECT = "Select * from Employee where id = ?";
	
			
			
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
	}
	
	public Employee getEmployee(){
		Employee employee = (Employee) jdbcTemplate.queryForObject(
				SAMPLE_SELECT, new Object[] { 1 }, new EmployeeRowMapper());
		return employee;
	}
}
