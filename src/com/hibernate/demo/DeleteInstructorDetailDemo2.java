package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

public class DeleteInstructorDetailDemo2 {
	
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Instructor.class);
		cfg.addAnnotatedClass(InstructorDetail.class);
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int id=4;
			session.beginTransaction();
			InstructorDetail tempInst = (InstructorDetail) session.get(InstructorDetail.class, id);
			
			System.out.println("Instructor detail: "+tempInst);
			System.out.println("the associated instructor: "+tempInst.getInstructor());
			session.delete(tempInst);
			session.getTransaction().commit();
			System.out.println("deleted");
		}finally {
			factory.close();
		}
	}
}