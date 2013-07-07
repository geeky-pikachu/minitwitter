package com.minitwitter.service;

import com.minitwitter.domain.Tweet;

public interface TweetService {
	Tweet tweet(String username, String message);
}
