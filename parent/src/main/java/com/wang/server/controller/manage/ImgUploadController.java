package com.wang.server.controller.manage;

import com.wang.server.service.QiniuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Auther: wl
 * @Date: 2019/7/3 18:14
 * @Description:
 */
@RestController
@RequestMapping("/panda/manage/img")
public class ImgUploadController {

    @Autowired
    private QiniuService qiniuService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@RequestParam(value="file", required=false) MultipartFile file, HttpServletRequest request) {

        if(file.isEmpty()) {
            return "error";
        }

        try {
            String fileUrl=qiniuService.saveImage(file);
            return "success, imageUrl = " + fileUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
