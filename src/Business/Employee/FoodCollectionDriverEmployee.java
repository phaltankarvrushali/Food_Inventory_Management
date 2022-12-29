/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

/**
 *
 * @author vrushaliphaltankar
 */
public class FoodCollectionDriverEmployee extends Employee{

    private String driverCurrentAddress;
    private String driverName;
    private String residentEmail;
    private int frequency;
    private boolean isBusy;

    public FoodCollectionDriverEmployee() {
      super();
      frequency = 0;
    }
    
    

    public String getDriverCurrentAddress() {
        return driverCurrentAddress;
    }

    public void setDriverCurrentAddress(String driverCurrentAddress) {
        this.driverCurrentAddress = driverCurrentAddress;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public boolean isIsBusy() {
        return isBusy;
    }

    public void setIsBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }

    public String getResidentEmail() {
        return residentEmail;
    }

    public void setResidentEmail(String residentEmail) {
        this.residentEmail = residentEmail;
    }


    
    
}
