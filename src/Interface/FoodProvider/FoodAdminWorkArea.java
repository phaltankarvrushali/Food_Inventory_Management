/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.FoodProvider;

import Business.Community.Community;
import Business.Employee.ResidentEmployee;
import Business.Employee.Employee;
import Business.Employee.RestaurantEmployee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FoodManagementEnterprise;
import Business.FoodProvider.Food;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author vrushaliphaltankar
 */
public class FoodAdminWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form FoodAdminWorkArea
     */
static int foodBarcode = 0;
private JPanel userProcessContainer;
private FoodManagementEnterprise enterprise;

    public FoodAdminWorkArea(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = (FoodManagementEnterprise) enterprise;
        populateCommunityCombobox();
        String best = (String) cboBestBefore.getSelectedItem();
        calculateExpiryDate(best);
        populateResidentCombobox(); 
        populateRestaturantCombobox();
        populateBestBeforeCombobox();
        populateFoodTypeCombobox();
        txtExpiryDate.setEnabled(false);
        txtThresholdDays.setEnabled(false);
        rdnResident.setSelected(true);
        jDateChooser1.setMaxSelectableDate(new Date());
    }
    
    public static int RandInt(int min, int max) {

    // Usually this can be a field rather than a method variable
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}
    
    public void populateCommunityCombobox(){
        
        cboCommuntiyName.removeAllItems();
        for(Community community : enterprise.getCommunityArrayList()){
            cboCommuntiyName.addItem(community);
        }
    }
    public  void populateResidentCombobox(){
        cboResident.removeAllItems();
        Community selectedCommunity = (Community) cboCommuntiyName.getSelectedItem(); 
        for(Employee ee : selectedCommunity.getResidentOrganization().getEmployeeDirectory().getEmployeeList()){
            ResidentEmployee residentEmployee = (ResidentEmployee) ee;
            cboResident.addItem(residentEmployee);
        }
        
    }
      public  void populateRestaturantCombobox(){
        cboRestaurant.removeAllItems();
        Community selectedCommunity = (Community) cboCommuntiyName.getSelectedItem(); 
        for(Employee ee : selectedCommunity.getRestaurantOrganization().getEmployeeDirectory().getEmployeeList()){
            RestaurantEmployee restaturantEmployee = (RestaurantEmployee) ee;
            cboRestaurant.addItem(restaturantEmployee);
        }
        
    }
      
      public  void populateBestBeforeCombobox(){
              
          cboBestBefore.removeAllItems();
          cboBestBefore.addItem("1 Month");
          cboBestBefore.addItem("2 Month");
          cboBestBefore.addItem("3 Month");
        
        }
      public  void populateFoodTypeCombobox(){
              
          cboFoodType.removeAllItems();
          cboFoodType.addItem("Canned Food");
          cboFoodType.addItem("Purchased Food");
          cboFoodType.addItem("Home made Food");
        
        }
      public void calculateExpiryDate(String bestBefore){
          Date expriryDate= null;
          Date purchaseDate = null;
          
          purchaseDate = jDateChooser1.getDate();
         
          
          if(purchaseDate == null){
              
              txtExpiryDate.setText(new Date().toString());
              return;
              
          }
          
          Calendar cal = Calendar.getInstance();
          cal.setTime(purchaseDate);
                
          if(bestBefore.equals("1 Month")){
//             purchaseDate = jDateChooser1.getDate();
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(purchaseDate);
                 cal.add(Calendar.MONTH, 1); 
                expriryDate = cal.getTime();
                txtExpiryDate.setText(expriryDate.toString());
 
          }
          else if (bestBefore.equals("2 Month")){
//              purchaseDate = jDateChooser1.getDate();
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(purchaseDate);
                 cal.add(Calendar.MONTH, 2); 
                expriryDate = cal.getTime();
                txtExpiryDate.setText(expriryDate.toString());
              
          }
          else if (bestBefore.equalsIgnoreCase("3 Month")){    
//              purchaseDate = jDateChooser1.getDate();
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(purchaseDate);
                cal.add(Calendar.MONTH, 3); 
                expriryDate = cal.getTime();
                txtExpiryDate.setText(expriryDate.toString());
              
          }
          else{
                txtExpiryDate.setText(new Date().toString());
          }
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboCommuntiyName = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cboResident = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFoodName = new javax.swing.JTextField();
        cboFoodType = new javax.swing.JComboBox();
        spnQuantity = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        rdnResident = new javax.swing.JRadioButton();
        rdnRestaurant = new javax.swing.JRadioButton();
        cboBestBefore = new javax.swing.JComboBox();
        txtExpiryDate = new javax.swing.JTextField();
        btnCreateFood = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cboRestaurant = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        txtThresholdDays = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(25, 118, 242));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Food Admin Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Community Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        cboCommuntiyName.setBackground(new java.awt.Color(25, 118, 242));
        cboCommuntiyName.setForeground(new java.awt.Color(255, 255, 255));
        cboCommuntiyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCommuntiyNameActionPerformed(evt);
            }
        });
        add(cboCommuntiyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 99, 212, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Resident :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        cboResident.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboResidentActionPerformed(evt);
            }
        });
        add(cboResident, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 206, 212, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Food Name:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Food Type :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Date of Purchase :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 358, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quantity :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Best Before :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Expiry Date :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, -1, -1));
        add(txtFoodName, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 307, 120, -1));

        cboFoodType.setBackground(new java.awt.Color(25, 118, 242));
        cboFoodType.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        cboFoodType.setForeground(new java.awt.Color(255, 255, 255));
        cboFoodType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFoodTypeActionPerformed(evt);
            }
        });
        add(cboFoodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 215, -1));
        add(spnQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 215, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Select type of Donator:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        buttonGroup1.add(rdnResident);
        rdnResident.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        rdnResident.setForeground(new java.awt.Color(255, 255, 255));
        rdnResident.setText("Resident");
        rdnResident.setBorderPainted(true);
        rdnResident.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnResidentActionPerformed(evt);
            }
        });
        add(rdnResident, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 157, -1, -1));

        buttonGroup1.add(rdnRestaurant);
        rdnRestaurant.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        rdnRestaurant.setForeground(new java.awt.Color(255, 255, 255));
        rdnRestaurant.setText("Restaturant");
        rdnRestaurant.setBorderPainted(true);
        rdnRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnRestaurantActionPerformed(evt);
            }
        });
        add(rdnRestaurant, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 157, -1, -1));

        cboBestBefore.setBackground(new java.awt.Color(25, 118, 242));
        cboBestBefore.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        cboBestBefore.setForeground(new java.awt.Color(255, 255, 255));
        cboBestBefore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBestBeforeActionPerformed(evt);
            }
        });
        add(cboBestBefore, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 415, 120, -1));
        add(txtExpiryDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 215, -1));

        btnCreateFood.setBackground(new java.awt.Color(25, 118, 242));
        btnCreateFood.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCreateFood.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateFood.setText("Create Food");
        btnCreateFood.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnCreateFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateFoodActionPerformed(evt);
            }
        });
        add(btnCreateFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 191, 40));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Select Restaurant :");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        cboRestaurant.setBackground(new java.awt.Color(25, 118, 242));
        cboRestaurant.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        cboRestaurant.setForeground(new java.awt.Color(255, 255, 255));
        cboRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRestaurantActionPerformed(evt);
            }
        });
        add(cboRestaurant, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 212, -1));
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 358, 120, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Threshold Days :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));
        add(txtThresholdDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 260, 119, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 350, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFoodActionPerformed
        // TODO add your handling code here:
    
        String foodName = txtFoodName.getText();
        
        if(null == foodName || foodName.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter Food Name");
            txtFoodName.setText("");
			return;
        }
        
            Pattern p = Pattern.compile("^[a-zA-Z \\s]+");
            Matcher m = p.matcher(foodName);  
            if(!m.matches())
            {
                JOptionPane.showMessageDialog(null, "Invalid Food Name");
			return;
            }
        
        String foodType=cboFoodType.getSelectedItem().toString();
        Date date = jDateChooser1.getDate();
        int quantity = (int) spnQuantity.getValue();
        if(quantity == 0){
           JOptionPane.showMessageDialog(null, "Quantity must not be zero");
           return;
        }
        
        
        Date date1 = null;
        String stringDate = txtExpiryDate.getText();
        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try{
         SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                                            Locale.ENGLISH);
         Date parsedDate = sdf.parse(stringDate);
         date1= formatter.parse(formatter.format(parsedDate));
        
        
        }catch(Exception ex){
           System.out.println(ex);
        }
        
        
        
        Food foodItem = new Food();
        foodItem.setFoodDateOfPurchase(date);
        foodItem.setFoodExpiryDate(date1);
        foodItem.setFoodType(foodType);
        foodItem.setQuantity(quantity);
        foodItem.setFoodName(foodName);
        foodItem.setFoodBarCode(foodBarcode);
        ++foodBarcode;
        
        Calendar cc1 = Calendar.getInstance();
        cc1.setTime(date1);
        cc1.add(Calendar.DATE, -Integer.parseInt(txtThresholdDays.getText()));
        foodItem.setFoodThresholdDate(cc1.getTime());
        
        
        if(rdnResident.isSelected()){
            ResidentEmployee residentEmployee = (ResidentEmployee) cboResident.getSelectedItem();
            residentEmployee.getFoodDirectory().addFood(foodItem);
            txtFoodName.setText("");
            
            JOptionPane.showMessageDialog(null, "Food Item created for  "   +   residentEmployee.toString());
            
            
        }
          if(rdnRestaurant.isSelected()){
            RestaurantEmployee restaurantEmployee = (RestaurantEmployee) cboRestaurant.getSelectedItem();
            restaurantEmployee.getFoodDirectory().addFood(foodItem);
            txtFoodName.setText("");
            JOptionPane.showMessageDialog(null, "Food Item created for  "   +   restaurantEmployee.toString());
        }       
    }//GEN-LAST:event_btnCreateFoodActionPerformed

    private void rdnResidentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnResidentActionPerformed
        // TODO add your handling code here:
        cboRestaurant.setEnabled(false);
        cboResident.setEnabled(true);
    }//GEN-LAST:event_rdnResidentActionPerformed

    private void rdnRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnRestaurantActionPerformed
        // TODO add your handling code here:
        cboRestaurant.setEnabled(true);
        cboResident.setEnabled(false);
    }//GEN-LAST:event_rdnRestaurantActionPerformed

    private void cboBestBeforeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBestBeforeActionPerformed
        // TODO add your handling code here:
        String best = (String) cboBestBefore.getSelectedItem();
        calculateExpiryDate(best);
      
    }//GEN-LAST:event_cboBestBeforeActionPerformed

    private void cboFoodTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFoodTypeActionPerformed
        // TODO add your handling code here:
        String type = cboFoodType.getSelectedItem().toString();
        if(type==null)
            return;

        if(type.equalsIgnoreCase("Canned Food"))
              txtThresholdDays.setText("5");
        else if(type.equalsIgnoreCase("Purchased Food"))
              txtThresholdDays.setText("4");
        else
              txtThresholdDays.setText("3");
        
    }//GEN-LAST:event_cboFoodTypeActionPerformed

    private void cboRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRestaurantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboRestaurantActionPerformed

    private void cboResidentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboResidentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboResidentActionPerformed

    private void cboCommuntiyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCommuntiyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCommuntiyNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateFood;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboBestBefore;
    private javax.swing.JComboBox cboCommuntiyName;
    private javax.swing.JComboBox cboFoodType;
    private javax.swing.JComboBox cboResident;
    private javax.swing.JComboBox cboRestaurant;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdnResident;
    private javax.swing.JRadioButton rdnRestaurant;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTextField txtExpiryDate;
    private javax.swing.JTextField txtFoodName;
    private javax.swing.JTextField txtThresholdDays;
    // End of variables declaration//GEN-END:variables
}
