package com.jdbc.data;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.jdbc.model.Student;
import com.jdbc.repository.StudentDAO;

@SpringBootApplication
@ComponentScan({"com.jdbc.model","com.jdbc.repository"})
public class StudentJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext ioc =  SpringApplication.run(StudentJdbcApplication.class, args);
		Student s = ioc.getBean(Student.class);
		StudentDAO dao  = ioc.getBean(StudentDAO.class); 
		
		s.setId(1);
		s.setName("ahri");
		s.setTech("IT");
		dao.save(s);
		List<Student> l = dao.findAll();
		
		for (Student student : l) {
			System.out.println(student.getId()+"   "+student.getName()+"   "+student.getTech());
		}
		
		}

}
