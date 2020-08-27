package com.lee.community.serviceimpl;

import com.lee.community.mapper.CommunityMsgMapper;
import com.lee.community.pojo.CommunityMsg;
import com.lee.community.service.CommunityMsgService;
import com.lee.community.util.FastJSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CommunityMsgServiceImpl implements CommunityMsgService {
    @Autowired
    CommunityMsgMapper communityMsgMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public List<CommunityMsg> queryMsg(int communityId) {
        String key = new String("communitiMsg:"+String.valueOf(communityId));
        String communityMsg = stringRedisTemplate.opsForValue().get(key);
        if(communityMsg==null){
            synchronized (this){
                communityMsg = stringRedisTemplate.opsForValue().get(key);
                if (communityMsg==null){
                    System.out.println("从数据库中获取......");
                    List<CommunityMsg> communityMsgs = communityMsgMapper.queryMsg(communityId);
                    stringRedisTemplate.opsForValue().set(key, FastJSONUtil.bean2json(communityMsgs),10, TimeUnit.SECONDS);
                    return communityMsgs;
                }
            }
        }


        return FastJSONUtil.json2beans(communityMsg,CommunityMsg.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateMsg(CommunityMsg communityMsg) {
        String key = new String("communitiMsg:"+String.valueOf(communityMsg.getCommunityId()));
        int i = communityMsgMapper.updateMsg(communityMsg);
        if (i>0){
            stringRedisTemplate.delete(key);
            //throw new RuntimeException("突然出错......");
        }
        return i;
    }
}
