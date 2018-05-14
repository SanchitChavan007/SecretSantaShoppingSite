package com.me.secretsanta.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 50, nullable = false)
	private int id;
	
	 @Column(name = "Customer_name", nullable = false)
    private String customerName;
	 
	 @Column(name = "Customer_Address", nullable = false)
    private String customerAddress;
	 
	 @Column(name = "Price", nullable = false)
    private double price;
    
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Order_Products", 
        joinColumns = { @JoinColumn(name = "ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "product_code") }
    )
    private List<Product> productList = new ArrayList<Product>();
   

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
    public int getId() {
        return id;
    }
 
   
    public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

   
	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void setId(int id) {
        this.id = id;
    }
 
   
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
   

}
