package com.dushop;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.nio.file.Path;
import java.nio.file.Paths;


/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-12  20:11
 *@Description: TODO
 *@Version: 1.0
 */


@Configuration
public class MvcConfig implements WebMvcConfigurer {
    /*Adapted from Admin Application*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("../category-images", registry);
        exposeDirectory("../brand-logos", registry);
        exposeDirectory("../product-images", registry);
        exposeDirectory("../site-logo", registry);

    }
    /*Adapted from Admin Application*/
    private void exposeDirectory(String pathPattern, ResourceHandlerRegistry registry) {
        Path path = Paths.get(pathPattern);
        String absolutePath = path.toFile().getAbsolutePath();

        String logicalPath = pathPattern.replace("../", "") + "/**";

        registry.addResourceHandler(logicalPath)
                .addResourceLocations("file:/" + absolutePath + "/");
    }

}