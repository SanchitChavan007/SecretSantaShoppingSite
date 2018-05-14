<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
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
 
   <div class="page-title">Product List</div>
 
   <c:forEach items="${requestScope.map.productlist}" var="prod">
       <div class="product-preview-container">
           <ul>
                         <li>Code: ${prod.code}</li>
               <li>Name: ${prod.name}</li>
               <li>Price: <fmt:formatNumber value="${prod.price}" type="currency"/></li>
                <li>Available Quantity: ${prod.quantity}</li>
                   <li><a
                   href="${pageContext.request.contextPath}/buyProduct.htm?code=${prod.code}">
                       Buy Now</a></li>
           </ul>
       </div>
 
   </c:forEach>
   <br/>
  
   <jsp:include page="footer.jsp" />
 
</body>
</html>