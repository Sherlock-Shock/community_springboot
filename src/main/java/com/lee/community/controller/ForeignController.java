package com.lee.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.community.dto.PageListJSON;
import com.lee.community.pojo.ForeignPeo;
import com.lee.community.service.ForeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ForeignController {
    @Autowired
    ForeignService foreignService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/getForeignPeople")
    public PageListJSON getForeignPeopleByPage(@RequestParam("page") int page , @RequestParam("rows") int rows, @RequestParam(value ="personName",required=false) String personName){

        PageHelper.startPage(page,rows);
        List<ForeignPeo> list = foreignService.queryForeignPeoByName(personName);
        PageInfo pageinfo = new PageInfo(list);

        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/deleteForeignPeos")
    public int deleteForeignPeoByNo(String[] personNo){
        return foreignService.deleteForeignByNo(personNo);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/addForeignPeo")
    public int addForeignPeo(ForeignPeo foreignPeo){
        return foreignService.addForeignPeo(foreignPeo);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/leaveCommunity")
    public int leaveCommunity(ForeignPeo foreignPeo){
        return foreignService.updateOutTimeByNo(foreignPeo);
    }
}
