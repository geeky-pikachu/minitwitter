package com.minitwitter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

import com.minitwitter.service.TweetServiceImpl;
import com.minitwitter.service.impl.UserServiceImpl;

@Configuration
@Import(RedisConfig.class)
public class ServiceConfig {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Bean
	TweetServiceImpl tweetService() {
		TweetServiceImpl tweetService = new TweetServiceImpl();
		tweetService.setRedisTemplate(redisTemplate);

		return tweetService;
	}
	
	@Bean
	UserServiceImpl userService(){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.setRedisTemplate(redisTemplate);
		
		return userServiceImpl;
	}
}
