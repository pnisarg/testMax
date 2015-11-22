
package com.projects.testMax.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projects.testMax.entity.Users;
import com.projects.testMax.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
	@RequestMapping(value="login")
	public ModelAndView login(HttpServletResponse response,HttpServletRequest request, @RequestParam (required = false) String username, @RequestParam  (required = false) String password) throws IOException{
		String fname = (String) request.getSession(false).getAttribute("fname");
		if(fname != null && !fname.isEmpty()){ //if user is already logged in redirect to home page
			String redirect = (request.getSession().getAttribute("privilege").equals("admin"))?"adminPanel":"home";
			return new ModelAndView(redirect);
		}else if(username == null || password == null){ 
			return new ModelAndView("login");
		}
		Users user = userService.authenticate(username, password);
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("fname", user.getFirstName());
			session.setAttribute("lname", user.getLastName());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("privilege", user.getPrivilege());
			if(user.getPrivilege().equalsIgnoreCase("user"))
				return new ModelAndView("home");
			else
				return new ModelAndView("adminPanel");
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "Invalid Username or Password!");
		return new ModelAndView("login",map);
	}
	@RequestMapping(value="logout")
	public ModelAndView logout(HttpServletResponse response,HttpServletRequest request){
		HttpSession session  = request.getSession();
		session.invalidate();
		return new ModelAndView("login");
	}
	@RequestMapping(value="home")
	public ModelAndView redirectHome(HttpServletResponse response,HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("fname") != null && !session.getAttribute("fname").toString().isEmpty()){
			return new ModelAndView("home");
		}else{
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(value="takeTest", method = RequestMethod.POST)
	public ModelAndView takeTest(HttpServletResponse response,HttpServletRequest request){
		return new ModelAndView("questionPanel");
	}
	
	@RequestMapping(value="review", method = RequestMethod.POST)
	public ModelAndView review(HttpServletResponse response,HttpServletRequest request){
		return new ModelAndView("reviewPanel");
	}
	
	
	
}
