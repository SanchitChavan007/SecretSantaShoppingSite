package com.me.secretsanta.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Products")
public class Product{
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_code",unique = true, nullable = false)
    private int code;
    
    @ManyToMany(mappedBy = "productList")
    private List<Order> orderList = new ArrayList<Order>();

	@Column(name="product_name")
    private String name;
	
	@Column(name="product_price")
    private double price;
	
	@Column(name="product_quantity")
    private String quantity;

 

    public Product() {
	
	}



	public int getCode() {
		return code;
	}




	public void setCode(int code) {
		this.code = code;
	}




	public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}



}
