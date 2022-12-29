/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.City.City;
import Business.Organization.Organization;
import Business.Roles.Role;
import Business.Roles.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author vrushaliphaltankar
 */
public class EcoSystem extends Organization {
    
    private static EcoSystem business;
    private ArrayList<City> cityList;
    
    
    
    private EcoSystem(){
        
        super("SystemAdmin");
        cityList = new ArrayList<City>();
        
    }
    
    public static EcoSystem getInstance(){
        if (business == null)
            business = new EcoSystem();
       
            return business; 
      
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
         ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public ArrayList<City> getCitiesList() {
        return cityList;
    }
    public City createAndAddCity() {
        City city = new City();
        cityList.add(city);
        return city;
    }
    
    
    
}
