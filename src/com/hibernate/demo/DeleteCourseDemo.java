package com.hibernate.demo;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;


public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Instructor.class);
		cfg.addAnnotatedClass(InstructorDetail.class);
		cfg.addAnnotatedClass(Course.class);
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			//start the transaction
			session.beginTransaction();
			//get course from databas
			int id=10;
			Course delCourse =(Course) session.get(Course.class, id);
			session.delete(delCourse);
			//delete that course
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("deleted");
			
		}finally {
			//add clean up close
			factory.close();
		}
	}

}
