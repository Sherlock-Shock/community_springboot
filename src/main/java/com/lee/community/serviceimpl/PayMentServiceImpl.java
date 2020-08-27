package com.lee.community.serviceimpl;

import com.lee.community.mapper.ParkingTPayListMapper;
import com.lee.community.mapper.PayItemMapper;
import com.lee.community.mapper.PaymentListMapper;
import com.lee.community.pojo.Bhouse;
import com.lee.community.pojo.ParkingTPayList;
import com.lee.community.pojo.PayItem;
import com.lee.community.pojo.PaymentList;
import com.lee.community.service.PayMentService;
import com.lee.community.service.PropertyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PayMentServiceImpl implements PayMentService {
    @Autowired
    PayItemMapper payItemMapper;
    @Autowired
    PaymentListMapper paymentListMapper;
    @Autowired
    ParkingTPayListMapper parkingTPayListMapper;
    @Autowired
    PropertyService propertyService;

    @Override
    public List<PayItem> queryPayItem(PayItem payItem) {
        return payItemMapper.queryPayItem(payItem);
    }

    @Override
    public int addPayItem(PayItem payItem) {
        payItem.setPayItemId("300"+String.valueOf(System.currentTimeMillis()));
        return payItemMapper.addPayItem(payItem);
    }

    @Override
    public int deletePayItemByIds(String[] ids) {
        return payItemMapper.deletePayItemByIds(ids);
    }

    @Override
    public int updatePayItemById(PayItem payItem) {
        return payItemMapper.updatePayItemById(payItem);
    }

    //paymentlist

    @Override
    public int addPaymentList(PaymentList paymentList) {
        paymentList.setPaymentId("500"+String.valueOf(System.currentTimeMillis()));
        return paymentListMapper.addPaymentList(paymentList);
    }

    @Override
    public List<Map> queryPaymentList(String payItemName,String beginTime,String overTime,String isPay) {
        return paymentListMapper.queryPaymentList(payItemName,beginTime,overTime,isPay);
    }

    @Override
    public List<Map> queryOwnerPaymentList(String userId, String payItemName, String beginTime, String overTime, String isPay) {
        return paymentListMapper.queryOwnerPaymentList( userId,  payItemName,  beginTime,  overTime,  isPay);
    }

    @Override
    public int updatePaymentListToPay(PaymentList paymentList) {
        paymentList.setPayTime(new Timestamp(System.currentTimeMillis()));
        return paymentListMapper.updatePaymentListToPay(paymentList);
    }

    @Override
    public int addParkingPaymentList(ParkingTPayList parkingTPayList) {
        parkingTPayList.setPaymentId("550"+String.valueOf(System.currentTimeMillis()));
        parkingTPayList.setPayTime(new Timestamp(System.currentTimeMillis()));
        return parkingTPayListMapper.addParkingPaymentList(parkingTPayList);
    }

    @Override
    public List<Map> queryTPPaymentList(String licenseNo, String beginTime, String overTime) {
        return parkingTPayListMapper.queryTPPaymentList(licenseNo,beginTime,overTime);
    }

    @Override
    public int addPiLiangPaymentList(String payItemId, String charStandard, String charOnce) {
        List<Map> charList=  propertyService.queryHouseAndOwner(new Bhouse());
        int flag = 0;
        for (Map item : charList){
            PaymentList payOne = new PaymentList();
            payOne.setPaymentId("500"+String.valueOf(System.currentTimeMillis()));
            payOne.setPayPerId(item.get("ownerId").toString());
            payOne.setPayItemId(payItemId);
            payOne.setPayable(countPayable(charStandard,charOnce,item.get("houseAreal").toString()));
            payOne.setHouseId(Integer.parseInt(item.get("houseId").toString()));
            payOne.setParkId(0);
            paymentListMapper.addPaymentList(payOne);
            flag++;
        }
        if(flag==charList.size()){
            return 1;
        }else {
            return 0;
        }

    }

    public String countPayable( String charStandard, String charOnce,String houseAreal){
        int money = 0;
        if (charStandard.equals("")){
            money = Integer.parseInt(charOnce);
        }else if(charOnce.equals("")){
            money = Integer.parseInt(charStandard)*Integer.parseInt(houseAreal);
        }else {
            money = Integer.parseInt(charStandard)*Integer.parseInt(houseAreal)+Integer.parseInt(charOnce);
        }
        return String.valueOf(money);
    }
}
