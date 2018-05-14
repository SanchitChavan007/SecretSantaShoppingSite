<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Adding</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">

</head>
<body>
<jsp:include page="header.jsp" />
<font color="red">${errorMessage}</font>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <form action="${contextPath}/displayOrderForm.htm" method="POST">
        <table>
        <tr>
            <td>Customer Name:</td>
            <td><input type="text" name="customerName" size="30" required="required" /></td>
        </tr>
       
        <tr>
            <td>Customer Address:</td>
            <td><input type="text" name="customerAddress" size="30" required="required" /></td>
        </tr>
        <tr>
           <h3>Cart Summary:</h3>
      <ul>
      <li>Products: </li>
     <c:forEach items="${myCart.cartItems}" var="cartItems">
       <div class="product-preview-container">
           <ul>
               <li>Product: ${cartItems.productInfo.code}</li>
               <li>Name: ${cartItems.productInfo.name}</li>
               <li>Price: ${cartItems.productInfo.price}</li>
               <br></br>
           </ul>
           </div>
           </c:forEach>
          <li>Quantity: ${myCart.quantityTotal}</li>
             <td><input type="hidden" name="quantity" value="${myCart.quantityTotal}"/></td>
          <li>Total: ${myCart.amountTotal}</li>
          <td><input type="hidden" name="price" value="${myCart.amountTotal}"/></td>
      </ul>
           
        </tr>
      
        <tr>
            <td colspan="2"><input type="submit" value="Add Order" /></td>
        </tr>
                
        </table>
    </form>
      <jsp:include page="footer.jsp" />
</body>
</html>