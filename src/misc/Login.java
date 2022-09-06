/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package misc;

import connection.loginCon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import merge.TeacherLayout;
import merge.adminLayout;
import merge.managerLayout;
import merge.studentLayout;

/**
 *
 * @author anime
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    Connection con = null;
    String user = "", ID = "";
    
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
        userlogoLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        passwordlogoLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/password.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
    }
    
    public Login(String catche) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        user = catche;
        
        if (user.equals("ADMIN")) {
            login.setText(user + " LOGIN");
            registrationLabel.setVisible(false);
        } else if (user.equals("MANAGER")) {
            forgotLabel1.setVisible(false);
            login.setText(user + " LOGIN");
            registrationLabel.setVisible(false);
        } else if (user.equals("TEACHER")) {
            login.setText(user + " LOGIN");
            registrationLabel.setVisible(true);
        } else if (user.equals("STUDENT")) {
            login.setText(user + " LOGIN");
            registrationLabel.setVisible(true);
        }
        
        userlogoLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        passwordlogoLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/password.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        
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
        logo = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        userlogoLabel = new javax.swing.JLabel();
        passwordlogoLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        useridField = new javax.swing.JTextField();
        showpassCheckbox = new javax.swing.JCheckBox();
        signinBtnLabel = new javax.swing.JLabel();
        optionBtnLabel = new javax.swing.JLabel();
        registrationLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        forgotLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/acmsB130px.png"))); // NOI18N

        login.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.setText("LOGIN");

        passwordField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        passwordField.setToolTipText("Input Password");
        passwordField.setBorder(null);
        passwordField.setPreferredSize(new java.awt.Dimension(75, 25));
        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordFieldMouseClicked(evt);
            }
        });
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        useridField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        useridField.setToolTipText("Input User ID");
        useridField.setBorder(null);
        useridField.setPreferredSize(new java.awt.Dimension(65, 25));
        useridField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                useridFieldMouseClicked(evt);
            }
        });
        useridField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                useridFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                useridFieldKeyReleased(evt);
            }
        });

        showpassCheckbox.setBackground(new java.awt.Color(255, 255, 255));
        showpassCheckbox.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        showpassCheckbox.setText("Show Password");
        showpassCheckbox.setBorder(null);
        showpassCheckbox.setContentAreaFilled(false);
        showpassCheckbox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showpassCheckbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showpassCheckboxMouseClicked(evt);
            }
        });

        signinBtnLabel.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        signinBtnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signinBtnLabel.setText("Sign In");
        signinBtnLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        signinBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signinBtnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signinBtnLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signinBtnLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signinBtnLabelMouseExited(evt);
            }
        });

        optionBtnLabel.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        optionBtnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        optionBtnLabel.setText("Option");
        optionBtnLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        optionBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        optionBtnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optionBtnLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                optionBtnLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                optionBtnLabelMouseExited(evt);
            }
        });

        registrationLabel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        registrationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrationLabel.setText("Want to register? Click here for registration");
        registrationLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrationLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrationLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrationLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrationLabelMouseExited(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(309, 5));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(309, 5));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        forgotLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        forgotLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        forgotLabel1.setText("Forgot Password");
        forgotLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(showpassCheckbox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(forgotLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(passwordlogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(userlogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(useridField, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(optionBtnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(signinBtnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(registrationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 66, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo)
                .addGap(18, 18, 18)
                .addComponent(login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userlogoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(useridField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordlogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showpassCheckbox)
                    .addComponent(forgotLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signinBtnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optionBtnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(registrationLabel)
                .addGap(59, 59, 59))
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

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void signinBtnLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinBtnLabelMouseEntered
        // TODO add your handling code here:
        signinBtnLabel.setFont(signinBtnLabel.getFont().deriveFont(Font.BOLD, 15f));
    }//GEN-LAST:event_signinBtnLabelMouseEntered

    private void signinBtnLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinBtnLabelMouseExited
        // TODO add your handling code here:
        signinBtnLabel.setFont(signinBtnLabel.getFont().deriveFont(~Font.BOLD, 14f));
    }//GEN-LAST:event_signinBtnLabelMouseExited

    private void optionBtnLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionBtnLabelMouseEntered
        // TODO add your handling code here:
        optionBtnLabel.setFont(optionBtnLabel.getFont().deriveFont(Font.BOLD, 15f));
    }//GEN-LAST:event_optionBtnLabelMouseEntered

    private void optionBtnLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionBtnLabelMouseExited
        // TODO add your handling code here:
        optionBtnLabel.setFont(optionBtnLabel.getFont().deriveFont(~Font.BOLD, 14f));
    }//GEN-LAST:event_optionBtnLabelMouseExited

    private void registrationLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationLabelMouseEntered
        // TODO add your handling code here:
        Font font = registrationLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        registrationLabel.setFont(font.deriveFont(attributes));
        registrationLabel.setFont(registrationLabel.getFont().deriveFont(Font.BOLD, 13f));
        registrationLabel.setForeground(Color.red);

    }//GEN-LAST:event_registrationLabelMouseEntered

    private void registrationLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationLabelMouseExited
        // TODO add your handling code here:
        Font font = registrationLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, ~TextAttribute.UNDERLINE_ON);
        registrationLabel.setFont(font.deriveFont(attributes));
        registrationLabel.setFont(registrationLabel.getFont().deriveFont(~Font.BOLD, 12f));
        registrationLabel.setForeground(Color.black);
    }//GEN-LAST:event_registrationLabelMouseExited

    private void showpassCheckboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showpassCheckboxMouseClicked
        // TODO add your handling code here:
        if (showpassCheckbox.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    }//GEN-LAST:event_showpassCheckboxMouseClicked

    private void passwordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMouseClicked
        // TODO add your handling code here:
        if (showpassCheckbox.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    }//GEN-LAST:event_passwordFieldMouseClicked

    private void optionBtnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionBtnLabelMouseClicked
        // TODO add your handling code here:
        dispose();
        new OptionMenu().setVisible(true);
    }//GEN-LAST:event_optionBtnLabelMouseClicked

    private void registrationLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationLabelMouseClicked
        // TODO add your handling code here:
        dispose();
        new Registration(user).setVisible(true);
    }//GEN-LAST:event_registrationLabelMouseClicked

    private void useridFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_useridFieldMouseClicked
        // TODO add your handling code here:
        useridField.setEditable(true);
        //useridField.
    }//GEN-LAST:event_useridFieldMouseClicked

    private void useridFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_useridFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_useridFieldKeyReleased

    private void signinBtnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinBtnLabelMouseClicked
        // TODO add your handling code here:
        try {
            BigInteger UserID = new BigInteger(useridField.getText().toString());
            ID = useridField.getText().toString();
            String Password = String.valueOf(passwordField.getPassword());
            ResultSet rs;
            
            if (user.equals("STUDENT")) {
                loginCon obj = new loginCon();
                rs = obj.returnRS("SELECT * FROM " + user + "S WHERE " + user.toLowerCase() + "_id=" + UserID + " AND " + user.toLowerCase() + "_pass='" + Password + "'");
                try {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Log in successful!");
                        dispose();
                        new studentLayout(ID).setVisible(true);
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or Password is INVALID!\nPlease Try Again..");
                        useridField.setText("");
                        passwordField.setText("");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            } else if (user.equals("TEACHER")) {
                loginCon obj = new loginCon();
                rs = obj.returnRS("SELECT * FROM " + user + "S WHERE " + user.toLowerCase() + "_id=" + UserID + " AND " + user.toLowerCase() + "_pass='" + Password + "'");
                try {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Log in successful!");
                        dispose();
                        new TeacherLayout(ID).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or Password is INVALID!\nPlease Try Again..");
                        useridField.setText("");
                        passwordField.setText("");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (user.equals("ADMIN")) {
                loginCon obj = new loginCon();
                UserID = new BigInteger(useridField.getText().toString());
                ID = useridField.getText().toString();
                Password = String.valueOf(passwordField.getPassword());
                System.out.println(ID+" "+Password);
                if (ID.equals("000001") && Password.equals("123456")) {
                    JOptionPane.showMessageDialog(null, "Log in successful!");
                    dispose();
                    new adminLayout(ID,"Admin Test 00","01999999999","Babar Road","123@gmail.com").setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Username or Password is INVALID!\nPlease Try Again..");
                    useridField.setText("");
                    passwordField.setText("");
                }
            }else if (user.equals("MANAGER")) {
                loginCon obj = new loginCon();
                rs = obj.returnRS("SELECT * FROM " + user + "S WHERE " + user.toLowerCase() + "_id=" + UserID + " AND " + user.toLowerCase() + "_pass='" + Password + "'");
                try {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Log in successful!");
                        dispose();
                        new managerLayout(ID).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or Password is INVALID!\nPlease Try Again..");
                        useridField.setText("");
                        passwordField.setText("");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (NumberFormatException ez) {
            JOptionPane.showMessageDialog(null, "User ID contains characters, only numbers allowed!");
        }
    }//GEN-LAST:event_signinBtnLabelMouseClicked

    private void useridFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_useridFieldKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            //useridField.setEditable(false);
            JOptionPane.showMessageDialog(null, "Only Numbers are allowed!");
            
            String string = useridField.getText();
            //creating a constructor of StringBuffer class  
            StringBuffer sb = new StringBuffer(string);
            //invoking the method  
            sb.deleteCharAt(sb.length() - 1);
            useridField.setText(sb.toString());
        }
    }//GEN-LAST:event_useridFieldKeyPressed

    private void forgotLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotLabel1MouseClicked
        dispose();
        new ForgetPassword(user).setVisible(true);
    }//GEN-LAST:event_forgotLabel1MouseClicked

    private void forgotLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotLabel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_forgotLabel1MouseEntered

    private void forgotLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotLabel1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_forgotLabel1MouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forgotLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel login;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel optionBtnLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordlogoLabel;
    private javax.swing.JLabel registrationLabel;
    private javax.swing.JCheckBox showpassCheckbox;
    private javax.swing.JLabel signinBtnLabel;
    private javax.swing.JTextField useridField;
    private javax.swing.JLabel userlogoLabel;
    // End of variables declaration//GEN-END:variables
}


/*String UserID = useridField.getText();
        String Password = String.valueOf(passwordField.getPassword());
        try {
            String quer = "SELECT * FROM STUDENTS WHERE student_id=? AND student_pass=?";
            ResultSet resultSet;
            PreparedStatement statement = con.prepareStatement(quer);
            statement.setString(1, UserID);
            statement.setString(2, Password);
            resultSet = statement.executeQuery();
            if(resultSet.next())
                {
                    //JOptionPane.showMessageDialog(null, "YES");
                    JOptionPane.showMessageDialog(null, "Logged In");
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Username or Password is INVALID!\nPlease Try Again..");
                    useridField.setText("");
                    passwordField.setText("");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
}*/
 /*try {
        int x = Integer.parseInt(useridField.getText());
    } catch (NumberFormatException nfe) {
        useridField.setText("");
        JOptionPane.showMessageDialog(null, "Only numbers are allowed!");
    }*/