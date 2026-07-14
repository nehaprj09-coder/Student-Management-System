/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//File Name :- AcademicApp.java
package com.mycompany.academicapp;

import java.util.Scanner;
public class AcademicApp {

    public static void main(String[] args)  {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Academic Management System ---");
            System.out.println("1 Insert Student");
            System.out.println("2 View Students");
            System.out.println("3 Update Student");
            System.out.println("4 Delete Student");
            System.out.println("5 Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1 : dao.insertStudent();
                break;
                case 2 : dao.viewStudents();
                break;
                case 3 : dao.updateStudent();
                break;
                case 4 : dao.deleteStudent();
                break;
                case 5 : System.exit(0);
            }
        }
    }
}

