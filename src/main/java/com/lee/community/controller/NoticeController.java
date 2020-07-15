package com.lee.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.community.common.Const;
import com.lee.community.dto.PageListJSON;
import com.lee.community.mapper.NoticeMapper;
import com.lee.community.pojo.Notice;
import com.lee.community.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @PostMapping("/getNotice")
    public PageListJSON getNoticeByPage(int page , int rows, @RequestParam(value ="title",required=false) String title){
        PageHelper.startPage(page,rows);
        List<Notice> list = noticeService.queryNoticeByTitle(title);
        PageInfo pageinfo = new PageInfo(list);
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }


    @PostMapping("/getOneNotice")
    public Notice getOneNotice(String noticeId){
        return noticeService.queryNoticeById(noticeId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/addNotice")
    public int addNotice(Notice notice){
        return noticeService.addNotice(notice);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/deleteNotice")
    public int deleteNotice(String[] noticeId){
        return noticeService.deleteNotice(noticeId);
    }

    @PostMapping("/uploadNoticePicture")
    public String uploadNoticePicture(MultipartFile file) {
        if (Objects.isNull(file) || file.isEmpty()) {
            return "0";
        }
        try {
            byte[] bytes = file.getBytes();
            String fimeName = String.valueOf(new Date().getTime())+".jpg";
            Path path = Paths.get(Const.NOTICE_PICTURE_FOLDER + fimeName);
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(Const.POST_PICTURE));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            String url = Const.NOTICE_PICTURE_URL+fimeName;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }


}
