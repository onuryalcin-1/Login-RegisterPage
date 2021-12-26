package com.bilgeadam.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static {
		try {
			
			sessionFactory = new Configuration().configure("com/bilgeadam/config/hibernate.cfg.xml").buildSessionFactory();
			
		} catch (Throwable e) {
			System.out.println("Session Factory Nesnesi oluþturulamadý");
			throw new ExceptionInInitializerError(e);
		}	
	}
	
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	
	
}
