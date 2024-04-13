package com.fanxy.oss.util;

import com.fanxy.oss.entity.FileInfo;
import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * Minio文件操作工具
 *
 * @Author FanXY
 * @Create 2024/4/13 2:35
 * @Version 1.0
 */
@Component
public class MinioUtil {

    @Resource
    MinioClient minioClient;

    /**
     * 创建bucket桶
     */
    public void createBucket(String bucketName) throws Exception {
        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!exists) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 删除bucket桶
     */

    public void deleteBucket(String bucketName) throws Exception {
        minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
    }

    /**
     * 列出所有bucket桶
     */
    public List<String> getAllBucket() throws Exception {
        List<Bucket> buckets = minioClient.listBuckets();
        return buckets.stream().map(Bucket::name).collect(Collectors.toList());
    }


    /**
     * 列出当前bucket桶及文件
     */
    public List<FileInfo> getAllFile(String bucketName) throws Exception {
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket(bucketName).build());
        List<FileInfo> fileInfoList = new LinkedList<>();
        for (Result<Item> result : results) {
            FileInfo fileInfo = new FileInfo();
            Item item = result.get();
            fileInfo.setFileName(item.objectName());
            fileInfo.setDirectoryFlag(item.isDir());
            fileInfo.setEtag(item.etag());
            fileInfoList.add(fileInfo);
        }
        return fileInfoList;
    }

    /**
     * 上传文件
     */
    public void upLoadFile(InputStream inputStream, String bucketName, String objectName) throws Exception {
        minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(objectName).
                stream(inputStream, -1, 5242889L).build());
    }
    /**
     * 下载文件
     */
    public InputStream downLoad(String bucketName, String objectName) throws Exception {
        return minioClient.getObject(GetObjectArgs.builder().
                bucket(bucketName).object(objectName).build());
    }

    /**
     * 删除文件
     */
    public void deleteObject(String bucketName, String objectName) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder().
                bucket(bucketName).object(objectName).build());
    }

    /**
     * 获取文件url
     */
    public String getPreviewFileUrl(String bucketName, String objectName) throws Exception {
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder().
                method(Method.GET).bucket(bucketName).object(objectName).build();
        return minioClient.getPresignedObjectUrl(args);
    }
}
