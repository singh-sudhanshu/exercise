package io.java.exercise.systems.twitter.domain;

import java.time.ZonedDateTime;
import java.util.UUID;

public class SimpleTweet extends Tweet {

    private final String tweetText;

    public SimpleTweet(UUID id, ZonedDateTime tweetPostedDateTime, String text) {
        this.tweetText = text;
    }
}
