<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">

</head>
<body>
 <jsp:include page="initial_header.jsp" />
<div class="container" style="text-align: center">
  <br>
  <br>
  <br>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <div class="container">
    <form action="${contextPath}/user/login.htm" method="POST">
        <table>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="username" size="30" required="required" /></td>
        </tr>
        
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" size="30" required="required"/></td>
        </tr>
        
        <tr>
            <td colspan="2"><input type="submit" value="Login" /></td>
           
        </tr>
                
        </table>
    </form>
    </div>
    <br><br>
    <a href="${contextPath}/user/create.htm">Register User</a><br></br>
    <a href="${contextPath}/admin/create.htm">Register Admin</a>
  
      </div>
          <jsp:include page="footer.jsp" />
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>