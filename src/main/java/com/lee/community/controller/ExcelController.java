package com.lee.community.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;

import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.lee.community.pojo.Owner;
import com.lee.community.service.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class ExcelController {
    @Autowired
    OwnerService ownerService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/exportOwnerExcel")
    public void exportOwnerExcel(HttpServletResponse response) throws IOException {
        Owner owner = new Owner();
        List<Owner> list = ownerService.queryOwner(owner);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("业主信息单", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Owner.class)
                .excelType(ExcelTypeEnum.XLSX).sheet("sheet")
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .doWrite(list);
    }
}
