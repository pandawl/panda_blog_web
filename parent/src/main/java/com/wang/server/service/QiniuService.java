package com.wang.server.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Auther: wl
 * @Date: 2019/7/3 17:59
 * @Description:
 */
public interface QiniuService {

    String saveImage(MultipartFile file) throws IOException;
}
