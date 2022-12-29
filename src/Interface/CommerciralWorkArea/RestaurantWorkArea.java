/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CommerciralWorkArea;

import Business.Community.Community;
import Business.EcoSystem;
import Business.Employee.ResidentEmployee;
import Business.Employee.RestaurantEmployee;
import Business.Organization.Organization;
import Business.FoodProvider.Food;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoodCollectionWorkRequest;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vrushaliphaltankar
 */
public class RestaurantWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form RestaurantWorkArea
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private Community community;
    private RestaurantEmployee restaurantEmployee;
   

    public RestaurantWorkArea(JPanel userProcessContainer,UserAccount account) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.account = account;
        community=account.getEmployee().getCommunityAssociated();
        restaurantEmployee= (RestaurantEmployee) account.getEmployee();
        populateTable();
        populateDonatedHistory();
        populateFridgeItems();
        tblDonatedHistory.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        tblFoodItemsToBeDonated.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        tblFridgeItemsw.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
    }
     
     public void populateFridgeItems(){
        
        
          DefaultTableModel model = (DefaultTableModel) tblFridgeItemsw.getModel();
          model.setRowCount(0);
          String status;
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
           //ResidentEmployee ee = (ResidentEmployee)  userAccount.getEmployee();
           for(Food food : restaurantEmployee.getFoodDirectory().getFoodDirectory()){
                        status = calculateStatusOfFood(food);
                        if(!status.equalsIgnoreCase("Can be donated")){
                            
                            Object[] row = new Object[6];
                            row[0] = food;
                            row[1]=  food.getFoodBarCode();
                            row[2]=  calculateStatusOfFood(food);            
                            row[3]= formatter.format(food.getFoodExpiryDate());
                            row[4]= formatter.format(food.getFoodDateOfPurchase());
                            row[5] = food.getQuantity();
                            model.addRow(row);
                            
                        }
                        
               
         
            
        }
        
        
    }
    
    
    public void populateDonatedHistory(){
        DefaultTableModel model = (DefaultTableModel) tblDonatedHistory.getModel();
        model.setRowCount(0);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for(Food food : restaurantEmployee.getFoodDonatedHistory().getFoodDirectory()  ){
               
                Object[] row = new Object[4];
                    row[0] = food;
                    row[1]=  food.getFoodBarCode();
                    row[2]=  food.getQuantity();
                    row[3]= formatter.format(food.getFoodExpiryDate());
                    model.addRow(row);
                
        }
        
    }
    

    private void populateTable(){
        
           DefaultTableModel model = (DefaultTableModel) tblFoodItemsToBeDonated.getModel();
           model.setRowCount(0);
           String status;
           SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
           //ResidentEmployee ee = (ResidentEmployee)  userAccount.getEmployee();
           for(Food food : restaurantEmployee.getFoodDirectory().getFoodDirectory()){
               status = calculateStatusOfFood(food);
               if(status.equalsIgnoreCase("Can be kept") && !status.equalsIgnoreCase("Spoiled")){
                        Object[] row = new Object[6];
                        row[0] = food;
                        row[1]=  food.getFoodBarCode();
                        row[2]=  calculateStatusOfFood(food);            
                        row[3]= formatter.format(food.getFoodExpiryDate());
                        row[4] = food.getQuantity();
                        row[5] = calculatePriority(food);
                        model.addRow(row);
               }
         
            
        }
        
    }
    
    public String calculatePriority(Food food){
        String priority = "";
        long thresholdDate = (food.getFoodThresholdDate().getTime())/(1000*60*60*24) ;
        //long expiryDate = (food.getFoodExpiryDate().getTime())/(1000*60*60*24);
        
        if(thresholdDate == new Date().getTime()/(1000*60*60*24) ){
            
            priority = "1";
            food.setFoodPriority(priority);
            
        }
        else {
            
            long difference = (long) (food.getFoodExpiryDate().getTime() - new Date().getTime())/(1000*60*60*24);
            if(difference >=5){
                priority = "1";
                food.setFoodPriority(priority);
            }
            else if(difference == 4){
                
                priority = "2";
                food.setFoodPriority(priority);
            }
            else if(difference == 3){
                
                priority = "3";
                food.setFoodPriority(priority);
            }
            else if(difference == 2){
                
                priority = "4";
                food.setFoodPriority(priority);
            }
            else if(difference ==1){
                
                priority = "5";
                food.setFoodPriority(priority);
            }
            else if(difference ==0){
                
                priority = "5";
                food.setFoodPriority(priority);
            }
            
            else{
                priority = "3";
                food.setFoodPriority(priority);
            }
        }
           
        
        return priority;
        
    }
    
    public String calculateStatusOfFood(Food food){
         String statusOfFood;
        Date today = new Date();
        
        long differenceFromThreshold = (long) (today.getTime() - food.getFoodThresholdDate().getTime())/(1000*60*60*24);
        long differenceFromExpiry = (long) (today.getTime() - food.getFoodExpiryDate().getTime())/(1000*60*60*24);
  
        if (differenceFromThreshold >=0 && differenceFromExpiry <= 0){
            statusOfFood = "Can Be Donated";            
        }
        else if(differenceFromThreshold >=0 && differenceFromExpiry >0 ){
            statusOfFood = "Spoiled"; 
        }  
        else{
            statusOfFood = "Can be kept";           
        }
             return statusOfFood; 
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFoodItemsToBeDonated = new javax.swing.JTable();
        btnDonationRequest = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDonatedHistory = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblFridgeItemsw = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(25, 118, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Restaurant Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, 45));

        jTabbedPane1.setBackground(new java.awt.Color(25, 118, 242));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(25, 118, 242));

        tblFoodItemsToBeDonated.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblFoodItemsToBeDonated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food Barcode", "Food Status", "Food Expiry Date", "Food Weight(lbs)", "Priority"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFoodItemsToBeDonated.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblFoodItemsToBeDonated);

        btnDonationRequest.setBackground(new java.awt.Color(25, 118, 242));
        btnDonationRequest.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnDonationRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnDonationRequest.setText("Request");
        btnDonationRequest.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnDonationRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonationRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(1108, Short.MAX_VALUE)
                .addComponent(btnDonationRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDonationRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Donation Request", jPanel1);

        jPanel2.setBackground(new java.awt.Color(25, 118, 242));

        tblDonatedHistory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblDonatedHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Food Name", "Food ID", "Food Weight(lbs)", "Food Expiry Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblDonatedHistory);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1202, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(420, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ViewDonationHistory", jPanel2);

        jPanel3.setBackground(new java.awt.Color(25, 118, 242));

        tblFridgeItemsw.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblFridgeItemsw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food ID", "Food Status", "Food Expiry Date", "Food Purchase Date", "Food Weight(lbs)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblFridgeItemsw);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1227, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(415, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Fridge Details", jPanel3);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 280, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDonationRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonationRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFoodItemsToBeDonated.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select the row from the table");
            return;
        }
        
        Food  food = (Food)tblFoodItemsToBeDonated.getValueAt(selectedRow, 0);
        FoodCollectionWorkRequest foodCollection = new FoodCollectionWorkRequest();
        foodCollection.setRequestDate(new Date());
        foodCollection.setSender(account);
        foodCollection.setFood(food);
        foodCollection.setRestaurantEmployee(restaurantEmployee);
        foodCollection.setStatus("New Request");
        Organization org =  community.getFoodCollectionOrganization();
        org.getWorkQueue().getWorkRequestArrayList().add(foodCollection);
        //userAccount.getWorkQueue().getWorkRequestList().add(foodCollection);
        restaurantEmployee.getFoodDirectory().getFoodDirectory().remove(food);
        restaurantEmployee.getFoodDonatedHistory().getFoodDirectory().add(food);
        populateTable();
        populateDonatedHistory();
        JOptionPane.showMessageDialog(null, "Work request send succesfully to Food Collection Authority. Please wait for the driver to come and collect your food items. Thank you for helping for the betterment of the society");
        
    }//GEN-LAST:event_btnDonationRequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDonationRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDonatedHistory;
    private javax.swing.JTable tblFoodItemsToBeDonated;
    private javax.swing.JTable tblFridgeItemsw;
    // End of variables declaration//GEN-END:variables
}
