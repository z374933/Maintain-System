package com.zhang.tool;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Upload {
    public String uploadImg(MultipartFile file, String name) {
        //非空检测
        if (file.isEmpty()) return "空文件！";
        String filePath = Constant.IMG_PATH + name + ".jpg";//生成绝对路径
        //删除原来头像
        File oldImg = new File(filePath);
        if (oldImg.exists()) {
            oldImg.delete();
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filePath);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传成功！";
    }
}
