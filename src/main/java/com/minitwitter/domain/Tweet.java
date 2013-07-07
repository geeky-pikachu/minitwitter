package com.minitwitter.domain;

import java.util.Date;

public class Tweet {
	private String username;
	private Date time;
	private String tweet;

	public Tweet(String username, String tweet, long time) {
		this.time = new Date(time);
		this.username = username;
		this.tweet = tweet;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
