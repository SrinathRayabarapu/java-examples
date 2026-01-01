package com.hibernate;

import com.hibernate.entities.User;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Entry point demonstrating basic Hibernate ORM operations.
 * 
 * <p>This class showcases the fundamental Hibernate workflow:</p>
 * <ol>
 *   <li>Obtain a Session from SessionFactory</li>
 *   <li>Begin a transaction</li>
 *   <li>Perform CRUD operations</li>
 *   <li>Commit or rollback the transaction</li>
 *   <li>Close resources</li>
 * </ol>
 * 
 * <h3>Hibernate Session States:</h3>
 * <ul>
 *   <li><b>Transient</b> - Object created but not associated with session</li>
 *   <li><b>Persistent</b> - Object associated with session, changes tracked</li>
 *   <li><b>Detached</b> - Object was persistent but session is closed</li>
 *   <li><b>Removed</b> - Object marked for deletion</li>
 * </ul>
 * 
 * <h3>Key Operations Demonstrated:</h3>
 * <ul>
 *   <li>{@code session.save()} - Persist a transient object</li>
 *   <li>{@code session.delete()} - Remove a persistent object</li>
 *   <li>{@code session.createCriteria()} - Query using Criteria API</li>
 * </ul>
 * 
 * @author srayabar
 * @see HibernateUtil
 * @see org.hibernate.Session
 */
public class HibernateMain {
	
	private static final Logger LOG = LoggerFactory.getLogger("JavaTestLog");
	
	/**
	 * Main method demonstrating basic Hibernate session and transaction management.
	 * 
	 * <p>Demonstrates:</p>
	 * <ul>
	 *   <li>Opening a session</li>
	 *   <li>Transaction handling</li>
	 *   <li>Saving and deleting entities</li>
	 *   <li>Querying with Criteria API</li>
	 *   <li>Proper resource cleanup</li>
	 * </ul>
	 *
	 * @param args command-line arguments (not used)
	 */
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
