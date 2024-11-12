package easyshop.fileutility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * Author: Libron John
 * Created: 2024 November 8
 * 
 * Description: ExcelUtility class that is used to retrieve the test data from an excel sheet 
 * 
 */

public class ExcelUtility {

	private static ExcelUtility instance = null;
	private static final String FILEPATH = "./src/main/resources/EasyShop_TestData.xlsx";

	private ExcelUtility() {

	}

	public static ExcelUtility getInstance() {

		if (instance == null) {
			synchronized (ExcelUtility.class) {
				if (instance == null)
					instance = new ExcelUtility();
			}
		}
		return instance;
	}

	public int getRowCount(String sheetname) {

		int rowCount = 0;
		
		try (FileInputStream fis = new FileInputStream(FILEPATH)) {
			Workbook workbook = WorkbookFactory.create(fis);
			rowCount = workbook.getSheet(sheetname).getLastRowNum();
			workbook.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return rowCount;
	}

	public String getCellData(String sheetname, int rowNum, int colNum) {

		String data = "";

		try (FileInputStream fis = new FileInputStream(FILEPATH)) {
			Workbook workbook = WorkbookFactory.create(fis);
			Cell cell = workbook.getSheet(sheetname).getRow(rowNum).getCell(colNum);
			data = cell.getStringCellValue();
			workbook.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return data;
	}

}
