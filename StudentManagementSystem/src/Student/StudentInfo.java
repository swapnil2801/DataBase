package Student;

import java.util.*;
import java.sql.*;

public class StudentInfo 
{

	public static void main(String[] args) throws Exception
	{
		System.out.println("Inside main");
		
		String URL = "jdbc:mysql://localhost:3306/StudentManagementSystem";
		String Pass = "root";
		String Username = "root";
		
		Connection connection = DriverManager.getConnection(URL,Username,Pass);
		Statement statement = connection.createStatement();
		ResultSet robj = statement.executeQuery("Select * from StudentInfo");
		
		while(robj.next())
		{
			System.out.println(robj.getInt("RollNo")+" "+robj.getString("Name")+" "+robj.getString("Grade")+" "+robj.getString("City"));
		}
	}

}


