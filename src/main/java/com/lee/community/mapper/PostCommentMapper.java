package com.lee.community.mapper;

import com.lee.community.pojo.PostComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostCommentMapper {
    int addComment(PostComment postComment);
    List<PostComment> queryAllCommentByPostId(@Param("postId") String postId,
                                      @Param("rankType") String rankType);
    int queryPostCommentNum(String postId);
    int giveCommentStar(int commentId);
    List<PostComment> queryInnerComment(String commentId);
    int queryBeComNum(int beCommentId);
}
