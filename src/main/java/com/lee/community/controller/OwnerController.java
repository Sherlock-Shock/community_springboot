package com.lee.community.controller;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.community.common.Const;
import com.lee.community.dto.PageListJSON;
import com.lee.community.dto.ResultJSON;
import com.lee.community.pojo.Owner;
import com.lee.community.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@RestController
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping( value = "/getOwner", method = RequestMethod.POST )
    public PageListJSON getOwnerByPage(int page , int rows, Owner owner){
        PageHelper.startPage(page,rows);
        List<Owner> list = ownerService.queryOwner(owner);
        PageInfo pageinfo = new PageInfo(list);
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/getOwnerById")
    public Owner getOwnerById(String ownerId){
        Owner owner = ownerService.queryOwnerById(ownerId);
        owner.setPhoto(Const.OWNER_PHOTO_URL+owner.getPhoto());
        return owner;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/addOwner")
    public int addOwner(Owner owner){
        return ownerService.addOwner(owner);
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/updateOwner")
    public int updateOwner(Owner owner){
        return ownerService.updateOwnerById(owner);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/getOwnerTotal")
    public int getOwnerTotal(){
        return ownerService.queryOwnerTotal();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/deleteOwners")
    public int deleteOwners(String[] ownerId){
        return ownerService.deleteOwners(ownerId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/uploadOwnerPhoto")
    public String uploadOwnerPhoto(MultipartFile file) {
        //String UPLOAD_FOLDER = "D:\\tempphoto\\";
        if (Objects.isNull(file) || file.isEmpty()) {
            return "0";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(Const.OWNER_UPLOAD_FOLDER + file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(Const.OWNER_UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            String filename = file.getOriginalFilename();
            ownerService.updatePhotoById(filename.substring(0,filename.lastIndexOf(".")));
            return "1";
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }

    @PostMapping("/getOwnerIdByPhone")
    public ResultJSON getOwnerIdByPhone(String phone){
        return new ResultJSON("200","",ownerService.queryOwnerIdByPhone(phone));
    }

    @PostMapping("/getOwnerMsgByPhone")
    public ResultJSON getOwnerByPhone(String phone){
        return new ResultJSON("200","",ownerService.queryOwnerMessageByPhone(phone));
    }

    @PostMapping("/getOwnerAllHouse")
    public ResultJSON getOwnerAllHouse(String ownerId){
        return new ResultJSON("200","",ownerService.queryOwnerAllHouse(ownerId));
    }
    @PostMapping("/getOwnerAllParking")
    public ResultJSON getOwnerAllParking(String ownerId){
        return new ResultJSON("200","",ownerService.queryOwnerAllParking(ownerId));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/dropHouse")
    public int dropHouse(String houseId){
        return ownerService.dropHouseById(houseId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/dropParking")
    public int dropParking(String parkId){
        return ownerService.dropParkingById(parkId);
    }



}
