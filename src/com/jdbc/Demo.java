package com.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            if (con.isClosed())
                System.out.println("Not Connected");
            else
                System.out.println("Connected");

            String q = "SELECT * FROM images WHERE pic = ?";

            int id = 2;

            try {
                PreparedStatement ps = con.prepareStatement(q);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    InputStream input = rs.getBinaryStream("pic");

                    String outputPath = "C:\\Users\\dipak\\OneDrive\\Desktop\\Demo\\sai.jpeg";

                    FileOutputStream outStream = new FileOutputStream(outputPath);

                    byte[] buffer = new byte[4096];

                    int bytesRead;
                    while ((bytesRead = input.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }

                    System.out.println("Image retrieved ");

                    input.close();
                    outStream.close();
                } else {
                    System.out.println("Image with id " + id + " not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

