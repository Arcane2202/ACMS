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
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
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
public class TeacherLayout extends javax.swing.JFrame {

    String teacherId = "";
    String courseID = "";
    String batchId = "";
    String Name = "";
    String Status = "";
    Connection con;
    int rowIndx = -1, mrowIndx = -1, actvrowIndx = -1;
    DefaultTableModel mod, modaca, modachv, modskill, modroutine, modactiv, modhob, modres;
    int infoNo = -1;
    String rId, weekDay;

    /**
     * Creates new form studentLayout
     */
    public TeacherLayout() {
        initComponents();
        rowIndx = -1;
        mrowIndx = -1;
        actvrowIndx = -1;
        populateProfile();
        populateRoutineTable();
        studentName.setText(Name);
        register.setText(Status);

        viewActBtn.setEnabled(false);
        JTableHeader Header = studentInfo.getTableHeader();
        Header.setFont(new Font("Tahome", Font.BOLD, 18));
        JTableHeader Header2 = routine.getTableHeader();
        Header2.setFont(new Font("Tahome", Font.BOLD, 18));
        JTableHeader Header3 = ActivityTable.getTableHeader();
        Header3.setFont(new Font("Tahome", Font.BOLD, 18));
    }

    public TeacherLayout(String id) {
        initComponents();
        teacherId = id;
        rowIndx = -1;
        mrowIndx = -1;
        actvrowIndx = -1;
        populateProfile();
        populateRoutineTable();
        studentName.setText(Name);
        register.setText(Status);

        viewActBtn.setEnabled(false);
        JTableHeader Header = studentInfo.getTableHeader();
        Header.setFont(new Font("Tahome", Font.BOLD, 18));
        JTableHeader Header2 = routine.getTableHeader();
        Header2.setFont(new Font("Tahome", Font.BOLD, 18));
        JTableHeader Header3 = ActivityTable.getTableHeader();
        Header3.setFont(new Font("Tahome", Font.BOLD, 18));
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
        resultsButton = new javax.swing.JButton();
        routineButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        register = new javax.swing.JLabel();
        studentName = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        BackPer1 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tName = new javax.swing.JTextField();
        tPhone = new javax.swing.JTextField();
        tEmail = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tBranch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tCourse = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tSub = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tStat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tID = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tSubName = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tDate = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentInfo = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        searchBox = new javax.swing.JTextField();
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
        profileButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        profileButton.setForeground(new java.awt.Color(255, 255, 255));
        profileButton.setText("Profile");
        profileButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        profileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        resultsButton.setBackground(new java.awt.Color(0, 168, 247));
        resultsButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
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
        routineButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
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
        returnButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        returnButton.setForeground(new java.awt.Color(255, 255, 255));
        returnButton.setText("Logout");
        returnButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        returnButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        register.setForeground(new java.awt.Color(255, 0, 0));
        register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        register.setText("registration");

        studentName.setFont(new java.awt.Font("Bahnschrift", 3, 24)); // NOI18N
        studentName.setForeground(new java.awt.Color(255, 255, 255));
        studentName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentName.setText("Teacher Name");

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Welcome!");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(resultsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(routineButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(returnButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(studentName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(routineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab3", jPanel9);

        jPanel10.setBackground(new java.awt.Color(0, 153, 255));

