package com.lee.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.community.dto.PageListJSON;
import com.lee.community.pojo.ParkingTPayList;
import com.lee.community.pojo.PayItem;
import com.lee.community.pojo.PaymentList;
import com.lee.community.service.PayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PayMentController {
    @Autowired
    PayMentService payMentService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/getPayItem")
    public PageListJSON getPayItemByPage(int page, int rows, PayItem payItem){

        PageHelper.startPage(page,rows);
        List<PayItem> list = payMentService.queryPayItem(payItem);
        PageInfo pageinfo = new PageInfo(list);

        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/addPayItem")
    public int addPayItem(PayItem payItem){
        return payMentService.addPayItem(payItem);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/deletePayItem")
    public int deletePayItem(String[] payItemId){
        return payMentService.deletePayItemByIds(payItemId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/updatePayItem")
    public int updatePayItem(PayItem payItem){
        return payMentService.updatePayItemById(payItem);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/addPaymentList")
    public int addPaymentList(PaymentList paymentList){
        return payMentService.addPaymentList(paymentList);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/getPaymentList")
    public PageListJSON getPaymentListByPage(int page, int rows,
                                             @RequestParam(value ="payItemName",required=false) String payItemName,
                                             @RequestParam(value ="beginTime",required=false) String beginTime,
                                             @RequestParam(value ="overTime",required=false) String overTime,
                                             @RequestParam(value ="isPay",required=false) String isPay){

        PageHelper.startPage(page,rows);
        List<Map> list = payMentService.queryPaymentList(payItemName,beginTime,overTime,isPay);
        PageInfo pageinfo = new PageInfo(list);
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PostMapping( "/getOwnerPaymentList")
    public PageListJSON getOwnerPaymentList(int page, int rows, String userId,
                                             @RequestParam(value ="payItemName",required=false) String payItemName,
                                             @RequestParam(value ="beginTime",required=false) String beginTime,
                                             @RequestParam(value ="overTime",required=false) String overTime,
                                             @RequestParam(value ="isPay",required=false) String isPay){
        PageHelper.startPage(page,rows);
        List<Map> list = payMentService.queryOwnerPaymentList(userId,payItemName,beginTime,overTime,isPay);
        PageInfo pageinfo = new PageInfo(list);
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }



    @PostMapping( "/payPayment")
    public int payPayment(PaymentList paymentList){
        return payMentService.updatePaymentListToPay(paymentList);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/addTPPaymentList")
    public int addTPPaymentList(ParkingTPayList parkingTPayList){
        return payMentService.addParkingPaymentList(parkingTPayList);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/getTPPaymentList")
    public PageListJSON getTPPaymentListByPage(int page, int rows,
                                               @RequestParam(value ="licenseNo",required=false) String licenseNo,
                                               @RequestParam(value ="beginTime",required=false) String beginTime,
                                               @RequestParam(value ="overTime",required=false) String overTime){

        PageHelper.startPage(page,rows);
        List<Map> list = payMentService.queryTPPaymentList(licenseNo,beginTime,overTime);
        PageInfo pageinfo = new PageInfo(list);
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/addPiLiangPaymentList")
    public int addPiLiangPaymentList(String payItemId, String charStandard,String charOnce){

        return payMentService.addPiLiangPaymentList(payItemId,charStandard,charOnce);
    }
}
