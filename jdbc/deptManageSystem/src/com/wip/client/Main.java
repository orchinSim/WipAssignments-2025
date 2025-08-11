package com.wip.client;
import java.util.List;
import java.util.Scanner;
import com.wip.client.*;
import com.wip.exception.DepartmentNotFoundException;
import com.wip.service.DeptService;

import com.wip.model.Dept;
public class Main {
	public static void main(String[] args) throws DepartmentNotFoundException {
        DeptService service = new DeptService();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
        	System.out.print( "\n:):(:) Department Management System :):(:)\n" +   "1. Add Department\n" + "2. Get Department by ID\n" +
        		    "3. Get All Departments\n" + "4. Update Department\n" + "5. Delete Department\n" +  "6. Exit\n" + "Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                	System.out.print("Enter Department ID: ");
                    int addId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Department Name: ");
                    String addName = sc.nextLine();
                    System.out.print("Enter Department Email: ");
                    String addEmail = sc.nextLine();
                    System.out.print("Enter Department Location: ");
                    String addLocation = sc.nextLine();

                    Dept newDept = new Dept(addId, addName, addEmail, addLocation);
                    service.addDept(newDept);
                    System.out.println("Department added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Department ID to search: ");
                    int searchId = sc.nextInt();
                    try {
                        Dept found = service.getDeptById(searchId);
                        System.out.println("Department Found: " + found);
                    } catch (DepartmentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    List<Dept> allDepts = service.getAllDepts();
                    System.out.println("All Departments:");
                    for (Dept d : allDepts) {
                        System.out.println(d);
                    }
                    break;

                case 4:
                    System.out.print("Enter Department ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Department Email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("Enter New Location: ");
                    String newLoc = sc.nextLine();

                    Dept updated = new Dept(updateId, newName, newEmail, newLoc);
                    service.updateDept(updated);
                    break;

                case 5:
                    System.out.print("Enter Department ID to delete: ");
                    int deleteId = sc.nextInt();
                    try {
                    	service.deleteDeptById(deleteId);
                    } catch (DepartmentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}


