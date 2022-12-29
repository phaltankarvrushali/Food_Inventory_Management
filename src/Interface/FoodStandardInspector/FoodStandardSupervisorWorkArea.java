/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.FoodStandardInspector;

import Business.Community.Community;
import Business.Organization.FoodStandardOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoodDistributionWorkRequest;
import Business.WorkQueue.FoodStandardWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author vrushaliphaltankar
 */
public class FoodStandardSupervisorWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form FoodStandardSupervisorWorkArea
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private Community community;
    private FoodStandardOrganization organization;

    public FoodStandardSupervisorWorkArea(JPanel userProcessContainer,UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        community = account.getEmployee().getCommunityAssociated();
        organization = community.getFoodStandardOrganization();
        tblFoodStandardSupervisorWorkRequest.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        populateNewRequestTable();
        populateDisapprovedRequestTable();
        populateApprovedRequestTable();
        
    }
    
    
    public void populateDisapprovedRequestTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblDisapprovedRequests.getModel();
        model.setRowCount(0);
        //String status = "";
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestArrayList()){
           // status = request.getStatus();
            if(request.getStatus().equalsIgnoreCase("To be dumped")){
                Object[] row = new Object[7];
                row[0] = ((FoodStandardWorkRequest) request);
                row[1] = ((FoodStandardWorkRequest) request).getFood().getFoodType();
                row[2] = ((FoodStandardWorkRequest) request).getFood().getFoodExpiryDate();
                row[3]=  ((FoodStandardWorkRequest) request).getCollectorDriver();
                row[4] = ((FoodStandardWorkRequest) request).getMessage();
                row[5] = ((FoodStandardWorkRequest) request).getStatus();
                row[6] = ((FoodStandardWorkRequest) request).getSentTo();
                model.addRow(row);
            }
            
        }
    }
    
    
    public void populateApprovedRequestTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblApprovedRequests.getModel();
        model.setRowCount(0);
        //String status = "";
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestArrayList()){
           // status = request.getStatus();
           if(request.getStatus().equalsIgnoreCase("Approved")){        
                    Object[] row = new Object[7];
                    row[0] = ((FoodStandardWorkRequest) request);
                    row[1] = ((FoodStandardWorkRequest) request).getFood().getFoodType();
                    row[2] = ((FoodStandardWorkRequest) request).getFood().getFoodExpiryDate();
                    row[3]=  ((FoodStandardWorkRequest) request).getCollectorDriver();
                    row[4] = ((FoodStandardWorkRequest) request).getMessage();
                    row[5] = ((FoodStandardWorkRequest) request).getStatus();
                    row[6] = ((FoodStandardWorkRequest) request).getSentTo();
                    model.addRow(row);
           }  
       }
        
        
    }

    
    public void populateNewRequestTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblFoodStandardSupervisorWorkRequest.getModel();
        model.setRowCount(0);
        //String status = "";
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestArrayList()){
           // status = request.getStatus();
           if(request.getStatus().equalsIgnoreCase("Pending")){
                    Object[] row = new Object[7];
                    row[0] = ((FoodStandardWorkRequest) request);
                    row[1] = ((FoodStandardWorkRequest) request).getFood().getFoodType();
                    row[2] = ((FoodStandardWorkRequest) request).getFood().getFoodExpiryDate();
                    row[3]=  ((FoodStandardWorkRequest) request).getCollectorDriver();
                    row[4] = ((FoodStandardWorkRequest) request).getMessage();
                    row[5] = ((FoodStandardWorkRequest) request).getStatus();
                    row[6] = ((FoodStandardWorkRequest) request).getSentTo();
                    model.addRow(row);      
           }
            
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

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFoodStandardSupervisorWorkRequest = new javax.swing.JTable(){

            public Component prepareRenderer(TableCellRenderer renderer, int row, int column){

                Component c = super.prepareRenderer(renderer, row, column);
                String ss = tblFoodStandardSupervisorWorkRequest.getValueAt(row, 5).toString();

                if(ss.equalsIgnoreCase("To be distributed")){
                    c.setBackground(Color.GREEN);
                    c.setForeground(Color.WHITE);

                }
                else if (ss.equalsIgnoreCase("To be dumped")){
                    c.setBackground(Color.RED);
                    c.setForeground(Color.WHITE);
                }
                else{
                    //super.getBackground()
                    c.setBackground(Color.ORANGE);
                    c.setForeground(super.getForeground());
                }
                return c;

            }

        };
        btnApprove = new javax.swing.JButton();
        btnDisApprove = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblApprovedRequests = new javax.swing.JTable(){

            public Component prepareRenderer(TableCellRenderer renderer, int row, int column){

                Component c = super.prepareRenderer(renderer, row, column);
                //String ss = tblFoodStandardSupervisorWorkRequest.getValueAt(row, 5).toString();
                c.setBackground(Color.GREEN);
                c.setForeground(super.getForeground());

                return c;

            }

        };
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDisapprovedRequests = new javax.swing.JTable(){

            public Component prepareRenderer(TableCellRenderer renderer, int row, int column){

                Component c = super.prepareRenderer(renderer, row, column);
                c.setBackground(Color.cyan);
                c.setForeground(super.getForeground());

                return c;

            }

        };
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(25, 118, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Food Standard Supervisor Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 23, -1, -1));

        jTabbedPane1.setBackground(new java.awt.Color(25, 118, 242));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(25, 118, 242));

        tblFoodStandardSupervisorWorkRequest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblFoodStandardSupervisorWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food Type", "Food expiry Date", "Collection Dept. Sender", "Message", "Status", "Sent To"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblFoodStandardSupervisorWorkRequest);

        btnApprove.setBackground(new java.awt.Color(25, 118, 242));
        btnApprove.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnApprove.setForeground(new java.awt.Color(255, 255, 255));
        btnApprove.setText("Approve");
        btnApprove.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnDisApprove.setBackground(new java.awt.Color(25, 118, 242));
        btnDisApprove.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnDisApprove.setForeground(new java.awt.Color(255, 255, 255));
        btnDisApprove.setText("Disapprove");
        btnDisApprove.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnDisApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisApproveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDisApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1525, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDisApprove, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnApprove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View New Requests", jPanel1);

        jPanel2.setBackground(new java.awt.Color(25, 118, 242));

        tblApprovedRequests.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblApprovedRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food Type", "Food expiry Date", "Sender", "Message", "Status", "Sent To"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblApprovedRequests);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Approved Requests", jPanel2);

        jPanel3.setBackground(new java.awt.Color(25, 118, 242));

        tblDisapprovedRequests.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblDisapprovedRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food Type", "Food expiry Date", "Sender", "Message", "Status", "Sent To"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblDisapprovedRequests);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 152, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Disapproved Requests", jPanel3);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 116, 1537, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 520, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDisApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisApproveActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFoodStandardSupervisorWorkRequest.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select the row from the table.");
            return;
        }

        FoodStandardWorkRequest request= (FoodStandardWorkRequest)  tblFoodStandardSupervisorWorkRequest.getValueAt(selectedRow, 0);
        request.setStatus("To be dumped");
        request.setSentTo("Trash");
        // request.setSender(account);
        request.setStandardSupervisor(account);
        request.setMessage("This food cannnot be consumed");
        populateApprovedRequestTable();
        populateNewRequestTable();
        populateDisapprovedRequestTable();
        JOptionPane.showMessageDialog(null, "Donated food cannot be consumed. Kindly send it to Waste Management Authority");
    }//GEN-LAST:event_btnDisApproveActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFoodStandardSupervisorWorkRequest.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select the row from the table.");
            return;
        }

        FoodStandardWorkRequest request= (FoodStandardWorkRequest)  tblFoodStandardSupervisorWorkRequest.getValueAt(selectedRow, 0);
        request.setStatus("Approved");
        request.setSentTo("Food Distribution Authority");   
        request.setStandardSupervisor(account);
        request.setMessage("This food can be consumed");
        FoodDistributionWorkRequest foodDistributionWorkRequest = new FoodDistributionWorkRequest();
        foodDistributionWorkRequest.setFood(request.getFood());
        foodDistributionWorkRequest.setMessage("Consumable Food");       
        
        foodDistributionWorkRequest.setSender(request.getSender());
        
        foodDistributionWorkRequest.setStandardSupervisor(account);
        foodDistributionWorkRequest.setStatus("To be distributed");
        foodDistributionWorkRequest.setResidentEmployee(request.getResidentEmployee());
      
        Organization org = community.getFoodDistributionOrganization();
        org.getWorkQueue().getWorkRequestArrayList().add(foodDistributionWorkRequest);
        populateApprovedRequestTable();
        populateNewRequestTable();
        populateDisapprovedRequestTable();
        JOptionPane.showMessageDialog(null, "Sent to Food Distribution Authority");
    }//GEN-LAST:event_btnApproveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnDisApprove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblApprovedRequests;
    private javax.swing.JTable tblDisapprovedRequests;
    private javax.swing.JTable tblFoodStandardSupervisorWorkRequest;
    // End of variables declaration//GEN-END:variables
}
