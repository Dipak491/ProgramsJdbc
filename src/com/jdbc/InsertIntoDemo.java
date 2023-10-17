package com.jdbc;
import java.sql.*;

public class InsertIntoDemo {

	public static void main(String[] args) 
	{
		
		//Dynamic query 
		
		//Create connection 
		
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			
			if(con.isClosed())
				System.out.println("Connection closed");
			else
				System.out.println("Connection Start..");
	
			String q = "insert into student(name,age) values(?,?)";
			
			//get PreparedStatement object
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value to query 
			
			pstmt.setString(1, "Dipak Narkhede");
			pstmt.setInt(2, 24); 
			
			pstmt.executeUpdate();//
			
			System.out.println("Inserted... ");
			
			con.close();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	

	}

}
