package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static final long PAGE_LOAD_TIMEOUT = 20;
	public static final long IMPLICIT_WAIT = 10;
	
	public static final String TESTDATA_SHEET_PATH = "C:\\Users\\sai\\Desktop\\workspace\\FreeCRMTest\\src"
													+ "\\main\\java\\com\\crm\\qa\\testdata\\FreeCRM_testdata.xlsx";

	
//	static WorkBook book;
//	static Sheet sheet;
	
	
	public TestUtil() throws IOException {
		super();
	}

	
	public void switchToFrame(){
		
		driver.switchTo().frame("mainpanel");
	}
	
	
//	public static Object[][] getTestData(String sheetName){
//		
//		FileInputStream file= null;
//		
//		try {
//			file = new FileInputStream(TESTDATA_SHEET_PATH);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		return null;
//		
//		
//		
//	}
	

}
