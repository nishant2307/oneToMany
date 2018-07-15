package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

public class DeleteInstuctor {
	
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Instructor.class);
		cfg.addAnnotatedClass(InstructorDetail.class);
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int theId = 2;
			session.beginTransaction();
			Instructor inst = (Instructor)session.get(Instructor.class, theId);
			System.out.println("found: "+inst);
			if(inst!=null) {
				System.out.println("deleting: "+inst);
				session.delete(inst);
			}
			
			//session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}
}
