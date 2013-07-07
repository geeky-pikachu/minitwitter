package com.minitwitter.service;

import java.util.List;

import com.minitwitter.domain.Tweet;

public interface TweetService {
	Long tweet(String username, String message);

	List<Tweet> list(String username, String mode);

	Long delete(String username, String tweet);

}
