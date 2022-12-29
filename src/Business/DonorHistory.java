/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.ResidentEmployee;

/**
 *
 * @author vrushaliphaltankar
 */
public class DonorHistory {
    
    private ResidentEmployee resident;
    private int count;

    public ResidentEmployee getResident() {
        return resident;
    }

    public void setResident(ResidentEmployee c) {
        this.resident = resident;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
    public void appendCount(){
        count++;
    }
    
    
    
}
