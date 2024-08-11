package DataBaseIntegrationTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
public class DataBaseTestingClass {
	@Test
	public void datatest() throws SQLException, IOException
	{
	int count=1;		
	String url = "jdbc:mysql://localhost:3306/zaibdb1";
	String user = "root";
	String pass = "810551Aa$";
	Connection con = DriverManager.getConnection(url, user, pass);
	Statement stmt = con.createStatement();
    ResultSet resultSet = stmt.executeQuery("SELECT * FROM data_table");
    ////
    FileInputStream file = new FileInputStream(new File("C:\\Users\\zaibu\\eclipse-workspace\\zaaaza\\DataFiles\\DataBaseTest.xlsx"));
    //FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\DataBaseTest1.xlsx"));
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet = workbook.getSheetAt(0);
    ////
    while (resultSet.next()) 
    {
        String usname = resultSet.getString("User_name"); // Assuming 'id' is a coC:\Users\zaibu\eclipse-workspace\zaaaza\DataFiles\DataBaseTest.xlsxlumn in the database table
        String pass1 = resultSet.getString("password"); // Assuming 'name' is a column in the database tabl
        ////
        String us = sheet.getRow(count).getCell(0).getStringCellValue(); // Assuming ID is in the first column in Excel
        String ps = sheet.getRow(count).getCell(1).getStringCellValue(); // Assuming Name is in the second column in Excel
        //// Comparison and assertion
        if (usname.equals(us) && pass1.equals(ps)) 
        {
         
             System.out.println(usname.equals(us) && pass1.equals(ps)); //print true  here
             
        }                                              
        else
        {
        	 
        	 System.out.println(usname.equals(us) && pass1.equals(ps));//print false
        	 System.out.println(usname+" Compare "+us+" or "+ pass1+" Compare "+ps+" Difference found at row " + count);
        }
          count++; // Move to the next row in Excel
    }
	
	}
}