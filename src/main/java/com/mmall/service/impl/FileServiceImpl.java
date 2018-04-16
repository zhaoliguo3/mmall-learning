package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Donqiuxote
 * @data 2018/4/11 10:00
 */
@Service
public class FileServiceImpl implements IFileService {

    private  Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String upload(MultipartFile file, String path) {
        //获取原始文件名
        String fileName = file.getOriginalFilename();
        //获取扩展名（不带.）
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        //上传的文件名 防止重复
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;

        logger.info("开始上传文件，文件名：{}，上传的路径：{}，新文件名：{}",fileName,path,uploadFileName);

        //如果要上传的路径不存在则赋予可写权限 创建文件夹
        File fileDir = new File(path);
        if (!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, uploadFileName);

        try {
            file.transferTo(targetFile);
            //此时文件已经上传成功

            // 将target文件上传到ftp服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));

            // 上传到ftp成功后删除upload文件夹下的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }

        return targetFile.getName();
    }
}
