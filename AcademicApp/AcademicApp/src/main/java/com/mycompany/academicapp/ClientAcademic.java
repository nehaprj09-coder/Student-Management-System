package com.mycompany.academicapp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientAcademic {

    public static void main(String[] args) {

        try {
            Socket s = new Socket("localhost", 5000);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Student Name or Enrollment: ");
            String input = sc.nextLine();

            // Send to server
            dos.writeUTF(input);

            // Receive from server
            String response = dis.readUTF();

            System.out.println("Result from Server: " + response);

            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}