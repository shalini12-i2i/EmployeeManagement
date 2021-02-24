package com.ideas2it.employee.service;

import java.util.HashMap;
import java.util.Map;
import com.ideas2it.employee.model.Employee;

/**
 * Contains methods to perform create , delete , display and update operations.
 * @author Shalini
 * @created on 22-02-2021
 */
public class EmployeeService {
    int employeeId = 1;
    Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

    /**
     * Creates an employee record.
     * @param fullName - Name of employee
     * @param designation - designation of employee
     * @param email - email of employee
     * @param phone - phone of employee
     * @param salary - salary of employee
     * @return status of employee record creation.
     */
    public boolean createEmployee(String fullName, String designation, String email, long phone, long salary) {
        Employee employee = new Employee(fullName, designation, email, phone, salary);
        if(null == employees.put(employeeId, employee)) {
            ++employeeId;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Displays an employee record based on employeeId.
     * @param employeeId - Unique employee Id.
     * @return displays particular employee record
     */
    public String displayEmployee(int employeeId) {
        Employee employee =  employees.get(employeeId);
        return employee.toString();
    }

    /**
     * Deletes an employee record based on employeeId.
     * @param employeeId - Unique employee Id.
     * @return status of deletion to the user .
     */
    public boolean deleteEmployee(int employeeId) {
        return null != employees.remove(employeeId);
    }

    /**
     * Updates an employee record based on the employeeId.
     * @param choice - choice of user to update
     * @param updatedField - field to update
     * @param employeeId - Unique employee Id.
     * @return status of updation to the user.
     */
    public boolean updateEmployee(int choice, String updatedField, int employeeId) {
        Employee employee = employees.get(employeeId);
        boolean isUpdated = false;
        switch(choice) {
           case 1 :
               isUpdated = true;
               employee.setFullName(updatedField);
               break;
           case 2 :
               isUpdated = true;
               employee.setDesignation(updatedField);
               break;
           case 3 :
               isUpdated = true;
               employee.setEmail(updatedField);
               break;
           case 4 :
               isUpdated = true;
               employee.setPhone(Long.parseLong(updatedField));
               break;
           case 5 :
               isUpdated = true;
               employee.setSalary(Long.parseLong(updatedField));
               break;
           default:
               break;
       }
       return isUpdated;
    }

    /**
     * Displays all employees record.
     * @return displays all employees as list object.
     */
    public String displayAllEmployees() {
        String employeeList = "" ;
        for(Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            employeeList = employeeList + employee.toString() + ";";
        }
        return employeeList;
    }
}
