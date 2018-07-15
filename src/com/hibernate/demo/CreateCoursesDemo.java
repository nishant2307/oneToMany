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


public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Instructor.class);
		cfg.addAnnotatedClass(InstructorDetail.class);
		cfg.addAnnotatedClass(Course.class);
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			int id=1;
			//start the transaction
			session.beginTransaction();
			Instructor instructor =(Instructor) session.get(Instructor.class, id);
			Course tempCourse = new Course("Air Guitar");
			Course tempCourse2 = new Course("Drums");
			
			//add courses to instructor
			instructor.add(tempCourse);
			instructor.add(tempCourse2);
	
			//save the courses
			session.save(tempCourse);
			session.save(tempCourse2);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Saved");
			
		}finally {
			//add clean up close
			factory.close();
		}
	}

}
