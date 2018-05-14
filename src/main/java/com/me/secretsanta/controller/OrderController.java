package com.me.secretsanta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.secretsanta.cartSession.CartSession;
import com.me.secretsanta.dao.OrderDAO;
import com.me.secretsanta.model.CartInfo;
import com.me.secretsanta.model.CartItem;
import com.me.secretsanta.model.ProductInfo;
import com.me.secretsanta.pojo.Order;
import com.me.secretsanta.pojo.Product;

@Controller
public class OrderController {

	@Autowired
	@Qualifier("orderDAO")
	OrderDAO odao;
	
	 @RequestMapping(value = "/displayOrderForm.htm", method = RequestMethod.GET)
	    public String createOrderForm(HttpServletRequest request) {
		 
		
	        return "create-order";
	    }
	    @RequestMapping(value = "/displayOrderForm.htm", method = RequestMethod.POST)
	    public String handleCreateForm(HttpServletRequest request, ModelMap map) {
	    	
	    	
	    	 CartInfo myCart = CartSession.getCartInSession(request);
	    	  if (myCart.isEmpty()) {
	              
	              return "redirect:/shoppingCart";
	          } 
	    	 	List<Product> productList = new ArrayList();
	    	 	
	    	 	for(CartItem c : myCart.getCartItems()) {
	    	 		productList.add(c.getProduct());
	    	 		System.out.println(c.getProduct().getName());
	    	 	}
	            String customerName = request.getParameter("customerName");
	            String customerAddress = request.getParameter("customerAddress");
	            Order order = new Order();
	            order.setCustomerAddress(customerAddress);
	            order.setCustomerName(customerName);
	            order.setPrice(myCart.getAmountTotal());
	            order.setQuantity(myCart.getQuantityTotal());
	            order.setProductList(productList);
	            
	            try {
	            	Boolean saved = odao.addOrder(order);
	             
	             
	             
	                
	            } catch (Exception e) {
	               
	                e.printStackTrace();
	            }
	            CartSession.removeCartInSession(request);
	            return "order-success";
	    }
	    
	    @RequestMapping(value = "/userOrders.htm", method = RequestMethod.GET)
	    public String viewOrders() {
		 	
	        return "user-orders";
	    }
	    @RequestMapping({ "/viewCustomerOrder.htm" })
	    public String listCustomerOrdersHandler(HttpServletRequest request, Model model, //
	            @RequestParam(value = "name", defaultValue = "") String name) throws Exception {
		
			
			List<Order> orderList = null;
			try {
				orderList = odao.displayCustomerOrder(name);
			} catch (Exception e) {
					}
			
			
			model.addAttribute("orderList", orderList);
			
			return "user-orders";
	    }

}
