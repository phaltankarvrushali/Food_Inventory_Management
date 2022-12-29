/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Employee.ResidentEmployee;
import Business.FoodProvider.Food;

/**
 *
 * @author vrushaliphaltankar
 */
public class FoodDistributionWorkRequest extends WorkRequest {
     
    private Food food;
    private ResidentEmployee residentEmployee;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public ResidentEmployee getResidentEmployee() {
        return residentEmployee;
    }

    public void setResidentEmployee(ResidentEmployee residentEmployee) {
        this.residentEmployee = residentEmployee;
    }
    
    @Override
    public String toString(){
        return food.getFoodName();
    }
}