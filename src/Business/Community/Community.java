/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Community;

import Business.Organization.ResidentOrganization;
import Business.Organization.CommunityAdminOrganization;
//import Business.Organization.FoodAdminOrganization;
import Business.Organization.FoodCollectionOrganization;
import Business.Organization.FoodDistributionOrganization;
import Business.Organization.FoodStandardOrganization;
import Business.Organization.RestaurantOrganization;

/**
 *
 * @author vrushaliphaltankar
 */
public class Community {
    
    private String communityName;
    private ResidentOrganization residentOrganization;
    //private FoodAdminOrganization foodAdminOrg;
    private FoodCollectionOrganization foodCollectionOrganization;
    private FoodDistributionOrganization foodDistributionOrganization;
    private FoodStandardOrganization foodStandardOrganization;
    private RestaurantOrganization restaurantOrganization;
    private CommunityAdminOrganization communityOrganization;
    
    public Community(String name){
        this.communityName = name;
        residentOrganization = new ResidentOrganization();
        //foodAdminOrg = new FoodAdminOrganization();
        foodCollectionOrganization = new FoodCollectionOrganization();
        foodDistributionOrganization = new FoodDistributionOrganization();
        communityOrganization = new CommunityAdminOrganization();
        foodStandardOrganization = new FoodStandardOrganization();
        restaurantOrganization = new RestaurantOrganization();
    }

    public ResidentOrganization getResidentOrganization() {
        return residentOrganization;
    }

    public void setResidentOrganization(ResidentOrganization residentOrganization) {
        this.residentOrganization = residentOrganization;
    }

//    public FoodAdminOrganization getFoodAdminOrg() {
//        return foodAdminOrg;
//    }
//
//    public void setFoodAdminOrg(FoodAdminOrganization foodAdminOrg) {
//        this.foodAdminOrg = foodAdminOrg;
//    }

    public FoodCollectionOrganization getFoodCollectionOrganization() {
        return foodCollectionOrganization;
    }

    public void setFoodCollectionOrganization(FoodCollectionOrganization foodCollectionOrganization) {
        this.foodCollectionOrganization = foodCollectionOrganization;
    }

    public FoodDistributionOrganization getFoodDistributionOrganization() {
        return foodDistributionOrganization;
    }

    public void setFoodDistributionOrganization(FoodDistributionOrganization foodDistributionOrganization) {
        this.foodDistributionOrganization = foodDistributionOrganization;
    }

    public FoodStandardOrganization getFoodStandardOrganization() {
        return foodStandardOrganization;
    }

    public void setFoodStandardOrganization(FoodStandardOrganization foodStandardOrganization) {
        this.foodStandardOrganization = foodStandardOrganization;
    }

    public RestaurantOrganization getRestaurantOrganization() {
        return restaurantOrganization;
    }

    public void setRestaurantOrganization(RestaurantOrganization restaurantOrganization) {
        this.restaurantOrganization = restaurantOrganization;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
    
    
       @Override
        public String toString() {
            return communityName;
        }

    public CommunityAdminOrganization getCommunityOrganization() {
        return communityOrganization;
    }

    public void setCommunityOrganization(CommunityAdminOrganization communityOrganization) {
        this.communityOrganization = communityOrganization;
    }
    
}
