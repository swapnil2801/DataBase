package EmployeData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class EMSystem
{
	public Scanner sobj;
	
	public EMSystem()
	{
		sobj = new Scanner(System.in);
	}
	
	public void finalize()
	{
		sobj.close();
	}
	
	public Connection Connection() throws Exception
	{
		String URL = "jdbc:mysql://localhost:3306/EmployeeManagementSystem";
		String Username = "root";
		String Pass = "root";
		
		Connection cobj= DriverManager.getConnection(URL,Username,Pass);
		return cobj;
	}
	
	public void DisplayAllData() throws Exception
	{
		Statement so = Connection().createStatement();
		ResultSet ro = so.executeQuery("Select * from employee");
		
		if(ro == null)
		{
			System.out.println("The database is empty");
		}
		else
		{
			System.out.println("\nThe Total data of All Employees is : ");
		}
		
		while(ro.next())
		{
			System.out.println("Id : "+ro.getInt("Id")+" , Name : "+ro.getString("Name")+", City : "+ro.getString("City")+" , Age : "+ro.getInt("age")+" , Experience : "+ro.getInt("Experience"));
		}
	}
	
	public void InsertData() throws Exception
	{
	
		Statement so = Connection().createStatement();
		String countQuery = "SELECT COUNT(*) FROM employee" ;
        ResultSet resultSet = so.executeQuery(countQuery);
        
        int iTemp = 0;
        
        if (resultSet.next()) {
            int rowCount = resultSet.getInt(1);
            iTemp = rowCount;
            System.out.println("Number of rows in table: " + rowCount);
        }
		
		System.out.println("Enter the following data of employee: ");
		
		System.out.println("Name : ");					
		String Name = sobj.next();
		
		System.out.println("City : ");
		String City = sobj.next();
		
		System.out.println("Age : ");
		int Age = sobj.nextInt();
		
		System.out.println("Experience : ");
		int Experience = sobj.nextInt();
		
		String InsertQuery = "INSERT INTO employeemanagementsystem.employee (Id,Name,City,Age,Experience) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement psobj = Connection().prepareStatement(InsertQuery);
		
		// Set the parameters for the prepared statement
		psobj.setInt(1, iTemp+1);
		psobj.setString(2, Name);
		psobj.setString(3, City);
		psobj.setInt(4, Age);
		psobj.setInt(5, Experience);
		
		// Execute the update to insert the data into the database
        int rowsInserted = psobj.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Data added successfully!");
        } else {
            System.out.println("Error to add data...");
        }   
	}
	
	public void UpdateData() throws Exception
	{
		System.out.println("Enter the id number of employee whose record you want to edit");
		int j = sobj.nextInt();
		
		System.out.println("What you want edit from below option : ");
		System.out.println("\npress 1 for Name");
		System.out.println("press 2 for City");
		System.out.println("press 3 for Age");
		System.out.println("press 4 for Experience\n");
		
		System.out.print("Enter the option : ");
		int k = sobj.nextInt();
		Connection cobj = Connection();
		
		if(k == 1)
		{
			System.out.print("Enter Name : ");
			String a = sobj.next();
			String UpdateQuery = "UPDATE Employee SET name = ? WHERE id = ?";
			PreparedStatement ps = cobj.prepareStatement(UpdateQuery);
			
			ps.setString(1,a);
			ps.setInt(2,j);
			
			int rowsAffected = ps.executeUpdate();
	        System.out.println(rowsAffected + " row(s) updated successfully.");

		}
		else if(k == 2)
		{
			System.out.print("Enter City : ");
			String a = sobj.next();
			String UpdateQuery = "UPDATE Employee SET City = ? WHERE id = ?";
			PreparedStatement ps = cobj.prepareStatement(UpdateQuery);
			
			ps.setString(1,a);
			ps.setInt(2,j);
			
			int rowsAffected = ps.executeUpdate();
	        System.out.println(rowsAffected + " row(s) updated successfully.");
		}
		else if(k == 3)
		{
			System.out.print("Enter Age : ");
			String a = sobj.next();
			String UpdateQuery = "UPDATE Employee SET Age = ? WHERE id = ?";
			PreparedStatement ps = cobj.prepareStatement(UpdateQuery);
			
			ps.setString(1,a);
			ps.setInt(2,j);
			
			int rowsAffected = ps.executeUpdate();
	        System.out.println(rowsAffected + " row(s) updated successfully.");
		}
		else if(k == 4)
		{
			System.out.print("Enter Experience : ");
			String a = sobj.next();
			String UpdateQuery = "UPDATE Employee SET Experience = ? WHERE id = ?";
			PreparedStatement ps = cobj.prepareStatement(UpdateQuery);
			
			ps.setString(1,a);
			ps.setInt(2,j);
			
			int rowsAffected = ps.executeUpdate();
	        System.out.println(rowsAffected + " row(s) updated successfully.");
		}
		else 
		{
			System.out.println("Enter valid choicw number...");
		}
		
		String UpdateQuery = "UPDATE Employee SET name = ? WHERE id = ?";
		PreparedStatement ps = cobj.prepareStatement(UpdateQuery);
		
	}
	
	public void DeleteData() throws Exception
	{
		System.out.println("Enter the id number whoes record you want to delete : ");
		int no = sobj.nextInt();
		Statement so = Connection().createStatement();
		so.executeUpdate("delete from Employee where id = "+no);
		System.out.println("Data delete succesfully...");
	}
	
}

public class Employee 
{

	public static void main(String[] args) throws Exception
	{
		System.out.println("Welcome To The Employee Management System Aplication....");
		
		
		EMSystem eobj = new EMSystem();
		eobj.Connection();
		Scanner sobj = new Scanner(System.in);
		while(true)
		{
			System.out.println("\n*****Options*****");
			System.out.println("\nPress 1 to read all data : ");
			System.out.println("press 2 to enter new record : ");
			System.out.println("press 3 to edit cureent record(By using primary key");
			System.out.println("press 4 to delete record : ");
			System.out.println("Press 5 to exit from application : \n");

			
			
			int Choice = sobj.nextInt();
			
			if(Choice == 5)
			{
				System.out.println("***Thanks for using Application***");
				break;
			}
			
			switch(Choice)
			{
				case 1:
					
					eobj.DisplayAllData();
					break;
				case 2:					
					
					eobj.InsertData();
					break;
					
				case 3:
					eobj.UpdateData();
					break;
				case 4:
					eobj.DeleteData();
					break;
					
				default:
					System.out.println("Please enter valid choice number...");
					break;
			}
		}
			sobj.close();
	}
}