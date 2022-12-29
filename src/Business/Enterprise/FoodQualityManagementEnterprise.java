/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Community.Community;
import Business.Roles.Role;
import java.util.ArrayList;


/**
 *
 * @author vrushaliphaltankar
 */
public class FoodQualityManagementEnterprise extends Enterprise {
    
    private ArrayList<Community> communityArrayList;
    
    public FoodQualityManagementEnterprise(String name){
        super(name,Enterprise.EnterpriseType.FoodQualityManagement);
        communityArrayList = new ArrayList<Community>();
        
    }
    
    public Community addCommunity(String name){
        Community c = new Community(name);
        communityArrayList.add(c);
        return c;
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Community> getCommunityArrayList() {
        return communityArrayList;
    }

    public void setCommunityArrayList(ArrayList<Community> communityArrayList) {
        this.communityArrayList = communityArrayList;
    }
    
}
