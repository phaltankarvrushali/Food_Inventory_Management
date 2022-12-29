/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.FoodProvider;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author vrushaliphaltankar
 */
public class FridgeSimulation {
    
    ArrayList<String> foodNamesList;
    ArrayList<Date> foodPurchaseDatesList;
    ArrayList<Integer> thresholdDaysList;
    ArrayList<Integer> foodQuantityList;
    ArrayList<String> foodTypeList;
    ArrayList<String> bestBeforeList;
    


    public FridgeSimulation() {
        
        foodNamesList = new ArrayList<>();
        foodPurchaseDatesList = new ArrayList<>();
        thresholdDaysList = new ArrayList<>();
        foodQuantityList = new ArrayList<>();
        foodTypeList = new ArrayList<>();
        bestBeforeList = new ArrayList<>();
        
        generateLists();       
    }
    
    
    private void generateLists(){
        
        foodNamesList.add("Meat");
        foodNamesList.add("Fruits");
        foodNamesList.add("Fish");
        foodNamesList.add("Pork");
        foodNamesList.add("Chicken");
        foodNamesList.add("Rice");
        foodNamesList.add("Dosa");
        foodNamesList.add("Lentil");
        foodNamesList.add("Bread");
        foodNamesList.add("Burger");
        foodNamesList.add("Pizza");

        try {
            SimpleDateFormat formatedDate = new SimpleDateFormat("yyyy-MM-dd");
            Date purchaseDate1 = formatedDate.parse("2022-11-11");
            Date purchaseDate2 = formatedDate.parse("2022-11-13");
            Date purchaseDate3 = formatedDate.parse("2022-11-02");
            Date purchaseDate4 = formatedDate.parse("2022-11-20");

            foodPurchaseDatesList.add(purchaseDate1);
            foodPurchaseDatesList.add(purchaseDate2);
            foodPurchaseDatesList.add(purchaseDate3);
            foodPurchaseDatesList.add(purchaseDate4);


            }        
            catch(Exception e){

            }
        
        foodQuantityList.add(1);
        foodQuantityList.add(2);
        foodQuantityList.add(3);
        foodQuantityList.add(4);
        foodQuantityList.add(5);
        foodQuantityList.add(6);
        foodQuantityList.add(7);
        foodQuantityList.add(8);
        foodQuantityList.add(9);
        foodQuantityList.add(10);
        
        foodTypeList.add("Canned Food");
        foodTypeList.add("Purchased Food");
        foodTypeList.add("Home made Food");
      
        bestBeforeList.add("1 Month");
   
        thresholdDaysList.add(3);
        thresholdDaysList.add(4);
        thresholdDaysList.add(5);
        
    }
    
    
    public ArrayList<Food> generateFoodData(int noOfFoodToBeGenerated){
        
        ArrayList<Food>  foodgeneratedList = new ArrayList<Food>(); 
        
        for(int i=0 ; i <noOfFoodToBeGenerated ; i ++){
            Food f = new Food();
            Random randomNumber = new Random();
            int foodNameCount = randomNumber.nextInt(10) + 0;            
            f.setFoodName(foodNamesList.get(foodNameCount));
            
            int foodPurchasedDateCount = randomNumber.nextInt(3) + 0;      
            f.setFoodDateOfPurchase(foodPurchaseDatesList.get(foodPurchasedDateCount));

            int foodQuantityCount = randomNumber.nextInt(9) + 0;    
            f.setQuantity(foodQuantityList.get(foodQuantityCount));
            
            int foodTypeCount = randomNumber.nextInt(2) + 0;
            f.setFoodType(foodTypeList.get(foodTypeCount));
            
            Calendar expiryCal = Calendar.getInstance();
            expiryCal.setTime(f.getFoodDateOfPurchase());
            expiryCal.add(Calendar.MONTH, 1);
            f.setFoodExpiryDate(expiryCal.getTime());
            
            int foodThresholdCount = randomNumber.nextInt(2) +0;
            f.setThresholdDays(thresholdDaysList.get(foodThresholdCount));
            Calendar thresholdCal = Calendar.getInstance();
            thresholdCal.setTime(f.getFoodExpiryDate());
            thresholdCal.add(Calendar.DATE, -( f.getThresholdDays()));
            f.setFoodThresholdDate(thresholdCal.getTime());
                 
            
            foodgeneratedList.add(f);
        }
        
        
        return foodgeneratedList;
        
    }
    
    
    
    
}
