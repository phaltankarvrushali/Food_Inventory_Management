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
import javax.swing.JPanel;

/**
 *
 * @author vrushaliphaltankar
 */
public abstract class Role {
    
    public enum RoleType{
        FoodAdmin("FoodAdmin"),
        WasteAdmin("WasteAdmin"),
        Resident("Resident"),
        Supervisor("Supervisor"),
        CommercialBody("CommercialBody"),
        Driver("Driver"),
        CommunityAdmin("Community Role"),
        FoodProvider("Food Provider");
        
        
        private String value;
        
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
        
        

    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
        
    }
    
    
    
    

