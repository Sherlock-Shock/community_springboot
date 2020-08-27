package com.lee.community.mapper;

import com.lee.community.pojo.PayItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayItemMapper {
    List<PayItem> queryPayItem(PayItem payItem);
    int addPayItem(PayItem payItem);
    int deletePayItemByIds(String[] ids);
    int updatePayItemById(PayItem payItem);
}
