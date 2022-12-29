/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.RestuarantRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author vrushaliphaltankar
 */
public class RestaurantOrganization extends Organization  {

    public RestaurantOrganization() {
        super(Organization.OrganizationType.RESTAURANT.getValue());
        roles.add(new RestuarantRole());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {      
        return roles;
    }
    
}
