/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Interface.CommerciralWorkArea.RestaurantWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author vrushaliphaltankar
 */
public class RestuarantRole extends Role  {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new RestaurantWorkArea(userProcessContainer,account);
    }
    
    @Override
    public String toString(){
        return Role.RoleType.CommercialBody.getValue();
        
    }
    
}
