package com.jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jdbc.model.Student;

@Component	
public class StudentRowMapper implements RowMapper<Student>{

	public StudentRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Student(rs.getInt("id"),rs.getString("name"),rs.getString("tech"));
	}

}
