package com.dushop.admin;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.user
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-07-22  11:44
 *@Description: TODO Export csv, excel(Apache POI)
 *@Version: 1.0
 */

public class AbstractExporter {

    /*
    @Project:  backendVansales
    @Author: street-fighter99
    Reference:https://github.com/street-fighter99/backendVansales/blob/4e45b54114d435a853284b60751ff672a2f094e0/src/main/java/com/ciferz/demo/controller/PDFGenerateController.java
     */
    public void setResponseHeader(HttpServletResponse response, String contentType, String extension, String prefix) throws IOException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String timestamp = dateFormatter.format(new Date());
        String fileName = prefix + timestamp + extension;
        response.setContentType(contentType);

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + fileName;
        response.setHeader(headerKey, headerValue);
    }
}
