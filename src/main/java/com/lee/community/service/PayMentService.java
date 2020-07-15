package com.lee.community.service;

import com.lee.community.pojo.ParkingTPayList;
import com.lee.community.pojo.PayItem;
import com.lee.community.pojo.PaymentList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PayMentService {
    List<PayItem> queryPayItem(PayItem payItem);
    int addPayItem(PayItem payItem);
    int deletePayItemByIds(String[] ids);
    int updatePayItemById(PayItem payItem);
    //paymentlist
    int addPaymentList(PaymentList paymentList);
    List<Map> queryPaymentList(String payItemName,String beginTime,String overTime,String isPay,String paymentId);
    List<Map> queryOwnerPaymentList(String userId,String payItemName,String beginTime,String overTime,String isPay);
    int updatePaymentListToPay(PaymentList paymentList);

    int addParkingPaymentList(ParkingTPayList parkingTPayList);
    List<Map> queryTPPaymentList(String licenseNo, String beginTime, String overTime);
    int addPiLiangPaymentList(String payItemId, String charStandard,String charOnce);

}
