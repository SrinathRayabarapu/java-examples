package com.hibernate;

import com.hibernate.entities.Student;
import com.hibernate.entities.StudentAddress;
import com.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Named Query Example
 *
 * @author Srinath.Rayabarapu
 */
public class StudentMain {
    public static void main(String args[]) {
        StudentAddress studentAddress = new StudentAddress("OMR Road", "Chennai", "TN", "600097");
        Student student1 = new Student("Prams", studentAddress);
        Student student2 = new Student("Joe", studentAddress);
        StudentMain studentMain = new StudentMain();
        studentMain.saveStudent(student1);
        studentMain.saveStudent(student2);
        List<Student> studentList = studentMain.getStudents();
        int ctr = 0;
        for (Student student : studentList) {
            ctr++;
            System.out.println(" dto " + ctr + ":" + student.getFirstName());
        }
    }

    public void saveStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(student);
            transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
            he.printStackTrace();
        } finally {
            session.close();
        }

    }

    public List<Student> getStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("findAllStudents");
        List<Student> stList = query.list();
        return stList;
    }

}