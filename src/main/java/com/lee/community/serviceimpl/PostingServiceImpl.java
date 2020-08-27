package com.lee.community.serviceimpl;

import com.lee.community.mapper.PostCommentMapper;
import com.lee.community.mapper.PostingMapper;
import com.lee.community.pojo.PostComment;
import com.lee.community.pojo.Posting;
import com.lee.community.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PostingServiceImpl implements PostingService {
    @Autowired
    PostingMapper postingMapper;
    @Autowired
    PostCommentMapper postCommentMapper;

    @Override
    public int addPosting(Posting posting) {
        posting.setPostId("700"+String.valueOf(System.currentTimeMillis()));
        posting.setPostTime(new Timestamp(System.currentTimeMillis()));
        return postingMapper.addPosting(posting);
    }

    @Override
    public List<Map> queryPostByTitle(String title) {
        return postingMapper.queryPostByTitle(title);
    }

    @Override
    public Map queryPostDetail(String postId) {
        postingMapper.updateViews(postId);
        return postingMapper.queryPostDetail(postId);
    }

    @Override
    public int deletePostById(String postId) {
        return postingMapper.deletePostById(postId);
    }
    //commont

    @Override
    public int addComment(PostComment postComment) {
        postComment.setComTime(new Timestamp(System.currentTimeMillis()));
        return postCommentMapper.addComment(postComment);
    }

    @Override
    public List<PostComment> queryAllCommentByPostId(String postId, String rankType) {
        return postCommentMapper.queryAllCommentByPostId(postId,rankType);
    }

    @Override
    public int queryPostCommentNum(String postId) {
        return postCommentMapper.queryPostCommentNum(postId);
    }

    @Override
    public int giveCommentStar(int commentId) {
        return postCommentMapper.giveCommentStar(commentId);
    }

    @Override
    public List<PostComment> queryInnerComment(String commentId) {
        return postCommentMapper.queryInnerComment(commentId);
    }

    @Override
    public int queryBeComNum(int beCommentId) {
        return postCommentMapper.queryBeComNum(beCommentId);
    }
}
