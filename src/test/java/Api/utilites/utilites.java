package Api.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utilites {
	
	static String path="./testdata/restassured.xlsx";
	public static String[][] setdata(String  xlname) throws IOException {
	File f=new File(path);
	FileInputStream file=new FileInputStream(f);
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("restassured");
	int row=sheet.getPhysicalNumberOfRows();
	int cell=sheet.getRow(1).getLastCellNum();
	String [][]data=new String[row-1][cell];//two dimesional array
	
	for(int i=0;i<row-1;i++) {
		for(int j=0;j<cell;j++) {
			DataFormatter df=new DataFormatter();
			data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			//sheet.getRow(i).getCell(j).getStringCellValue();
	}		 
	}		
	workbook.close();
	file.close();
	return data;
	

}
}