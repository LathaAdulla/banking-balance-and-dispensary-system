package com.bank.fin.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bank.fin.model.ClientAccountReportModel;


public class ClientExcelExporter {
			private XSSFWorkbook workbook;
		    private XSSFSheet sheet;
		    private List<ClientAccountReportModel> listClients;
		     
		    public ClientExcelExporter(List<ClientAccountReportModel> listClients) {
		        this.listClients = listClients;
		        workbook = new XSSFWorkbook();
		    }
		 
		 
		    private void writeHeaderLine() {
		        sheet = workbook.createSheet("Users");
		         
		        Row row = sheet.createRow(0);
		         
		        CellStyle style = workbook.createCellStyle();
		        XSSFFont font = workbook.createFont();
		        font.setBold(true);
		        font.setFontHeight(16);
		        style.setFont(font);
		         
		        createCell(row, 0, "Client ID", style);      
		        createCell(row, 1, "Client Surname", style);       
		        createCell(row, 2, "Client Account Number", style);    
		        createCell(row, 3, "Account Description", style);
		        createCell(row, 4, "Display Balance", style);
		    }
		        private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		            sheet.autoSizeColumn(columnCount);
		            Cell cell = row.createCell(columnCount);
		            if (value instanceof Integer) {
		                cell.setCellValue((Integer) value);
		            } else if (value instanceof Boolean) {
		                cell.setCellValue((Boolean) value);
		            }else {
		                cell.setCellValue((String) value);
		            }
		            cell.setCellStyle(style);
		        }
		         
		        private void writeDataLines() {
		            int rowCount = 1;
		     
		            CellStyle style = workbook.createCellStyle();
		            XSSFFont font = workbook.createFont();
		            font.setFontHeight(14);
		            style.setFont(font);
		                     
		            for (ClientAccountReportModel client : listClients) {
		                Row row = sheet.createRow(rowCount++);
		                int columnCount = 0;
		                 
		                createCell(row, columnCount++, client.getClientId(), style);
		                createCell(row, columnCount++, client.getClientSurname(), style);
		                createCell(row, columnCount++, client.getClientAccountNumber(), style);
		                createCell(row, columnCount++, client.getAccountDescription().toString(), style);
		                createCell(row, columnCount++, client.getDisplayBalance().toString(), style);
		                 
		            }
		        }
		         
		        public void export() throws IOException {
		            writeHeaderLine();
		            writeDataLines();
		            
		           String filename = System.getProperty("user.home") + File.separator + "/Desktop" + File.separator + "ClientAccountReport.xlsx";
		           System.out.println("File path"+filename);
		            FileOutputStream out = new FileOutputStream(
		                    new File(filename));
		                 
		                 workbook.write(out);
		                 out.close();	             
		       
		             
		        }

}

