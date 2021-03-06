<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Adding</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
   <jsp:include page="admin_header.jsp" />
    <a href="${pageContext.request.contextPath}/user/login.htm">Home</a><br></br>
<font color="red">${errorMessage}</font>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
   Orders:
   <table border=1>
   	<tr>
   	    <th>Order ID</th>
   		<th>Customer Name</th>
   		<th>Customer Address</th>
   		<th>Price</th>
   		<th>Quantity</th>
   		<th>Products</th>
   		
   	</tr>
   	<c:forEach items="${orderList}" var="list">
   	<tr>
   		    <td>${list.id}</td>
   			<td>${list.customerName}</td>
   			<td>${list.customerAddress}</td>
   			<td>${list.price}</td>
   			<td>${list.quantity}</td>
   			<td><a href="${pageContext.request.contextPath}/detailProducts.htm?id=${list.id}">
     View Products
   </a></td>
   		
   	</tr>
   	</c:forEach>
   </table>
     <jsp:include page="footer.jsp" />
</body>
</html>