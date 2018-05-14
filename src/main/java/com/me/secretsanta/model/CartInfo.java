package com.me.secretsanta.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.me.secretsanta.dao.OrderDAO;
import com.me.secretsanta.dao.ProductDAO;
import com.me.secretsanta.pojo.Product;
import com.me.secretsanta.pojo.User;

public class CartInfo {
	@Autowired
	@Qualifier("productDAO")
	ProductDAO pdao;
	
	 private int orderNum;
	
	   
	 
	    private final List<CartItem> cartItems = new ArrayList<CartItem>();
	 
	    public CartInfo() {
	 
	    }
	 
	    public int getOrderNum() {
	        return orderNum;
	    }
	 
	    public void setOrderNum(int orderNum) {
	        this.orderNum = orderNum;
	    }
	 
	  
	 
	    public List<CartItem> getCartItems() {
	        return this.cartItems;
	    }
	 
	    public Boolean checkIfProductExists(int code){
	    	for (CartItem item : this.cartItems) {
	            if (item.getProductInfo().getCode()==code) {
	            	System.out.println("In check");
	                return true;
	            }
	        }
	    	return false;
	    }
	    
	    public CartItem findItemByCode(int code) {
	    	System.out.println("Called");
	        for (CartItem item : this.cartItems) {
	            if (item.getProductInfo().getCode()==code) {
	            	System.out.println("In findItemByCart"+item.getAmount());
	                return item;
	            }
	        }
	        return null;
	    }
	 
	    public void addProduct(ProductInfo productInfo, int quantity, Product p) throws Exception {
	    	System.out.println("BEFORE CARTITEM LINE"+productInfo.getCode());
	   
	        	System.out.println(p.getName()+"cart Info");
	     
	        	CartItem itemm = new CartItem();
	        	if (getCartItems().isEmpty()) {
		            itemm = new CartItem();
		            itemm.setQuantity(1);
		            itemm.setProductInfo(productInfo);
		            itemm.setProduct(p);
		            this.cartItems.add(itemm);
		        }else {
		        	if (checkIfProductExists(productInfo.getCode())){
		        		itemm = findItemByCode(productInfo.getCode());
			        	
				        int newQuantity = itemm.getQuantity() + quantity;
				        if (newQuantity <= 0) {
				            this.cartItems.remove(itemm);
				        } else {
				            itemm.setQuantity(newQuantity);
				        }
		        	}else {
		        		System.out.println(p.getName()+"adding a new product");
		        		   itemm = new CartItem();
				            itemm.setQuantity(1);
				            itemm.setProductInfo(productInfo);
				            itemm.setProduct(p);
				            this.cartItems.add(itemm);
		        	}
		        	
		        }
	        	
	    }
	 
	    public void validate() {
	 
	    }
	 
	    public void updateProduct(int code, int quantity) {
	        CartItem itemm = this.findItemByCode(code);
	 
	        if (itemm != null) {
	            if (quantity <= 0) {
	                this.cartItems.remove(itemm);
	            } else {
	                itemm.setQuantity(quantity);
	            }
	        }
	    }
	 
	    public void removeProduct(ProductInfo productInfo) {
	        CartItem itemm = this.findItemByCode(productInfo.getCode());
	        if (itemm != null) {
	            this.cartItems.remove(itemm);
	        }
	    }
	 
	    public boolean isEmpty() {
	        return this.cartItems.isEmpty();
	    }
	 
	  
	 
	    public int getQuantityTotal() {
	        int quantity = 0;
	        for (CartItem itemm : this.cartItems) {
	            quantity += itemm.getQuantity();
	        }
	        return quantity;
	    }
	 
	  

		public double getAmountTotal() {
	        double total = 0;
	        for (CartItem itemm : this.cartItems) {
	            total += itemm.getAmount();
	        }
	        return total;
	    }
	 
	    public void updateQuantity(CartInfo cartForm) {
	        if (cartForm != null) {
	            List<CartItem> itemm = cartForm.getCartItems();
	            for (CartItem line : itemm) {
	                this.updateProduct(line.getProductInfo().getCode(), line.getQuantity());
	            }
	        }
	 
	    }

}
