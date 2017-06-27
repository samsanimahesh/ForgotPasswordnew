package com.mahesh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mahesh.beans.UserDetails;

public class DataAccess {
	
	public int saveUserDetails(UserDetails userDetails){
		Integer userId = -1;
		Session session = DaoUtil.getSession();
		if(session.isOpen()){
			Transaction transaction = session.beginTransaction();
			transaction.begin();
			 userId = (Integer)session.save(userDetails);
			transaction.commit();
		}else{
			session.close();
			DaoUtil.closeSessionFactory();
		}
		return userId;
	}

}
