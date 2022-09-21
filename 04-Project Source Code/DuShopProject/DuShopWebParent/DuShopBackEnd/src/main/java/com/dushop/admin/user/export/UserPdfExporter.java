package com.dushop.admin.user.export;

import com.dushop.admin.AbstractExporter;
import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.dushop.admin.AbstractExporter;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.dushop.common.entity.User;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.user
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-07-22  12:56
 *@Description: TODO
 *@Version: 1.0
 */

public class UserPdfExporter extends AbstractExporter {
    /**Adopted from
     @title:How to use getInstance method in com.itextpdf.text.pdf.PdfWriter
     @Author:tabnine.com
     @Reference: https://www.tabnine.com/code/java/methods/com.itextpdf.text.pdf.PdfWriter/getInstance
     **/
    public void export(List<User> listUsers, HttpServletResponse response) throws IOException {
        super.setResponseHeader(response, "application/pdf", ".pdf", "users_");

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(20);
        font.setColor(Color.BLUE);

        Paragraph paragraph = new Paragraph("List of User", font);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setSpacingBefore(10);
        table.setWidths(new float[] {1.2f, 3.5f, 3.0f, 3.0f, 3.0f, 1.7f});

        writeTableHeader(table);
        writeTableData(table, listUsers);

        document.add(table);

        document.close();

    }

    /**Adopted from
     @title:How to use getInstance method in com.itextpdf.text.pdf.PdfWriter
     @Author:tabnine.com
     @Reference: https://www.tabnine.com/code/java/methods/com.itextpdf.text.pdf.PdfWriter/getInstance
     **/

    private void writeTableData(PdfPTable table, List<User> listUsers) {
        for (User user : listUsers) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getEmail());
            table.addCell(user.getFirstName());
            table.addCell(user.getLastName());
            table.addCell(user.getRoles().toString());
            table.addCell(String.valueOf(user.isEnabled()));
        }
    }
    /**
     Adopted from
     @title:How to use getInstance method in com.itextpdf.text.pdf.PdfWriter
     @Author:tabnine.com
     @Reference: https://www.tabnine.com/code/java/methods/com.itextpdf.text.pdf.PdfWriter/getInstance
     **/

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.LIGHT_GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("First Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Last Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Roles ", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Enabled", font));
        table.addCell(cell);
    }

}