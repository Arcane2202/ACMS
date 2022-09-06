/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package merge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tanve
 */
public class CourseM extends javax.swing.JFrame {

    int rowIndx = -1;
    DefaultTableModel mod,model;
    Connection con;
    String task = "Edit";

    /**
     * Creates new form CourseM
     */
    public CourseM() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
        } catch (SQLException ex) {
            Logger.getLogger(CourseM.class.getName()).log(Level.SEVERE, null, ex);
        }

        populateTable();
        //populateBatch();
        //populateDistrict();

        saveCourse.setVisible(false);
        cancelCourse.setVisible(false);
        subjectViewer.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        cancelCourse = new javax.swing.JButton();
        courseFee = new javax.swing.JTextField();
        courseName = new javax.swing.JTextField();
        courseId = new javax.swing.JTextField();
        idlab = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editCourse = new javax.swing.JButton();
        saveCourse = new javax.swing.JButton();
        returnCourse = new javax.swing.JButton();
        addCourse = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        subjectViewer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

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

        cancelCourse.setBackground(new java.awt.Color(0, 168, 247));
        cancelCourse.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        cancelCourse.setText("Cancel");
        cancelCourse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelCourseActionPerformed(evt);
            }
        });

        courseFee.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        courseFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseFeeActionPerformed(evt);
            }
        });

        courseName.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        courseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNameActionPerformed(evt);
            }
        });

        courseId.setEditable(false);
        courseId.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        courseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseIdActionPerformed(evt);
            }
        });

        idlab.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        idlab.setText("ID               :");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel2.setText("Name        :");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel3.setText("Couse Fee:");

        editCourse.setBackground(new java.awt.Color(0, 168, 247));
        editCourse.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        editCourse.setText("Edit");
        editCourse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCourseActionPerformed(evt);
            }
        });

        saveCourse.setBackground(new java.awt.Color(0, 168, 247));
        saveCourse.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        saveCourse.setText("Save");
        saveCourse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCourseActionPerformed(evt);
            }
        });

        returnCourse.setBackground(new java.awt.Color(0, 168, 247));
        returnCourse.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        returnCourse.setText("Return");
        returnCourse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        returnCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnCourseActionPerformed(evt);
            }
        });

        addCourse.setBackground(new java.awt.Color(0, 168, 247));
        addCourse.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        addCourse.setText("Add");
        addCourse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(cancelCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(addCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idlab, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(courseFee)
                            .addComponent(courseId)
                            .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(returnCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseId, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idlab, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(courseName, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(courseFee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveCourse)
                    .addComponent(cancelCourse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCourse)
                    .addComponent(addCourse))
                .addGap(67, 67, 67)
                .addComponent(returnCourse)
                .addGap(77, 77, 77))
        );

        jTabbedPane2.addTab("tab3", jPanel9);

        jPanel2.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 360, 800));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 800));

        jPanel15.setBackground(new java.awt.Color(0, 168, 247));

        title.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Course Management");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(641, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 1030, 50));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        courseTable.setAutoCreateRowSorter(true);
        courseTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        courseTable.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        courseTable.setModel(new javax.swing.table.DefaultTableModel(
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
        courseTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        courseTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        courseTable.setGridColor(new java.awt.Color(255, 255, 255));
        courseTable.setRowHeight(70);
        courseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(courseTable);

        subjectViewer.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        subjectViewer.setText("View Subjects");
        subjectViewer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectViewerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(918, 918, 918))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subjectViewer, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(subjectViewer)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel6);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 1010, 700));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel1.setText("Search:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 100, 50));

        jTextField1.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 190, 50));

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

    private void cancelCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelCourseActionPerformed
        // TODO add your handling code here:
        //jTabbedPane1.setSelectedIndex(1);
        //populateProfile();
        editCourse.setVisible(true);
        addCourse.setVisible(true);
        returnCourse.setVisible(true);
        saveCourse.setVisible(false);
        cancelCourse.setVisible(false);
        courseId.setText("");
        courseName.setText("");
        courseFee.setText("");
        courseId.setVisible(true);
        idlab.setVisible(true);
    }//GEN-LAST:event_cancelCourseActionPerformed

    private void courseFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseFeeActionPerformed

    private void courseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseNameActionPerformed

    private void courseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseIdActionPerformed

    private void editCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCourseActionPerformed
        // TODO add your handling code here:
        task = "Edit";
        editCourse.setVisible(false);
        addCourse.setVisible(false);
        returnCourse.setVisible(false);
        saveCourse.setVisible(true);
        cancelCourse.setVisible(true);
        courseId.setVisible(false);
        idlab.setVisible(false);
    }//GEN-LAST:event_editCourseActionPerformed

    private void saveCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCourseActionPerformed
        // TODO add your handling code here:
        String id = courseId.getText();
        String name = courseName.getText().toString();
        String corfee = courseFee.getText().toString();

        if (task.equals("Edit")) {
            try {
                String quer = "UPDATE COURSES set course_name=?,course_fee=? WHERE course_id=?";
                PreparedStatement statement = con.prepareStatement(quer);
                statement.setString(1, name);
                statement.setString(2, corfee);
                statement.setString(3, id);
                statement.executeUpdate();
                populateTable();
                JOptionPane.showMessageDialog(this, "Successfully Updated");
                editCourse.setVisible(true);
                addCourse.setVisible(true);
                returnCourse.setVisible(true);
                saveCourse.setVisible(false);
                cancelCourse.setVisible(false);
                courseId.setText("");
                courseName.setText("");
                courseFee.setText("");
                courseId.setVisible(true);
                idlab.setVisible(true);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        } else {

            try {
                String quer = "INSERT INTO COURSES VALUES(?,?)";
                PreparedStatement statement = con.prepareStatement(quer);
                statement.setString(1, name);
                statement.setString(2, corfee);
                statement.executeUpdate();
                populateTable();
                JOptionPane.showMessageDialog(this, "Successfully Added");
                editCourse.setVisible(true);
                addCourse.setVisible(true);
                returnCourse.setVisible(true);
                saveCourse.setVisible(false);
                cancelCourse.setVisible(false);
                courseId.setText("");
                courseName.setText("");
                courseFee.setText("");
                courseId.setVisible(true);
                idlab.setVisible(true);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_saveCourseActionPerformed

    private void returnCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnCourseActionPerformed
        // TODO add your handling code here:
        adminLayout obj = new adminLayout();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_returnCourseActionPerformed

    private void courseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTableMouseClicked
        // TODO add your handling code here:
        mod = (DefaultTableModel) courseTable.getModel();
        rowIndx = courseTable.getSelectedRow();
        courseId.setText(mod.getValueAt(rowIndx, 0).toString());
        courseName.setText(mod.getValueAt(rowIndx, 1).toString());
        courseFee.setText(mod.getValueAt(rowIndx, 2).toString());
        subjectViewer.setVisible(true);
    }//GEN-LAST:event_courseTableMouseClicked

    private void addCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseActionPerformed
        // TODO add your handling code here:
        editCourse.setVisible(false);
        addCourse.setVisible(false);
        returnCourse.setVisible(false);
        saveCourse.setVisible(true);
        cancelCourse.setVisible(true);
        task = "Add";
        courseId.setText("");
        courseName.setText("");
        courseId.setVisible(false);
        idlab.setVisible(false);
    }//GEN-LAST:event_addCourseActionPerformed

    private void subjectViewerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectViewerActionPerformed
        // TODO add your handling code here:
        String id = mod.getValueAt(rowIndx, 0).toString();
        subjectM obj = new subjectM(id);
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_subjectViewerActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        String s = jTextField1.getText();
        searchRecordApprove(s);
    }//GEN-LAST:event_jTextField1KeyReleased

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
            java.util.logging.Logger.getLogger(CourseM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCourse;
    private javax.swing.JButton cancelCourse;
    private javax.swing.JTextField courseFee;
    private javax.swing.JTextField courseId;
    private javax.swing.JTextField courseName;
    private javax.swing.JTable courseTable;
    private javax.swing.JButton editCourse;
    private javax.swing.JLabel idlab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton returnCourse;
    private javax.swing.JButton saveCourse;
    private javax.swing.JButton subjectViewer;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
    public void populateTable() {
        try {
            String quer = "SELECT course_id,course_name,course_fee FROM COURSES";
            ResultSet resultSet;
            PreparedStatement statement = con.prepareStatement(quer);
            resultSet = statement.executeQuery();
            courseTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            searchRecordApprove("");
        } catch (SQLException ex) {
            Logger.getLogger(studentLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void searchRecordApprove(String str){
        model = (DefaultTableModel) courseTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        courseTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));

    }
}
