package com.Test.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Test.Basetest.BaseTest;

public class ExcelReader extends BaseTest{
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	String path=null;
	
	public ExcelReader(String path){
		this.path=path;
	}
	
	
	public static int  getRowCount(String xlfile,String xlSheet) throws IOException {
		fi=new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
	}
	public static int  getCellCount(String xlfile,String xlSheet,int rownum) throws IOException{
		   
		fi=new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		XSSFRow row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	
	}
	public static String  getCellData(String xlfile,String xlSheet,int rownum,int colnum) throws IOException{
		   
		fi=new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		XSSFRow row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			DataFormatter formater=new DataFormatter();
			String cellData=formater.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e) {
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	public static void  setCellData(String xlfile,String xlSheet,int rownum,int colnum,String data) throws IOException{
	     
		fi=new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
	    row=ws.getRow(rownum);
	    cell=row.createCell(colnum);
	    cell.setCellValue(data);
	    fo=new FileOutputStream(xlfile);
	    wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
		
	}


}
