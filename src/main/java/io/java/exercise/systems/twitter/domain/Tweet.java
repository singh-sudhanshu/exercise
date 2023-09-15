package io.java.exercise.systems.twitter.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class Tweet implements Serializable {

    public static final Long classVersionId = 1L;

    private UUID userId;
    private UUID tweetId;
    private Long tweetRank;
    private ZonedDateTime tweetPostedDateTime;
}
