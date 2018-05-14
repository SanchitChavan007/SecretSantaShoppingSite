<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
   <jsp:include page="header.jsp" />
 <a href="${pageContext.request.contextPath}/viewOrders.htm">
      Back to Orders   </a><br></br>
<font color="red">${errorMessage}</font>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
   Product Details:
   <table border=1>
   	<tr>
   		<th>Product Code</th>
   		<th>Product  Name</th>
   		<th>Price</th>
   		<th>Quantity</th>
   		
   	</tr>
   	<c:forEach items="${productList}" var="product">
   	<tr>
   		
   			<td>${product.code}</td>
   			<td>${product.name}</td>
   			<td>${product.price}</td>
   			<td>${product.quantity}</td>
   	</tr>
   	</c:forEach>
   </table>
     <jsp:include page="footer.jsp" />
</body>
</html>