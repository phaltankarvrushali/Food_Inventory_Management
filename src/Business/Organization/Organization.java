/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Roles.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author vrushaliphaltankar
 */
public abstract class Organization {
    
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;
    public ArrayList<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }
    
    public enum OrganizationType{
        
        FOODADMIN("Food Admin Organization"),
        FOODCOLLECTION("Food Collection Organization"),
        FOODDISTRIBUTION("Food Distribution Organization"),
        FOODSTANDARD("Food Standard Organization"),
        WASTEADMIN("Waste Admin Organization"),
        WASTEDUMP("Waste Dump Organization"),
        RESIDENT("Resident Organization"),
        RESTAURANT("Restaurant Organization"),
        COMMUNITYADMIN("Community Admin");
        
        private String value;
        private OrganizationType(String value){
            this.value = value;
        }
        public String getValue() {
            return value;
        }   
        
    }
    
    public Organization(String name){
        
        this.name =name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        roles = new ArrayList<Role>();
        ++counter;
        
        
    }
    
    public abstract ArrayList<Role> getSupportedRole();
    
    @Override
    public String toString() {
        return name;
    }
    
}
