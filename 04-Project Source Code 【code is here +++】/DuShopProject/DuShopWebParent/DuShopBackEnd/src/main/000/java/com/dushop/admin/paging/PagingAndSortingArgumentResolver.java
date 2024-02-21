package com.dushop.admin.paging;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.paging
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-17  22:14
 *@Description: TODO
 *@Version: 1.0
 */

public class PagingAndSortingArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(PagingAndSortingParam.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer model,
                                  NativeWebRequest request, WebDataBinderFactory binderFactory) throws Exception {
        PagingAndSortingParam annotation = parameter.getParameterAnnotation(PagingAndSortingParam.class);
        String sortDir = request.getParameter("sortDir");
        String sortField = request.getParameter("sortField");
        String keyword = request.getParameter("keyword");

        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", reverseSortDir);
        model.addAttribute("keyword", keyword);
        model.addAttribute("moduleURL", annotation.moduleURL());


        return new PagingAndSortingHelper(model, annotation.listName(),
                sortField, sortDir, keyword);
    }

}
