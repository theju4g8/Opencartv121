package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
//DataProvider 1
	@DataProvider(name="Logindata")
	public String [][] getData() throws IOException{
		String path =".\\testdata\\Opencart_Logindata.xlsx";//taking xl file from testdata folder
		ExcelUtility xlutil = new ExcelUtility(path);//creating an object for excel utility
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		String logindata[][] = new String [totalrows][totalcols];//created for 2D array
		for(int i=1;i<=totalrows;i++)//1 read data from xl storing in 2D array
		{
			for(int j=0;j<totalcols;j++)//0 i is row j is col
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);//1,0
			}
		}
		return logindata;//returning 2D array
	}
}
