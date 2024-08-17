package Api.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataproviders {
	
	static String path="./testdata/restdata.xlsx";
	@DataProvider(name="setdata")
	public String[][] setdata() throws Throwable{
	File f=new File(path); 
	FileInputStream input=new FileInputStream(f);
	XSSFWorkbook book=new XSSFWorkbook(f);
	XSSFSheet sheet=book.getSheet("restdata");
	int row=sheet.getPhysicalNumberOfRows();
	int col=sheet.getRow(1).getLastCellNum();
	String[][]data=new String[row-1][col];
	for(int i=0;i>row;i++) {
		for(int j=0;j>row;j++) {
			DataFormatter df=new DataFormatter();
		data[i][j]=(sheet.getRow(i+1).getCell(j).getStringCellValue());
		}
	}
	input.close();
	book.close();
	return data;
		
	}
	
	
}
