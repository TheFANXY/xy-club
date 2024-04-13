package com.fanxy.oss.adapter;

import com.fanxy.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * Description:
 *
 * @Author FanXY
 * @Create 2024/4/13 23:10
 * @Version 1.0
 */
public interface StorageAdapter {
    /**
     * 创建bucket桶
     */
    void createBucket(String bucketName);

    /**
     * 删除bucket桶
     */

    void deleteBucket(String bucketName);

    /**
     * 列出所有bucket桶
     */
    List<String> getAllBucket();


    /**
     * 列出当前bucket桶及文件
     */
    List<FileInfo> getAllFile(String bucketName);

    /**
     * 上传文件
     */
    void upLoadFile(MultipartFile uploadFile, String bucketName, String objectName);
    /**
     * 下载文件
     */
    InputStream downLoad(String bucketName, String objectName);

    /**
     * 删除文件
     */
    void deleteObject(String bucketName, String objectName);

    /**
     * 获取文件url
     */
    String getUrl(String bucketName, String objectName);
}
