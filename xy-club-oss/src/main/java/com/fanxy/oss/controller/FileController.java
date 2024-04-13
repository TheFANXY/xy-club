package com.fanxy.oss.controller;

import com.fanxy.oss.entity.Result;
import com.fanxy.oss.service.FileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @Author FanXY
 * @Create 2024/4/13 17:56
 * @Version 1.0
 */
@RestController
public class FileController {

    @Resource
    FileService fileService;

    /**
     * 测试能否正常工作
     */
    @RequestMapping("/testGetAllBuckets")
    public String testGetAllBuckets() throws Exception {
        List<String> allBucket = fileService.getAllBucket();
        return allBucket.get(0);
    }

    /**
     * 获取文件的url
     */
    @RequestMapping("/getUrl")
    public String getUrl(String bucketName, String objectName) throws Exception {
        return fileService.getUrl(bucketName, objectName);
    }

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile uploadFile, String bucketName, String objectName) throws Exception {
        String url = fileService.uploadFile(uploadFile, bucketName, objectName);
        return Result.ok(url);
    }
}