package com.dushop.admin;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.util.List;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-07-13  13:11
 *@Description: TODO
 *@Version: 1.0
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("user-photos", registry);
        exposeDirectory("../category-images", registry);
        exposeDirectory("../brand-logos", registry);
        exposeDirectory("../product-images", registry);
        exposeDirectory("../site-logo", registry);
    }

    private void exposeDirectory(String pathPattern, ResourceHandlerRegistry registry) {
        Path path = Paths.get(pathPattern);
        String absolutePath = path.toFile().getAbsolutePath();

        String logicalPath = pathPattern.replace("../", "") + "/**";

        registry.addResourceHandler(logicalPath)
                .addResourceLocations("file:/" + absolutePath + "/");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new PagingAndSortingArgumentResolver());
    }

}

        /*//User Photos
        String dirName = "user-photos";
        Path userPhotosDir = Paths.get(dirName);

        String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + userPhotosPath + "/");

        //Category Photos
        String categoryImagesDirName = "../category-images";
        Path categoryImagesDir = Paths.get(categoryImagesDirName);

        String categoryImagesPath = categoryImagesDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/category-images/**")
                .addResourceLocations("file:/" + categoryImagesPath + "/");

        //Brand Photos
        String brandLogosDirName = "../brand-logos";
        Path brandLogosDir = Paths.get(brandLogosDirName);

        String brandLogosPath = brandLogosDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/brand-logos/**")
                .addResourceLocations("file:/" + brandLogosPath + "/");*/