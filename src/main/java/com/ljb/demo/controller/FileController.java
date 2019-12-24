package com.ljb.demo.controller;

import com.ljb.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    @Value("${file.root-path}")
    private String fileRoot;
    @Value("${file.pictures-path}")
    private String pictureSavePath;
    @Value("${file.uri}")
    private String uri;
    @Value("${server.servlet.context-path}")
    private String projectPath;

    @RequestMapping(value = "/saveImage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(HttpServletRequest request, @RequestParam("file") MultipartFile loadFile) {
        if (null == loadFile)
            throw new RuntimeException("the file cannot null");
        String name = loadFile.getOriginalFilename();

        System.out.println("-------------------aaaaaaaaaaaa----------------" + "   name =" + name);
        String suffixName = name.substring(name.lastIndexOf("."));
        String saveFilePath = fileRoot + pictureSavePath;
        String newFileName = UUID.randomUUID().toString() + suffixName;
        File saveFile = new File(saveFilePath, newFileName);

        if (!saveFile.exists()) {
            try {
                loadFile.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("-------------------aaaaaaaaaaaa-----user.dir1-----------" + System.getProperty("user.dir"));
        System.out.println("-------------------aaaaaaaaaaaa-----user.dir2-----------" + ClassUtils.getDefaultClassLoader().getResource("").getPath());
        try {
            System.out.println("-------------------aaaaaaaaaaaa-----user.dir3-----------" + ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String serverIp = CommonUtils.getServerIp(request);
        System.out.println("-------------------aaaaaaaaaaaa-----serverIp-----------" + serverIp);
        String newPicturePath = serverIp +projectPath+ uri + newFileName;
        System.out.println("-------------------aaaaaaaaaaaa-----newPicturePath-----------" + newPicturePath);

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", newPicturePath);
        return map;
    }

    @PostMapping("/article/img/upload")
    @ResponseBody
    public Map<String, Object> uploadImg(@RequestParam("file") MultipartFile multipartFile) {
        String name = multipartFile.getOriginalFilename();
        System.out.println("-------------------aaaaaaaaaaaa----------------" + "   name =" + name);
        String suffixName = name.substring(name.lastIndexOf("."));
        String saveFilePath = "G://tools//pictures";
        File file = new File(saveFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String newFileName = UUID.randomUUID().toString() + suffixName;
        File saveFile = new File(saveFilePath, newFileName);
        if (!saveFile.exists()) {
            try {
                multipartFile.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", newFileName);
        return map;
    }
}

