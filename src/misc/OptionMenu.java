/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package misc;

import java.awt.Color;

/**
 *
 * @author anime
 */
public class OptionMenu extends javax.swing.JFrame {

    /**
     * Creates new form OptionMenu
     */
    
    public OptionMenu() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
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
        studentPanel = new javax.swing.JPanel();
        studentLabel = new javax.swing.JLabel();
        managerPanel = new javax.swing.JPanel();
        managerLabel = new javax.swing.JLabel();
        teacherPanel = new javax.swing.JPanel();
        teacherLabel = new javax.swing.JLabel();
        adminPanel = new javax.swing.JPanel();
        adminLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(37, 36, 34));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        studentPanel.setBackground(null);
        studentPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        studentPanel.setForeground(new java.awt.Color(255, 255, 255));

        studentLabel.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        studentLabel.setForeground(new java.awt.Color(255, 255, 255));
        studentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentLabel.setText("STUDENT");
        studentLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                studentLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
        studentPanel.setLayout(studentPanelLayout);
        studentPanelLayout.setHorizontalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        studentPanelLayout.setVerticalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        managerPanel.setBackground(null);
        managerPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        managerPanel.setForeground(new java.awt.Color(255, 255, 255));

        managerLabel.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        managerLabel.setForeground(new java.awt.Color(255, 255, 255));
        managerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        managerLabel.setText("MANAGER");
        managerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        managerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managerLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                managerLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                managerLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout managerPanelLayout = new javax.swing.GroupLayout(managerPanel);
        managerPanel.setLayout(managerPanelLayout);
        managerPanelLayout.setHorizontalGroup(
            managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(managerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );
        managerPanelLayout.setVerticalGroup(
            managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(managerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        teacherPanel.setBackground(null);
        teacherPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        teacherPanel.setForeground(new java.awt.Color(255, 255, 255));

        teacherLabel.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        teacherLabel.setForeground(new java.awt.Color(255, 255, 255));
        teacherLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teacherLabel.setText("TEACHER");
        teacherLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teacherLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                teacherLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                teacherLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout teacherPanelLayout = new javax.swing.GroupLayout(teacherPanel);
        teacherPanel.setLayout(teacherPanelLayout);
        teacherPanelLayout.setHorizontalGroup(
            teacherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(teacherLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        teacherPanelLayout.setVerticalGroup(
            teacherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(teacherLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        adminPanel.setBackground(null);
        adminPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        adminPanel.setForeground(new java.awt.Color(255, 255, 255));
        adminPanel.setToolTipText("");

        adminLabel.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        adminLabel.setForeground(new java.awt.Color(255, 255, 255));
        adminLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminLabel.setText("ADMIN");
        adminLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adminLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SELECT USER:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(studentPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(managerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(teacherPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(adminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(managerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(teacherPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
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

    private void adminLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLabelMouseEntered
        // TODO add your handling code here:
        adminPanel.setBackground(Color.white);
        adminLabel.setForeground(Color.black);
    }//GEN-LAST:event_adminLabelMouseEntered

    private void adminLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLabelMouseExited
        // TODO add your handling code here:
        adminPanel.setBackground(null);
        adminLabel.setForeground(Color.white);
    }//GEN-LAST:event_adminLabelMouseExited

    private void managerLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managerLabelMouseEntered
        // TODO add your handling code here:
        managerPanel.setBackground(Color.white);
        managerLabel.setForeground(Color.black);
    }//GEN-LAST:event_managerLabelMouseEntered

    private void managerLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managerLabelMouseExited
        // TODO add your handling code here:
        managerPanel.setBackground(null);
        managerLabel.setForeground(Color.white);
    }//GEN-LAST:event_managerLabelMouseExited

    private void teacherLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherLabelMouseEntered
        // TODO add your handling code here:
        teacherPanel.setBackground(Color.white);
        teacherLabel.setForeground(Color.black);
    }//GEN-LAST:event_teacherLabelMouseEntered

    private void teacherLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherLabelMouseExited
        // TODO add your handling code here:
        teacherPanel.setBackground(null);
        teacherLabel.setForeground(Color.white);
    }//GEN-LAST:event_teacherLabelMouseExited

    private void studentLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLabelMouseEntered
        // TODO add your handling code here:
        studentPanel.setBackground(Color.white);
        studentLabel.setForeground(Color.black);
    }//GEN-LAST:event_studentLabelMouseEntered

    private void studentLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLabelMouseExited
        // TODO add your handling code here:
        studentPanel.setBackground(null);
        studentLabel.setForeground(Color.white);
    }//GEN-LAST:event_studentLabelMouseExited

    private void adminLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLabelMouseClicked
        // TODO add your handling code here:
        dispose();
        new Login("ADMIN").setVisible(true);
    }//GEN-LAST:event_adminLabelMouseClicked

    private void managerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managerLabelMouseClicked
        // TODO add your handling code here:
        dispose();
        new Login("MANAGER").setVisible(true);
    }//GEN-LAST:event_managerLabelMouseClicked

    private void teacherLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherLabelMouseClicked
        // TODO add your handling code here:
        dispose();
        new Login("TEACHER").setVisible(true);
    }//GEN-LAST:event_teacherLabelMouseClicked

    private void studentLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLabelMouseClicked
        // TODO add your handling code here:
        dispose();
        new Login("STUDENT").setVisible(true);
    }//GEN-LAST:event_studentLabelMouseClicked

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
            java.util.logging.Logger.getLogger(OptionMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminLabel;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel managerLabel;
    private javax.swing.JPanel managerPanel;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JPanel studentPanel;
    private javax.swing.JLabel teacherLabel;
    private javax.swing.JPanel teacherPanel;
    // End of variables declaration//GEN-END:variables
}
