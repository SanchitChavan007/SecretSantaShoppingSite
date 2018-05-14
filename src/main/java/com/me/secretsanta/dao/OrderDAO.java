package com.me.secretsanta.dao;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.me.secretsanta.pojo.Order;
import com.me.secretsanta.pojo.Product;

public class OrderDAO extends DAO{

	
	public OrderDAO() {
    
    }
    
    

    public Boolean addOrder(Order o) throws Exception{
        try {
   begin();
getSession().save(o);
commit();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Cannot save object" + ex.getMessage());
            return false;
        } 

    }
    
    
    public Order findOrder(int id) throws Exception {
    	Order order = new Order();
    	 String select_query= "from Order where id=:ID";
    	 
    	 try {
         	
 
             Query q=getSession().createQuery(select_query);
             q.setParameter("id", id);
             
//          
             order = (Order) q.uniqueResult();
             
         } catch (Exception ex) {
             System.out.println("Cannot retrieve data " + ex.getMessage());
         }   
         
         return order;
    
    }
    
    public List<Order> displayOrder() throws Exception{
        List<Order> ordertList = new ArrayList<Order>();

        begin();
        String select_query= "from Order";

        try {
        	
        	
            Query q=getSession().createQuery(select_query);
            

            ordertList = q.list();
           
        } catch (Exception ex) {
            System.out.println("Cannot retrieve data " + ex.getMessage());
        }   
        
        return ordertList;
    }
    
    public List<Order> displayCustomerOrder(String name) throws Exception{
        List<Order> ordertList = new ArrayList<Order>();

        begin();
        String select_query= "from Order where customerName=:name";
        try {
        	
        	
            Query q=getSession().createQuery(select_query);
            q.setParameter("name", name);
            ordertList = q.list();
          
        } catch (Exception ex) {
            System.out.println("Cannot retrieve data " + ex.getMessage());
        }   
        
        return ordertList;
    }
        
    public List<Product> displayOrderProducts(int id) throws Exception{
        List<Product> productList = new ArrayList<Product>();

        begin();
        String select_query= "SELECT o.productList from Order o where o.id=:ID";
        try {
        	
        	
            Query q=getSession().createQuery(select_query);
            q.setParameter("ID", id);
            productList = q.list();
     
        } catch (Exception ex) {
            System.out.println("Cannot retrieve data " + ex.getMessage());
        }   
        
        return productList;
    }
    
}
