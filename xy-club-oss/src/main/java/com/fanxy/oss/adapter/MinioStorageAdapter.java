package com.fanxy.oss.adapter;

import com.fanxy.oss.entity.FileInfo;
import com.fanxy.oss.util.MinioUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

/**
 * Description:
 *
 * @Author FanXY
 * @Create 2024/4/13 23:19
 * @Version 1.0
 */
public class MinioStorageAdapter implements StorageAdapter{
    @Resource
    private MinioUtil minioUtil;

    @Value("${minio.url}}")
    private String url;

    @Override
    @SneakyThrows
    public void createBucket(String bucketName) {
        minioUtil.createBucket(bucketName);
    }

    @Override
    @SneakyThrows
    public void deleteBucket(String bucketName) {
        minioUtil.deleteBucket(bucketName);
    }

    @Override
    @SneakyThrows
    public List<String> getAllBucket() {
        return minioUtil.getAllBucket();
    }

    @Override
    @SneakyThrows
    public List<FileInfo> getAllFile(String bucketName) {
        return minioUtil.getAllFile(bucketName);
    }

    @Override
    @SneakyThrows
    public void upLoadFile(MultipartFile uploadFile, String bucketName, String objectName) {
        minioUtil.createBucket(bucketName);
        if (objectName != null) {
            minioUtil.upLoadFile(uploadFile.getInputStream(), bucketName, objectName);
        } else {
            minioUtil.upLoadFile(uploadFile.getInputStream(), bucketName, uploadFile.getOriginalFilename());
        }
    }

    @Override
    @SneakyThrows
    public InputStream downLoad(String bucketName, String objectName) {
        return minioUtil.downLoad(bucketName, objectName);
    }

    @Override
    @SneakyThrows
    public void deleteObject(String bucketName, String objectName) {
        minioUtil.deleteObject(bucketName, objectName);
    }

    @Override
    @SneakyThrows
    public String getUrl(String bucketName, String objectName) {
        return minioUtil.getPreviewFileUrl(bucketName, objectName);
    }
}