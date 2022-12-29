/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Community.Community;

/**
 *
 * @author vrushaliphaltankar
 */
public abstract class Employee {
    
    private String name;
    private String address;
    private int id;
    private Community communityAssociated;
    private static int count = 1 ;
    private String emailID;
    
    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public Community getCommunityAssociated() {
        return communityAssociated;
    }

    public void setCommunityAssociated(Community communityAssociated) {
        this.communityAssociated = communityAssociated;
    }
    
    @Override
    public String toString(){
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   
    
 
    
    
}
