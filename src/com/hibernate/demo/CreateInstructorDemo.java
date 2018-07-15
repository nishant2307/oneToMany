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


public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Instructor.class);
		cfg.addAnnotatedClass(InstructorDetail.class);
		cfg.addAnnotatedClass(Course.class);
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Instructor tempInstructor = new Instructor("Nish","bhar","nish@cyz.com");
			InstructorDetail tempInstructorDetail =new InstructorDetail("myyoutube","table tennis"); 
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			session.save(tempInstructor);
			session.getTransaction().commit();
			System.out.println("Saved");
			
		}finally {
			//add clean up close
			factory.close();
		}
	}

}
