package com.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetriveImg {

	public static void main(String[] args) 
	{
		
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			
			String q = "select from images where id=6";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			
			if(rs.next())
			{
				InputStream inputStream = rs.getBinaryStream("pic");
				String outputPath  = "C:\\Users\\dipak\\OneDrive\\Desktop\\Retrive.jpg";
				FileOutputStream outputStream =  new FileOutputStream(outputPath);
				
				byte[] buffer = new byte[4096];
				int bytesRead;
				
				while((bytesRead = inputStream.read(buffer)) != -1)
				{
					outputStream.write(buffer,0,bytesRead);
	
				}
				
				System.out.println("Image retrived saved to "+outputPath);
			}
			else
			{
				System.out.println("Image not found");
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
