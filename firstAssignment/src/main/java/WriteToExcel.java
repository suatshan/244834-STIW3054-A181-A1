import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToExcel {
    public void write() throws IOException {
        String[] columns = {"Tajuk","Maklumat"};

        String excelFile = "Data File.xlsx";
        Scrapper Scrapper=new Scrapper();
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Trivia");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());


        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i <=1; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);

        }

        // Create Other rows and cells with data
        int rowNum = 1;
        for(DataFile DataFile:Scrapper.findAll()) {
            Row row = sheet.createRow(rowNum);

            row.createCell(0)
                    .setCellValue(DataFile.getResult());

            row.createCell(1)
                    .setCellValue(DataFile.getResult2());
            rowNum++;
        }

        // Resize all columns to fit the content size
        for(int i = 0; i <=2; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(excelFile);
        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
}


