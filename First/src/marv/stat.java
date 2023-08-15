package marv;

import java.sql.*;

public class stat {

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("Inside main");
		
		
        String URL = "jdbc:mysql://localhost:3306/swapnil1";
        String username="root";
        String password="root";
        String Query = "Select * from student";

        try{
            Connection connection = DriverManager.getConnection(URL,username,password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(Query);
            System.out.println("Connection successfull.....");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("StudentID")+" "+resultSet.getString("StudentName")+" "+resultSet.getString("StudentAge")+" "+resultSet.getString("StudentCity"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
	}

}
