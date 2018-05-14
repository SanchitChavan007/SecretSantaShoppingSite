package com.me.secretsanta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.secretsanta.cartSession.CartSession;
import com.me.secretsanta.dao.ProductDAO;
import com.me.secretsanta.model.CartInfo;
import com.me.secretsanta.model.CartItem;
import com.me.secretsanta.model.ProductInfo;
import com.me.secretsanta.pojo.Product;



@Controller
public class CartController{
	@Autowired
	@Qualifier("productDAO")
	ProductDAO pdao;
	
	   @RequestMapping(value = "/displayCart.htm", method = RequestMethod.GET)
	    public String showCart() {
		   
	        return "shoppingCart";
	    }
	
	 @RequestMapping({ "/buyProduct.htm" })
	    public String listProductHandler(HttpServletRequest request, Model model, //
	            @RequestParam(value = "code", defaultValue = "") int code) throws Exception {
		 Product product = null;
		 //List<Product> productList = new ArrayList<Product>();
	  HttpSession session = request.getSession();
      if (code > 0) {
           try {
			product = pdao.findProduct(code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      if (product != null) {
    	  
         
          CartInfo cartInfo = CartSession.getCartInSession(request);

          ProductInfo productInfo = new ProductInfo(product);
          
          Product p = new Product();
          p = pdao.findProduct_trial(productInfo.getCode()); 
          cartInfo.addProduct(productInfo, 1, p);
          session.setAttribute("cartInfo", cartInfo);
          for(CartItem c:cartInfo.getCartItems()) {
        	  System.out.println(c.getQuantity());
          }
   
          
          
          
      }
    
      
    
      
      return "shoppingCart";
  }
	 
	 @RequestMapping({ "/shoppingCartRemoveProduct.htm" })
	    public String removeProductHandler(HttpServletRequest request, Model model, //
	            @RequestParam(value = "code", defaultValue = "") int code) {
	        Product product = null;
	        if (code > 0) {
	            try {
					product = pdao.findProduct(code);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
	        }
	        if (product != null) {
	 
	           
	            CartInfo cartInfo = CartSession.getCartInSession(request);
	 
	            ProductInfo productInfo = new ProductInfo(product);
	 
	            cartInfo.removeProduct(productInfo);
	 
	        }
	        
	        return "shoppingCart";
	    }
	 @RequestMapping({ "/clearCart.htm" })
	    public String clearCartHandler(HttpServletRequest request, Model model) {
		 CartInfo cartInfo = CartSession.getCartInSession(request);
	           cartInfo.getCartItems().clear();
	           HttpSession session = request.getSession();
	           session.setAttribute("cartInfo", cartInfo);
	       
	            return "customer-dashboard";
	        }
	      
	        
	      
} 


