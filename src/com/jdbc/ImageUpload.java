package com.jdbc;

import java.sql.*;
import java.io.*;

public class ImageUpload {

	public static void main(String[] args)
	{
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			
			String q = "insert into images(pic) values(?)";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			File imgFile = new File("C:\\Users\\dipak\\OneDrive\\Desktop\\dipak.jpg");
			
			FileInputStream fis = new FileInputStream(imgFile);
			
			//pstmt.setBinaryStream(1,fis,fis.available());
			
			pstmt.setBinaryStream(1, fis,(int)imgFile.length());
			
			pstmt.executeUpdate();
			
			System.out.println("Done...");
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
