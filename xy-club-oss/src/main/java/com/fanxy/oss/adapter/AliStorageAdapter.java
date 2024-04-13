package com.fanxy.oss.adapter;

import com.fanxy.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * Description:
 *
 * @Author FanXY
 * @Create 2024/4/13 23:21
 * @Version 1.0
 */
public class AliStorageAdapter implements StorageAdapter{
    @Override
    public void createBucket(String bucketName) {

    }

    @Override
    public void deleteBucket(String bucketName) {

    }

    @Override
    public List<String> getAllBucket() {
        return null;
    }

    @Override
    public List<FileInfo> getAllFile(String bucketName) {
        return null;
    }

    @Override
    public void upLoadFile(MultipartFile uploadFile, String bucketName, String objectName) {

    }

    @Override
    public InputStream downLoad(String bucketName, String objectName) {
        return null;
    }

    @Override
    public void deleteObject(String bucketName, String objectName) {

    }

    @Override
    public String getUrl(String bucketName, String objectName) {
        return null;
    }
}
