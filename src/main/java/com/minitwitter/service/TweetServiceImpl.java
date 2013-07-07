package com.minitwitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import com.minitwitter.domain.Tweet;

public class TweetServiceImpl implements TweetService {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public Tweet tweet(String username, String message) {
		ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
		long time = System.currentTimeMillis();
		Boolean canTweet = zset.add(username , message, time);
		System.out.println("SERVICE: " + username);
		System.out.println("SERVICE: " + message);
		System.out.println("SERVICE: " + time);
		if (canTweet) {
			Tweet tweet = new Tweet(username, message, time);
			return tweet;
		}
		return null;
	}

	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public boolean delete(String username, String tweet) {
		ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
		return zset.remove(username, tweet);
	}

}
