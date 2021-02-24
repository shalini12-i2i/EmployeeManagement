package com.ideas2it.employee.controller;

import com.ideas2it.employee.service.EmployeeService;
/**
 * Performs creating ,deleting ,displaying  and updating EmployeeDetails.
 * @author Shalini
 * created on 22-02-2021
 */
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();
    /**
     * Creates an employee record.
     * @param fullName - Name of employee
     * @param designation - designation of employee
     * @param email - email of employee
     * @param phone - phone of employee
     * @param salary - salary of employee
     * @return status of employee record creation.
     */
    public boolean createEmployee(String fullName, String designation, String email, long phone, long salary){
        return employeeService.createEmployee(fullName, designation, email, phone, salary);
    }

    /**
     * Displays an employee record based on employeeId.
     * @param employeeId - Unique employee Id.
     * @return displays particular employee record
     */
    public String displayEmployee(int employeeId) {
        return employeeService.displayEmployee( employeeId);
    }

    /**
     * Displays all employees record.
     * @return displays all employees as list object.
     */
    public String displayAllEmployees() {
        return employeeService.displayAllEmployees();
    }

    /**
     * Updates an employee record based on the employeeId.
     * @param choice - choice of user to update
     * @param updatedField - field to update
     * @param employeeId - Unique employee Id.
     * @return status of updation to the user.
     */
    public boolean updateEmployee(int choice, String updatedField,  int employeeId) {
        return employeeService.updateEmployee(choice, updatedField, employeeId);
    }

    /**
     * Deletes an employee record based on employeeId.
     * @param employeeId - Unique employee Id.
     * @return status of deletion to the user .
     */
    public boolean deleteEmployee(int employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}
