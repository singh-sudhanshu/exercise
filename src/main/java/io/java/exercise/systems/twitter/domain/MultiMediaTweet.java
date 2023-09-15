package io.java.exercise.systems.twitter.domain;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class MultiMediaTweet extends Tweet {

    private final List<String> mediaUrls;

    public MultiMediaTweet(UUID id, ZonedDateTime tweetPostedDateTime, List<String> mediaUrls) {
        this.mediaUrls = mediaUrls;
    }
}
