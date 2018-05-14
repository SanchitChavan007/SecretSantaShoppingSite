package com.me.secretsanta.controller;


import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.captcha.botdetect.web.servlet.Captcha;
import com.me.secretsanta.dao.UserDAO;
import com.me.secretsanta.pojo.User;


@Controller
public class UserController {

	
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/user/login.htm", method = RequestMethod.GET)
    public String showLoginForm(HttpServletRequest request, UserDAO userDao) throws Exception {

        
        HttpSession session = request.getSession();
       User u =  (User) session.getAttribute("user");
    
    	
       if (u != null && u.getRole().equals("customer")) {
           return "customer-dashboard";
       }
       else if(u != null && u.getRole().equals("admin")) {
       	return "admin-menu";
       }
       
       else {
    	   return "user-login";
       }
    	
      
    }
    
    @RequestMapping(value = "/user/create.htm", method = RequestMethod.GET)
    public String showCreateForm() {

        return "user-create-form";
    }
    @RequestMapping(value = "/user/create.htm", method = RequestMethod.POST)
    public String handleCreateForm(HttpServletRequest request, UserDAO userDao, ModelMap map) {
        Captcha captcha = Captcha.load(request, "CaptchaObject");
        String captchaCode = request.getParameter("captchaCode");
        HttpSession session = request.getSession();
        if (captcha.validate(captchaCode)) {
            String useremail = request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");

            String role = request.getParameter("role");
            

            User user = new User();
            user.setUseremail(useremail);
            user.setPassword(password);
            user.setRole(role);
            user.setAddress(address);
            user.setName(name);
            user.setPhone(phone);

            try {
                User u = userDao.register(user);
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            map.addAttribute("errorMessage", "Invalid Captcha!");
            return "user-create-form";
        }

        return "user-created";
    }
    
    
    @RequestMapping(value = "/admin/create.htm", method = RequestMethod.GET)
    public String showAdminRegister() {

        return "admin-register";
    }
    @RequestMapping(value = "/admin/create.htm", method = RequestMethod.POST)
    public String handleAdminCreateForm(HttpServletRequest request, UserDAO userDao, ModelMap map) {
        Captcha captcha = Captcha.load(request, "CaptchaObject");
        String captchaCode = request.getParameter("captchaCode");
        HttpSession session = request.getSession();
        if (captcha.validate(captchaCode)) {
            String useremail = request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");

            String role = request.getParameter("role");
            

            User user = new User();
            user.setUseremail(useremail);
            user.setPassword(password);
            user.setRole(role);
            user.setAddress(address);
            user.setName(name);
            user.setPhone(phone);

            try {
                User u = userDao.register(user);
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            map.addAttribute("errorMessage", "Invalid Captcha!");
            return "admin-register";
        }

        return "user-created";
    }
    


@RequestMapping(value = "/user/login.htm", method = RequestMethod.POST)
public String handleLoginForm(HttpServletRequest request, UserDAO userDao, ModelMap map) {

		
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    HttpSession session = request.getSession();
    		
     try {
		session.setAttribute("user",userDao.get(username, password));
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

    try {
        User u = userDao.get(username, password);

        if (u != null && u.getRole().equals("customer")) {
            return "customer-dashboard";
        }
        else if(u != null && u.getRole().equals("admin")) {
        	return "admin-menu";
        }
       else {
            map.addAttribute("errorMessage", "Invalid username/password!");
            return "error";
        }
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return null;

}

@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
public String logoutUser(HttpServletRequest request) {

	HttpSession session = request.getSession();
   session.invalidate();
	
    return "logout-success";
}

@RequestMapping(value = "/addProducts.htm", method = RequestMethod.GET)
public String addProducts() {


    return "admin-dashboard";
}

@RequestMapping(value = "/adminPage.htm", method = RequestMethod.GET)
public String adminPage() {


    return "admin-menu";


}
}





	
