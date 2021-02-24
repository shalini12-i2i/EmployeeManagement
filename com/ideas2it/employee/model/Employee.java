package com.ideas2it.employee.model;
/**
 * Employee model contains the details of employee.
 * @author Shalini
 * created at 22-02-2021.
 */
public class Employee {
    private String fullName ;
    private String designation;
    private String email;
    private long phone ;
    private long salary ;

    public Employee(String fullName, String designation, String email, long phone, long salary) {
        this.fullName = fullName;
        this.designation = designation;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName (String fullName) {
        this.fullName = fullName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
