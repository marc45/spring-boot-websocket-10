package com.zhaihuilin.controller;

import com.zhaihuilin.config.UploadConfig;
import lombok.extern.log4j.Log4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 上传 下载
 * Created by zhaihuilin on 2018/2/26  15:04.
 */
@RestController
@RequestMapping("/upload")
@Log4j
public class UploadController {

    @Autowired
    private UploadConfig uploadConfig;

    @PostMapping("/uploadImage")
    public JSONObject uploadImage(@RequestParam("file")MultipartFile file ) throws Exception{

        if (file.isEmpty()){
            return  new  JSONObject("上传文件不能为空");
        }

        String fileName= file.getOriginalFilename();//获取文件名

        log.info("获取文件名------------>"+fileName);
        String suffixName= fileName.substring(fileName.lastIndexOf("."));//获取文件后缀名

        log.info("获取文件后缀名------------>"+suffixName);
        String filePath= uploadConfig.FILE_PATH;//获取上传后的路劲

        log.info("获取上传的路劲------------>"+filePath);

        File dest =new File(filePath + fileName);


        if (!dest.getParentFile().exists()){ //检测目录是否存在
             dest.getParentFile().mkdirs();
        }

        try {
             file.transferTo(dest);//上传
             log.info("获取上传后的路劲------------>"+filePath +fileName);
             return new JSONObject("上传成功！");
        }catch (Exception e){
             e.printStackTrace();
        }
        return new JSONObject("上传失败！");
    }

}
