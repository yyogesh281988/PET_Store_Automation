package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	
	@DataProvider(name="data")
	public String[][] getAllData()throws Exception
	{
		
		String path=System.getProperty("user.dir")+"//testData/UserData.xlsx";
		
		ExcelUtilities exl=new ExcelUtilities(path);
		
		int rowNum=exl.getRowCount("Sheet1");
		int colCount=exl.getCellCount("Sheet1",1);
		
		String data[][]=new String[rowNum][colCount];
		
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				data[i-1][j]=exl.getCellData("Sheet1", i, j);
			}
		}
		return data;
		
	}

	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws Exception
	{
		String  path=System.getProperty("user.dir")+"//testData/UserData.xlsx";
		ExcelUtilities exl=new ExcelUtilities(path);
		
		int rowNum=exl.getRowCount("Sheet1");
		String data[]=new String[rowNum];
		
		for(int i=1;i<=rowNum;i++)
		{
			data[i-1]=exl.getCellData("Sheet1", i, 1);
		}
		return data;
	}
}
