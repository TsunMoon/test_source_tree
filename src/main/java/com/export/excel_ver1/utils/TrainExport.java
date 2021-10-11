package com.export.excel_ver1.utils;

import com.export.excel_ver1.model.Users;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TrainExport {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Users> users;

    public TrainExport(List<Users> users) {
        this.users = users;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine(){
        sheet = workbook.createSheet("Test_create");

        Row row =  sheet.createRow(0);

        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(18);
        CellStyle style = workbook.createCellStyle();
        style.setFont(font);

        createCell(row,0,"User ID", style);
        createCell(row,0,"Email", style);
        createCell(row,0,"Full Name", style);
        createCell(row,0,"Enaable", style);
        createCell(row,0,"Role ID", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if(value instanceof Integer){
            cell.setCellValue((Integer) value);
        }else if(value instanceof Boolean){
            cell.setCellValue((Boolean) value);
        }else{
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLine(){
        int rowCount = 1;

        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);

        CellStyle style = workbook.createCellStyle();
        style.setFont(font);

        for(Users user : users){
            int columnCount = 0;
            Row row = sheet.createRow(rowCount++);

            createCell(row, columnCount++, user.getId(), style);
            createCell(row, columnCount++, user.getEmail(), style);
            createCell(row, columnCount++, user.getFullname(), style);
            createCell(row, columnCount++, user.isEnabled(), style);
            createCell(row, columnCount++, user.getRoleId(), style);
        }
    }


    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLine();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        System.out.println("Thêm lần 1");
        System.out.println("Suni nè bạn");
        System.out.println("Thanh nè");
        outputStream.close();

        System.out.println("A2");
    }

    public void test(){
        System.out.println("Feature A");
    }





}
