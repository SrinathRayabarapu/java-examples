package com.hibernate;

import com.hibernate.entities.User;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * starting point for all hibernate work
 * 
 * @author srayabar
 *
 */
public class HibernateMain {
	
	private static final Logger LOG = LoggerFactory.getLogger("JavaTestLog");
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		session.beginTransaction();

		/*
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeId(1);
		employeeEntity.setFirstName("srinath");
		employeeEntity.setLastName("rayabarapu");
		employeeEntity.setEmail("naath.r@gmail.com");
		session.save(employeeEntity);
		*/
		User user1 = new User();
		User user2 = new User();
		
		session.save(user1);
		session.save(user2);
		
		List<User> list = session.createCriteria(User.class).list();
		LOG.info("Users list Size is : {}", list.size());
		
		session.delete(user1);
		session.delete(user2);
		
		session.getTransaction().commit();
		
		list.stream().forEach(u ->
			LOG.info(u.getUserId() + ", " + u.getName() + ", " + u.getVehicle())
		);
		
		HibernateUtil.shutdownSessionFactory();
		
	}
	
}
