/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



//File Name :- ACDBConnection.java
package com.mycompany.academicapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ACDBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/academicdb";
            String user = "root";
            String pass = "drashti@2005";

            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Database Connected");

        } catch (SQLException |ClassNotFoundException e) {
            System.out.println("Connection Failed");
        }

        return con;
    }
}