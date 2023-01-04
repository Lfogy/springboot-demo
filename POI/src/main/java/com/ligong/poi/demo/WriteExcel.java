package com.ligong.poi.demo;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet sheet = xssfWorkbook.createSheet("工作表1");

        sheet.createRow(0).createCell(0).setCellValue("hello");
        sheet.createRow(1).createCell(0).setCellValue("world");
        sheet.createRow(2).createCell(0).setCellValue("java");

        FileOutputStream fos = new FileOutputStream("D:\\IdeaCode\\springboot-demo\\POI\\src\\main\\resources\\file\\product.xlsx");

        xssfWorkbook.write(fos);

        fos.close();
        xssfWorkbook.close();

    }
}
