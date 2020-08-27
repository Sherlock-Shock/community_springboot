package com.lee.community.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PostComment {
    private int commentId;
    private String postId;
    private String userId;
    private String content;
    private Timestamp comTime;
    private int beCommentId;
    private int starNum;
    private int beComNum;
    private List<PostComment> children = new ArrayList<PostComment>();
    private String userName;
    private String photo;
    private String userRole;

    public PostComment() {
    }

    public PostComment(int commentId, String postId, String userId, String content, Timestamp comTime, int beCommentId, int starNum, List<PostComment> children) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.comTime = comTime;
        this.beCommentId = beCommentId;
        this.starNum = starNum;
        this.children = children;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getComTime() {
        return comTime;
    }

    public void setComTime(Timestamp comTime) {
        this.comTime = comTime;
    }

    public int getBeCommentId() {
        return beCommentId;
    }

    public void setBeCommentId(int beCommentId) {
        this.beCommentId = beCommentId;
    }

    public int getStarNum() {
        return starNum;
    }

    public void setStarNum(int starNum) {
        this.starNum = starNum;
    }

    public List<PostComment> getChildren() {
        return children;
    }

    public void setChildren(List<PostComment> children) {
        this.children = children;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getBeComNum() {
        return beComNum;
    }

    public void setBeComNum(int beComNum) {
        this.beComNum = beComNum;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
