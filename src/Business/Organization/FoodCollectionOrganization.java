/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

//import Business.DonorHistory;
import Business.Roles.FoodCollectionDriverRole;
import Business.Roles.FoodCollectionAdminRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author vrushaliphaltankar
 */
public class FoodCollectionOrganization extends Organization{
 
    
    public FoodCollectionOrganization() {
        super(Organization.OrganizationType.FOODCOLLECTION.getValue());
        //foodCollectionDonations = new ArrayList<>();
        roles.add(new FoodCollectionDriverRole());
        roles.add(new FoodCollectionAdminRole());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return roles;
    }
}
