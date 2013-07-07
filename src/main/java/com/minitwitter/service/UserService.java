package com.minitwitter.service;

import com.minitwitter.domain.User;

public interface UserService {
	public boolean checkAuthen(String username, String password) ;
	public User registUser(User user);
}