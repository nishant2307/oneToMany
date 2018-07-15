package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;


public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Instructor.class);
		cfg.addAnnotatedClass(InstructorDetail.class);
		cfg.addAnnotatedClass(Course.class);
		cfg.addAnnotatedClass(Review.class);
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			//start the transaction
			session.beginTransaction();
			
			//create a course
			Course tempCourse = new Course("Pacman");
			
			//add some reviews
			tempCourse.addReview(new Review("Great Course"));
			tempCourse.addReview(new Review("loved it"));
			tempCourse.addReview(new Review("amazing"));
			
			//save the course and caascade
			System.out.println("saving the course");
			session.save(tempCourse);
			System.out.println(tempCourse.getReviews());
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Saved");
			
		}finally {
			//add clean up close
			factory.close();
		}
	}

}
