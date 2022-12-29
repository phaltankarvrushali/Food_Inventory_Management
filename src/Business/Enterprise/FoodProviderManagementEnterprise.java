/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author vrushaliphaltankar
 */
public class FoodProviderManagementEnterprise extends Enterprise{
    
    public FoodProviderManagementEnterprise(String name){
        
        super(name,EnterpriseType.FoodProviderManagement);
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}