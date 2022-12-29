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
public class FoodStandardWorkRequest extends WorkRequest {
 
     private Food food;
     private String sentTo;
     private ResidentEmployee residentEmployee;
    
     @Override
    public String toString(){
        return food.getFoodName();
        
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public ResidentEmployee getResidentEmployee() {
        return residentEmployee;
    }

    public void setResidentEmployee(ResidentEmployee residentEmployee) {
        this.residentEmployee = residentEmployee;
    }
}
