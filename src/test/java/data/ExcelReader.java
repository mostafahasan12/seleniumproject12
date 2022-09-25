package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
   static FileInputStream fis = null;
   
   public FileInputStream getFileInputStream() 
   {
   
	    String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.xlsx"; 
		File srcFile = new File(filePath);
	    try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test File Data file not found. terminating process !! : check file path of testData");
			System.exit(0);
		}
	    return fis;
   }

   public Object [] [] getExcelData () throws IOException {
	   fis = getFileInputStream();
	   XSSFWorkbook wb = new XSSFWorkbook(fis);
	   XSSFSheet sheet = wb.getSheetAt(0);
	   
	   int TotalNumbersOfRows = (sheet.getLastRowNum()+1);
	   int TotalNumbersOfCols = 4;
	   
	   String [] [] arrayExcelData  = new String [TotalNumbersOfRows] [TotalNumbersOfCols];
	   
	   for (int i = 0; i < TotalNumbersOfRows; i++ ) 
	      {
		   for (int j = 0; j < TotalNumbersOfCols; j++ ) {
			   XSSFRow row = sheet.getRow(i);
			   arrayExcelData [i] [j] = row.getCell(j).toString();			   
		   }                                                      
		   
		  
	        }
	   wb.close();
	return arrayExcelData;
   } }
//  
   


