package com.lee.community.pojo;

import java.sql.Timestamp;

public class Notice {
    private String noticeId;
    private String title;
    private String content;
    private String publisher;
    private Timestamp publishTime;
    private int views;

    public Notice() {
    }

    public Notice(String noticeId, String title, String content, String publisher, Timestamp publishTime, int views) {
        this.noticeId = noticeId;
        this.title = title;
        this.content = content;
        this.publisher = publisher;
        this.publishTime = publishTime;
        this.views = views;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
