/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.CommunityAdminRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author vrushaliphaltankar
 */
public class CommunityAdminOrganization extends Organization {

    public CommunityAdminOrganization() {
        super(Organization.OrganizationType.COMMUNITYADMIN.getValue());
         roles.add(new CommunityAdminRole());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {       
        return roles;
    }
    
}
