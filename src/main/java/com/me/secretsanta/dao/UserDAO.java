package com.me.secretsanta.dao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.me.secretsanta.pojo.User;

public class UserDAO extends DAO{

	public User register(User u) throws Exception{
		try {
		    begin();
			System.out.println("inside DAO");
			getSession().save(u);
			commit();
			return u;
		} catch(HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	

	public User get(String useremail){
	        try {
	         
	            Query q = getSession().createQuery("from User where userEmail = :useremail");
	            q.setString("useremail", useremail);
	            User user = (User) q.uniqueResult();
	            return user;
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }
	            return null;
	        
	    }
	    public User get(String useremail, String password, String role) throws Exception {
	        try {
	            begin();
	            Query q = (Query) getSession().createQuery("from User where userEmail = :useremail and password = :password and role = :role" );
	            q.setString("useremail", useremail);
	            q.setString("password", password);  
	            q.setString("role", role);
	            User user = (User) q.uniqueResult();
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not get user " + useremail, e);
	        }
}
	    public User get(String useremail, String password) throws Exception {
	        try {
	            begin();
	            Query q = (Query) getSession().createQuery("from User where userEmail = :useremail and password = :password" );
	            q.setString("useremail", useremail);
	            q.setString("password", password);  
	            User user = (User) q.uniqueResult();
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not get user " + useremail, e);
	        }
}
}	    
