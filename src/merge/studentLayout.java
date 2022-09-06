package merge;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import misc.Login;
import net.proteanit.sql.DbUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Arcane
 */
public class studentLayout extends javax.swing.JFrame {

    String studentId = "";
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
     * Creates new form studentLayout
     */
    public studentLayout() {
        initComponents();
        rowIndx = -1;
        mrowIndx = -1;
        actvrowIndx = -1;
        populateProfile();
        studentName.setText(Name);
        register.setText(Status);
        populateRoutineTable();

        viewActBtn.setEnabled(false);
        JTableHeader Header = studentInfo.getTableHeader();
        Header.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        JTableHeader Header2 = routine.getTableHeader();
        Header2.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        JTableHeader Header3 = ActivityTable.getTableHeader();
        Header3.setFont(new Font("Bahnschrift", Font.BOLD, 18));
    }

    public studentLayout(String id) {
        initComponents();
        studentId = id;
        rowIndx = -1;
        mrowIndx = -1;
        actvrowIndx = -1;
        populateProfile();
        studentName.setText(Name);
        register.setText(Status);
        populateRoutineTable();

        viewActBtn.setEnabled(false);
        JTableHeader Header = studentInfo.getTableHeader();
        Header.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        JTableHeader Header2 = routine.getTableHeader();
        Header2.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        JTableHeader Header3 = ActivityTable.getTableHeader();
        Header3.setFont(new Font("Bahnschrift", Font.BOLD, 18));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        profileButton = new javax.swing.JButton();
        subjectsButton = new javax.swing.JButton();
        resultsButton = new javax.swing.JButton();
        routineButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        studentName = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        register = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        sName = new javax.swing.JTextField();
        sPhone = new javax.swing.JTextField();
        sEmail = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        sBranch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        sCourse = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        sBatch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        sAdmission = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        sID = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sStatus = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        sArea = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentInfo = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        routine = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        viewActBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ActivityTable = new javax.swing.JTable();
        returnRoutine = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        profileButton.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        profileButton.setForeground(new java.awt.Color(255, 255, 255));
        profileButton.setText("Profile");
        profileButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        profileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        subjectsButton.setBackground(new java.awt.Color(0, 168, 247));
        subjectsButton.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        subjectsButton.setForeground(new java.awt.Color(255, 255, 255));
        subjectsButton.setText("Enrolled Subjects");
        subjectsButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        subjectsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subjectsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectsButtonActionPerformed(evt);
            }
        });

        resultsButton.setBackground(new java.awt.Color(0, 168, 247));
        resultsButton.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        resultsButton.setForeground(new java.awt.Color(255, 255, 255));
        resultsButton.setText("Results History");
        resultsButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        resultsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultsButtonActionPerformed(evt);
            }
        });

        routineButton.setBackground(new java.awt.Color(0, 168, 247));
        routineButton.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        routineButton.setForeground(new java.awt.Color(255, 255, 255));
        routineButton.setText("Routine");
        routineButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        routineButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        routineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routineButtonActionPerformed(evt);
            }
        });

        returnButton.setBackground(new java.awt.Color(0, 168, 247));
        returnButton.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        returnButton.setForeground(new java.awt.Color(255, 255, 255));
        returnButton.setText("Logout");
        returnButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        returnButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        studentName.setFont(new java.awt.Font("Bahnschrift", 2, 18)); // NOI18N
        studentName.setForeground(new java.awt.Color(255, 255, 255));
        studentName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentName.setText("Student Name");

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Welcome!");

        register.setForeground(new java.awt.Color(255, 0, 0));
        register.setText("registration");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subjectsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(returnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(routineButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(register)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(register)
                .addGap(54, 54, 54)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(subjectsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(routineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );

        jTabbedPane2.addTab("tab3", jPanel9);

        jPanel2.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 360, 800));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 800));

        jPanel15.setBackground(new java.awt.Color(0, 168, 247));

        title.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Student Profile");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 1030, 120));

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

        sName.setEditable(false);
        sName.setBackground(new java.awt.Color(255, 255, 255));
        sName.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        sName.setBorder(null);

        sPhone.setEditable(false);
        sPhone.setBackground(new java.awt.Color(255, 255, 255));
        sPhone.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        sPhone.setBorder(null);

        sEmail.setEditable(false);
        sEmail.setBackground(new java.awt.Color(255, 255, 255));
        sEmail.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        sEmail.setBorder(null);

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
        jLabel5.setText("Other Infromation");

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

        sBranch.setEditable(false);
        sBranch.setBackground(new java.awt.Color(255, 255, 255));
        sBranch.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        sBranch.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel7.setText("Course                :");

        sCourse.setEditable(false);
        sCourse.setBackground(new java.awt.Color(255, 255, 255));
        sCourse.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        sCourse.setBorder(null);

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setText("Batch          :");

        sBatch.setEditable(false);
        sBatch.setBackground(new java.awt.Color(255, 255, 255));
        sBatch.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        sBatch.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel9.setText("Admission Date  :");

        sAdmission.setEditable(false);
        sAdmission.setBackground(new java.awt.Color(255, 255, 255));
        sAdmission.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        sAdmission.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel10.setText("ID                :");

        sID.setBackground(new java.awt.Color(204, 204, 204));
        sID.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel13.setText("Status                 :");

        sStatus.setBackground(new java.awt.Color(255, 255, 255));
        sStatus.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N

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

        sArea.setEditable(false);
        sArea.setBackground(new java.awt.Color(255, 255, 255));
        sArea.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        sArea.setBorder(null);

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sID, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sName, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(sArea, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(sBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sAdmission)
                            .addComponent(sCourse)
                            .addComponent(sStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(sName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(sEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sBranch)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(sAdmission)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sArea)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(486, 486, 486))
        );

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        studentInfo.setAutoCreateRowSorter(true);
        studentInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        studentInfo.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        studentInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        studentInfo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        studentInfo.setColumnSelectionAllowed(true);
        studentInfo.setGridColor(new java.awt.Color(255, 255, 255));
        studentInfo.setRowHeight(70);
        studentInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentInfo);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        routine.setAutoCreateRowSorter(true);
        routine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        routine.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        routine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Weekday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        routine.setGridColor(new java.awt.Color(255, 255, 255));
        routine.setRowHeight(70);
        routine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                routineMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(routine);
        if (routine.getColumnModel().getColumnCount() > 0) {
            routine.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 810, 550));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 20));

        viewActBtn.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        viewActBtn.setText("View Schedule");
        viewActBtn.setEnabled(false);
        viewActBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActBtnActionPerformed(evt);
            }
        });
        jPanel5.add(viewActBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, -1, 30));

        jTabbedPane1.addTab("tab3", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        ActivityTable.setAutoCreateRowSorter(true);
        ActivityTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ActivityTable.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        ActivityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ActivityTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        ActivityTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ActivityTable.setGridColor(new java.awt.Color(255, 255, 255));
        ActivityTable.setRowHeight(70);
        ActivityTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActivityTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ActivityTable);
        if (ActivityTable.getColumnModel().getColumnCount() > 0) {
            ActivityTable.getColumnModel().getColumn(0).setResizable(false);
        }

        returnRoutine.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        returnRoutine.setText("Return");
        returnRoutine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnRoutineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(returnRoutine, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(918, 918, 918))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(returnRoutine)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel6);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 1020, 700));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void subjectsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectsButtonActionPerformed
        // TODO add your handling code here:
        if (Status.equals("unregistered")) {
            JOptionPane.showMessageDialog(this, "You have to be registered in order to access this!!");
        } else {
            populateSubjectsTable();
            viewActBtn.setEnabled(false);
            infoNo = 2;
        }

    }//GEN-LAST:event_subjectsButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        // TODO add your handling code here:
        populateProfile();
        viewActBtn.setEnabled(false);
        infoNo = 1;
    }//GEN-LAST:event_profileButtonActionPerformed

    private void resultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultsButtonActionPerformed
        // TODO add your handling code here:
        if (Status.equals("unregistered")) {
            JOptionPane.showMessageDialog(this, "You have to be registered in order to access this!!");
        } else {
            jTabbedPane1.setSelectedIndex(1);
            populateResultsTable();
            viewActBtn.setEnabled(false);
            infoNo = 3;
        }
    }//GEN-LAST:event_resultsButtonActionPerformed

    private void routineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routineButtonActionPerformed
        // TODO add your handling code here:
        if (Status.equals("unregistered")) {
            JOptionPane.showMessageDialog(this, "You have to be registered in order to access this!!");
        } else {
            jTabbedPane1.setSelectedIndex(2);
            viewActBtn.setVisible(true);
            title.setText("Routine");
            infoNo = 4;
        }
    }//GEN-LAST:event_routineButtonActionPerformed

    private void routineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_routineMouseClicked
        // TODO add your handling code here:
        modroutine = (DefaultTableModel) routine.getModel();
        mrowIndx = routine.getSelectedRow();
        rId = modroutine.getValueAt(mrowIndx, 0).toString();
        viewActBtn.setEnabled(true);
    }//GEN-LAST:event_routineMouseClicked

    private void viewActBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActBtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
        populateScheduleTable();
        title.setText("Day Activities");
    }//GEN-LAST:event_viewActBtnActionPerformed

    private void ActivityTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActivityTableMouseClicked
        // TODO add your handling code here:
        modactiv = (DefaultTableModel) ActivityTable.getModel();
        actvrowIndx = ActivityTable.getSelectedRow();

    }//GEN-LAST:event_ActivityTableMouseClicked

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
        //jTabbedPane1.setSelectedIndex(1);
        //populateProfile();
        dispose();
        new Login("STUDENT").setVisible(true);
    }//GEN-LAST:event_returnButtonActionPerformed

    private void studentInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentInfoMouseClicked
        // TODO add your handling code here:
        mod = (DefaultTableModel) studentInfo.getModel();
        rowIndx = studentInfo.getSelectedRow();

    }//GEN-LAST:event_studentInfoMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        cancel.setVisible(true);
        save.setVisible(true);
        editButton.setVisible(false);
        sName.setEditable(true);
        sName.setBorder(new LineBorder(Color.decode("#0099FF"), 1));
        sPhone.setEditable(true);
        sPhone.setBorder(new LineBorder(Color.decode("#0099FF"), 1));
        sEmail.setEditable(true);
        sEmail.setBorder(new LineBorder(Color.decode("#0099FF"), 1));
    }//GEN-LAST:event_editButtonActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String name = sName.getText();
        String phone = sPhone.getText();
        String email = sEmail.getText();
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
            String quer = "UPDATE STUDENTS SET student_name=?,student_email=?,student_phone=? WHERE student_id=?";
            ResultSet resultSet;
            PreparedStatement pstatement = con.prepareStatement(quer);
            pstatement.setString(1, name);
            pstatement.setString(2, email);
            pstatement.setString(3, phone);
            pstatement.setString(4, studentId);
            pstatement.executeUpdate();
            String course = null, Batch = null, Branch = null;
            JOptionPane.showMessageDialog(this, "Successful!");
            populateProfile();
        } catch (SQLException ex) {
            Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        populateProfile();
    }//GEN-LAST:event_cancelActionPerformed

    private void returnRoutineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnRoutineActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        viewActBtn.setVisible(true);
        title.setText("Routine");
    }//GEN-LAST:event_returnRoutineActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(studentLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentLayout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ActivityTable;
    private javax.swing.JButton cancel;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton profileButton;
    private javax.swing.JLabel register;
    private javax.swing.JButton resultsButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton returnRoutine;
    private javax.swing.JTable routine;
    private javax.swing.JButton routineButton;
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
    private javax.swing.JTable studentInfo;
    private javax.swing.JLabel studentName;
    private javax.swing.JButton subjectsButton;
    private javax.swing.JLabel title;
    private javax.swing.JButton viewActBtn;
    // End of variables declaration//GEN-END:variables

    public void populateProfile() {
        jTabbedPane1.setSelectedIndex(0);
        cancel.setVisible(false);
        save.setVisible(false);
        editButton.setVisible(true);
        title.setText("Student Profile");
        sName.setBorder(new LineBorder(Color.decode("#0099FF"), 0));
        sPhone.setBorder(new LineBorder(Color.decode("#0099FF"), 0));
        sEmail.setBorder(new LineBorder(Color.decode("#0099FF"), 0));

        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
            String quer = "SELECT * FROM STUDENTS WHERE student_id=?";
            ResultSet resultSet;
            PreparedStatement pstatement = con.prepareStatement(quer);
            pstatement.setString(1, studentId);
            resultSet = pstatement.executeQuery();
            String Branch = null;
            while (resultSet.next()) {
                studentId = resultSet.getString("student_id");
                sID.setText(studentId);
                Name = resultSet.getString("student_name");
                sName.setText(Name);
                sPhone.setText(resultSet.getString("student_phone"));
                sEmail.setText(resultSet.getString("student_email"));
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
            while (resultSet.next()) {
                sBatch.setText(resultSet.getString(2));
            }
            quer = "SELECT * FROM COURSES WHERE course_id=?";
            pstatement = con.prepareStatement(quer);
            pstatement.setString(1, courseID);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
                sCourse.setText(resultSet.getString(2));
            }
            quer = "SELECT * FROM BRANCHES WHERE branch_id=?";
            pstatement = con.prepareStatement(quer);
            pstatement.setString(1, Branch);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
                sBranch.setText(resultSet.getString(2));
                sArea.setText(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void populateSubjectsTable() {
        jTabbedPane1.setSelectedIndex(1);
        title.setText("Enrolled Subjects");
        try {
            String quer = "SELECT subject_id,subject_name,teacher_name,teacher_email,teacher_phone FROM SUBJECTS INNER JOIN TEACHERS ON SUBJECTS.teacher_id=TEACHERS.teacher_id WHERE course_id=?";
            ResultSet resultSet;
            PreparedStatement statement = con.prepareStatement(quer);
            statement.setString(1, courseID);
            resultSet = statement.executeQuery();
            studentInfo.setModel(DbUtils.resultSetToTableModel(resultSet));
            studentInfo.setFillsViewportHeight(true);

        } catch (SQLException ex) {
            Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void populateResultsTable() {

        jTabbedPane1.setSelectedIndex(1);
        title.setText("Exam Results");
        try {
            String quer = "SELECT exam_date as Exam_Date,subject_id as Subject,exam_total_marks as Total_Marks,result_obtained_marks as Obtained_Marks,result_grade as Grade,exam_type as Type FROM RESULTS INNER JOIN EXAMS ON RESULTS.exam_id=EXAMS.exam_id WHERE student_id=?";
            ResultSet resultSet;
            PreparedStatement statement = con.prepareStatement(quer);
            statement.setString(1, studentId);

            resultSet = statement.executeQuery();
            studentInfo.setModel(DbUtils.resultSetToTableModel(resultSet));
            studentInfo.setFillsViewportHeight(true);

        } catch (SQLException ex) {
            Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void populateRoutineTable() {

        DefaultTableModel model = (DefaultTableModel) routine.getModel();
        Object[] obj1 = {"SATURDAY"};
        model.addRow(obj1);
        Object[] obj2 = {"SUNDAY"};
        model.addRow(obj2);
        Object[] obj3 = {"MONDAY"};
        model.addRow(obj3);
        Object[] obj4 = {"TUESDAY"};
        model.addRow(obj4);
        Object[] obj5 = {"WEDNESDAY"};
        model.addRow(obj5);
        Object[] obj6 = {"THURSDAY"};
        model.addRow(obj6);
        routine.setFillsViewportHeight(true);

    }

    public void populateScheduleTable() {

        viewActBtn.setVisible(true);
        try {
            String quer = "SELECT schedule_starting_time as Start_Time,schedule_activity_type as Activity,subject_id as Subject,room_id as Room,teacher_name as Teacher FROM SCHEDULES INNER JOIN TEACHERS ON SCHEDULES.teacher_id = TEACHERS.teacher_id WHERE schedule_weekday = ? and batch_id = ?";
            ResultSet resultSet;
            PreparedStatement statement = con.prepareStatement(quer);
            statement.setString(1, rId);
            statement.setString(2, batchId);
            resultSet = statement.executeQuery();
            ActivityTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            ActivityTable.setFillsViewportHeight(true);
        } catch (SQLException ex) {
            Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
