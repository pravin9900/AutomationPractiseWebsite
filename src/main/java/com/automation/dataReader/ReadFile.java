package com.automation.dataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {
	static XSSFWorkbook wb = new XSSFWorkbook();
	static XSSFSheet sheet = wb.createSheet("Order details");

	public static String readPropertiesFile(String key) {
		String output = null;
		File file = new File(System.getProperty("user.dir") + "/Data Folders/testData.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);
			output = prop.getProperty(key);
			return output;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	public static void writeIntoExcelFile(int rowNum, String orderID, String date) throws IOException {

		XSSFRow row;

		row = sheet.createRow(rowNum);
		Cell cell = row.createCell(0);
		cell.setCellValue(orderID);
		Cell cell1 = row.createCell(1);
		cell1.setCellValue(date);
		FileOutputStream fos = new FileOutputStream("Data Folders//Order.xlsx");
		wb.write(fos);
	}

}
