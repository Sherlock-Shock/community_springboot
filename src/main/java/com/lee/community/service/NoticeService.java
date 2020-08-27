package com.lee.community.service;

import com.lee.community.pojo.Notice;

import java.util.List;

public interface NoticeService {
    int addNotice(Notice notice);
    List<Notice> queryNoticeByTitle(String title);
    int deleteNotice(String[] ids);
    Notice queryNoticeById(String id);
}
