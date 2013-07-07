package com.minitwitter.service;

import java.util.Set;

import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

import com.minitwitter.domain.Tweet;

public interface TweetService {
	Tweet tweet(String username, String message);
	Set<TypedTuple<String>> list(String username, String mode);
}
