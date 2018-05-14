package com.me.secretsanta.dao;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.me.secretsanta.model.PaginationResult;
import com.me.secretsanta.model.ProductInfo;
import com.me.secretsanta.pojo.Product;

public class ProductDAO extends DAO{

	
	public ProductDAO() {
    
    }
    
    

    public Boolean addProduct(Product mv) throws Exception{
        try {
        	
begin();
getSession().save(mv);
commit();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Cannot save object" + ex.getMessage());
            return false;
        } 

    }
    
    public void printThis(){
    	System.out.println("here i am");
    }
    
    public Product findProduct(int code) throws Exception {
    	Product product = new Product();
    	 String select_query= "from Product where code=:product_code";
    	
    	 try {
       begin();
             Query q=getSession().createQuery(select_query);
             q.setParameter("product_code", code);
            System.out.println(code+"This is code");
             product = (Product) q.uniqueResult();
        
              System.out.println(product.getName());
              System.out.println("1");
             return product;
     
         } catch (Exception ex) {
             System.out.println("Cannot retrieve data " + ex.getMessage());
         }   
         System.out.println("2");
         return null;
    
    }
    
    public Product findProduct_trial(int code) throws Exception {
    	Product product = new Product();
    	 String select_query= "from Product where code=:product_code";
    	
    	 try {
       begin();
             Query q=getSession().createQuery(select_query);
             q.setParameter("product_code", code);
             System.out.println("in findproduct trial");
             product = (Product) q.uniqueResult();
          commit();
             return product;
     
         } catch (Exception ex) {
             System.out.println("Cannot retrieve data " + ex.getMessage());
         }   
      
         return null;
    
    }
    
    public PaginationResult<ProductInfo> queryProducts(int page,
            int maxResult, int maxNavigationPage  ){
    	
				return null;
    	
    }


    public List<Product> displayProduct() throws Exception{
        List<Product> productList = new ArrayList<Product>();
//        Movie movie;
        
        String select_query= "from Product";
//        String select_query= "from Movie where title= :title";
        try {
        begin();
            Query q=getSession().createQuery(select_query);
            
//            q.setString("title", "Titanic");
            productList = q.list();
            
        } catch (Exception ex) {
            System.out.println("Cannot retrieve data " + ex.getMessage());
        }   
        
        return productList;
    }
    
    public List<Product> displayOrderProduct(int Id) throws Exception{
        List<Product> productList = new ArrayList<Product>();
//        Movie movie;
        
        String select_query= "from Order where Id=:ID";
//        String select_query= "from Movie where title= :title";
        try {
        begin();
            Query q=getSession().createQuery(select_query);
            
//            q.setString("title", "Titanic");
            productList = q.list();
            
        } catch (Exception ex) {
            System.out.println("Cannot retrieve data " + ex.getMessage());
        }   
        
        return productList;
    }
        
    
}
