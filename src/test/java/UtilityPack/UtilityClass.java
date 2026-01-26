package UtilityPack;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {

	public static String getExcelData(int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("D:\\Testing_Workspace\\OrangeHRM\\src\\test\\resources\\ExcelData.xlsx");
		DataFormatter df = new DataFormatter();
		String value = df.formatCellValue(WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell)) ;
		return value;
	}
	
	public static WebDriverWait wait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}
	
}
