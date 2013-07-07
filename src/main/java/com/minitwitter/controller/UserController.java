package com.minitwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.minitwitter.service.TweetService;

@Controller
public class UserController {
	@Autowired
	TweetService tweetService;
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
	public String post(@PathVariable String username) {
		return "post";
	}
	
	@RequestMapping(value = "/{username}/post", method = RequestMethod.POST)
	public ModelAndView post(@PathVariable String username, @RequestParam String message) {		
		ModelAndView mv = new ModelAndView("post");
		if (message != null && message != "") {
			tweetService.tweet(username, message);
			System.out.println("post as: " + username);
			System.out.println("with message: " + message);
		} else {
			System.out.println("post empty message as: " + username);			
		}		
		return mv;
	}
	
	@RequestMapping(value = "/{username}/delete/{postId}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable String username, @PathVariable String postId) {		
		ModelAndView mv = new ModelAndView("delete");
		// tweetService.delete(postId);
		System.out.println("post as: " + username);
		return mv;
	}
}