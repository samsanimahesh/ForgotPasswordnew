package com.mahesh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoUtil {
	
	static SessionFactory sessionFactory = null;
	public static Session getSession(){
		
		sessionFactory = (SessionFactory) new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		return session;
		
	}
	
	public static void closeSessionFactory(){
		sessionFactory.close();
	}

}
