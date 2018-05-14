package com.me.secretsanta.cartSession;

import javax.servlet.http.HttpServletRequest;

import com.me.secretsanta.model.CartInfo;

public class CartSession {
	public static CartInfo getCartInSession(HttpServletRequest request) {
		 
  //Cart Functioning
        CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");
        
        if (cartInfo == null) {
            cartInfo = new CartInfo();
            
            request.getSession().setAttribute("myCart", cartInfo);
        }
 
        return cartInfo;
    }
 
    public static void removeCartInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("myCart");
    }
 
}
