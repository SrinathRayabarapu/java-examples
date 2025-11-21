package com.hibernate.test;

import com.hibernate.entities.User;
import com.hibernate.entities.Vehicle;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test class for Hibernate functionality
 */
public class HibernateTest {
	private final static Logger LOG = LoggerFactory.getLogger(HibernateTest.class);
	private static Session currentSession;
	
	private static User user1 = new User("Shubha");
	private static User user2 = new User("Srinath");
	private static Vehicle vehicle = new Vehicle("Benz");
	
	@BeforeClass
	public static void openSession() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
	}
	
	@AfterClass
	public static void closeSession() {
		HibernateUtil.shutdownSessionFactory();
	}
	
	@Before
	public void beginTransaction() {
		currentSession.beginTransaction();
	}
	
	@After
	public void commitTransaction() {
		currentSession.getTransaction().commit();
	}
	
	@Test
	public void testAHibernateConnection() {
		assertNotNull(currentSession);
		LOG.info("Session NOT NULL tested!");
	}
	
	@Test
	public void testBSaveUsers() {
		user1.setVehicle(vehicle);
		currentSession.save(user1);
		
		//currentSession.save(user2);
		currentSession.save(vehicle);
		
		//User user = (User)currentSession.get(User.class, 1);		
		//LOG.info("User 1 Addresses set size : {}", user.getAddressesSet().size());
		
		//List<User> list = currentSession.createCriteria(User.class).list();
		//LOG.info("Users list Size is : {}", list.size());
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testCDeleteUsers() {
		currentSession.delete(user1);
		currentSession.delete(user2);
		
		List<User> list = currentSession.createCriteria(User.class).list();
		LOG.info("Users list Size is : {}", list.size());
		
		assertTrue("Users were not deleted!", list.size() == 0);		
	}
}