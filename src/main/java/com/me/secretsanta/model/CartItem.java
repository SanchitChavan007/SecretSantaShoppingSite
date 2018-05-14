package com.me.secretsanta.model;

import com.me.secretsanta.pojo.Product;

public class CartItem {

	 	private ProductInfo productInfo;
	    private int quantity;
	    private Product product;
	    
	    public CartItem() {
	        this.quantity = 0;
	    }
	 
	    public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public ProductInfo getProductInfo() {
	        return productInfo;
	    }
	 
	    public void setProductInfo(ProductInfo productInfo) {
	        this.productInfo = productInfo;
	    }
	 
	    public int getQuantity() {
	        return quantity;
	    }
	 
	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
	 
	    public double getAmount() {
	        return this.productInfo.getPrice() * this.quantity;
	    }
}
