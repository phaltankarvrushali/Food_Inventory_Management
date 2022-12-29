/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Community.Community;
import java.util.ArrayList;

/**
 *
 * @author vrushaliphaltankar
 */
public class EmployeeDirectory {
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name, Community communityName, Employee employee){
       // Employee employee = new Employee();
        employee.setName(name);
        employee.setCommunityAssociated(communityName);
        employeeList.add(employee);
        return employee;
    }
    
}
