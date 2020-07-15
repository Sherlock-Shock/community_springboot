package com.lee.community.service;

import com.lee.community.pojo.CommunityMsg;

import java.util.List;

public interface CommunityMsgService {
    List<CommunityMsg> queryMsg(int communityId);
    int updateMsg(CommunityMsg communityMsg);
}
