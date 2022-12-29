/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CommunityAdminWorkArea;

import Business.City.City;
import Business.Community.Community;
import Business.Employee.ResidentEmployee;
import Business.Employee.FoodCollectionDriverEmployee;
import Business.Employee.FoodCollectionSupervisorEmployee;
import Business.Employee.FoodDistributionSupervisorEmployee;
import Business.Employee.FoodStandardSupervisorEmployee;
import Business.Employee.RestaurantEmployee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FoodManagementEnterprise;
import Business.FoodProvider.FridgeSimulation;
import Business.Organization.ResidentOrganization;
import Business.Organization.FoodCollectionOrganization;
import Business.Organization.FoodDistributionOrganization;
import Business.Organization.FoodStandardOrganization;
import Business.Organization.Organization;
import Business.Organization.RestaurantOrganization;
import Business.Roles.FoodCollectionDriverRole;
import Business.Roles.FoodDistributionAdminRole;
import Business.Roles.FoodStandardAdminRole;
import Business.Roles.Role;
import Business.FoodProvider.Food;
import Business.FoodProvider.FridgeSimulation;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

////////// EMAIL IMPORTS
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vrushaliphaltankar
 */
public class ManageUserAccount extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccount
     */
    private JPanel userProcessContainer;
    private FoodManagementEnterprise enterprise;
    private Community community;
    private FridgeSimulation simulator;
    
    public ManageUserAccount(JPanel userProcessContainer,Enterprise enterprise,Community community) {
        initComponents();
        this.userProcessContainer =userProcessContainer;
        this.enterprise = (FoodManagementEnterprise) enterprise; 
        this.community=community;
        lblErrAddress.setVisible(false);
        lblErrEmailID.setVisible(false);
        lblErrEmpName.setVisible(false);
        lblErrPass.setVisible(false);
        lblErrUsername.setVisible(false);
        populateOrganizationCombobox();
        popTableData();
        simulator = new FridgeSimulation();
    }
    
    
     public boolean isValidEmailAddress(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
    }
    
    
    private void popTableData() {

        DefaultTableModel model = (DefaultTableModel) tblUserAccount.getModel();

        model.setRowCount(0);
        
        
        
        for(int i =0 ; i< cboOrganization.getItemCount() ; i++ ){
            Organization org = (Organization) cboOrganization.getItemAt(i);
             for (UserAccount ua : org.getUserAccountDirectory().getUserAccountArrayList()) {
                Object row[] = new Object[2];
                row[0] = ua;
                row[1] = ua.getRole();
                ((DefaultTableModel) tblUserAccount.getModel()).addRow(row);
            }            
        }
        

//        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
//            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
//                Object row[] = new Object[2];
//                row[0] = ua;
//                row[1] = ua.getRole();
//                ((DefaultTableModel) tblUserAccount.getModel()).addRow(row);
//            }
//        }
    }
    
    public void populateOrganizationCombobox(){
        
        cboOrganization.removeAllItems();
         cboOrganization.addItem(community.getResidentOrganization());
         cboOrganization.addItem(community.getFoodCollectionOrganization());
         cboOrganization.addItem(community.getFoodDistributionOrganization());
         cboOrganization.addItem(community.getFoodStandardOrganization());
         cboOrganization.addItem(community.getRestaurantOrganization());
    }
    
  private void populateRoleComboBox(Organization organization){
        cboRole.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            cboRole.addItem(role);
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

        btnback = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        cboOrganization = new javax.swing.JComboBox();
        txtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cboRole = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUserAccount = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmployeeName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        lblErrAddress = new javax.swing.JLabel();
        lblErrUsername = new javax.swing.JLabel();
        lblErrEmpName = new javax.swing.JLabel();
        lblErrPass = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtEmailID = new javax.swing.JTextField();
        lblErrEmailID = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(25, 118, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnback.setBackground(new java.awt.Color(25, 118, 242));
        btnback.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnback.setForeground(new java.awt.Color(255, 255, 255));
        btnback.setText("BACK");
        btnback.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnback.setPreferredSize(new java.awt.Dimension(50, 26));
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 112, 40));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Organization");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        btnCreate.setBackground(new java.awt.Color(25, 118, 242));
        btnCreate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("CREATE");
        btnCreate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 190, 110, 50));

        cboOrganization.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboOrganizationActionPerformed(evt);
            }
        });
        add(cboOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 260, -1));

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 260, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        cboRole.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(cboRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 260, -1));

        tblUserAccount.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tblUserAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUserAccount);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 79, 964, 90));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, -1, -1));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 260, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Role");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Manage User Account");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        txtEmployeeName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmployeeName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmployeeNameFocusLost(evt);
            }
        });
        add(txtEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 260, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, -1, -1));

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddress.setRows(5);
        txtAddress.setEnabled(false);
        jScrollPane2.setViewportView(txtAddress);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 260, 80));

        lblErrAddress.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblErrAddress.setForeground(new java.awt.Color(255, 0, 51));
        lblErrAddress.setText("errorMessage");
        add(lblErrAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 260, -1, 20));

        lblErrUsername.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblErrUsername.setForeground(new java.awt.Color(255, 0, 51));
        lblErrUsername.setText("errorMessage");
        add(lblErrUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, -1));

        lblErrEmpName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblErrEmpName.setForeground(new java.awt.Color(255, 0, 51));
        lblErrEmpName.setText("errorMessage");
        add(lblErrEmpName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 200, -1, -1));

        lblErrPass.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblErrPass.setForeground(new java.awt.Color(255, 0, 51));
        lblErrPass.setText("errorMessage");
        add(lblErrPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 380, -1, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Email ID");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        txtEmailID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtEmailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 260, -1));

        lblErrEmailID.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblErrEmailID.setForeground(new java.awt.Color(255, 0, 51));
        lblErrEmailID.setText("errorMessage");
        add(lblErrEmailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        jButton1.setBackground(new java.awt.Color(25, 118, 242));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("DELETE");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 310, 110, 50));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 270, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String userName = txtUsername.getText();
        String password = txtPassword.getText();
        Role role = (Role) cboRole.getSelectedItem();
        Organization organization = (Organization) cboOrganization.getSelectedItem();
        String name = txtEmployeeName.getText();
        String address = txtAddress.getText();
        
        if(userName.isEmpty()){
            lblErrUsername.setText("UserName cannot be blank");
            lblErrUsername.setVisible(true);
            return;
        }
        
            Pattern p = Pattern.compile("^[a-zA-Z0-9\\s]+");
            Matcher m = p.matcher(userName);  
            if(!m.matches())
            {
                JOptionPane.showMessageDialog(null, "Invalid User Name");
			return;
            }
        
        if(password.isEmpty()){
            lblErrPass.setText("Password cannot be blank");
            lblErrPass.setVisible(true);
            return;
        }
        
             p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
            m = p.matcher(password);  
            if(!m.matches())
            {
                JOptionPane.showMessageDialog(null, "Password should contain atleast One Uppercase, one Lowercase, a number and a special character");
            
            return;
            }
        if(name.isEmpty()){
            lblErrEmpName.setText("Employee Name cannot be blank");
            lblErrEmpName.setVisible(true);
            return;
        }
        
            p = Pattern.compile("^[a-zA-Z \\s]+");
            m = p.matcher(name);  
            if(!m.matches())
            {
                JOptionPane.showMessageDialog(null, "Invalid Name");
			return;
            }
        if(address.isEmpty()){
            lblErrAddress.setText("Address cannot be blank");
            lblErrAddress.setVisible(true);
            return;
        }
        
        p = Pattern.compile("^[a-zA-Z,0-9 \\s]+");
            m = p.matcher(address);  
            if(!m.matches())
            {
                JOptionPane.showMessageDialog(null, "Invalid Address");
			return;
            }
            
        if(txtEmailID.getText().isEmpty()){
            lblErrEmailID.setText("Email cannot be blank");
            lblErrEmailID.setVisible(true);
            return;
        }
        if(!isValidEmailAddress(txtEmailID.getText().trim())){
            lblErrEmailID.setText("Please enter the Email ID in proper format");
            lblErrEmailID.setVisible(true);
            return;
        }
       
        if(organization instanceof ResidentOrganization){
            ResidentEmployee ee = new ResidentEmployee();
            ee.setName(name);
            ee.setCommunityAssociated(community);            
            ee.setAddress(address);
            ee.setEmailID(txtEmailID.getText());
            organization.getEmployeeDirectory().createEmployee(name, community, ee);  
            organization.getUserAccountDirectory().createUserAccount(userName, password, ee, role);           
            ArrayList<Food> foodItems =  simulator.generateFoodData(5);
             for(Food item: foodItems){
                 ee.getFoodDirectory().addFood(item);
             }
        }
        
        else if(organization instanceof FoodCollectionOrganization){  
            if(role instanceof FoodCollectionDriverRole){
                FoodCollectionDriverEmployee ee = new FoodCollectionDriverEmployee();
                organization.getEmployeeDirectory().createEmployee(name, community, ee);   
                organization.getUserAccountDirectory().createUserAccount(userName, password, ee, role);
            }
            else {
                FoodCollectionSupervisorEmployee ee = new FoodCollectionSupervisorEmployee();
                organization.getEmployeeDirectory().createEmployee(name, community, ee);
                organization.getUserAccountDirectory().createUserAccount(userName, password, ee, role);
            }
            
        }
        else if(organization instanceof FoodDistributionOrganization){
            if(role instanceof FoodDistributionAdminRole){
                FoodDistributionSupervisorEmployee ee = new FoodDistributionSupervisorEmployee();
                organization.getEmployeeDirectory().createEmployee(name, community, ee);        
                organization.getUserAccountDirectory().createUserAccount(userName, password, ee, role);
            }                      
        }
        else if(organization instanceof FoodStandardOrganization){
            if(role instanceof FoodStandardAdminRole){
                FoodStandardSupervisorEmployee ee = new FoodStandardSupervisorEmployee();
                organization.getEmployeeDirectory().createEmployee(name, community, ee);      
                organization.getUserAccountDirectory().createUserAccount(userName, password, ee, role);
            }                 
        }
        else if(organization instanceof RestaurantOrganization){
            RestaurantEmployee ee = new RestaurantEmployee();
            ee.setName(name);
            ee.setCommunityAssociated(community);            
            ee.setAddress(address);
            ee.setEmailID(txtEmailID.getText());
            organization.getEmployeeDirectory().createEmployee(name, community, ee);
            organization.getUserAccountDirectory().createUserAccount(userName, password, ee, role);
            ArrayList<Food> foodItems =  simulator.generateFoodData(10);
             for(Food item: foodItems){
                 ee.getFoodDirectory().addFood(item);
             }
            
        }        
        
        
        ///////////// EMAIL LOGIC START
        String ToEmail = txtEmailID.getText();
        String FromEmail = "yashp268742@gmail.com";
        String FromEmailPassword = "zmcgepozgdonrmnj";//You email Password from you want to send email
        String Subjects = "WELCOME TO FOOD DONATION";
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(FromEmail, FromEmailPassword);
            }
        });
        
        
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
            message.setSubject(Subjects);
            message.setText("Thank you for joining our food donation initiative. Your donations will help feed the poor and the needy.");
            Transport.send(message);
        }catch(Exception ex){
            System.out.println(""+ex);
        }
        
        ///////////// EMAIL LOGIC END

        
        
        popTableData();
        txtAddress.setText("");
        txtEmployeeName.setText("");
        txtPassword.setText("");
        txtUsername.setText("");
        txtEmailID.setText("");
        lblErrAddress.setText("");
        lblErrEmailID.setText("");
        lblErrEmpName.setText("");
        lblErrPass.setText("");
        lblErrUsername.setText("");
        JOptionPane.showMessageDialog(null, "User Account successfully made.");

    }//GEN-LAST:event_btnCreateActionPerformed

    private void cboOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboOrganizationActionPerformed
        Organization organization = (Organization) cboOrganization.getSelectedItem();
        if (organization != null){
            populateRoleComboBox(organization);

            if(organization instanceof ResidentOrganization || organization instanceof RestaurantOrganization){
                txtAddress.setEnabled(true); 
                txtEmailID.setEnabled(true);
                
            }
            else {
                txtAddress.setEnabled(false);
                txtEmailID.setEnabled(false);
            }

        }
    }//GEN-LAST:event_cboOrganizationActionPerformed

    private void txtEmployeeNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmployeeNameFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtEmployeeNameFocusLost

    private void txtEmailIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailIDActionPerformed

    private void cboRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboRoleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = tblUserAccount.getSelectedRow();
		if (row < 0)
		{
			JOptionPane.showMessageDialog(null, "Please select User");
			return;
		}
		
		UserAccount tempUA = null;
                
                DefaultTableModel model = (DefaultTableModel) tblUserAccount.getModel();
		String username = model.getValueAt(row, 0).toString();
                
                Organization tempOrg = null;
                
                for(int i =0 ; i< cboOrganization.getItemCount() ; i++ ){
                    Organization org = (Organization) cboOrganization.getItemAt(i);
             for (UserAccount ua : org.getUserAccountDirectory().getUserAccountArrayList()) {
                if(username.equalsIgnoreCase(ua.getUsername()))
                {
                    tempOrg = org;
                    tempUA = ua;
                }
            }            
        }
                
               tempOrg.getUserAccountDirectory().getUserAccountArrayList().remove(tempUA);
                popTableData();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnback;
    private javax.swing.JComboBox cboOrganization;
    private javax.swing.JComboBox cboRole;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblErrAddress;
    private javax.swing.JLabel lblErrEmailID;
    private javax.swing.JLabel lblErrEmpName;
    private javax.swing.JLabel lblErrPass;
    private javax.swing.JLabel lblErrUsername;
    private javax.swing.JTable tblUserAccount;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtEmailID;
    private javax.swing.JTextField txtEmployeeName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
