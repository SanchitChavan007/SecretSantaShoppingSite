<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<div class="menu-container">
  
  <h1>Logged in as ${user.name}.</h1>
  
   <a href="${pageContext.request.contextPath}/user/login.htm">Home</a>
   |
   <a href="${pageContext.request.contextPath}/displayProducts.htm">
      Product List
   </a>
   |
   <a href="${pageContext.request.contextPath}/displayCart.htm">
      ${user.name}'s Cart
 
     |
</a>
</div>