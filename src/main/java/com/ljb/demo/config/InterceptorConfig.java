package com.ljb.demo.config;

import com.ljb.demo.interceptor.CommonInterceptor;
import com.ljb.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    CommonInterceptor commonInterceptor;

    @Value("${file.root-path}")
    private String rootPath;
    @Value("${file.pictures-path}")
    private String imageSavePath;
    @Value("${file.picture-resource-mapping}")
    private String mappingResourcePath;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (CommonUtils.isStringEmpty(rootPath) || CommonUtils.isStringEmpty(imageSavePath)) return;

        //其中mappingResourcePath表示访问的前缀。"file:"+ rootPath + imageSavePath是文件真实的存储路径
        registry.addResourceHandler(mappingResourcePath).addResourceLocations("file:" + rootPath + imageSavePath);
    }
}
