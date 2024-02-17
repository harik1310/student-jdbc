package com.jdbc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbc.model.Student;

@Repository
public class StudentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(Student s) {
		String query = "insert into student(id,name,tech) values (?,?,?)";
		jdbcTemplate.update(query,s.getId(),s.getName(),s.getTech());
		System.out.println("data added");
	}
	

	public List<Student> findAll(){
		String query = "select * from student order by tech";
		return jdbcTemplate.query(query, new StudentRowMapper());
	}
	
	public StudentDAO() {
		
	}

}
