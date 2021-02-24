package com.ideas2it.employee.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.ideas2it.employee.controller.EmployeeController;
/**
 * Contains method to get details to create new employee
 * and passes on params for controller.
 * @author Shalini
 * created at 22.02.2021
 */
public class EmployeeView {
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    EmployeeController employeeController = new EmployeeController();
    /**
     * Gets input details to update from
     * the user as updated name , designation , email ,
     * phone and salary .
     */
    public void createEmployee() throws IOException {
        System.out.println("Enter Full name ");
        String fullName = bufferedReader.readLine();
        System.out.println("Enter Designation");
        String designation =  bufferedReader.readLine();
        System.out.println("Enter Email id ");
        String email =  bufferedReader.readLine();
        System.out.println("Enter Phone Number");
        long phone =  Long.parseLong(bufferedReader.readLine());
        System.out.println("Enter Salary");
        long salary = Long.parseLong(bufferedReader.readLine());
        if(employeeController.createEmployee(fullName, designation, email, phone, salary )) {
            System.out.println("Successfully created !!!");
        } else {
            System.out.println("Unsuccessful!!");
        }
    }


    /**
     * Gets EmployeeId from the user.
     * @return user entered employeeId.
     */
    private int getEmployeeId() throws IOException {
        System.out.println("Enter your Employee Id : ");
        int employeeId = Integer.parseInt(bufferedReader.readLine());
        return employeeId;
    }

    /**
     * Gets and prints details as  name , designation , email ,
     * phone and salary for a specific user defined employee.
     */
    public void displayEmployee() throws IOException {
        String[] employeeList = employeeController.displayEmployee(getEmployeeId()).split("    ");
        System.out.println("Name : " + employeeList[0]);
        System.out.println("Designation : " + employeeList[1]);
        System.out.println("Email : " + employeeList[2]);
        System.out.println("Phone Number : " + employeeList[3]);
        System.out.println("Salary : " + employeeList[4]);
    }

    /**
     * Gets and prints details as  name , designation , email ,
     * phone and salary for a all employees.
     */
    public void displayAllEmployee() {
        String[] employeeList = employeeController.displayAllEmployees().split(";");
        System.out.println("************************************************");
        System.out.print("Name  Designation  Email Id  PhoneNumber  Salary");
        for (int index = 0; index < employeeList.length; index++) {
            if(0 == index) {
                System.out.println();
            }
            System.out.println(employeeList[index]);
        }
    }

    /**
     * Gets details to delete from
     * the user as employee Id and prints
     * user message .
     */
    public void deleteDetails() throws IOException {
        if(employeeController.deleteEmployee(getEmployeeId())) {
            System.out.println("Successfully Deleted!!!");
        } else {
            System.out.println("Employee cannot be deleted!!!");
        }
    }


    /**
     * Contains methods to get details to update from
     * the user as updated name , designation , email ,
     * phone and salary .
     */
    public void updateEmployeeDetails() throws IOException {
        System.out.println("Enter the field to Update\n 1. Update Name \n 2. Update Designation \n " +
                          "3. Update Email \n 4. Update Phone \n 5.Update Salary\nEnter Your Choice\n");
        int choice = Integer.parseInt(bufferedReader.readLine());
        switch(choice) {
            case 1 :
                System.out.println("Enter your updated Name");
                String updatedName = bufferedReader.readLine();
                employeeController.updateEmployee(choice, updatedName, getEmployeeId());
                break;
            case 2 :
                System.out.println("Enter your updated Designation");
                String updatedDesignation = bufferedReader.readLine();
                employeeController.updateEmployee(choice, updatedDesignation, getEmployeeId());
                break;
            case 3 :
                System.out.println("Enter your updated Email Id");
                String updatedEmail = bufferedReader.readLine();
                employeeController.updateEmployee(choice, updatedEmail, getEmployeeId());
                break;
            case 4 :
                System.out.println("Enter your updated Phone Number");
                String  updatedPhone = bufferedReader.readLine();
                employeeController.updateEmployee(choice, updatedPhone, getEmployeeId());
                break;
            case 5 :
                System.out.println("Enter your updated  Salary");
                String updatedSalary = bufferedReader.readLine();
                employeeController.updateEmployee(choice, updatedSalary, getEmployeeId());
                break;
            default:
                System.out.println("Invalid Choice !!!");
                break;
        }
    }

    /**
     * Calls create , delete , update
     * and display the employee Details methods .
     * It passes the parameters to EmployeeController.
     */
    public void operations() throws IOException {
        String welcomeString = "\nWelcome to Employee Management System\n 1. Create Employee \n 2. Display Employee \n " +
                               "3. Update Employee\n 4. Delete Employee\n 5. Display All employees\n Enter 0 to exit";
        int choice = 1;
        while(0 != choice) {
            System.out.println(welcomeString);
            choice = Integer.parseInt(bufferedReader.readLine());
            switch(choice) {
                case 0 :
                    break;
                case 1:
                    createEmployee();
                    break;
                case 2:
                    displayEmployee();
                    break;
                case 3 :
                    updateEmployeeDetails();
                    break;
                case 4 :
                    deleteDetails();
                    break;
                case 5 :
                    displayAllEmployee();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
