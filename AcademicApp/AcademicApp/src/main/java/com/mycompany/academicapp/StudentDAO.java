/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//File Name :- StudentDAO.java
package com.mycompany.academicapp;

import java.sql.*;
import java.util.Scanner;

public class StudentDAO {

    Scanner sc = new Scanner(System.in);

    public void insertStudent() {
        try (Connection con = ACDBConnection.getConnection()) {

            System.out.print("Enter Enrollment: ");
            String enrollment = sc.next();

            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine(); 

            System.out.print("Enter Email: ");
            String email = sc.next();

            System.out.print("Enter Department: ");
            String dept = sc.next();

            System.out.print("Enter Semester: ");
            int sem = sc.nextInt();

            String sql = "INSERT INTO students (enrollment,name,email,department,semester) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, enrollment);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, dept);
            ps.setInt(5, sem);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Added Successfully");
            else
                System.out.println("Insert Failed");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void viewStudents() {
        try (Connection con = ACDBConnection.getConnection()) {

            String sql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("%-15s %-20s %-30s %-12s %-5s\n",
                    "ENROLL", "NAME", "EMAIL", "DEPT", "SEM");
            System.out.println("-----------------------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-15s %-20s %-30s %-12s %-5d\n",
                        rs.getString("enrollment"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department"),
                        rs.getInt("semester")
                );
            }

            System.out.println("-----------------------------------------------------------------------------------------------");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateStudent() {
        try (Connection con = ACDBConnection.getConnection()) {

            System.out.print("Enter Enrollment: ");
            String enrollment = sc.next();

            sc.nextLine(); 

            System.out.print("Enter New Name: ");
            String name = sc.nextLine(); 

            String sql = "UPDATE students SET name=? WHERE enrollment=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, enrollment);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Updated");
            else
                System.out.println("Student Not Found");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteStudent() {
        try (Connection con = ACDBConnection.getConnection()) {

            System.out.print("Enter Enrollment: ");
            String enrollment = sc.next();

            String sql = "DELETE FROM students WHERE enrollment=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, enrollment);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Deleted");
            else
                System.out.println("Student Not Found");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}