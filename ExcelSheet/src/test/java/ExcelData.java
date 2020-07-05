import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelData 
{

	XSSFWorkbook wb;
	XSSFSheet sheet;
	String data;
	public ExcelData(String excelpath)
	{
		
		try {
			File src=new File(excelpath);
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} 
		 catch (Exception e) 
		{
			
			System.out.println(e.getMessage());
		}
		
	}
	public String getData(int sheetNumber, int row, int column)
	{
		sheet=wb.getSheetAt(sheetNumber);
		XSSFCell cell=sheet.getRow(row).getCell(column);
		if(cell.getCellType()==Cell.CELL_TYPE_STRING) 
		    data = cell.getStringCellValue(); 
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC) 
		    data = String.valueOf(cell.getNumericCellValue());
		return data;	
		
	}
	
	public int getRowCount(int sheetIndex)
	{
		
			int row=wb.getSheetAt(sheetIndex).getLastRowNum();
			row=row+1;
			return row;
	}
	
	
	
}
