package com.bilgeadam.service;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bilgeadam.entity.User;
import com.bilgeadam.util.HibernateUtil;

public class RegisterService {

	public boolean register(User user) {
		Session session = HibernateUtil.openSession();
		System.out.println("Result: " + user.getUserId() );
		
		if(isUserExists(user)) {
			System.out.println("Kullanýcý Adý DB'de yok");
		}
		
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			
			
			
		} catch (Exception e) {
			System.out.println("Hata!,"+ e.getMessage());
		}finally {
			session.close();
		}
		return true;
	}
	
	public boolean isUserExists(User user){
		Session session = HibernateUtil.openSession();
		boolean result = false;
		
		try {
			Query<?> query = session.createQuery("FROM User where userId='"+user.getUserId()+"'");
			User u = (User)query.uniqueResult();
			if(u != null) {
				System.out.println("Kullanýcý null deðil");
				result = true;
			}
			System.out.println("Result: " + user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
		
	}

}
