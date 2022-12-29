/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.FoodProvider.FoodDirectory;
/**
 *
 * @author vrushaliphaltankar
 */
public class FoodDistributionSupervisorEmployee extends Employee {

    private FoodDirectory foodDirectory;
    private FoodDirectory foodDonatedHistory;

    public FoodDistributionSupervisorEmployee(){
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


}
