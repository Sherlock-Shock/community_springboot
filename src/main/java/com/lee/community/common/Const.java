package com.lee.community.common;

public class Const {

    public static final long EXPIRATION_TIME = 432_000_000;     // 5天(以毫秒ms计)
    //public static final long EXPIRATION_TIME = 10;
    public static final String SECRET = "mycommunity";      // JWT密码
    public static final String TOKEN_PREFIX = "Bearer";         // Token前缀
    public static final String HEADER_STRING = "Authorization"; // 存放Token的Header Key

    public static final String OWNER_UPLOAD_FOLDER = "D:\\tempphoto\\ownerphotos\\";
    public static final String OWNER_PHOTO_URL = "http://localhost:9002/ownerphotos/";

    public static final String USER_UPLOAD_FOLDER = "D:\\tempphoto\\userphotos\\";
    public static final String USER_PHOTO_URL = "http://localhost:9002/userphotos/";

    public static final String POST_PICTURE = "D:\\tempphoto\\postPicture\\";
    public static final String POST_PICTURE_URL = "http://localhost:9002/postPicture/";

    public static final String NOTICE_PICTURE_FOLDER = "D:\\tempphoto\\noticePhoto\\";
    public static final String NOTICE_PICTURE_URL = "http://localhost:9002/noticePhoto/";
}
