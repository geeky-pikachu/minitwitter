package com.minitwitter.service;

import java.util.List;

import com.minitwitter.domain.User;

public interface UserService {
	public boolean checkAuthen(String username, String password) ;
//	public User registUser(User user);
	public User userRegister(User user);
	public List<String> listAllUser(String username);
}