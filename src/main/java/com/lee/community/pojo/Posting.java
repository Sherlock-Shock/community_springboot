package com.lee.community.pojo;

import java.sql.Timestamp;

public class Posting {
    private String postId;
    private String userId;
    private String title;
    private String content;
    private Timestamp postTime;
    private int views;

    public Posting() {
    }

    public Posting(String postId, String userId, String title, String content, Timestamp postTime, int views) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.postTime = postTime;
        this.views = views;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
