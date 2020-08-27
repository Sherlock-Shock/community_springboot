package com.lee.community.mapper;

import com.lee.community.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    int addNotice(Notice notice);
    List<Notice> queryNoticeByTitle(String title);
    int deleteNotice(String[] ids);
    Notice queryNoticeById(String id);
    int updateViews(String noticeId);
}
