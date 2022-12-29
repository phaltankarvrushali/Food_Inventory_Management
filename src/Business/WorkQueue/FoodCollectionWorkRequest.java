/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Employee.ResidentEmployee;
import Business.Employee.RestaurantEmployee;
import Business.FoodProvider.Food;

/**
 *
 * @author vrushaliphaltankar
 */
public class FoodCollectionWorkRequest extends WorkRequest {
    
    private Food food;
    private ResidentEmployee residentEmployee;
    private RestaurantEmployee restaurantEmployee;
    private String  driverName;
    
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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    @Override
    public String toString(){
        return food.getFoodName();
        
    }

    public RestaurantEmployee getRestaurantEmployee() {
        return restaurantEmployee;
    }

    public void setRestaurantEmployee(RestaurantEmployee restaurantEmployee) {
        this.restaurantEmployee = restaurantEmployee;
    }

  
    
    
    
}
