//package com.ljb.demo.config;
//
//import org.springframework.boot.web.servlet.MultipartConfigFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.MultipartConfigElement;
//import java.io.File;
//
//@Configuration
//public class MultipartConfig {
//
//    @Bean
//    public MultipartConfigElement createMultipartConfigElement() {
//        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
////        String filePath = System.getProperty("user.dir") + "\\var\\tmp";
////        File file = new File(filePath);
////        if (!file.exists())
////            file.mkdirs();
//        multipartConfigFactory.setLocation("/var/tmp");
////        multipartConfigFactory.setLocation(filePath);
//        return multipartConfigFactory.createMultipartConfig();
//    }
//}
