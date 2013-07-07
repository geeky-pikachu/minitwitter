package com.minitwitter.domain;

import java.util.Date;

public class Tweet {
	private Date time;
	private String tweet;
	private String username;

	public Tweet(String tweet, Long time, String username) {
		this.time = new Date(time);
		this.tweet = tweet;
		this.username = username;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}


}
