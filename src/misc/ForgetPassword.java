package misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import merge.TeacherLayout;
import merge.studentLayout;

public class ForgetPassword extends javax.swing.JFrame {

    Connection con;
    String user = "", id = "", newpass = "", phn = "", mail = "";

    public ForgetPassword() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public ForgetPassword(String fpass) {
        initComponents();

        setLocationRelativeTo(null);
        setResizable(false);
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        user = fpass;
        updateBtn.setEnabled(false);
        System.out.println(user);
    }

    public void validateFields() {
        id = userText.getText();
        phn = numberText.getText();
        mail = mailText.getText();
        newpass = newPassText.getText();
        if (!id.equals("") && !phn.equals("") && !mail.equals("") && !newpass.equals("")) {
            updateBtn.setEnabled(true);
        } else {
            updateBtn.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        userText = new javax.swing.JTextField();
        numberText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mailText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        newPassText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/acmsB130px.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("ID : ");

        userText.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        userText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        userText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextActionPerformed(evt);
            }
        });
        userText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userTextKeyReleased(evt);
            }
        });

        numberText.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        numberText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numberText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        numberText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numberTextKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Phone Noumber : ");

        mailText.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        mailText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mailText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mailText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mailTextKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Email : ");

        newPassText.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        newPassText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newPassText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newPassText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newPassTextKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("New Password : ");

        updateBtn.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        updateBtn.setText("Update!");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(newPassText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mailText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(updateBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userText, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberText, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numberText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mailText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newPassText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn)
                    .addComponent(backBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTextActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        id = userText.getText();
        phn = numberText.getText();
        mail = mailText.getText();
        newpass = newPassText.getText();
        String sql = "", tid = "", tphn = "", tmail = "";
        ResultSet rs;
        if (user.equals("TEACHER")) {
            try {
                String quer = "SELECT * FROM TEACHERS WHERE teacher_id=?";
                ResultSet resultSet;
                PreparedStatement pstatement = con.prepareStatement(quer);
                pstatement.setString(1, id);
                resultSet = pstatement.executeQuery();
                while (resultSet.next()) {
                    tphn = resultSet.getString("teacher_phone");
                    tmail = resultSet.getString("teacher_email");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherLayout.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (tphn.equals(phn) && tmail.equals(mail)) {
                try {
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
                    String quer = "UPDATE TEACHERS SET teacher_pass = '" + newpass + "' WHERE teacher_id = '" + id + "'";
                    ResultSet resultSet;
                    PreparedStatement pstatement = con.prepareStatement(quer);
                    pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update successful!");
                    dispose();
                    new Login(user).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, " Invalid email or phone! ");
                numberText.setText("");
                mailText.setText("");
                newPassText.setText("");
            }

        } else if (user.equals("STUDENT")) {
            try {
                String quer = "SELECT * FROM STUDENTS WHERE student_id=?";
                ResultSet resultSet;
                PreparedStatement pstatement = con.prepareStatement(quer);
                pstatement.setString(1, id);
                resultSet = pstatement.executeQuery();
                while (resultSet.next()) {
                    tphn = resultSet.getString("student_phone");
                    tmail = resultSet.getString("student_email");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherLayout.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (tphn.equals(phn) && tmail.equals(mail)) {
                try {
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
                    String quer = "UPDATE STUDENTS SET student_pass = '" + newpass + "' WHERE student_id = '" + id + "'";
                    ResultSet resultSet;
                    PreparedStatement pstatement = con.prepareStatement(quer);
                    pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update successful!");
                    dispose();
                    new Login(user).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, " Invalid email or phone! ");
                numberText.setText("");
                mailText.setText("");
                newPassText.setText("");
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void userTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTextKeyReleased
        validateFields();
    }//GEN-LAST:event_userTextKeyReleased

    private void numberTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberTextKeyReleased
        validateFields();
    }//GEN-LAST:event_numberTextKeyReleased

    private void mailTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mailTextKeyReleased
        validateFields();
    }//GEN-LAST:event_mailTextKeyReleased

    private void newPassTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPassTextKeyReleased
        validateFields();
    }//GEN-LAST:event_newPassTextKeyReleased

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new Login(user).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField mailText;
    private javax.swing.JTextField newPassText;
    private javax.swing.JTextField numberText;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField userText;
    // End of variables declaration//GEN-END:variables
}
