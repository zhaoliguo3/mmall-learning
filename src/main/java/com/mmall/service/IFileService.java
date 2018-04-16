package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Donqiuxote
 * @data 2018/4/11 9:59
 */
public interface IFileService {
    String upload(MultipartFile file,String path);
}
