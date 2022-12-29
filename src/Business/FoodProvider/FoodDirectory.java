/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.FoodProvider;

import java.util.ArrayList;

/**
 *
 * @author vrushaliphaltankar
 */
public class FoodDirectory {
    
    private ArrayList<Food> foodDirectory;
    
    public FoodDirectory(){
        foodDirectory = new ArrayList<Food>();
        
    }

    public ArrayList<Food> getFoodDirectory() {
        return foodDirectory;
    }

    public void setFoodDirectory(ArrayList<Food> foodDirectory) {
        this.foodDirectory = foodDirectory;
    }
    
    public Food addFood(Food food ){
        
        foodDirectory.add(food);
        return food;
        
        
    }
    
    public void removeFood(Food food ){
        
        foodDirectory.remove(food);
        //return food;
        
        
    }
    
    
    
}
