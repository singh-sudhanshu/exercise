package io.java.exercise.systems.twitter.api.external;

import io.java.exercise.systems.twitter.domain.Tweet;

import java.util.List;

public interface TweetService {

    void createTweet(Tweet tweet);
    List<Tweet> tweets(String userId);
}
