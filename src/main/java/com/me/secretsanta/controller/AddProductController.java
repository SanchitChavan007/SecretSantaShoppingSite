package com.me.secretsanta.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.secretsanta.cartSession.CartSession;
import com.me.secretsanta.dao.OrderDAO;
import com.me.secretsanta.dao.ProductDAO;
import com.me.secretsanta.model.CartInfo;
import com.me.secretsanta.model.CartItem;
import com.me.secretsanta.model.ProductInfo;
import com.me.secretsanta.pojo.Order;
import com.me.secretsanta.pojo.Product;



@Controller

public class AddProductController {
	
	@Autowired
	@Qualifier("productDAO")
	ProductDAO pdao;
	
	@Autowired
	@Qualifier("orderDAO")
	OrderDAO odao;
	


	
	@RequestMapping(value="/addProduct.htm", method=RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("product") Product product, BindingResult result) throws Exception {
		
		String modelObject=null;
		Map<String, Object> map = new HashMap<String,Object>();
	
		if(result.hasErrors()) {
			return new ModelAndView("admin-dashboard", "product", product);
		}
		
		Boolean saved = pdao.addProduct(product);
		int count = 1;
        map.put("msgtyp", "add");
        
        if(saved) {
          map.put("msgfor", "success");
          map.put("rowcount", count);}
        else {
        	map.put("msgfor", "error");
        	map.put("msg", "Could not save product");
        }
		return new ModelAndView("add-success", "map", map);
	}
	
	@RequestMapping(value="/viewOrders.htm", method=RequestMethod.GET)
	public ModelAndView viewOrderPage(Model model) {
		
		List<Order> orderList = null;
		try {
			orderList = odao.displayOrder();
		} catch (Exception e) {
				}
		
		
		model.addAttribute("orderList", orderList);
		
		return new ModelAndView("viewOrders");
		
	}
	
	
	
	 @RequestMapping({ "/detailProducts.htm" })
	    public String listOrderProducts(HttpServletRequest request, Model model, //
	            @RequestParam(value = "id", defaultValue = "") int id) throws Exception {
		 List<Product> productList = new ArrayList<Product>();
		 //List<Product> productList = new ArrayList<Product>();
	 
  HttpSession session = request.getSession();
        try {
			productList = odao.displayOrderProducts(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
        for(Product p : productList) {
			System.out.println("Controller"+p.getName());
		}
       
       session.setAttribute("productList", productList);
    
   return "product-detail";
}
	 
	 @RequestMapping({ "/detailCustomerProducts.htm" })
	    public String listCustomerOrderProducts(HttpServletRequest request, Model model, //
	            @RequestParam(value = "id", defaultValue = "") int id) throws Exception {
		 List<Product> productList = new ArrayList<Product>();
		 //List<Product> productList = new ArrayList<Product>();
	 
HttpSession session = request.getSession();
     try {
			productList = odao.displayOrderProducts(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

     for(Product p : productList) {
			System.out.println("Controller"+p.getName());
		}
    
    session.setAttribute("productList", productList);
 
return "customerProduct-detail";
}
}
