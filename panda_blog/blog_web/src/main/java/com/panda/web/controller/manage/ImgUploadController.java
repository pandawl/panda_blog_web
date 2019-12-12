package com.panda.web.controller.manage;


import com.panda.common.util.ResultCode;
import com.panda.common.util.ResultUtils;
import com.panda.service.QiniuService;
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
    public String uploadImage(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            return ResultUtils.generateResultStr(ResultCode.PARAM_ERROR, "图片不能为空", 0);

        }

        try {
            String fileUrl = qiniuService.saveImage(file);
            return ResultUtils.generateResultStr(ResultCode.SUCCESS, "新增成功", fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultUtils.generateResultStr(ResultCode.DATA_ERROR, "图片保存异常", 0);
    }
}
