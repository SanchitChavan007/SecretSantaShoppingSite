<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
  <jsp:include page="initial_header.jsp" />
  <font color="red">${errorMessage}</font>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <form action="${contextPath}/user/create.htm" method="POST">
        <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" size="30" required="required" /></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" size="30" required="required" /></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone" size="30" required="required" /></td>
        </tr>
        <tr>
            <td>User Email:</td>
            <td><input type="text" name="username" size="30" required="required" /></td>
        </tr>
        
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" size="30" required="required"/></td>
        </tr>
         <tr>
         <td><input type="hidden" name="role" value="customer"/></td>
        </tr>
        
        <tr>
                <td colspan="2">
                <label for="captchaCode" class="prompt">Retype the characters from the picture:</label> 
                <%
                    // Adding BotDetect Captcha to the page
                    Captcha captcha = Captcha.load(request, "CaptchaObject");
                    captcha.setUserInputID("captchaCode");

                    String captchaHtml = captcha.getHtml();
                    out.write(captchaHtml);
                %> 
                <input id="captchaCode" type="text" name="captchaCode" required="required"/>
                </td>
            </tr>
        
        <tr>
            <td colspan="2"><input type="submit" value="Submit" /></td>
        </tr>
                
        </table>
    </form>
      <jsp:include page="footer.jsp" />
</body>
</html>