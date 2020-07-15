package com.lee.community.service;

import com.lee.community.pojo.PostComment;
import com.lee.community.pojo.Posting;

import java.util.List;
import java.util.Map;

public interface PostingService {
    //post
    int addPosting(Posting posting);
    List<Map> queryPostByTitle(String title);
    Map queryPostDetail(String postId);
    int deletePostById(String postId);


    //commont
    int addComment(PostComment postComment);
    List<PostComment> queryAllCommentByPostId(String postId,String rankType);
    int queryPostCommentNum(String postId);
    int giveCommentStar(int commentId);
    List<PostComment> queryInnerComment(String commentId);
    int queryBeComNum(int beCommentId);
}
