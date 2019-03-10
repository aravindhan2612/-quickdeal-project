package com.ecomm.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.UserDetail;
@Controller
public class UserController {
	@Autowired
	UserDetailDAO userDetailDAO;
	@RequestMapping("/login_success")
	public String checkLogin(HttpSession session,Model m)
	{
		String page="";
		boolean loggedIn;
	
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication=sContext.getAuthentication();
		
		String username=authentication.getName();
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		//List<Category> listCategories=categoryDAO.listCategories();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ADMIN"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				loggedIn=true;
				page="UserHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
		}
		
		return page;
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String Registeruser(@RequestParam("username")String username,@RequestParam("customerName")String customerName,@RequestParam("address")String addr,@RequestParam("password")String password,@RequestParam("mobilenumber")String mobileNo,@RequestParam("Email")String Email)
	{
	
		UserDetail user=new UserDetail();
		user.setCustomerName(customerName);
		user.setUsername(username);
		user.setPassword(password);
		user.setMobileNo(mobileNo);
		user.setEmail(Email);
		user.setAddr(addr);
		user.setEnabled(true);
		user.setRole("USER");
	    userDetailDAO.registerUser(user);
	    
		return "Login";
	}

}
