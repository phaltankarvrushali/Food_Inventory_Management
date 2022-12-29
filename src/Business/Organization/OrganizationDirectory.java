/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.OrganizationType;
import Business.Roles.ResidentRole;

import java.util.ArrayList;

/**
 *
 * @author vrushaliphaltankar
 */
public class OrganizationDirectory {
    
    
    private ArrayList<Organization> organizationArrayList;

    public OrganizationDirectory() {
        organizationArrayList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationArrayList() {
        return organizationArrayList;
    }
    
      public Organization createOrganization(Organization.OrganizationType type){
        Organization organization = null;
        if (type.getValue().equals(OrganizationType.RESIDENT.getValue())){
            organization = new ResidentOrganization();
            //add roles 
            organization.getSupportedRole().add(new ResidentRole());
            organizationArrayList.add(organization);
        }
        else if (type.getValue().equals(OrganizationType.FOODCOLLECTION.getValue())){
            organization = new FoodCollectionOrganization();   
            organizationArrayList.add(organization);
        }
        else if (type.getValue().equals(OrganizationType.FOODDISTRIBUTION.getValue())){
            organization = new FoodDistributionOrganization();   
            organizationArrayList.add(organization);
        }
        else if (type.getValue().equals(OrganizationType.FOODSTANDARD.getValue())){
            organization = new FoodStandardOrganization();   
            organizationArrayList.add(organization);
        }
        
        else if (type.getValue().equals(OrganizationType.RESTAURANT.getValue())){
            organization = new RestaurantOrganization();   
            organizationArrayList.add(organization);
        }
        
        return organization;
    }
}
