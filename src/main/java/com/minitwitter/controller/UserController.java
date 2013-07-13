package com.minitwitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.minitwitter.domain.Tweet;
import com.minitwitter.domain.User;
import com.minitwitter.service.TweetService;
import com.minitwitter.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/signin/")
	public ModelAndView signin() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping("/register/")
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/register/", method = RequestMethod.POST)
	public ModelAndView registerForm(@RequestParam String username, @RequestParam String password1, @RequestParam String password2, @RequestParam String email){
		ModelAndView mv = new ModelAndView("register");
		
		User user  = new User();
		user.setUsername(username);
		user.setPassword1(password1);
		user.setPassword2(password2);
		user.setEmail(email);
		
		User afterRegister = userService.userRegister(user);
		if(afterRegister.isNewUser()){
			mv = new ModelAndView("registerSuccess");
		}
		return mv;
	}
	
	@Autowired
	TweetService tweetService;
	
	@RequestMapping("/{username}")	//{username}
	public ModelAndView showTweet(@PathVariable String username) {
		List<Tweet> listTweet = listTweet("username");
		return new ModelAndView("post", "tweets", listTweet);
	}

	private List<Tweet> listTweet(String username) {
		return tweetService.list(username, "all");
	}
	
	@RequestMapping(value = "/{username}", method = RequestMethod.POST)
	public ModelAndView post(@PathVariable String username,
			@RequestParam String message) {
		ModelAndView mv = new ModelAndView("redirect:/" + username);
		if (message != null && message != "") {
			tweetService.tweet(username, message);
			System.out.println("post as: " + username);
			System.out.println("with message: " + message);
		} else {
			System.out.println("post empty message as: " + username);
		}
		return mv;
	}

//	@RequestMapping("/signout/")
//	public ModelAndView signout(){
//	 	session.invalidate();  
//	 	ModelAndView mv = new ModelAndView(response.sendRedirect(request.getContextPath() + "/index.jsp"));  
//	}
}