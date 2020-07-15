package com.lee.community.serviceimpl;

import com.lee.community.mapper.NoticeMapper;
import com.lee.community.pojo.Notice;
import com.lee.community.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    @Override
    public int addNotice(Notice notice) {
        notice.setNoticeId("400"+String.valueOf(new Date().getTime()));
        notice.setPublishTime(new Timestamp(new Date().getTime()));
        return noticeMapper.addNotice(notice);
    }

    @Override
    public List<Notice> queryNoticeByTitle(String title) {
        return noticeMapper.queryNoticeByTitle(title);
    }

    @Override
    public int deleteNotice(String[] ids) {
        return noticeMapper.deleteNotice(ids);
    }

    @Override
    public Notice queryNoticeById(String id) {
        noticeMapper.updateViews(id);
        return noticeMapper.queryNoticeById(id);
    }
}
