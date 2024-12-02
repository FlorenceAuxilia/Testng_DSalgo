package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="Pythoncode")
	public String[][] getData() throws InterruptedException, IOException
	{
		String path=".\\testData\\Python.xlsx";//taking Excel file from testData folder ----.\\ represents System.getProperty("user.dir")
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Python");
		int totalcol=xlutil.getCellCount("Python", 1);
		String code[][]=new String[totalrows][totalcol];//creating 2D array of string
		for(int i=1;i<=totalrows;i++) //row data starts at 1
		{
			for(int j=0;j<totalcol;j++) //column starts at 0
			{
				code[i-1][j]=xlutil.getCellData("Python", i, j); // storing array starts at logindata(0,0)
				System.out.println(code[i-1][j]);
			}
		}
		return code;//return 2D array
	}
	

	@DataProvider(name="loginCredentials")
	public String[][] getloginData() throws InterruptedException, IOException
	{
		String path=".\\testData\\Python.xlsx";//taking Excel file from testData folder ----.\\ represents System.getProperty("user.dir")
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Login");
		int totalcol=xlutil.getCellCount("Login", 1);
		System.out.println("Row Count =" +totalrows  + "Column count =" + totalcol  );
		String LoginData[][]=new String[totalrows][totalcol];//creating 2D array of string
		for(int i=1;i<=totalrows;i++) //row data starts at 1
		{
			for(int j=0;j<totalcol;j++) //column starts at 0
			{
				LoginData[i-1][j]=xlutil.getCellData("Credentials", i, j); // storing array starts at logindata(0,0)
				System.out.println(LoginData[i-1][j]);
			}
		}
		return LoginData;//return 2D array of login data's
	}
	
	@DataProvider(name="ArrayPythoncode")
	public String[][] getArrayData() throws InterruptedException, IOException
	{
		String path=".\\testData\\NewPython.xlsx";//taking Excel file from testData folder ----.\\ represents System.getProperty("user.dir")
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("ArrayPython");
		int totalcol=xlutil.getCellCount("ArrayPython", 1);
		String code[][]=new String[totalrows][totalcol];//creating 2D array of string
		for(int i=1;i<=totalrows;i++) //row data starts at 1
		{
			for(int j=0;j<totalcol;j++) //column starts at 0
			{
				code[i-1][j]=xlutil.getCellData("ArrayPython", i, j); // storing array starts at logindata(0,0)
				System.out.println(code[i-1][j]);
			}
		}
		return code;//return 2D array of login data's
	}
	@DataProvider(name="RegisterPythoncode")
	public String[][] getRegisterData() throws InterruptedException, IOException
	{
		String path=".\\testData\\NewPython.xlsx";//taking Excel file from testData folder ----.\\ represents System.getProperty("user.dir")
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Registration");
		int totalcol=xlutil.getCellCount("Registration", 1);
		String code[][]=new String[totalrows][totalcol];//creating 2D array of string
		for(int i=1;i<=totalrows;i++) //row data starts at 1
		{
			for(int j=0;j<totalcol;j++) //column starts at 0
			{
				code[i-1][j]=xlutil.getCellData("Registration", i, j); // storing array starts at logindata(0,0)
				System.out.println(code[i-1][j]);
			}
		}
		return code;//return 2D array of login data's
	}
	@DataProvider(name = "Queuetypes")
	public Object[] QueueTypes() {
		String[] Queuetypes = { "Implementation of Queue in Python", "Implementation using collections.deque",
				"Implementation using array", "Queue Operations" };
		return Queuetypes;
	}
	
	@DataProvider(name = "Treetypes")
	public String[] Treetypes() {
		String[] Treetypes = { 	"Overview of Trees","Terminologies","Types of Trees","Tree Traversals",
								"Traversals-Illustration","Binary Trees","Types of Binary Trees",
								"Implementation in Python" ,"Binary Tree Traversals","Implementation of Binary Trees",
								"Applications of Binary trees","Binary Search Trees","Implementation Of BST"};
	
		return Treetypes;
	}
	
	@DataProvider(name = "Graphtypes")
	public String[] GraphTypes() {
		String[] Graphtypes = { "Graph","Graph Representations" };
		return Graphtypes;
	}
	
}
