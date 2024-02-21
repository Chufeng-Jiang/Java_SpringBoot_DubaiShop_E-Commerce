package com.dushop.admin;

import com.dushop.admin.AbstractExporter;
import com.dushop.common.entity.Category;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;


/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.category
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-04  17:17
 *@Description: TODO
 *@Version: 1.0
 */

public class CategoryCsvExporter extends AbstractExporter {

    /*
    @Title: Spring MVC with CSV File Download Example
    @Author: Nam Ha Minh
    Available at:https://www.codejava.net/frameworks/spring/spring-mvc-with-csv-file-download-example
     */
    public void export(List<Category> listCategories, HttpServletResponse response)
            throws IOException {
        super.setResponseHeader(response, "text/csv", ".csv", "categories_");

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        String[] csvHeader = {"Category ID", "Category Name"};
        String[] fieldMapping = {"id", "name"};

        csvWriter.writeHeader(csvHeader);

        for (Category category : listCategories) {
            category.setName(category.getName().replace("--", "  "));
            csvWriter.write(category, fieldMapping);
        }

        csvWriter.close();
    }
}
