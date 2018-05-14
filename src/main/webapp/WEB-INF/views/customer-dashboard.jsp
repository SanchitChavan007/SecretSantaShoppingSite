<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Books Shop Online</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<style>
body, html {
    height: 100%;
}
.bgimg {
    background-position: center;
    background-size: cover;
    background-image: url("${pageContext.request.contextPath}/gift.jpg");
    min-height: 75%;
}
.menu {
    display: none;
}
</style>
<body>
 
   <jsp:include page="header.jsp" />
 
       <div class="page-title">Welcome to Secret Santa gift store! Select the perfect gift for your loved ones from our unique collection of gifts!</div>
  

  
  
   <jsp:include page="footer.jsp" />
   
</body>
</html>