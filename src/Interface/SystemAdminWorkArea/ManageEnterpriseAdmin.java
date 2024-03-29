/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.SystemAdminWorkArea;

import Business.City.City;
import Business.Community.Community;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Employee.FoodEnterpriseAdminEmployee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FoodManagementEnterprise;
import Business.Roles.FoodEnterpriseAdminRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vrushaliphaltankar
 */
public class ManageEnterpriseAdmin extends javax.swing.JPanel {

    /**
     * Creates new form ManageEnterpriseAdmin
     */
    private JPanel userProcessContainer;
    private EcoSystem system;

    public ManageEnterpriseAdmin(JPanel userProcessContainer,EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateTable();
        populateCityComboBox();
        lblErrUsername.setVisible(false);
        lblErrPass.setVisible(false);
        lblErrName.setVisible(false);
        tblEnterpriseAdmin.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));

    }


    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblEnterpriseAdmin.getModel();

        model.setRowCount(0);
        for (City city : system.getCitiesList()) {
            for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseArrayList()) {
                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountArrayList()) {
                    Object[] row = new Object[3];
                    row[0] = enterprise.getName();
                    row[1] = city.getName();
                    row[2] = userAccount.getUsername();

                    model.addRow(row);
                }
            }
        }
    }

    private void populateCityComboBox(){
        cboCity.removeAllItems();

        for (City city : system.getCitiesList()){
            cboCity.addItem(city);
        }
    }

    private void populateEnterpriseComboBox(City city){
        cboEnterprise.removeAllItems();

        for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseArrayList()){
            cboEnterprise.addItem(enterprise);
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
        jLabel2 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboEnterprise = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEnterpriseAdmin = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        cboCity = new javax.swing.JComboBox();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblErrUsername = new javax.swing.JLabel();
        lblErrPass = new javax.swing.JLabel();
        lblErrName = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Enterprise Admin");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Username");

        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Enterprise");

        cboEnterprise.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEnterpriseActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Password");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tblEnterpriseAdmin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblEnterpriseAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise Name", "City", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEnterpriseAdmin);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Name");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("City");

        cboCity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboCity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCityActionPerformed(evt);
            }
        });

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblErrUsername.setForeground(java.awt.Color.red);
        lblErrUsername.setText("jLabel7");

        lblErrPass.setForeground(java.awt.Color.red);
        lblErrPass.setText("jLabel7");

        lblErrName.setForeground(java.awt.Color.red);
        lblErrName.setText("jLabel7");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Delete User");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(70, 70, 70)
                                .addComponent(cboCity, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel4)))
                                        .addGap(58, 58, 58))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel5)
                                        .addGap(84, 84, 84)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSubmit)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtUserName)
                                            .addComponent(cboEnterprise, 0, 170, Short.MAX_VALUE)
                                            .addComponent(txtPassword)
                                            .addComponent(txtName))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblErrUsername)
                                            .addComponent(lblErrName)
                                            .addComponent(lblErrPass)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(btnBack))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButton1)))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addComponent(cboEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblErrUsername)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblErrPass)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrName, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addComponent(btnSubmit)
                .addGap(38, 38, 38)
                .addComponent(btnBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCityActionPerformed

        City city = (City) cboCity.getSelectedItem();
        if (city != null){
            populateEnterpriseComboBox(city);
        }

    }//GEN-LAST:event_cboCityActionPerformed

    private void cboEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEnterpriseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEnterpriseActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        Enterprise enterprise = (Enterprise) cboEnterprise.getSelectedItem();
        Employee e = null;
        if (enterprise instanceof FoodManagementEnterprise){
            e = new FoodEnterpriseAdminEmployee();

        }
        else {

            //create employee for waste
        }

        String username = txtUserName.getText();
        String password = String.valueOf(txtPassword.getPassword());
        String name = txtName.getText();

        if(username.isEmpty() ){
            lblErrUsername.setText("User Name cannot be blank");
            lblErrUsername.setVisible(true);
            return;
        }
        
        
        Pattern p = Pattern.compile("^[a-z\\s]+");
        Matcher m = p.matcher(username);  
        if(!m.matches())
        {
            txtUserName.setText("");
            txtPassword.setText("");
            txtName.setText("");
            JOptionPane.showMessageDialog(null, "Invalid username");
            
            return;
        }
        
        if(password.isEmpty() ){
            lblErrPass.setText("Password cannot be blank");
            lblErrPass.setVisible(true);
            return;
        }
        
        p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
        m = p.matcher(password);  
        if(!m.matches())
        {
            txtUserName.setText("");
            txtPassword.setText("");
            txtName.setText("");
            JOptionPane.showMessageDialog(null, "Password should contain atleast One Uppercase, one Lowercase, a number and a special character");
            
            return;
        }
        
        if(name.isEmpty() ){
            
            txtName.setText("Name cannot be blank");
            txtName.setVisible(true);
            return;
        }
        
        p = Pattern.compile("^[a-zA-Z \\s]+");
        m = p.matcher(name);  
        if(!m.matches())
        {
             txtUserName.setText("");
            txtPassword.setText("");
            txtName.setText("");
            JOptionPane.showMessageDialog(null, "Invalid Name");
            
            return;
        }

        Employee employee = enterprise.getEmployeeDirectory().createEmployee(name,null,e);

        UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new FoodEnterpriseAdminRole() );
        populateTable();
        txtName.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        JOptionPane.showMessageDialog(null, "User account made successfully");

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkArea systemAdminwjp = (SystemAdminWorkArea) component;
        systemAdminwjp.populateJtree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = tblEnterpriseAdmin.getSelectedRow();
		if (row < 0)
		{
			JOptionPane.showMessageDialog(null, "Please select User");
			return;
		}
		
		UserAccount tempUA = null;
                Enterprise tempEnterprise = null;
                DefaultTableModel model = (DefaultTableModel) tblEnterpriseAdmin.getModel();
		String username = model.getValueAt(row, 2).toString();
                String EnterpriseName = model.getValueAt(row, 0).toString();
                
                for (City city : system.getCitiesList()) 
                {
            for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseArrayList())
                    {
                        if(enterprise.getName().equalsIgnoreCase(EnterpriseName))
                        {
                            tempEnterprise = enterprise;
                        }
                    }
                }
             
            for (UserAccount useraccount : tempEnterprise.getUserAccountDirectory().getUserAccountArrayList()){
                     if(username.equalsIgnoreCase(useraccount.getUsername()))
                        {
                            tempUA = useraccount;
                            break;
                        }
                
                }
               tempEnterprise.getUserAccountDirectory().getUserAccountArrayList().remove(tempUA);
                populateTable();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox cboCity;
    private javax.swing.JComboBox cboEnterprise;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrName;
    private javax.swing.JLabel lblErrPass;
    private javax.swing.JLabel lblErrUsername;
    private javax.swing.JTable tblEnterpriseAdmin;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
