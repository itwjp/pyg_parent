package com.pinyougou.shop.controller;

import com.pinyougou.entity.Result;
import com.pinyougou.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: UploadController
 * @author: itXiaoKe
 * @date: 2020/2/26 13:44
 * @Description: no description
 * @Version: 1.0
 */
@RestController
@RequestMapping("/file")
public class UploadController {

    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL; // 文件服务器地址

    private static final String TRACKER_URL = "classpath:config/fdfs_client.conf";

    @RequestMapping("/upload")
    public Result upload(MultipartFile file) {
        // 图片全名
        String originalFilename = file.getOriginalFilename();
        // 后缀名
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            FastDFSClient fastDFSClient = new FastDFSClient(TRACKER_URL);
            String path = fastDFSClient.uploadFile(file.getBytes(), suffixName);
            String url = FILE_SERVER_URL + path;
            return new Result(true, url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }
}
