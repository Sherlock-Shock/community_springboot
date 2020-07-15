package com.lee.community.controller;

import com.lee.community.common.Const;
import com.lee.community.pojo.Users;
import com.lee.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/updatePassword")
    public int updatePassword(Users users) {
        return userService.updatePassword(users);
    }

    @PostMapping("/uploadUserPhoto")
    public String uploadOwnerPhoto(MultipartFile file) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String filename = auth.getName();

        if (Objects.isNull(file) || file.isEmpty()) {
            return "0";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(Const.USER_UPLOAD_FOLDER + filename+".jpg");
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(Const.OWNER_UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            userService.updatePhotoById(filename);
            return "1";
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/resetOwnerPassword")
    public int resetOwnerPassword(String ownerId){
        return userService.resetOwnerPassword(ownerId);
    }

}
