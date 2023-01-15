package Utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Base.TestBase;

public class ReadData extends TestBase{
	
	public static String readPropertyFile(String value) throws Exception  {
		
		FileInputStream file = new FileInputStream("./TestData/config.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(value);
	}
	
	public static String readExcelFile(int row, int col, String sheetName) throws Exception {
		FileInputStream file = new FileInputStream("./TestData/Data.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet(sheetName);
		String value = excel.getRow(row).getCell(col).getStringCellValue();
		return value;
	}
	
	
	
}
