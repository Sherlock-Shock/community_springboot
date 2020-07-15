package com.lee.community.mapper;

import com.lee.community.pojo.CommunityMsg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMsgMapper {
    List<CommunityMsg> queryMsg(int communityId);
    int updateMsg(CommunityMsg communityMsg);
}
