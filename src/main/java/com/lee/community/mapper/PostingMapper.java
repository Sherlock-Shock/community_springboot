package com.lee.community.mapper;

import com.lee.community.pojo.Posting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostingMapper {
    int addPosting(Posting posting);
    List<Map> queryPostByTitle(String title);
    Map queryPostDetail(String postId);
    int updateViews(String postId);
    int deletePostById(String postId);
}
