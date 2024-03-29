/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package merge;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import misc.Login;
import misc.Registration;

/**
 *
 * @author anime
 */
public class SubjectAssign extends javax.swing.JFrame {

    /**
     * Creates new form SubjectAssign
     */
    Connection con=null;
    BigInteger subjectid,courseid;
    String subject,course,coursename,managerID="", teacherID="";
    
     DefaultComboBoxModel dm = new DefaultComboBoxModel();
    
    public SubjectAssign() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        loadCombo();
    }
    
    public SubjectAssign(String mid,String tid) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        teacherID = tid;
        managerID = mid;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        loadCombo();
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
        jLabel1 = new javax.swing.JLabel();
        courseComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        subjectComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select Course:");

        courseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        courseComboBox.setBorder(null);
        courseComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                courseComboBoxItemStateChanged(evt);
            }
        });
        courseComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseComboBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                courseComboBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                courseComboBoxMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                courseComboBoxMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                courseComboBoxMouseReleased(evt);
            }
        });
        courseComboBox.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                courseComboBoxComponentHidden(evt);
            }
        });
        courseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Subject:");

        subjectComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        subjectComboBox.setBorder(null);
        subjectComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                subjectComboBoxItemStateChanged(evt);
            }
        });
        subjectComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjectComboBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                subjectComboBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                subjectComboBoxMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                subjectComboBoxMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                subjectComboBoxMouseReleased(evt);
            }
        });
        subjectComboBox.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                subjectComboBoxComponentHidden(evt);
            }
        });
        subjectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectComboBoxActionPerformed(evt);
            }
        });

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addComponent(jLabel2))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(subjectComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(courseComboBox, 0, 213, Short.MAX_VALUE))))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(63, Short.MAX_VALUE))
        );

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

    private void courseComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_courseComboBoxItemStateChanged
        // TODO add your handling code here:
        if(courseComboBox.getSelectedItem().toString().equals("SELECT")){
            subjectComboBox.setVisible(false);
        }else if(courseComboBox.getSelectedItem().toString()!="SELECT"){
            subjectComboBox.setVisible(true);
            dm = new DefaultComboBoxModel();
            dm.addElement("SELECT");
            subjectComboBox.setModel(dm);
            dm.setSelectedItem("SELECT");
            coursename = courseComboBox.getSelectedItem().toString();
            setSubjectCombo();
        }
    }//GEN-LAST:event_courseComboBoxItemStateChanged

    private void courseComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_courseComboBoxMouseClicked

    private void courseComboBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseComboBoxMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_courseComboBoxMouseEntered

    private void courseComboBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseComboBoxMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_courseComboBoxMouseExited

    private void courseComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseComboBoxMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseComboBoxMousePressed

    private void courseComboBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseComboBoxMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_courseComboBoxMouseReleased

    private void courseComboBoxComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_courseComboBoxComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_courseComboBoxComponentHidden

    private void courseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseComboBoxActionPerformed

    private void subjectComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_subjectComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboBoxItemStateChanged

    private void subjectComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboBoxMouseClicked

    private void subjectComboBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectComboBoxMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboBoxMouseEntered

    private void subjectComboBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectComboBoxMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboBoxMouseExited

    private void subjectComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectComboBoxMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboBoxMousePressed

    private void subjectComboBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectComboBoxMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboBoxMouseReleased

    private void subjectComboBoxComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_subjectComboBoxComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboBoxComponentHidden

    private void subjectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        course = courseComboBox.getSelectedItem().toString();
        subject = subjectComboBox.getSelectedItem().toString();
        
        if(course.equals("SELECT")){
                JOptionPane.showConfirmDialog(null, "Select teacher's course!", "Error", JOptionPane.CANCEL_OPTION);
            }else if(subject.equals("SELECT")){
                JOptionPane.showConfirmDialog(null, "Select teacher's subject!", "Error", JOptionPane.CANCEL_OPTION);
            }else{
                
                try {
                   
                    fetchCourse();
                    
                    System.out.println(teacherID + subject);
                    String QUERY = "UPDATE SUBJECTS "
                            + "SET teacher_id = "+teacherID
                            + "WHERE subject_name = '" + subject + "'";
                    Statement statement = con.createStatement();
                    statement.executeUpdate(QUERY);
                    
                    JOptionPane.showMessageDialog(null, "Assigning successful!");
                    //new Options(PetID,PetName,Value).setVisible(true);
                    dispose();
                    new managerLayout(managerID, teacherID).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
                   
                    fetchCourse();
                    
                    
                    String QUERY = "UPDATE TEACHERS "
                            + "SET teacher_reg_status = 'UNREGISTERED'"
                            +"WHERE teacher_id="+teacherID;
                    Statement statement = con.createStatement();
                    statement.executeUpdate(QUERY);
                    
                    JOptionPane.showMessageDialog(null, "Registration unsuccessful!");
                    //new Options(PetID,PetName,Value).setVisible(true);
                    dispose();
                    new managerLayout(managerID, teacherID).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SubjectAssign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubjectAssign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubjectAssign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubjectAssign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubjectAssign().setVisible(true);
            }
        });
    }
    
     private void setSubjectCombo() {
        try
        {
            // Your database connections 
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery("SELECT subject_name FROM SUBJECTS INNER JOIN COURSES ON COURSES.course_id=SUBJECTS.course_id WHERE COURSES.course_name='"+coursename+"';");
            while(rs.next()){                            
                subjectComboBox.addItem(rs.getString(1));
            }
            //con.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error"+e);
        }
    }

    private void fetchCourse() {        
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM COURSES WHERE course_name='"+course+"'";
            
            ResultSet resultset = statement.executeQuery(sql);
            
            while(resultset.next()){
                String tcourseID = resultset.getString("course_id");
                String tcoursename  = resultset.getString("course_name");
                
                
                if(course.equals(tcoursename))
                {
                    BigInteger temp = new BigInteger(tcourseID);
                    courseid = temp;
                }
                    
                    
                }
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void loadCombo() {
    try
    {
    // Your database connections 
    Statement st = con.createStatement();
    ResultSet rs= st.executeQuery("select course_name from COURSES");
    while(rs.next()){                            
        courseComboBox.addItem(rs.getString(1));
    }
    //con.close();
    }
    catch(Exception e)
    {
        System.out.println("Error"+e);
    }   
}
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> courseComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> subjectComboBox;
    // End of variables declaration//GEN-END:variables
}
