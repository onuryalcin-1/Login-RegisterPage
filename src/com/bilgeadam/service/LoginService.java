package com.bilgeadam.service;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bilgeadam.entity.User;
import com.bilgeadam.util.HibernateUtil;

public class LoginService {

	public boolean authentication(String userId, String password) {
		
		User user = getUserById(userId);
		
		if(user != null && user.getUserId().equals(userId) && user.getPassword().equals(password)) {
			
			return true;
		}else {
			return false;
		}
	}

	public User getUserById(String userId) {
		
		Session session = HibernateUtil.openSession();
		Transaction trx = null;
		User user = null;
		
		try {
			trx = session.getTransaction();
			trx.begin();
			Query query = session.createQuery("from User where userId='"+userId+"'");
			user = (User)query.uniqueResult();
			trx.commit();
		} catch (Exception e) {
			if(trx != null) {
				trx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return user;
	}

}
