/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.FoodProvider;

import java.util.Date;

/**
 *
 * @author vrushaliphaltankar
 */
public class Food {
    
    private int foodBarCode;
    private String foodName;
    private Date foodDateOfPurchase;
    private Date foodExpiryDate;
    private Date foodThresholdDate;
    private int thresholdDays;
    private String statusOfFood;
    private boolean isThresholdReached;
    private int quantity;  //
    private int numberOfBenificary;
    private String rewardPoints;
    private String foodPriority;
    
            
    private String foodType;
    private static int count=1;
    
    public Food(){
        foodBarCode = count;
        count++;
    }
    
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    
     public String getStatusOfFood() {
        return statusOfFood;
    }

    public void setStatusOfFood(String statusOfFood) {
        this.statusOfFood = statusOfFood;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }


    
    
    @Override
    public String toString(){
        return foodName;
    }

 
   

    public boolean isIsThresholdReached() {
        return isThresholdReached;
    }

    public void setIsThresholdReached(boolean isThresholdReached) {
        this.isThresholdReached = isThresholdReached;
    }

    public Date getFoodDateOfPurchase() {
        return foodDateOfPurchase;
    }

    public void setFoodDateOfPurchase(Date foodDateOfPurchase) {
        this.foodDateOfPurchase = foodDateOfPurchase;
    }

    public Date getFoodExpiryDate() {
        return foodExpiryDate;
    }

    public void setFoodExpiryDate(Date foodExpiryDate) {
        this.foodExpiryDate = foodExpiryDate;
    }

    public Date getFoodThresholdDate() {
        return foodThresholdDate;
    }

    public void setFoodThresholdDate(Date foodThresholdDate) {
        this.foodThresholdDate = foodThresholdDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFoodBarCode() {
        return foodBarCode;
    }

    public void setFoodBarCode(int foodBarCode) {
        this.foodBarCode = foodBarCode;
    }

    public int getNumberOfBenificary() {
        return numberOfBenificary;
    }

    public void setNumberOfBenificary(int numberOfBenificary) {
        this.numberOfBenificary = numberOfBenificary;
    }

    public String getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(String rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public String getFoodPriority() {
        return foodPriority;
    }

    public void setFoodPriority(String foodPriority) {
        this.foodPriority = foodPriority;
    }

    public int getThresholdDays() {
        return thresholdDays;
    }

    public void setThresholdDays(int thresholdDays) {
        this.thresholdDays = thresholdDays;
    }   
    
}
