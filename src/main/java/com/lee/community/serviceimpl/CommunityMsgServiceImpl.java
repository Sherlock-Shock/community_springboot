package com.lee.community.serviceimpl;

import com.lee.community.mapper.CommunityMsgMapper;
import com.lee.community.pojo.CommunityMsg;
import com.lee.community.service.CommunityMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommunityMsgServiceImpl implements CommunityMsgService {
    @Autowired
    CommunityMsgMapper communityMsgMapper;

    @Override
    public List<CommunityMsg> queryMsg(int communityId) {
        return communityMsgMapper.queryMsg(communityId);
    }

    @Override
    public int updateMsg(CommunityMsg communityMsg) {
        return communityMsgMapper.updateMsg(communityMsg);
    }
}
