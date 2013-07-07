package com.minitwitter.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.minitwitter.domain.Tweet;
import com.minitwitter.domain.User;
import com.minitwitter.service.TweetService;
import com.minitwitter.service.UserService;

@Controller
public class UserController {
	@Autowired
	TweetService tweetService;
	@Autowired
	UserService userService;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam String username,
			@RequestParam String password1, @RequestParam String password2,
			@RequestParam String email) {
		ModelAndView mv = new ModelAndView("/register");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password1);
		user.setConfirmPassword(password2);
		user.setEmail(email);

		User after = userService.registUser(user);
		if (after.isNewUser()) {
			mv = new ModelAndView("/registerSuccess");
		}
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView registerForm() {
		return new ModelAndView("register");
	}

	
	@RequestMapping("/{username}")
	public ModelAndView showTweet(@PathVariable String username) {
		List<Tweet> listTweet = listTweet(username);
		return new ModelAndView("post", "tweets", listTweet);
	}

	@RequestMapping("/{username}/post")
	public ModelAndView post(@PathVariable String username) {
		List<Tweet> listTweet = listTweet(username);
		return new ModelAndView("post", "tweets", listTweet);
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

	@RequestMapping(value = "/{username}/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String username,
			@PathVariable String id) {
		ModelAndView mv = new ModelAndView("redirect:/" + username);
		tweetService.delete(username, id);
		System.out.println("post as: " + username);
		return mv;
	}

	private List<Tweet> listTweet(String username) {
		return tweetService.list(username, "all");
	}
}