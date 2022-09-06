/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package merge;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import misc.Login;
import misc.Registration;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author anime
 */
public class managerLayout extends javax.swing.JFrame {

    String managerId = "2022020001";
    DefaultTableModel model;
    String approvalUserType = "";
    String courseID = "";
    String batchId = "";
    String Status = "";
    String Name = "";
    Connection con;
    int rowIndx = -1, mrowIndx = -1, actvrowIndx = -1;
    DefaultTableModel mod, modaca, modachv, modskill, modroutine, modactiv, modhob;
    int infoNo = -1;
    String rId, weekDay;

    /**
     * Creates new form managerLayout
     */
    public managerLayout() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        rowIndx = -1;
        mrowIndx = -1;
        actvrowIndx = -1;
        populateProfile();
        studentName.setText(Name);
        userType.setText(Status);

    }

    public managerLayout(String id) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        managerId = id;

        rowIndx = -1;
        mrowIndx = -1;
        actvrowIndx = -1;
        populateProfile();
        studentName.setText(Name);
        userType.setText(Status);
    }

    public managerLayout(String mid,String tid) {
        initComponents();

        managerId = mid;
        
        rowIndx = -1;
        mrowIndx = -1;
        actvrowIndx = -1;
        populateProfile();
        studentName.setText(Name);
        userType.setText(Status);
        jTabbedPane1.setSelectedIndex(1);
        infoNo = 2;
        title.setText("Account Approval");

        buttonGroup1.clearSelection();

        approvalUserType = "TEACHER";
        setRecordsToTable("APPROVE");
        title.setText(approvalUserType + " Approval");
        teacherARadio.setSelected(true);

        approvalTableHider.setVisible(false);
        approvalTable.setVisible(true);
        approvalTable.getTableHeader().setVisible(true);
        searchLabel.setVisible(true);
        searchField.setVisible(true);
        approveButton.setVisible(true);
        DeleteApproveButton.setVisible(true);
        
    }
    
    public void setRecordsToTable(String operation) {
        if(operation == "APPROVE"){
            
            approveTableDesign("APPROVE");
            try {
                String quer = "";
                if (approvalUserType.equals("STUDENT")) {

                    quer = "SELECT S.student_id as ID,S.student_name as Name,S.student_phone as Phone,S.student_email as Email,S.student_admission_date as Admission_Date,C.course_name as Course, BA.batch_name as Batch, BR.branch_name\n"
                            + "FROM STUDENTS S\n"
                            + "INNER JOIN COURSES C ON C.course_id=S.course_id\n"
                            + "INNER JOIN BATCHS BA ON BA.batch_id=S.batch_id\n"
                            + "INNER JOIN BRANCHES BR ON BR.branch_id = S.branch_id\n"
                            + "WHERE S.student_reg_status = 'UNREGISTERED'";

                    ResultSet resultSet;
                    PreparedStatement statement = con.prepareStatement(quer);
                    resultSet = statement.executeQuery();
                    approvalTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                    approvalTable.setFillsViewportHeight(true);
                    model = (DefaultTableModel) approvalTable.getModel();
                    searchRecord("","APPROVE");
                    selectedApprovalID.setText("");


                } else if (approvalUserType.equals("TEACHER")) {

                    quer = "SELECT T.teacher_id as ID,T.teacher_name as Name,T.teacher_phone as Phone,T.teacher_email as Email,T.teacher_joining_date as Joining_Date,T.teacher_salary as Salary, BR.branch_name as Branch\n"
                            + "FROM TEACHERS T\n"
                            + "INNER JOIN BRANCHES BR ON BR.branch_id = T.branch_id\n"
                            + "WHERE T.teacher_reg_status = 'UNREGISTERED'";

                    ResultSet resultSet;
                    PreparedStatement statement = con.prepareStatement(quer);
                    resultSet = statement.executeQuery();
                    approvalTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                    approvalTable.setFillsViewportHeight(true);
                    model = (DefaultTableModel) approvalTable.getModel();
                    searchRecord("","APPROVE");
                    selectedApprovalID.setText("");


                }

            } catch (SQLException ex) {
                Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(operation == "INFORMATION"){
            
            approveTableDesign("INFORMATION");
            try {
                String quer = "";
                if (approvalUserType.equals("STUDENT")) {

                    quer = "SELECT S.student_id as ID,S.student_name as Name,S.student_phone as Phone,S.student_email as Email,S.student_admission_date as Admission_Date,C.course_name as Course, BA.batch_name as Batch, BR.branch_name\n"
                            + "FROM STUDENTS S\n"
                            + "INNER JOIN COURSES C ON C.course_id=S.course_id\n"
                            + "INNER JOIN BATCHS BA ON BA.batch_id=S.batch_id\n"
                            + "INNER JOIN BRANCHES BR ON BR.branch_id = S.branch_id\n"
                            + "WHERE S.student_reg_status = 'REGISTERED'";

                    ResultSet resultSet;
                    PreparedStatement statement = con.prepareStatement(quer);
                    resultSet = statement.executeQuery();
                    informationTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                    informationTable.setFillsViewportHeight(true);
                    model = (DefaultTableModel) informationTable.getModel();
                    searchRecord("","INFORMATION");
                    selectedinfoID.setText("");


                } else if (approvalUserType.equals("TEACHER")) {

                    quer = "SELECT T.teacher_id as ID,T.teacher_name as Name,T.teacher_phone as Phone,T.teacher_email as Email,T.teacher_joining_date as Joining_Date,T.teacher_salary as Salary, BR.branch_name as Branch\n"
                            + "FROM TEACHERS T\n"
                            + "INNER JOIN BRANCHES BR ON BR.branch_id = T.branch_id\n"
                            + "WHERE T.teacher_reg_status = 'REGISTERED'";

                    ResultSet resultSet;
                    PreparedStatement statement = con.prepareStatement(quer);
                    resultSet = statement.executeQuery();
                    informationTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                    informationTable.setFillsViewportHeight(true);
                    model = (DefaultTableModel) informationTable.getModel();
                    searchRecord("","INFORMATION");
                    selectedinfoID.setText("");


                }

            } catch (SQLException ex) {
                Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    public void approveRecord() {
        approveTableDesign("APPROVE");
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
             String SQL = "UPDATE " + approvalUserType + "S\n"
                            + "SET " + approvalUserType.toLowerCase() + "_reg_status = 'REGISTERED'\n"
                            + "WHERE " + approvalUserType.toLowerCase() + "_id = ?";

            PreparedStatement pstatement = con.prepareStatement(SQL);
            pstatement.setString(1, selectedApprovalID.getText());
            pstatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration successful!");
            selectedApprovalID.setText("");
            setRecordsToTable("APPROVE");
            
            

        } catch (SQLException ex) {
            Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteUserRecord(String operation) {
        approveTableDesign(operation);
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
             String SQL = "DELETE FROM " + approvalUserType + "S\n"
                            + "WHERE " + approvalUserType.toLowerCase() + "_id = ?";

            PreparedStatement pstatement = con.prepareStatement(SQL);
            if(operation == "APPROVE"){ 
                pstatement.setString(1, selectedApprovalID.getText());
            }else if(operation == "INFORMATION"){ 
                pstatement.setString(1, selectedinfoID.getText());
            }
            
            pstatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Delete successful!");
            if(operation == "APPROVE"){ 
                selectedApprovalID.setText("");
            }else if(operation == "INFORMATION"){ 
                selectedinfoID.setText("");
            }
            setRecordsToTable(operation);
            
            

        } catch (SQLException ex) {
            Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchRecord(String str, String operation) {
        if(operation == "APPROVE"){
            model = (DefaultTableModel) approvalTable.getModel();
            TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
            approvalTable.setRowSorter(trs);
            trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
        }else if(operation == "INFORMATION"){
            model = (DefaultTableModel) informationTable.getModel();
            TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
            informationTable.setRowSorter(trs);
            trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        profileButton = new javax.swing.JButton();
        approvalButton = new javax.swing.JButton();
        accountInfoButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        studentName = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        userType = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        mName = new javax.swing.JTextField();
        mPhone = new javax.swing.JTextField();
        mEmail = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        mBranch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bDistrict = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        mID = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        bArea = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        studentARadio = new javax.swing.JRadioButton();
        teacherARadio = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        searchLabel = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        approvalTableHider = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        approvalTable = new javax.swing.JTable();
        approveButton = new javax.swing.JButton();
        selectedIDALabel = new javax.swing.JLabel();
        selectedApprovalID = new javax.swing.JTextField();
        DeleteApproveButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        studentIRadio = new javax.swing.JRadioButton();
        teacherIRadio = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        searchLabel1 = new javax.swing.JLabel();
        searchField1 = new javax.swing.JTextField();
        infoTableHider = new javax.swing.JPanel();
        ViewLayout = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        sID = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        sPhone = new javax.swing.JTextField();
        sName = new javax.swing.JTextField();
        sEmail = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        sBranch = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        sArea = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        sBatch = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        sCourse = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        sAdmission = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        sStatus = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        informationTable = new javax.swing.JTable();
        ViewButton = new javax.swing.JButton();
        selectedIDALabel1 = new javax.swing.JLabel();
        selectedinfoID = new javax.swing.JTextField();
        infoDeleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1374, 792));
        jPanel1.setName(""); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1374, 792));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 50));

        jTabbedPane2.setBackground(new java.awt.Color(0, 153, 255));
        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel9.setBackground(new java.awt.Color(0, 153, 255));

        profileButton.setBackground(new java.awt.Color(0, 168, 247));
        profileButton.setFont(new java.awt.Font("Bahnschrift", 2, 18)); // NOI18N
        profileButton.setForeground(new java.awt.Color(255, 255, 255));
        profileButton.setText("Profile");
        profileButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        profileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        approvalButton.setBackground(new java.awt.Color(0, 168, 247));
        approvalButton.setFont(new java.awt.Font("Bahnschrift", 2, 18)); // NOI18N
        approvalButton.setForeground(new java.awt.Color(255, 255, 255));
        approvalButton.setText("Account Approval");
        approvalButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        approvalButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        approvalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approvalButtonActionPerformed(evt);
            }
        });

        accountInfoButton.setBackground(new java.awt.Color(0, 168, 247));
        accountInfoButton.setFont(new java.awt.Font("Bahnschrift", 2, 18)); // NOI18N
        accountInfoButton.setForeground(new java.awt.Color(255, 255, 255));
        accountInfoButton.setText("Account Information ");
        accountInfoButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        accountInfoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accountInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountInfoButtonActionPerformed(evt);
            }
        });

        returnButton.setBackground(new java.awt.Color(0, 168, 247));
        returnButton.setFont(new java.awt.Font("Bahnschrift", 2, 18)); // NOI18N
        returnButton.setForeground(new java.awt.Color(255, 255, 255));
        returnButton.setText("Logout");
        returnButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        returnButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        studentName.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        studentName.setForeground(new java.awt.Color(255, 255, 255));
        studentName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentName.setText("User Name");

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Welcome!");

        userType.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        userType.setForeground(new java.awt.Color(51, 255, 102));
        userType.setText("MANAGER");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(approvalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(userType))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userType)
                .addGap(42, 42, 42)
                .addComponent(profileButton)
                .addGap(46, 46, 46)
                .addComponent(approvalButton)
                .addGap(41, 41, 41)
                .addComponent(accountInfoButton)
                .addGap(197, 197, 197)
                .addComponent(returnButton)
                .addGap(186, 186, 186))
        );

        jTabbedPane2.addTab("tab3", jPanel9);

        jPanel2.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 360, 800));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 800));

        jPanel15.setBackground(new java.awt.Color(0, 168, 247));

        title.setFont(new java.awt.Font("Bahnschrift", 2, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Manager Profile");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(642, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(title)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 1030, 50));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setText("Name          :");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setText("E-mail       :");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel3.setText("Phone         :");

        jPanel7.setBackground(new java.awt.Color(0, 168, 247));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 168, 247));
        jLabel4.setText("Personal Infromation");

        mName.setEditable(false);
        mName.setBackground(new java.awt.Color(255, 255, 255));
        mName.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        mName.setBorder(null);

        mPhone.setEditable(false);
        mPhone.setBackground(new java.awt.Color(255, 255, 255));
        mPhone.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        mPhone.setBorder(null);

        mEmail.setEditable(false);
        mEmail.setBackground(new java.awt.Color(255, 255, 255));
        mEmail.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        mEmail.setBorder(null);

        editButton.setBackground(new java.awt.Color(0, 168, 247));
        editButton.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.setBorder(null);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 168, 247));
        jLabel5.setText("Branch Infromation");

        jPanel8.setBackground(new java.awt.Color(0, 168, 247));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel6.setText("Branch       :");

        mBranch.setEditable(false);
        mBranch.setBackground(new java.awt.Color(255, 255, 255));
        mBranch.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        mBranch.setBorder(null);

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setText("District       :");

        bDistrict.setEditable(false);
        bDistrict.setBackground(new java.awt.Color(255, 255, 255));
        bDistrict.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        bDistrict.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel10.setText("ID                :");

        mID.setBackground(new java.awt.Color(204, 204, 204));
        mID.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N

        save.setBackground(new java.awt.Color(0, 168, 247));
        save.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Save");
        save.setBorder(null);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(0, 168, 247));
        cancel.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.setBorder(null);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel11.setText("Area           :");

        bArea.setEditable(false);
        bArea.setBackground(new java.awt.Color(255, 255, 255));
        bArea.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        bArea.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bDistrict))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(bArea, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(mBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(142, 142, 142))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mID, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mName, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(editButton)
                    .addComponent(cancel)
                    .addComponent(save))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(mID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(mEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mBranch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(bArea)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(474, 474, 474))
        );

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(studentARadio);
        studentARadio.setText("Student");
        studentARadio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentARadioMouseClicked(evt);
            }
        });
        studentARadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentARadioActionPerformed(evt);
            }
        });
        jPanel4.add(studentARadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 23, -1, -1));

        buttonGroup1.add(teacherARadio);
        teacherARadio.setText("Teacher");
        teacherARadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherARadioActionPerformed(evt);
            }
        });
        jPanel4.add(teacherARadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 23, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel7.setText("Account Type :");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 24, -1, -1));

        searchLabel.setText("Search Area :");
        jPanel4.add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 25, -1, -1));

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        jPanel4.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 22, 286, -1));

        approvalTableHider.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout approvalTableHiderLayout = new javax.swing.GroupLayout(approvalTableHider);
        approvalTableHider.setLayout(approvalTableHiderLayout);
        approvalTableHiderLayout.setHorizontalGroup(
            approvalTableHiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        approvalTableHiderLayout.setVerticalGroup(
            approvalTableHiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel4.add(approvalTableHider, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 850, 400));

        approvalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        approvalTable.setFocusable(false);
        approvalTable.setGridColor(new java.awt.Color(204, 255, 255));
        approvalTable.setSelectionBackground(new java.awt.Color(0, 0, 255));
        approvalTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        approvalTable.setUpdateSelectionOnSort(false);
        approvalTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                approvalTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(approvalTable);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 80, 819, 555));

        approveButton.setText("Approve");
        approveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveButtonActionPerformed(evt);
            }
        });
        jPanel4.add(approveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 150, 110, -1));

        selectedIDALabel.setText("Current Selected ID:");
        jPanel4.add(selectedIDALabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, -1, -1));

        selectedApprovalID.setEditable(false);
        selectedApprovalID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedApprovalIDMouseClicked(evt);
            }
        });
        selectedApprovalID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedApprovalIDActionPerformed(evt);
            }
        });
        jPanel4.add(selectedApprovalID, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 110, -1));

        DeleteApproveButton.setText("Delete");
        DeleteApproveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteApproveButtonActionPerformed(evt);
            }
        });
        jPanel4.add(DeleteApproveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 190, 110, -1));

        jTabbedPane1.addTab("tab2", jPanel4);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup2.add(studentIRadio);
        studentIRadio.setText("Student");
        studentIRadio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentIRadioMouseClicked(evt);
            }
        });
        studentIRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIRadioActionPerformed(evt);
            }
        });
        jPanel11.add(studentIRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 23, -1, -1));

        buttonGroup2.add(teacherIRadio);
        teacherIRadio.setText("Teacher");
        teacherIRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherIRadioActionPerformed(evt);
            }
        });
        jPanel11.add(teacherIRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 23, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel12.setText("Account Type :");
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 24, -1, -1));

        searchLabel1.setText("Search Area :");
        jPanel11.add(searchLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 25, -1, -1));

        searchField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchField1KeyReleased(evt);
            }
        });
        jPanel11.add(searchField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 22, 286, -1));

        infoTableHider.setBackground(new java.awt.Color(255, 255, 255));
        infoTableHider.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Bahnschrift", 1, 22)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 168, 247));
        jLabel25.setText("Personal Information");

        jLabel26.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("ID                :");

        jLabel27.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Name          :");

        sID.setBackground(new java.awt.Color(204, 204, 204));
        sID.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Phone         :");

        sPhone.setEditable(false);
        sPhone.setBackground(new java.awt.Color(255, 255, 255));
        sPhone.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        sPhone.setBorder(null);

        sName.setEditable(false);
        sName.setBackground(new java.awt.Color(255, 255, 255));
        sName.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        sName.setBorder(null);

        sEmail.setEditable(false);
        sEmail.setBackground(new java.awt.Color(255, 255, 255));
        sEmail.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        sEmail.setBorder(null);

        jLabel29.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("E-mail       :");

        jLabel30.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jLabel30.setText("Branch       :");

        sBranch.setEditable(false);
        sBranch.setBackground(new java.awt.Color(255, 255, 255));
        sBranch.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        sBranch.setBorder(null);

        jLabel31.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jLabel31.setText("Area           :");

        sArea.setEditable(false);
        sArea.setBackground(new java.awt.Color(255, 255, 255));
        sArea.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        sArea.setBorder(null);

        jLabel32.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jLabel32.setText("Batch          :");

        sBatch.setEditable(false);
        sBatch.setBackground(new java.awt.Color(255, 255, 255));
        sBatch.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        sBatch.setBorder(null);

        jLabel33.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jLabel33.setText("Course                :");

        sCourse.setEditable(false);
        sCourse.setBackground(new java.awt.Color(255, 255, 255));
        sCourse.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        sCourse.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jLabel9.setText("Admission Date  :");

        sAdmission.setEditable(false);
        sAdmission.setBackground(new java.awt.Color(255, 255, 255));
        sAdmission.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        sAdmission.setBorder(null);

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jLabel13.setText("Status                 :");

        sStatus.setBackground(new java.awt.Color(255, 255, 255));
        sStatus.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Bahnschrift", 1, 22)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 168, 247));
        jLabel34.setText("Other Information");

        jPanel18.setBackground(new java.awt.Color(0, 168, 247));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel19.setBackground(new java.awt.Color(0, 168, 247));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewLayoutLayout = new javax.swing.GroupLayout(ViewLayout);
        ViewLayout.setLayout(ViewLayoutLayout);
        ViewLayoutLayout.setHorizontalGroup(
            ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewLayoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(245, 245, 245))
            .addGroup(ViewLayoutLayout.createSequentialGroup()
                .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewLayoutLayout.createSequentialGroup()
                        .addGap(475, 475, 475)
                        .addComponent(jLabel27))
                    .addGroup(ViewLayoutLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel30))
                    .addGroup(ViewLayoutLayout.createSequentialGroup()
                        .addGap(445, 445, 445)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(449, Short.MAX_VALUE))
            .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewLayoutLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ViewLayoutLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(ViewLayoutLayout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sID, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(sName, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addComponent(sEmail)))
                        .addGroup(ViewLayoutLayout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewLayoutLayout.createSequentialGroup()
                                    .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(ViewLayoutLayout.createSequentialGroup()
                                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(sArea, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(sBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18))
                                .addGroup(ViewLayoutLayout.createSequentialGroup()
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(sBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)))
                            .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(sAdmission, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                .addComponent(sCourse, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(ViewLayoutLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        ViewLayoutLayout.setVerticalGroup(
            ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewLayoutLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addGap(90, 90, 90)
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(210, 210, 210)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewLayoutLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jLabel25)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                    .addGap(18, 18, 18)
                    .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29)
                        .addComponent(sEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(89, 89, 89)
                    .addComponent(jLabel34)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)
                    .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sBranch)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(sAdmission)
                        .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sArea)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGap(20, 20, 20)
                    .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ViewLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(sStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(65, 65, 65)))
        );

        infoTableHider.add(ViewLayout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 830, 550));

        jPanel11.add(infoTableHider, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 850, 580));

        informationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        informationTable.setFocusable(false);
        informationTable.setGridColor(new java.awt.Color(204, 255, 255));
        informationTable.setSelectionBackground(new java.awt.Color(0, 0, 255));
        informationTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        informationTable.setUpdateSelectionOnSort(false);
        informationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                informationTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(informationTable);

        jPanel11.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 80, 819, 555));

        ViewButton.setText("View");
        ViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButtonActionPerformed(evt);
            }
        });
        jPanel11.add(ViewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 150, 110, -1));

        selectedIDALabel1.setText("Current Selected ID:");
        jPanel11.add(selectedIDALabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, -1, -1));

        selectedinfoID.setEditable(false);
        selectedinfoID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedinfoIDMouseClicked(evt);
            }
        });
        selectedinfoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedinfoIDActionPerformed(evt);
            }
        });
        jPanel11.add(selectedinfoID, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 110, -1));

        infoDeleteButton.setText("Delete");
        infoDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoDeleteButtonActionPerformed(evt);
            }
        });
        jPanel11.add(infoDeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 190, 110, -1));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab3", jPanel10);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 1010, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        // TODO add your handling code here:
        populateProfile();
        //viewActBtn.setEnabled(false);
        infoNo = 1;
    }//GEN-LAST:event_profileButtonActionPerformed

    private void approvalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approvalButtonActionPerformed
        // TODO add your handling code here:

        //populateSubjectsTable();
        //viewActBtn.setEnabled(false);
        jTabbedPane1.setSelectedIndex(1);
        infoNo = 2;
        title.setText("Account Approval");

        buttonGroup1.clearSelection();

        approvalTableHider.setVisible(true);
        approvalTable.getTableHeader().setVisible(false);
        approvalTable.setVisible(false);
        searchLabel.setVisible(false);
        searchField.setVisible(false);
        approveButton.setVisible(false);
        DeleteApproveButton.setVisible(false);


    }//GEN-LAST:event_approvalButtonActionPerformed

    private void accountInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountInfoButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        infoNo = 3;
        title.setText("Account Information");

        buttonGroup2.clearSelection();

        infoTableHider.setVisible(true);
        ViewLayout.setVisible(false);
        informationTable.getTableHeader().setVisible(false);
        informationTable.setVisible(false);
        searchLabel1.setVisible(false);
        searchField1.setVisible(false);
        ViewButton.setVisible(false);
        infoDeleteButton.setVisible(false);
    }//GEN-LAST:event_accountInfoButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
        //jTabbedPane1.setSelectedIndex(1);
        //populateProfile();
        dispose();
        new Login("MANAGER").setVisible(true);
    }//GEN-LAST:event_returnButtonActionPerformed

    private void DeleteApproveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteApproveButtonActionPerformed
        // TODO add your handling code here:
        if (selectedApprovalID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Select an Index from the table first!");
        } else {
            deleteUserRecord("APPROVE");
        }
    }//GEN-LAST:event_DeleteApproveButtonActionPerformed

    private void selectedApprovalIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedApprovalIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectedApprovalIDActionPerformed

    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
        // TODO add your handling code here:
        if (selectedApprovalID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Select an Index from the table first!");
        } else {
            approveRecord();
            //new SubjectAssign(managerId,selectedApprovalID.getText()).setVisible(true);
            //dispose();
        }
    }//GEN-LAST:event_approveButtonActionPerformed

    private void approvalTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approvalTableMouseClicked
        // TODO add your handling code here:
        
        try{
            int row = approvalTable.getSelectedRow();
            String ID = (approvalTable.getModel().getValueAt(row, 0).toString());
            selectedApprovalID.setText(ID);
            System.out.println(ID);
            
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null,"Select an Valid Index!");
        }
    }//GEN-LAST:event_approvalTableMouseClicked

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
        String search = searchField.getText();
        searchRecord(search,"APPROVE");
    }//GEN-LAST:event_searchFieldKeyReleased

    private void teacherARadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherARadioActionPerformed
        // TODO add your handling code here:
        approvalUserType = "TEACHER";
        setRecordsToTable("APPROVE");
        title.setText(approvalUserType + " Approval");
        teacherARadio.setSelected(true);

        approvalTableHider.setVisible(false);
        approvalTable.setVisible(true);
        approvalTable.getTableHeader().setVisible(true);
        searchLabel.setVisible(true);
        searchField.setVisible(true);
        approveButton.setVisible(true);
        DeleteApproveButton.setVisible(true);
    }//GEN-LAST:event_teacherARadioActionPerformed

    private void studentARadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentARadioActionPerformed
        // TODO add your handling code here:
        approvalUserType = "STUDENT";
        setRecordsToTable("APPROVE");
        title.setText(approvalUserType + " Approval");
        studentARadio.setSelected(true);

        approvalTableHider.setVisible(false);
        approvalTable.setVisible(true);
        approvalTable.getTableHeader().setVisible(true);
        searchLabel.setVisible(true);
        searchField.setVisible(true);
        approveButton.setVisible(true);
        DeleteApproveButton.setVisible(true);
    }//GEN-LAST:event_studentARadioActionPerformed

    private void studentARadioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentARadioMouseClicked
        // TODO add your handling code her
    }//GEN-LAST:event_studentARadioMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        populateProfile();
    }//GEN-LAST:event_cancelActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String name = mName.getText();
        String phone = mPhone.getText();
        String email = mEmail.getText();
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
            String quer = "UPDATE MANAGERS SET manager_name=?,manager_email=?,manager_phone=? WHERE manager_id=?";
            ResultSet resultSet;
            PreparedStatement pstatement = con.prepareStatement(quer);
            pstatement.setString(1, name);
            pstatement.setString(2, email);
            pstatement.setString(3, phone);
            pstatement.setString(4, managerId);
            pstatement.executeUpdate();
            String course = null, Batch = null, Branch = null;
            JOptionPane.showMessageDialog(this, "Successful!");
            populateProfile();
        } catch (SQLException ex) {
            Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        cancel.setVisible(true);
        save.setVisible(true);
        editButton.setVisible(false);
        mName.setEditable(true);
        mName.setBorder(new LineBorder(Color.decode("#0099FF"), 1));
        mPhone.setEditable(true);
        mPhone.setBorder(new LineBorder(Color.decode("#0099FF"), 1));
        mEmail.setEditable(true);
        mEmail.setBorder(new LineBorder(Color.decode("#0099FF"), 1));
    }//GEN-LAST:event_editButtonActionPerformed

    private void studentIRadioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentIRadioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIRadioMouseClicked

    private void studentIRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIRadioActionPerformed
        // TODO add your handling code here:
        approvalUserType = "STUDENT";
        setRecordsToTable("INFORMATION");
        title.setText(approvalUserType + " Information");
        studentIRadio.setSelected(true);

        infoTableHider.setVisible(false);
        informationTable.setVisible(true);
        informationTable.getTableHeader().setVisible(true);
        searchLabel1.setVisible(true);
        searchField1.setVisible(true);
        ViewButton.setVisible(true);
        infoDeleteButton.setVisible(true);
    }//GEN-LAST:event_studentIRadioActionPerformed

    private void teacherIRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherIRadioActionPerformed
        // TODO add your handling code here:
        approvalUserType = "TEACHER";
        setRecordsToTable("INFORMATION");
        title.setText(approvalUserType + " Information");
        teacherIRadio.setSelected(true);

        infoTableHider.setVisible(false);
        informationTable.setVisible(true);
        informationTable.getTableHeader().setVisible(true);
        searchLabel1.setVisible(true);
        searchField1.setVisible(true);
        ViewButton.setVisible(true);
        infoDeleteButton.setVisible(true);
    }//GEN-LAST:event_teacherIRadioActionPerformed

    private void searchField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchField1KeyReleased
        // TODO add your handling code here:
        String search = searchField1.getText();
        searchRecord(search,"INFORMATION");
    }//GEN-LAST:event_searchField1KeyReleased

    private void informationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informationTableMouseClicked
        // TODO add your handling code here:
        
        
        try{
            int row = informationTable.getSelectedRow();
            String ID = (informationTable.getModel().getValueAt(row, 0).toString());
            selectedinfoID.setText(ID);
            System.out.println(ID);    
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null,"Select an Valid Index!");
        }
    }//GEN-LAST:event_informationTableMouseClicked

    private void ViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewButtonActionPerformed
        // TODO add your handling code here:
        infoTableHider.setVisible(true);
        ViewLayout.setVisible(true);
        informationTable.getTableHeader().setVisible(false);
        informationTable.setVisible(false);
        if(approvalUserType == "STUDENT"){
            
             try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
            String quer = "SELECT * FROM STUDENTS WHERE student_id=?";
            ResultSet resultSet;
            PreparedStatement pstatement = con.prepareStatement(quer);
            String studentId = selectedinfoID.getText();
            pstatement.setString(1, studentId);
            resultSet = pstatement.executeQuery();
            String Branch = null;
            while(resultSet.next()) {
                studentId = resultSet.getString("student_id");
                sID.setText(studentId);
                Name = resultSet.getString("student_name");
                sName.setText(Name);
                sPhone.setText(resultSet.getString("student_phone"));
                sEmail.setText(resultSet.getString("student_email"));
                jLabel9.setText("Admission Date");
                sAdmission.setText(resultSet.getString("student_admission_date"));
                courseID = resultSet.getString("course_id");
                batchId = resultSet.getString("batch_id");
                Branch = resultSet.getString("branch_id");
                sStatus.setText(resultSet.getString("student_reg_status"));
                Status = resultSet.getString("student_reg_status");
            }

            quer = "SELECT * FROM BATCHS WHERE batch_id=?";
            pstatement = con.prepareStatement(quer);
            pstatement.setString(1, batchId);
            resultSet = pstatement.executeQuery();
            while(resultSet.next()) {
                sBatch.setText(resultSet.getString(2));
            }
            quer = "SELECT * FROM COURSES WHERE course_id=?";
            pstatement = con.prepareStatement(quer);
            pstatement.setString(1, courseID);
            resultSet = pstatement.executeQuery();
            while(resultSet.next()) {
                sCourse.setText(resultSet.getString(2));
            }
            quer = "SELECT * FROM BRANCHES WHERE branch_id=?";
            pstatement = con.prepareStatement(quer);
            pstatement.setString(1, Branch);
            resultSet = pstatement.executeQuery();
            while(resultSet.next()) {
                sBranch.setText(resultSet.getString(2));
                sArea.setText(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        } else if(approvalUserType == "TEACHER"){
            
             try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
            String quer = "SELECT T.teacher_id, T.teacher_name, T.teacher_phone, T.teacher_email, T.teacher_joining_date, T.teacher_reg_status, B.branch_id, B.branch_name\n"
                    + "FROM TEACHERS T\n"
                    + "LEFT JOIN BRANCHES B\n"
                    + "ON T.branch_id = B.branch_id\n"
                    + "WHERE T.teacher_id=?";
            ResultSet resultSet;
            PreparedStatement pstatement = con.prepareStatement(quer);
            String teacherId = selectedinfoID.getText();
            pstatement.setString(1, teacherId);
            resultSet = pstatement.executeQuery();
            String course = null, Batch = null, Branch = null;
            while (resultSet.next()) {
                sID.setText(resultSet.getString("teacher_id"));
                sName.setText(resultSet.getString("teacher_name"));
                sPhone.setText(resultSet.getString("teacher_phone"));
                sEmail.setText(resultSet.getString("teacher_email"));
                jLabel9.setText("Joining Date");
                sAdmission.setText(resultSet.getString("teacher_joining_date"));
                Branch = resultSet.getString("branch_name");
                sBranch.setText(resultSet.getString("branch_name") + " [ B_ID: " + resultSet.getString("branch_id") + " ]");
                sStatus.setText(resultSet.getString("teacher_reg_status"));
            }
            //quer = "SELECT course_id,subject_id, subject_name FROM SUBJECTS WHERE teacher_id = ?";
            quer = "SELECT C.course_id, S.subject_id, S.subject_name, C.course_name FROM SUBJECTS S FULL JOIN COURSES C ON S.course_id = C.course_id WHERE S.teacher_id = ?";
            pstatement = con.prepareStatement(quer);
            pstatement.setString(1, teacherId);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
                course = resultSet.getString("course_name");
                courseID = resultSet.getString("course_name");
                sCourse.setText(courseID +  " [ C_ID: " + resultSet.getString("course_id") + " ]");
                jLabel31.setText("Subject ID");
                sArea.setText(resultSet.getString("subject_id"));
                jLabel32.setText("Subject Name");
                sBatch.setText(resultSet.getString("subject_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
        
    }//GEN-LAST:event_ViewButtonActionPerformed

    private void selectedinfoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedinfoIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectedinfoIDActionPerformed

    private void infoDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoDeleteButtonActionPerformed
        // TODO add your handling code here:
        if (selectedinfoID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Select an Index from the table first!");
        } else {
            deleteUserRecord("INFORMATION");
        }
    }//GEN-LAST:event_infoDeleteButtonActionPerformed

    private void selectedinfoIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedinfoIDMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Select from the TABLE please!");
    }//GEN-LAST:event_selectedinfoIDMouseClicked

    private void selectedApprovalIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedApprovalIDMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Select from the TABLE please!");
    }//GEN-LAST:event_selectedApprovalIDMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        infoTableHider.setVisible(false);
        ViewLayout.setVisible(false);
        informationTable.getTableHeader().setVisible(true);
        informationTable.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(managerLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managerLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managerLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managerLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managerLayout().setVisible(true);
            }
        });
    }

    public void populateProfile() {
        jTabbedPane1.setSelectedIndex(0);
        cancel.setVisible(false);
        save.setVisible(false);
        editButton.setVisible(true);
        title.setText("Manager Profile");
        mName.setBorder(new LineBorder(Color.decode("#0099FF"), 0));
        mPhone.setBorder(new LineBorder(Color.decode("#0099FF"), 0));
        mEmail.setBorder(new LineBorder(Color.decode("#0099FF"), 0));

        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
            String quer = "SELECT *\n"
                    + "FROM MANAGERS M\n"
                    + "LEFT JOIN BRANCHES B\n"
                    + "ON M.manager_id = B.manager_id\n"
                    + "WHERE M.manager_id=?";
            ResultSet resultSet;
            PreparedStatement pstatement = con.prepareStatement(quer);
            pstatement.setString(1, managerId);
            resultSet = pstatement.executeQuery();
            String Branch = null;
            while (resultSet.next()) {
                managerId = resultSet.getString("manager_id");
                mID.setText(managerId);
                Name = resultSet.getString("manager_name");
                mName.setText(Name);
                mPhone.setText(resultSet.getString("manager_phone"));
                mEmail.setText(resultSet.getString("manager_email"));
                Branch = resultSet.getString("branch_id");
                mBranch.setText(resultSet.getString("branch_name"));
                bArea.setText(resultSet.getString("branch_address"));
                bDistrict.setText(resultSet.getString("branch_district"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteApproveButton;
    private javax.swing.JButton ViewButton;
    private javax.swing.JPanel ViewLayout;
    private javax.swing.JButton accountInfoButton;
    private javax.swing.JButton approvalButton;
    private javax.swing.JTable approvalTable;
    private javax.swing.JPanel approvalTableHider;
    private javax.swing.JButton approveButton;
    private javax.swing.JTextField bArea;
    private javax.swing.JTextField bDistrict;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancel;
    private javax.swing.JButton editButton;
    private javax.swing.JButton infoDeleteButton;
    private javax.swing.JPanel infoTableHider;
    private javax.swing.JTable informationTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField mBranch;
    private javax.swing.JTextField mEmail;
    private javax.swing.JLabel mID;
    private javax.swing.JTextField mName;
    private javax.swing.JTextField mPhone;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JTextField sAdmission;
    private javax.swing.JTextField sArea;
    private javax.swing.JTextField sBatch;
    private javax.swing.JTextField sBranch;
    private javax.swing.JTextField sCourse;
    private javax.swing.JTextField sEmail;
    private javax.swing.JLabel sID;
    private javax.swing.JTextField sName;
    private javax.swing.JTextField sPhone;
    private javax.swing.JLabel sStatus;
    private javax.swing.JButton save;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField searchField1;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel searchLabel1;
    private javax.swing.JTextField selectedApprovalID;
    private javax.swing.JLabel selectedIDALabel;
    private javax.swing.JLabel selectedIDALabel1;
    private javax.swing.JTextField selectedinfoID;
    private javax.swing.JRadioButton studentARadio;
    private javax.swing.JRadioButton studentIRadio;
    private javax.swing.JLabel studentName;
    private javax.swing.JRadioButton teacherARadio;
    private javax.swing.JRadioButton teacherIRadio;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userType;
    // End of variables declaration//GEN-END:variables

    private void approveTableDesign(String operation) {
        if(operation == "APPROVE"){
            approvalTable.getTableHeader().setFont(new Font("Bahnschrift", Font.BOLD, 14));
            approvalTable.getTableHeader().setOpaque(false);
            approvalTable.getTableHeader().setBackground(new Color(0, 0, 255));
            approvalTable.getTableHeader().setForeground(new Color(255, 255, 255));
            approvalTable.setRowHeight(25);    
        }else if(operation == "INFORMATION"){
            informationTable.getTableHeader().setFont(new Font("Bahnschrift", Font.BOLD, 14));
            informationTable.getTableHeader().setOpaque(false);
            informationTable.getTableHeader().setBackground(new Color(0, 0, 255));
            informationTable.getTableHeader().setForeground(new Color(255, 255, 255));
            informationTable.setRowHeight(25);    
        }
        
    }
}
