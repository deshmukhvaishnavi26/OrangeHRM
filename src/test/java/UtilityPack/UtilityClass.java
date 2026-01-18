package UtilityPack;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilityClass {

	public static String getExcelData(int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("D:\\Testing_Workspace\\OrangeHRM\\src\\test\\resources\\ExcelData.xlsx");
		DataFormatter df = new DataFormatter();
		String value = df.formatCellValue(WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell)) ;
		return value;
	}
	
}
