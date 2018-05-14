<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Shopping Cart</title>
 
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">

</head>
<body>
   <jsp:include page="header.jsp" />
  
  
   <fmt:setLocale value="en_US" scope="session"/>
 
   <div class="page-title">${user.name}'s Cart!</div>
 
   <c:if test="${empty cartInfo or empty cartInfo.cartItems}">
       <h2>There is no items in Cart</h2>
       <a href="${pageContext.request.contextPath}/productList">Show
           Product List</a>
   </c:if>
 
   <c:if test="${not empty cartInfo and not empty cartInfo.cartItems}">
       <form:form method="POST" modelAttribute="cartForm" action="${contextPath}/displayOrderForm.htm">
 
           <c:forEach items="${cartInfo.cartItems}" var="cartItems"
               varStatus="varStatus">
               <div class="product-preview-container">
                   <ul>
                       
                       <li>Code: ${cartItems.productInfo.code}
                       </li>
                       <li>Name: ${cartItems.productInfo.name}</li>
                       <li>Price: <span class="price">
                      
                         <fmt:formatNumber value="${cartItems.productInfo.price}" type="currency"/>
                        
                       </span></li>
                       <li>Quantity: ${cartItems.quantity}</li>
                       <li>Subtotal:
                         <span class="subtotal">
                        
                            <fmt:formatNumber value="${cartItems.amount}" type="currency"/>
                      
                         </span>
                       </li>
                       <li><a
                           href="${pageContext.request.contextPath}/shoppingCartRemoveProduct.htm?code=${cartItems.productInfo.code}">
                               Delete </a></li>
                   </ul>
                   </ul>
               </div>
           </c:forEach>
           <div style="clear: both"></div>
         
           <a class="navi-item"
               href="${pageContext.request.contextPath}/displayOrderForm.htm">Proceed to Checkout!</a>
        
               
       </form:form>
 
 
   </c:if>
 
 
   <jsp:include page="footer.jsp" />
 
</body>
</html>