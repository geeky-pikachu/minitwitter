package com.minitwitter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.minitwitter.domain.User;
import com.minitwitter.service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public boolean checkAuthen(String username, String password) {

		return false;
	}

	@Override
	public User registUser(User user) {
		HashOperations<String, String, String> redisHash = redisTemplate
				.opsForHash();
		if (redisHash.get(user.getUsername(), "username") == null) {
			redisHash.put(user.getUsername(), "username", user.getUsername());
			redisHash.put(user.getUsername(), "password", user.getPassword());
			redisHash.put(user.getUsername(), "confirm",
					user.getConfirmPassword());
			redisHash.put(user.getUsername(), "email", user.getEmail());
			user.setNewUser(true);
		} else{
			user.setNewUser(false);
		}
		return user;
	}
}
