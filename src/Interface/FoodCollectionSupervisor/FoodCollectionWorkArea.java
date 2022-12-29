/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.FoodCollectionSupervisor;
import org.apache.commons.lang3.StringUtils;
import Business.Community.Community;
import Business.Employee.Employee;
import Business.Employee.FoodCollectionDriverEmployee;
import Business.Employee.FoodCollectionSupervisorEmployee;
import Business.Organization.FoodCollectionOrganization;
import Business.Roles.FoodCollectionDriverRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoodCollectionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
//import org.jfree.util.StringUtils;

/**
 *
 * @author vrushaliphaltankar
 */
public class FoodCollectionWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form FoodCollectionWorkArea
     */
    private JPanel userProcessContainer;
    private UserAccount account ;
    private Community community;
    private FoodCollectionOrganization organization;
    private FoodCollectionSupervisorEmployee empSupervisor;

    public FoodCollectionWorkArea(JPanel userProcessContainer,UserAccount account) {
        
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        
        community =  account.getEmployee().getCommunityAssociated();
        empSupervisor =  (FoodCollectionSupervisorEmployee)  account.getEmployee();
        organization = (FoodCollectionOrganization) community.getFoodCollectionOrganization();
        
        populateNewRequestTable();
        populateAssignedRequestTable();
        populateCompletedRequestTable();
        populateCombobox();
        populateDriverUseraccount();
        lbErrlEmpName.setVisible(false);
        lblErrAddress.setVisible(false);
        lblPassword.setVisible(false);
        lblUsername.setVisible(false);
        jScrollPane6.setVisible(false);
        tblNewRequest.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        tblAssignedRequests.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        tblCompletedRequests.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        tblDriverUserAccount.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        
    }
    
    
     public String sendGet(String url) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
               // String s =con.getResponseMessage();
                
                
                
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
                
                //s = response.toString().substring(0, response.toString().length()-1);
                
		in.close();

		//print result
		System.out.println(response.toString());
                
                return response.toString();

	}

    
    
    private void populateDriverUseraccount(){
        
         DefaultTableModel model = (DefaultTableModel) tblDriverUserAccount.getModel();
         model.setRowCount(0);
        

                for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountArrayList()) {
                        Object row[] = new Object[2];
                        row[0] = ua;
                        row[1] = ua.getRole();
                        model.addRow(row);
            }  
    
    }  
    
      private void populateNewRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblNewRequest.getModel();
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestArrayList()){
            //request = (FoodCollectionWorkRequest) request;
           if(request.getStatus().equalsIgnoreCase("New Request")){
               
                    Object[] row = new Object[7];
                    row[0] = ((FoodCollectionWorkRequest) request);
                    row[1] = ((FoodCollectionWorkRequest) request).getFood().getFoodType();
                    row[2] = ((FoodCollectionWorkRequest) request).getSender().getEmployee();
                    row[3] = ((FoodCollectionWorkRequest) request).getFood().getFoodPriority();
                    row[4] = ((FoodCollectionWorkRequest) request).getSender().getEmployee().getAddress();
                    row[5] = ((FoodCollectionWorkRequest) request).getDriverName();
                    row[6] =  request.getStatus();
                    model.addRow(row);
            }
            
         }
        
    }    

       private void populateAssignedRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblAssignedRequests.getModel();
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestArrayList()){
            //request = (FoodCollectionWorkRequest) request;
            if(request.getStatus().equalsIgnoreCase("Pending for pickup")){
                    Object[] row = new Object[7];
                    row[0] = ((FoodCollectionWorkRequest) request);
                    row[1] = ((FoodCollectionWorkRequest) request).getFood().getFoodType();
                    row[2] = ((FoodCollectionWorkRequest) request).getSender().getEmployee().getName();
                    row[3] = ((FoodCollectionWorkRequest) request).getFood().getFoodPriority();
                    row[4] = ((FoodCollectionWorkRequest) request).getSender().getEmployee().getAddress();
                    row[5] = ((FoodCollectionWorkRequest) request).getDriverName();
                    row[6] =  request.getStatus();
                    model.addRow(row);
            }
            
         }
        
    }

       
    private void populateCompletedRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblCompletedRequests.getModel();
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestArrayList()){
            //request = (FoodCollectionWorkRequest) request;
            if(request.getStatus().equalsIgnoreCase("Food Delivered to Standard Authority")){
                    Object[] row = new Object[7];
                    row[0] = ((FoodCollectionWorkRequest) request);
                    row[1] = ((FoodCollectionWorkRequest) request).getFood().getFoodType();
                    row[2] = ((FoodCollectionWorkRequest) request).getSender().getEmployee();
                    row[3] = ((FoodCollectionWorkRequest) request).getFood().getFoodPriority();
                    row[4] = ((FoodCollectionWorkRequest) request).getSender().getEmployee().getAddress();
                    row[5] = ((FoodCollectionWorkRequest) request).getDriverName();
                    row[6] =  request.getStatus();
                    model.addRow(row);
            }
            
         }
        
    }    
    
    
    
    
    
    
    private void populateCombobox(){
        
        cboDriverList.removeAllItems();
        for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountArrayList()){
            
            if (ua.getEmployee() instanceof FoodCollectionDriverEmployee){
                if(!((FoodCollectionDriverEmployee)ua.getEmployee()).isIsBusy()){
                   cboDriverList.addItem(ua);
               }                 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNewRequest = new javax.swing.JTable();
        cboDriverList = new javax.swing.JComboBox();
        lblDriver = new javax.swing.JLabel();
        btnAssignRequest = new javax.swing.JButton();
        btnFindingDrivers = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblRecommendationDriver = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAssignedRequests = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCompletedRequests = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCurrentAddress = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPasseord = new javax.swing.JTextField();
        lbErrlEmpName = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblErrAddress = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDriverUserAccount = new javax.swing.JTable();
        btnBack1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(25, 118, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Food Collection Supervisor Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        jTabbedPane1.setBackground(new java.awt.Color(25, 118, 242));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(25, 118, 242));

        tblNewRequest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblNewRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food Type", "Donor Name", "Priority", "Donar Address", "Assigned To", "Status"
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
        jScrollPane1.setViewportView(tblNewRequest);

        cboDriverList.setBackground(new java.awt.Color(25, 118, 242));
        cboDriverList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblDriver.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblDriver.setForeground(new java.awt.Color(255, 255, 255));
        lblDriver.setText("Select Driver:");

        btnAssignRequest.setBackground(new java.awt.Color(25, 118, 242));
        btnAssignRequest.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnAssignRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnAssignRequest.setText("Assign Request");
        btnAssignRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignRequestActionPerformed(evt);
            }
        });

        btnFindingDrivers.setBackground(new java.awt.Color(25, 118, 242));
        btnFindingDrivers.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnFindingDrivers.setForeground(new java.awt.Color(255, 255, 255));
        btnFindingDrivers.setText("Recommendation for closest agent");
        btnFindingDrivers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindingDriversActionPerformed(evt);
            }
        });

        tblRecommendationDriver.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblRecommendationDriver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Driver Name", "Driver Current Location", "Distance (in miles)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRecommendationDriver.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tblRecommendationDriver);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDriver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboDriverList, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnAssignRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFindingDrivers))
                        .addGap(0, 738, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDriverList, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssignRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnFindingDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("View New Requests", jPanel1);

        jPanel2.setBackground(new java.awt.Color(25, 118, 242));

        tblAssignedRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food Type", "Donor Name", "Priority", "Donar Address", "Assigned To", "Status"
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
        jScrollPane2.setViewportView(tblAssignedRequests);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1811, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(367, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Assigned Requests", jPanel2);

        jPanel3.setBackground(new java.awt.Color(25, 118, 242));

        tblCompletedRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food Type", "Donor Name", "Priority", "Donar Address", "Assigned To", "Status"
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
        jScrollPane3.setViewportView(tblCompletedRequests);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(367, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Completed Requests", jPanel3);

        jPanel4.setBackground(new java.awt.Color(25, 118, 242));
        jPanel4.setForeground(new java.awt.Color(255, 0, 0));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee Name:");

        txtFullName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFullNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Current Address :");

        txtCurrentAddress.setColumns(20);
        txtCurrentAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCurrentAddress.setRows(5);
        jScrollPane4.setViewportView(txtCurrentAddress);

        btnSubmit.setBackground(new java.awt.Color(25, 118, 242));
        btnSubmit.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Add Driver");
        btnSubmit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username :");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password :");

        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtPasseord.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPasseord.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                txtPasseordAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtPasseord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasseordActionPerformed(evt);
            }
        });

        lbErrlEmpName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbErrlEmpName.setForeground(new java.awt.Color(255, 0, 0));
        lbErrlEmpName.setText("errMessage");

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 0, 0));
        lblUsername.setText("errMessage");

        lblErrAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblErrAddress.setForeground(new java.awt.Color(255, 0, 0));
        lblErrAddress.setText("errMessage");

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 0, 0));
        lblPassword.setText("errMessage");

        tblDriverUserAccount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblDriverUserAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "User Name", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblDriverUserAccount);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtFullName, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbErrlEmpName)
                                    .addComponent(lblErrAddress))
                                .addGap(176, 176, 176)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPasseord, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(lblUsername))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(lblPassword))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(244, 620, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbErrlEmpName)
                        .addComponent(jLabel5)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUsername))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtPasseord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPassword)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4)))
                        .addGap(65, 65, 65)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErrAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Drivers", jPanel4);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 89, 1831, 570));

        btnBack1.setBackground(new java.awt.Color(25, 118, 242));
        btnBack1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnBack1.setForeground(new java.awt.Color(255, 255, 255));
        btnBack1.setText("BACK");
        btnBack1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });
        add(btnBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 550, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblNewRequest.getSelectedRow();
       
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select the row from the table.");
            return;
        }
        
        FoodCollectionWorkRequest request = (FoodCollectionWorkRequest) tblNewRequest.getValueAt(selectedRow, 0);

        UserAccount empDriver = (UserAccount) cboDriverList.getSelectedItem();
        
        ((FoodCollectionDriverEmployee)empDriver.getEmployee()).setIsBusy(true);
        int freq = ((FoodCollectionDriverEmployee)empDriver.getEmployee()).getFrequency();
        //((FoodCollectionDriverEmployee)empDriver.getEmployee()).setFrequency(freq++); 
        ((FoodCollectionDriverEmployee)empDriver.getEmployee()).setFrequency(++freq); 
        request.setDriverName(empDriver.getEmployee().getName());
        request.setCollectorDriver(empDriver);
        request.setCollectorSupervisor(account);
        request.setStatus("Pending for pickup");
        request.setMessage("Kindly Collect the package and deliver to Food Standard Authority");
              
        populateNewRequestTable();
        populateAssignedRequestTable();
        populateCompletedRequestTable();
        populateCombobox();
        empDriver.getWorkQueue().getWorkRequestArrayList().add(request);
        
        
        JOptionPane.showMessageDialog(null, "Request send to " +empDriver.getUsername() );
    }//GEN-LAST:event_btnAssignRequestActionPerformed

    private void txtFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFullNameActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String name = "";
        String currentAddress = "";
        String userName = "";
        String password = "";
        name = txtFullName.getText().trim();
        currentAddress = txtCurrentAddress.getText();
        userName =txtUserName.getText().trim();
        password = txtPasseord.getText().trim();
        if(userName.isEmpty()){
           lblUsername.setText("UserName cannot be blank");
           lblUsername.setVisible(true);
           return;
        }
        if(password.isEmpty()){
           lblPassword.setText("Password cannot be blank");
           lblPassword.setVisible(true);
           return;
        }
        if(currentAddress.isEmpty()){
           lblErrAddress.setText("Current Address cannot be blank");
           lblErrAddress.setVisible(true);
           return;
        }
        if(name.isEmpty()){
           lbErrlEmpName.setText("UserName cannot be blank");
           lbErrlEmpName.setVisible(true);
           return;
        }
        FoodCollectionDriverEmployee empDriver = new FoodCollectionDriverEmployee();
        empDriver.setDriverCurrentAddress(currentAddress);
        empDriver.setDriverName(name);
        organization.getEmployeeDirectory().createEmployee(name, community, empDriver);
        organization.getUserAccountDirectory().createUserAccount(userName, password, empDriver, new FoodCollectionDriverRole());
        populateDriverUseraccount();
        txtCurrentAddress.setText("");
        txtFullName.setText("");
        txtPasseord.setText("");
        txtUserName.setText("");
        lblErrAddress.setText("");
        lblPassword.setText("");
        lblUsername.setText("");
        lbErrlEmpName.setText("");
        
        
        
        JOptionPane.showMessageDialog(null, "Driver added successfully in Food Collection Organization.");
        
        populateCombobox();
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtPasseordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasseordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasseordActionPerformed

    private void btnFindingDriversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindingDriversActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblNewRequest.getSelectedRow();
        int nearestMiles = 0;
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select the row from the table.");
            return;
        }
        
        btnAssignRequest.setEnabled(false);
        btnFindingDrivers.setName("Finding closest drivers...");
        
        btnFindingDrivers.setEnabled(false);        
       
        jScrollPane6.setVisible(true);
        FoodCollectionWorkRequest request = (FoodCollectionWorkRequest) tblNewRequest.getValueAt(selectedRow, 0);
        String pickupAddress = request.getSender().getEmployee().getAddress();
        DefaultTableModel model = (DefaultTableModel) tblRecommendationDriver.getModel();
        model.setRowCount(0);
        for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountArrayList()){
            Employee ee = ua.getEmployee();
            if( ee instanceof FoodCollectionDriverEmployee){
                try
                   {   
                       if(nearestMiles == 3){
                          break; 
                       }
                       
                        String driverCurrentLocation =  ((FoodCollectionDriverEmployee)(ee)).getDriverCurrentAddress();
                        String sourceAddress= pickupAddress;
                        String myKey ="AIzaSyDxQT-LVz0VhlZN_4FZ4NaKoa63zeGIge0";

                        driverCurrentLocation = driverCurrentLocation.replace(" ", "+");
                        sourceAddress = sourceAddress.replace(" ", "+");

                        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=#ORIGIN&destinations=#DESTINATION&mode=driving&units=imperial&language=fr-FR&key=#KEY";
                        url = url.replace("#ORIGIN", driverCurrentLocation);
                        url = url.replace("#DESTINATION", sourceAddress);
                        url = url.replace("#KEY", myKey);

                       // HttpURLConnectionExample http = new HttpURLConnectionExample();

                       // System.out.println("Testing 1 - Send Http GET request");
                        String json = sendGet(url);

                        String a=  StringUtils.substringBefore(json, "miles");
                        String b = StringUtils.substringAfterLast(a, "\"");
                        b=b.replace(",", ".");
                        String distance = b + "miles";    
                            //System.out.println("Distance : " + b +" miles.");
                        
                        Double bInMiles = Double.parseDouble(b);
                        if (bInMiles < 2.0 ){
                            nearestMiles ++;
                        }
                             

                            Object[] row = new Object[3];
                            row[0] = ua.getEmployee().getName();
                            row[1] = ((FoodCollectionDriverEmployee)(ee)).getDriverCurrentAddress();
                            row[2] = distance;
                             
                            model.addRow(row);
     
                        }
                        catch(Exception e)
                        {
                            System.out.println("Message :" + e.getMessage());
                        }
            }
            
        }
        
        btnAssignRequest.setEnabled(true);
        btnFindingDrivers.setName("Recommendation for closest driver >>");
        btnFindingDrivers.setEnabled(true);
       
        
        
    }//GEN-LAST:event_btnFindingDriversActionPerformed

    private void txtPasseordAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtPasseordAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasseordAncestorMoved

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBack1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignRequest;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnFindingDrivers;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox cboDriverList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbErrlEmpName;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JLabel lblErrAddress;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblAssignedRequests;
    private javax.swing.JTable tblCompletedRequests;
    private javax.swing.JTable tblDriverUserAccount;
    private javax.swing.JTable tblNewRequest;
    private javax.swing.JTable tblRecommendationDriver;
    private javax.swing.JTextArea txtCurrentAddress;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPasseord;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
