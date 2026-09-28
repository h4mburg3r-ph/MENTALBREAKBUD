package com.example.repov1;

import java.util.Scanner;

// Infraction class
class Infraction {
    String description;
    String date;

    public Infraction(String description, String date) {
        this.description = description;
        this.date = date;
    }
}

// Account class
class Account {
    String studentName;
    int studentID;
    int studentPIN;
    int infractionTotal;
    Infraction[] infractions;

    public Account(String studentName, int studentID, int studentPIN, int capacity) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentPIN = studentPIN;
        this.infractionTotal = 0;
        this.infractions = new Infraction[capacity];
    }

    public void addInfraction(String description, String date) {
        if (infractionTotal < infractions.length) {
            infractions[infractionTotal] = new Infraction(description, date);
            infractionTotal++;
            System.out.println("\n[SUCCESS] Infraction added successfully for " + studentName);
        } else {
            System.out.println("\n[ERROR] Infraction storage is full for this account!");
        }
    }

    public void displayAccountInfo() {
        System.out.println("\n--- Student Account Information ---");
        System.out.println("Name: " + studentName);
        System.out.println("Student ID: " + studentID);
        System.out.println("Total Infractions: " + infractionTotal);

        if (infractionTotal > 0) {
            System.out.println("Infraction Details:");
            for (int i = 0; i < infractionTotal; i++) {
                System.out.println("  - " + infractions[i].date + ": " + infractions[i].description);
            }
        } else {
            System.out.println("No infractions recorded.");
        }
    }
}

// BAGUHIN DITO: Ginawang 'bagdocpeta3' para mag-match sa bagdocpeta3.java
public class bagdocpt3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account studentAccount = new Account("Juan Dela Cruz", 20261001, 1234, 5);

        boolean running = true;
        while (running) {
            System.out.println("\n=== STUDENT INFRACTION SYSTEM ===");
            System.out.println("1. Add Infraction");
            System.out.println("2. Display Account Info");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter infraction description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter date (e.g., September 28, 2026): ");
                    String date = scanner.nextLine();
                    studentAccount.addInfraction(desc, date);
                    break;
                case 2:
                    studentAccount.displayAccountInfo();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting system... Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}