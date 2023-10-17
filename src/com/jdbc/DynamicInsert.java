package com.jdbc;



import java.sql.*;
import java.io.*;


public class DynamicInsert 
{

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
	
			String q = "insert into student(id,name,age) values(?,?,?)";
			
			//get PreparedStatement object
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter id ");
			int id = Integer.parseInt(br.readLine());

			
			System.out.println("Enter name: ");
			String name = br.readLine();
			
			System.out.println("Enter age ");
			int age = Integer.parseInt(br.readLine());
			
			
			
			
			//set the value to query 
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, age); 
			
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

