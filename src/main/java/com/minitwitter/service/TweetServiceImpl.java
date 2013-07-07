package com.minitwitter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import com.minitwitter.domain.Tweet;

public class TweetServiceImpl implements TweetService {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public Long tweet(String username, String message) {
		String key = username + ":tweets";
		long time = System.currentTimeMillis();
		String data = time + ":delim:" + message;

		ListOperations<String, String> list = redisTemplate.opsForList();
		return list.leftPush(key, data);
	}

	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}


	public List<Tweet> list(String username, String mode) {
		ListOperations<String, String> list = redisTemplate.opsForList();
		String key = username + ":tweets";
		List<String> tweets = list.range(key, 0, -1);
		List<Tweet> tweetList = new ArrayList<Tweet>();
		for(String item: tweets){
			String[] array = item.split(":delim:");
			String tweet = array[1];
			Long time = Long.parseLong(array[0]);
			tweetList.add(new Tweet(tweet, time, username));
		}
		return tweetList;
	}

	@Override
	public Long delete(String username, String id) {
		ListOperations<String, String> list = redisTemplate.opsForList();
		String key = username + ":tweets";
		Long longId = Long.parseLong(id);
		String tweet = list.range(key, longId, longId).get(0);

		return list.remove(key, longId, tweet);

	}

}
