/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.FoodProvider.Food;
import Business.FoodProvider.FoodDirectory;


/**
 *
 * @author vrushaliphaltankar
 */
public class RestaurantEmployee extends Employee {

 
    private FoodDirectory foodDirectory;
    private FoodDirectory foodDonatedHistory;
    private int currentRewardPoints;
    
    
    public RestaurantEmployee(){
        foodDirectory = new FoodDirectory();
        foodDonatedHistory = new FoodDirectory();
        
    }

    public FoodDirectory getFoodDirectory() {
        return foodDirectory;
    }

    public void setFoodDirectory(FoodDirectory foodDirectory) {
        this.foodDirectory = foodDirectory;
    }

    public FoodDirectory getFoodDonatedHistory() {
        return foodDonatedHistory;
    }

    public void setFoodDonatedHistory(FoodDirectory foodDonatedHistory) {
        this.foodDonatedHistory = foodDonatedHistory;
    }

    public int getCurrentRewardPoints() {
        return currentRewardPoints;
    }

    public void setCurrentRewardPoints(int currentRewardPoints) {
        this.currentRewardPoints = currentRewardPoints;
    }
    
     public int calculateTotalRewardPointsForResident(){
        
        int rewardPoints = 0;
        
        for(Food food:foodDonatedHistory.getFoodDirectory()){
            try{
               rewardPoints+= Integer.parseInt(food.getRewardPoints().trim());
            }
            catch(Exception e){
                rewardPoints+= 0;
            }
        }
        currentRewardPoints = rewardPoints;
        
        return currentRewardPoints;
    }
    
    
}
