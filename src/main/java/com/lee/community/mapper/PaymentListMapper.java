package com.lee.community.mapper;

import com.lee.community.pojo.PayItem;
import com.lee.community.pojo.PaymentList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PaymentListMapper {
    int addPaymentList(PaymentList paymentList);
    List<Map> queryPaymentList(@Param("payItemName") String payItemName,
                               @Param("beginTime") String beginTime,
                               @Param("overTime") String overTime,
                               @Param("isPay") String isPay);
    int updatePaymentListToPay(PaymentList paymentList);

    List<Map> queryOwnerPaymentList(@Param("userId") String userId,
                                    @Param("payItemName") String payItemName,
                                    @Param("beginTime") String beginTime,
                                    @Param("overTime") String overTime,
                                    @Param("isPay") String isPay);

}
