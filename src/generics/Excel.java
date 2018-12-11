package generics;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel 
{
	public static int getRowCount(String path,String sheet)
	{
		int r=0;
		try{
			
			r=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}
	
	public static String getCellValue(String path,String sheet,int r,int c)
	{
		Cell v=null;
		try{
			
			v=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getCell(c);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(v!=null) {
			return v.toString();
		}
		else {
			return null;
		}
	}
}
