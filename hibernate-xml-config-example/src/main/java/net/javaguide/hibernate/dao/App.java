package net.javaguide.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguide.hibernate.model.Student;
import net.javaguide.hibernate.util.HibernateUtil;


public class App {
    public static void main(String[] args) {

    	
    	StudentDao studentDao = new StudentDao();
    	
    	Student student1 = new Student("Stanley", "Chen", "szuychen@gmail.com");
    	Student student2 = new Student("Michael", "Lin", "mlin@gmail.com");
    	studentDao.saveStudent(student1);
    	studentDao.saveStudent(student2);
    	    	    	
    	List<Student> students = studentDao.getAllStudents();    	
    	students.forEach(s -> System.out.println(s.getFirstName()));
    	
    	Student student3 = studentDao.getStudentById(student1.getId());
    	studentDao.deleteStudent(student3.getId());
    	
    	
    	students = studentDao.getAllStudents();    	
    	students.forEach(s -> System.out.println(s.getFirstName()));
    	
    	
    	
    	/*
        Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        Student student1 = new Student("John", "Cena", "john@javaguides.com");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(student);
            session.save(student1);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List < Student > students = session.createQuery("from Student", Student.class).list();
            students.forEach(s -> System.out.println(s.getFirstName()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    */
    
    }
}
