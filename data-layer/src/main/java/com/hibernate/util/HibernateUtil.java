package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * responsible for creating {@link SessionFactory} from hibernate.cfg.xml
 * 
 * SingletonCommon pattern is used to construct session factory.
 * 
 * @author Srinath.Rayabarapu
 *
 */
public class HibernateUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("JavaTestLog");
	
	//why volatile?
	//tells the compiler that it must always use the master copy of a volatile variable in case of multi-threading scenarios
	private static volatile SessionFactory sessionFactory = buildSessionFactory();
	
	private HibernateUtil() {
		//shouldn't create a object of it
	}
	
	private static SessionFactory buildSessionFactory() {
		if(sessionFactory == null){
			//multi-threading case
			synchronized (HibernateUtil.class) {
				//double checking
				if(sessionFactory == null){
					LOGGER.info("No session factory exists!");
					Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
					StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		            serviceRegistryBuilder.applySettings(configuration.getProperties());
		            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		            LOGGER.info("Created a Session Factory");
				}
			}
		}
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	//Destroy this SessionFactory and release all resources (caches, connection pools, etc).
	public static void shutdownSessionFactory(){
		getSessionFactory().close();
		LOGGER.info("Closed Session Factory");
	}
	
}