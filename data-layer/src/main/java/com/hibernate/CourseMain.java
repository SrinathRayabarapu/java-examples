package com.hibernate;

/* Crud Operations and Criteria Example*/

import com.hibernate.entities.Course;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CourseMain {
    public static void main(String[] args) {
        CourseMain mgr = new CourseMain();
        if (args[0].equals("store")) {
            Course course = new Course("Physics", getDate("18/06/10"),
                    getDate("18/09/10"));
            Long courseId1 = mgr.saveCourse(course);

            course = new Course("Chemistry", getDate("20/08/10"),
                    getDate("20/11/10"));
            Long courseId2 = mgr.saveCourse(course);

            course = new Course("Maths", getDate("8/10/10"),
                    getDate("20/01/11"));
            mgr.saveCourse(course);
            course = new Course("Physics", getDate("6/05/09"),
                    getDate("20/01/11"));
            mgr.saveCourse(course);
            course = new Course("Maths", getDate("2/03/08"),
                    getDate("20/01/11"));
            Long courseId3 = mgr.saveCourse(course);

            mgr.listCourse();

            mgr.updateCourse(courseId3, "Mathematics");

            // mgr.deleteCourse(courseId2);

            mgr.listCourse();
            mgr.courseListUsingCriteria("Physics");

        }

    }

    private static Date getDate(String dateString) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Date today = null;

        try {

            today = df.parse(dateString);

            System.out.println("Today = " + df.format(today));

        } catch (ParseException e) {

            e.printStackTrace();

        }

        return today;
    }

    private static void printDate(String dateType, Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(dateType + " = " + df.format(date));
    }

    private Long saveCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        Long courseId = null;
        try {
            transaction = session.beginTransaction();
            courseId = (Long) session.save(course);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("In Course Exception ::");
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return courseId;
    }

    public void updateCourse(Long courseId, String courseName) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Course course = (Course) session.get(Course.class, courseId);
            course.setCourseName(courseName);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("In Course Exception ::");
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void deleteCourse(Long courseId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Course course = (Course) session.get(Course.class, courseId);
            session.delete(course);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("In Course Exception ::");
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void listCourse() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            List courses = session
                    .createQuery(
                            "from Course course where course.courseName like 'Physics' order by course.courseStartDate asc")
                    .list();
            Iterator iterator = courses.iterator();
            while (iterator.hasNext()) {
                Course course = (Course) iterator.next();
                System.out.println(course.getCourseName() + ": startDate :"
                        + course.getCourseStartDate());
            }

        } catch (HibernateException e) {
            System.out.println("In Course Exception ::");

            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void courseListUsingCriteria(String expString) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Course.class);

        criteria.add(Restrictions.like("courseName", expString));
        List courses = criteria.list();
        Iterator iterator = courses.iterator();
        while (iterator.hasNext()) {

            Course course = (Course) iterator.next();
            System.out.println("Course Name :" + course.getCourseName());
            printDate("StartDate", course.getCourseStartDate());
            printDate("EndDate", course.getCourseEndDate());
        }

    }

}
