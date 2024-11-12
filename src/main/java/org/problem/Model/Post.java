package org.problem.Model;

import java.time.LocalDateTime;

public class Post {
    private static int postCounter = 1;
    private String id;
    private String content;
    private LocalDateTime timestamp;
    private int likes;
    private int dislikes;

    public Post(String content) {
        this.id = String.format("%03d", postCounter++);
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.likes = 0;
        this.dislikes = 0;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void like() {
        likes++;
    }

    public void dislike() {
        dislikes++;
    }
}