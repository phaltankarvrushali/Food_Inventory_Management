/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author vrushaliphaltankar
 */
public abstract class WorkRequest {
    
    private String message;
    private UserAccount sender;
   // private UserAccount receiver;
    private UserAccount collectorSupervisor;
    private UserAccount collectorDriver;
    private UserAccount standardSupervisor;
    private UserAccount distributionSupervisor;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    
    public WorkRequest(){
      requestDate = new Date();
        
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public UserAccount getCollectorSupervisor() {
        return collectorSupervisor;
    }

    public void setCollectorSupervisor(UserAccount collectorSupervisor) {
        this.collectorSupervisor = collectorSupervisor;
    }

    public UserAccount getCollectorDriver() {
        return collectorDriver;
    }

    public void setCollectorDriver(UserAccount collectorDriver) {
        this.collectorDriver = collectorDriver;
    }

    public UserAccount getStandardSupervisor() {
        return standardSupervisor;
    }

    public void setStandardSupervisor(UserAccount standardSupervisor) {
        this.standardSupervisor = standardSupervisor;
    }

    public UserAccount getDistributionSupervisor() {
        return distributionSupervisor;
    }

    public void setDistributionSupervisor(UserAccount distributionSupervisor) {
        this.distributionSupervisor = distributionSupervisor;
    }
    
    
    
}
