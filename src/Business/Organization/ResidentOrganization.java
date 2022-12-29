/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.ResidentRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author vrushaliphaltankar
 */
public class ResidentOrganization extends Organization {

    public ResidentOrganization() {
        super(OrganizationType.RESIDENT.getValue());
        roles.add(new ResidentRole());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {        
        return roles;
    }
    
    
    
}
