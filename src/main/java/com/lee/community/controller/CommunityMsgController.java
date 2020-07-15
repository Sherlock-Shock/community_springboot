package com.lee.community.controller;

import com.lee.community.dto.ResultJSON;
import com.lee.community.pojo.CommunityMsg;
import com.lee.community.service.CommunityMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityMsgController {
    @Autowired
    CommunityMsgService communityMsgService;

    @PostMapping("/getCommunityMsg")
    public ResultJSON queryMsg(int communityId){
        return new ResultJSON("200","成功",communityMsgService.queryMsg(communityId));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/updateCommunityMsg")
    public int updateMsg(CommunityMsg communityMsg){
        return communityMsgService.updateMsg(communityMsg);
    }


}
