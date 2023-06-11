package com.hackq.com;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class XcelFunctions {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path = null;

	
	public XcelFunctions(String path) throws IOException {
		this.path = path;
	}
	
	public void writeData(String sheetname,int rownum,int colmnum,String [][] data) throws IOException
	{
	
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		
		
		for(int r = 1; r <= rownum; r++)
		{
			row = sheet.createRow(r);
			
			for(int c = 0; c < colmnum; c++)
			{
				cell = row.createCell(c);
				cell.setCellValue(data[r-1][c]);
			}
		}
		
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		System.out.println("Data inserted in Excel file.");	
	}		
}
