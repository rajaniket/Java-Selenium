package package1;

import java.io.File;
import java.io.IOException;

import com.google.common.collect.Table.Cell;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelIntegration {
 
		public static void main(String[] args) throws BiffException, IOException 
		
		{
			
			/*
			 Excel

				1. jxl jar files
					
					http://www.java2s.com/Code/Jar/j/Downloadjx126jar.htm
					a zip file will be downloaded extract the file
					add the jar file to project
					right click on project
					build path configure build path libraries class path -> add external jars
					navigate to the extracted folder and add the jar file
					
				2. Create a excel with .xls extension (save file with .xls extension)
			 */
			
			File f = new File ("ExcelFiles\\TestData.xls");
			// create a workbook instance used to hold the workbook
			
			Workbook wb = Workbook.getWorkbook(f);
			// how many sheets are there in file( in excel sheet below you can add multiple page)
			System.out.println("no of sheets are : " + wb.getNumberOfSheets());
			// create a sheet instance
			Sheet sh = wb.getSheet(0); // selecting sheet 0 
			int rows = sh.getRows();
			int col = sh.getColumns();
			System.out.println("Rows: "+rows+"\ncol: "+col);
		
			String[] str = new String[col];
			
			Program3.setUp(); // opening browser and website
			
			for(int r=1; r<rows; r++)  // leaving 0th row as it contains heading name not value
			{
				for(int c=0; c<col; c++)
				{
					jxl.Cell c1 = sh.getCell(c, r);
					str[c] = c1.getContents();   // str0 and str1 will store values when r=1 (str0 is id and str2 is password)
					 
				}
				
				Program3.application12(str); // calling it for every row , will set id and password 
				
			}
			
			
			
	
			
		}
	

}
