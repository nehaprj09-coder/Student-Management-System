package com.mycompany.academicapp;

import java.io.*;
import java.net.*;
import java.sql.*;

public class ServerAcademic {

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server Started...");

            Socket s = ss.accept();
            System.out.println("Client Connected");

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            // Receive search input from client
            String search = dis.readUTF();

            // Database connection (use your existing class)
            Connection con = ACDBConnection.getConnection();

            String sql = "SELECT * FROM students WHERE enrollment=? OR name LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, search);
            ps.setString(2, "%" + search + "%");

            ResultSet rs = ps.executeQuery();

            String result = "Student Not Found";

            if (rs.next()) {
                result =
                        "Enrollment: " + rs.getString("enrollment") +
                        ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email") +
                        ", Dept: " + rs.getString("department") +
                        ", Sem: " + rs.getInt("semester");
            }

            // Send result back
            dos.writeUTF(result);

            con.close();
            s.close();
            ss.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}