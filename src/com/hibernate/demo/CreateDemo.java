package com.hibernate.demo;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;


public class CreateDemo {

	public static void main(String[] args) {
		
		//create session facrtory
//		SessionFactory factory =  new Configuration()
//								.configure("hibernate.cfg.xml")
//								.addAnnotatedClass(Student.class)
//								.buildSessionFactory();
//		Connection conn = new 
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Instructor.class);
		cfg.addAnnotatedClass(InstructorDetail.class);
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Instructor tempInstructor = new Instructor("hello","asdf","abc@cyz.com");
			InstructorDetail tempInstructorDetail =new InstructorDetail("myyoutube","coding"); 
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			session.save(tempInstructor);
			session.getTransaction().commit();
			System.out.println("Saved");
			
		}finally {
			factory.close();
		}
	}

}
