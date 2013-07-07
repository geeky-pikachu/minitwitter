package com.minitwitter.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

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

	public Set<TypedTuple<String>> list(String username, String mode) {
		ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
		Set<TypedTuple<String>> tweets = zset.rangeWithScores(username, 0, -1);
		
		return tweets;
	}

}
