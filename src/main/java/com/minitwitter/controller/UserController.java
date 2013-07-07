package com.minitwitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/{username}")
	public ModelAndView showTweet(@PathVariable String username) {
		ModelAndView mv = new ModelAndView("list");
		//tweetService.showTweet(username);
		System.out.println("show post of: " + username);
		return mv;
	}
	
	@RequestMapping("/{username}/post")
	public ModelAndView post(@PathVariable String username) {		
		ModelAndView mv = new ModelAndView("post");
		//tweetService.tweet(username, message);
		System.out.println("post as: " + username);
		return mv;
	}
	
	@RequestMapping("/{username}/delete/{postId}")
	public ModelAndView post(@PathVariable String username, @PathVariable String postId) {		
		ModelAndView mv = new ModelAndView("delete");
		// tweetService.delete(postId);
		System.out.println("post as: " + username);
		return mv;
	}
}