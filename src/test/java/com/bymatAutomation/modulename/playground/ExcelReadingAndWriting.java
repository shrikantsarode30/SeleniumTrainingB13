package com.bymatAutomation.modulename.playground;

import com.bymatautomation.seleniumtraining.ExcelReader;

public class ExcelReadingAndWriting {

	public static void main(String[] args) {
		
		ExcelReader excel = new ExcelReader("F:\\EclipseProgramWorkspace\\Java2022_09\\SeleniumTrainingB13_MVN\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		
		//F:\EclipseProgramWorkspace\Java2022_09\SeleniumTrainingB13_MVN\src\test\resources\testData\Master_Sheet.xlsx
		
		//excel.addSheet("NewSheet");
		//excel.addColumn("NewSheet", "Name");
		System.out.println(excel.getCellData("Test_Cases","TestCaseName",5));
		System.out.println(excel.getRowCount("Test_Cases"));
		System.out.println(excel.getCellData("Test_data", 3, 5));
		System.out.println(excel.getCellData("Test_data", 3, 9));
	}
}