        BackPer1.setBackground(new java.awt.Color(0, 168, 247));
        BackPer1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        BackPer1.setText("Return");
        BackPer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackPer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(BackPer1)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(899, 899, 899)
                .addComponent(BackPer1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab3", jPanel10);

        jPanel2.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 360, 800));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 800));

        jPanel15.setBackground(new java.awt.Color(0, 168, 247));

        title.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Teacher Profile");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 1030, 120));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("NAME               :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("E-MAIL             :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("PHONE        :");

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 168, 247));
        jLabel4.setText("Personal Infromation");

        tName.setEditable(false);
        tName.setBackground(new java.awt.Color(255, 255, 255));
        tName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tName.setBorder(null);

        tPhone.setEditable(false);
        tPhone.setBackground(new java.awt.Color(255, 255, 255));
        tPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tPhone.setBorder(null);

        tEmail.setEditable(false);
        tEmail.setBackground(new java.awt.Color(255, 255, 255));
        tEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tEmail.setBorder(null);

        editButton.setBackground(new java.awt.Color(0, 168, 247));
        editButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.setBorder(null);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Branch       :");

        tBranch.setEditable(false);
        tBranch.setBackground(new java.awt.Color(255, 255, 255));
        tBranch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tBranch.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Course              :");

        tCourse.setEditable(false);
        tCourse.setBackground(new java.awt.Color(255, 255, 255));
        tCourse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tCourse.setBorder(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Subject ID :");

        tSub.setEditable(false);
        tSub.setBackground(new java.awt.Color(255, 255, 255));
        tSub.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tSub.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Status               :");

        tStat.setEditable(false);
        tStat.setBackground(new java.awt.Color(255, 255, 255));
        tStat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tStat.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("ID               :");

        tID.setBackground(new java.awt.Color(204, 204, 204));
        tID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Subject Name   :");

        tSubName.setBackground(new java.awt.Color(255, 255, 255));
        tSubName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        save.setBackground(new java.awt.Color(0, 168, 247));
        save.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Save");
        save.setBorder(null);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(0, 168, 247));
        cancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.setBorder(null);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Join Date   :");

        tDate.setEditable(false);
        tDate.setBackground(new java.awt.Color(255, 255, 255));
        tDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tDate.setBorder(null);

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
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tDate, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(tBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tSub, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tStat)
                            .addComponent(tCourse)
                            .addComponent(tSubName, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 143, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tEmail)
                    .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(134, 134, 134))
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
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tName)
                    .addComponent(tID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tBranch, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tStat)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tSub, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tSubName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(432, 432, 432))
        );

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        studentInfo.setAutoCreateRowSorter(true);
        studentInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        studentInfo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Search Box");

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel14.setText("Search Key : ");

        searchBox.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        searchBox.setText(" ");
        searchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoxActionPerformed(evt);
            }
        });
        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBoxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(searchBox))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        routine.setAutoCreateRowSorter(true);
        routine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        routine.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1020, 570));

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

        viewActBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        viewActBtn.setText("View Schedule");
        viewActBtn.setEnabled(false);
        viewActBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActBtnActionPerformed(evt);
            }
        });
        jPanel5.add(viewActBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 590, 240, 60));

        jTabbedPane1.addTab("tab3", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        ActivityTable.setAutoCreateRowSorter(true);
        ActivityTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ActivityTable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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

        returnRoutine.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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
                .addGap(438, 438, 438)
                .addComponent(returnRoutine, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(887, 887, 887))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(returnRoutine, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jTabbedPane1.addTab("tab4", jPanel6);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 1030, 700));

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

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        // TODO add your handling code here:
        populateProfile();
        viewActBtn.setEnabled(false);
        infoNo = 1;
    }//GEN-LAST:event_profileButtonActionPerformed

    private void resultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultsButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        populateResultsTable();
        viewActBtn.setEnabled(false);
        infoNo = 3;
    }//GEN-LAST:event_resultsButtonActionPerformed

    private void routineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routineButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        viewActBtn.setVisible(true);
        title.setText("Routine");
        infoNo = 4;
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
        new Login("TEACHER").setVisible(true);
    }//GEN-LAST:event_returnButtonActionPerformed

    private void studentInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentInfoMouseClicked
        // TODO add your handling code here:
        mod = (DefaultTableModel) studentInfo.getModel();
        rowIndx = studentInfo.getSelectedRow();

    }//GEN-LAST:event_studentInfoMouseClicked

    private void BackPer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackPer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackPer1ActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        cancel.setVisible(true);
        save.setVisible(true);
        editButton.setVisible(false);
        tName.setEditable(true);
        tName.setBorder(new LineBorder(Color.decode("#0099FF"), 1));
        tPhone.setEditable(true);
        tPhone.setBorder(new LineBorder(Color.decode("#0099FF"), 1));
        tEmail.setEditable(true);
        tEmail.setBorder(new LineBorder(Color.decode("#0099FF"), 1));
    }//GEN-LAST:event_editButtonActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String name = tName.getText();
        String phone = tPhone.getText();
        String email = tEmail.getText();
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
            String quer = "UPDATE TEACHERS SET teacher_name=?,teacher_email=?,teacher_phone=? WHERE teacher_id=?";
            ResultSet resultSet;
            PreparedStatement pstatement = con.prepareStatement(quer);
            pstatement.setString(1, name);
            pstatement.setString(2, email);
            pstatement.setString(3, phone);
            pstatement.setString(4, teacherId);
            pstatement.executeUpdate();
            String course = null, Batch = null, Branch = null;
            JOptionPane.showMessageDialog(this, "Successful!");
            populateProfile();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherLayout.class.getName()).log(Level.SEVERE, null, ex);
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

    private void searchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoxActionPerformed

    public void search(String SRC) {
        modres = (DefaultTableModel) studentInfo.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modres);
        studentInfo.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + SRC));
    }
    private void searchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyReleased
        String src = searchBox.getText();
        search(src);
    }//GEN-LAST:event_searchBoxKeyReleased

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
            java.util.logging.Logger.getLogger(TeacherLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherLayout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ActivityTable;
    private javax.swing.JButton BackPer1;
    private javax.swing.JButton cancel;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
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
    private javax.swing.JButton save;
    private javax.swing.JTextField searchBox;
    private javax.swing.JTable studentInfo;
    private javax.swing.JLabel studentName;
    private javax.swing.JTextField tBranch;
    private javax.swing.JTextField tCourse;
    private javax.swing.JTextField tDate;
    private javax.swing.JTextField tEmail;
    private javax.swing.JLabel tID;
    private javax.swing.JTextField tName;
    private javax.swing.JTextField tPhone;
    private javax.swing.JTextField tStat;
    private javax.swing.JTextField tSub;
    private javax.swing.JLabel tSubName;
    private javax.swing.JLabel title;
    private javax.swing.JButton viewActBtn;
    // End of variables declaration//GEN-END:variables

    public void populateProfile() {
        jTabbedPane1.setSelectedIndex(0);
        cancel.setVisible(false);
        save.setVisible(false);
        editButton.setVisible(true);
        title.setText("Teacher Profile");
        tName.setBorder(new LineBorder(Color.decode("#0099FF"), 0));
        tPhone.setBorder(new LineBorder(Color.decode("#0099FF"), 0));
        tEmail.setBorder(new LineBorder(Color.decode("#0099FF"), 0));

        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
            //String quer = "SELECT * FROM TEACHERS WHERE teacher_id=?";
            String quer = "SELECT T.teacher_id, T.teacher_name, T.teacher_phone, T.teacher_email, T.teacher_joining_date, T.teacher_reg_status, B.branch_id, B.branch_name\n"
                    + "FROM TEACHERS T\n"
                    + "LEFT JOIN BRANCHES B\n"
                    + "ON T.branch_id = B.branch_id\n"
                    + "WHERE T.teacher_id=?";
            ResultSet resultSet;
            PreparedStatement pstatement = con.prepareStatement(quer);
            pstatement.setString(1, teacherId);
            resultSet = pstatement.executeQuery();
            String course = null, Batch = null, Branch = null;
            while (resultSet.next()) {
                teacherId = resultSet.getString("teacher_id");
                tID.setText(resultSet.getString("teacher_id"));
                Name = resultSet.getString("teacher_name");
                tName.setText(Name);
                tPhone.setText(resultSet.getString("teacher_phone"));
                tEmail.setText(resultSet.getString("teacher_email"));
                tDate.setText(resultSet.getString("teacher_joining_date"));
                Branch = resultSet.getString("branch_name");
                tBranch.setText(resultSet.getString("branch_name") + " [ B_ID: " + resultSet.getString("branch_id") + " ]");
                tStat.setText(resultSet.getString("teacher_reg_status"));
                Status = resultSet.getString("teacher_reg_status");
            }
            //quer = "SELECT course_id,subject_id, subject_name FROM SUBJECTS WHERE teacher_id = ?";
            quer = "SELECT C.course_id, S.subject_id, S.subject_name, C.course_name FROM SUBJECTS S FULL JOIN COURSES C ON S.course_id = C.course_id WHERE S.teacher_id = ?";
            pstatement = con.prepareStatement(quer);
            pstatement.setString(1, teacherId);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
                course = resultSet.getString("course_name");
                courseID = resultSet.getString("course_name");
                tCourse.setText(courseID + " [ C_ID: " + resultSet.getString("course_id") + " ]");
                tSub.setText(resultSet.getString("subject_id"));
                tSubName.setText(resultSet.getString("subject_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherLayout.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TeacherLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void populateResultsTable() {

        jTabbedPane1.setSelectedIndex(1);
        title.setText("Exam Results");
        try {
            String quer = "SELECT exam_date as Exam_Date,student_id as Student_ID, exam_total_marks as Total_Marks,result_obtained_marks as Obtained_Marks,result_grade as Grade,exam_type as Type\n"
                    + "FROM RESULTS INNER JOIN EXAMS ON RESULTS.exam_id=EXAMS.exam_id INNER JOIN SUBJECTS ON SUBJECTS.teacher_id = ?";
            ResultSet resultSet;
            PreparedStatement statement = con.prepareStatement(quer);
            statement.setString(1, teacherId);

            resultSet = statement.executeQuery();
            studentInfo.setModel(DbUtils.resultSetToTableModel(resultSet));
            studentInfo.setFillsViewportHeight(true);

        } catch (SQLException ex) {
            Logger.getLogger(TeacherLayout.class.getName()).log(Level.SEVERE, null, ex);
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
            String quer = "SELECT schedule_starting_time as Start_Time,schedule_activity_type as Activity,subject_id as Subject,room_id as Room,teacher_name as Teacher FROM SCHEDULES INNER JOIN TEACHERS ON SCHEDULES.teacher_id = TEACHERS.teacher_id WHERE schedule_weekday = ? and SCHEDULES.teacher_id = ?";
            ResultSet resultSet;
            PreparedStatement statement = con.prepareStatement(quer);
            statement.setString(1, rId);
            statement.setString(2, teacherId);
            resultSet = statement.executeQuery();
            ActivityTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            ActivityTable.setFillsViewportHeight(true);
        } catch (SQLException ex) {
            Logger.getLogger(TeacherLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
