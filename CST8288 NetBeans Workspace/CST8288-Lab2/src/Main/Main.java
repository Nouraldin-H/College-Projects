/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
Student Name: Nouraldin Hassan
Student Number: 041054019
Course & Section #: 22S_CST8288_010/011
Declaration:
This is my own original work and is free from Plagiarism.
*/
package Main;

import java.util.Scanner;
import pkgDBManager.DatabaseManager;

/**
 * This class has the main method for running SQL statements
 * @author Nouraldin Hassan
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of the DatabaseManager class
        DatabaseManager dbManager = new DatabaseManager();

        // Display the contents of the Recipients table
        System.out.println("Initial Recipients Table:");
        dbManager.displayNeatRecipientsTable(); // Remove "Neat" from displayNeatRecipientsTable to see line-by-line output
        System.out.println();
// ************************************************************
        // Insert a new recipient into the table
        dbManager.insertRecipient("John Doe", 2023, "Exampleville", "Arts");

        // Display the updated Recipients table
        System.out.println("Updated Recipients Table:");
        dbManager.displayNeatRecipientsTable(); // Remove "Neat" from displayNeatRecipientsTable to see line-by-line output
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to remove the entry for the matching AwardID");
        int input = sc.nextInt();
        // Delete the newly inserted recipient
        dbManager.deleteRecipient(input); // Change the recipientId as needed

        // Display the table after deletion
        System.out.println("Recipients Table After Deletion:");
        dbManager.displayNeatRecipientsTable(); // Remove "Neat" from displayNeatRecipientsTable to see line-by-line output
// ************************************************************
        // Close the database connection
        dbManager.close();
    }
}
