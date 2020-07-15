package com.lee.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.community.common.Const;
import com.lee.community.dto.PageListJSON;
import com.lee.community.pojo.PostComment;
import com.lee.community.pojo.Posting;
import com.lee.community.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.*;

@RestController
public class PostingController {
    @Autowired
    PostingService postingService;

    @PostMapping("/addPosting")
    public int addPosting(Posting posting){
        return postingService.addPosting(posting);
    }

    @PostMapping( "/getPosting")
    public PageListJSON getPostingByPage(int page, int rows,
                                         @RequestParam(value = "title",required = false) String title){

        PageHelper.startPage(page,rows);
        List<Map> list = postingService.queryPostByTitle(title);
        PageInfo pageinfo = new PageInfo(list);

        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PostMapping("/getPostDetail")
    public Map getPostDetail(String postId){
        return postingService.queryPostDetail(postId);
    }

    //commont
    @PostMapping("/addComment")
    public int addComment(PostComment postComment){
        return postingService.addComment(postComment);
    }

    @PostMapping("/getAllComment")
    public PageListJSON addComment(int page,int rows,String postId, String rankType){
        PageHelper.startPage(page,rows);
        List<PostComment> list =postingService.queryAllCommentByPostId(postId,rankType);
        for (PostComment po : list) {
            //System.out.println(po.getBeCommentId());
            //int j = po.getCommentId();
            //int i = postingService.queryBeComNum();
            po.setBeComNum(postingService.queryBeComNum(po.getCommentId()));
        }
        PageInfo pageinfo = new PageInfo(list);
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PostMapping("/getInnerComment")
    public List<PostComment> queryInnerComment(String commentId){
        return postingService.queryInnerComment(commentId);
    }

    @PostMapping("/getCommentNum")
    public int getCommentNum(String postId){
        return postingService.queryPostCommentNum(postId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/deletePost")
    public int deletePostById(String postId){
        return postingService.deletePostById(postId);
    }

    @PostMapping("/giveCommentStar")
    public int giveCommentStar(int commentId){
        return postingService.giveCommentStar(commentId);
    }

    @PostMapping("/uploadPostPicture")
    public String uploadPostPicture(MultipartFile file) {
        if (Objects.isNull(file) || file.isEmpty()) {
            return "0";
        }
        try {
            byte[] bytes = file.getBytes();
            String fimeName = String.valueOf(new Date().getTime())+".jpg";
            Path path = Paths.get(Const.POST_PICTURE + fimeName);
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(Const.POST_PICTURE));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            String url = Const.POST_PICTURE_URL+fimeName;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }

}
