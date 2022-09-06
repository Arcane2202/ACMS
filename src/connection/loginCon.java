/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author anime
 */

public class loginCon {
    public Connection connection;
    
    
    public void executeUpdate(String SQL) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet returnRS(String SQL)
    {
        ResultSet resultset=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(
                        "jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
                
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery(SQL);

        } catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The input you inserted is invalid!\nInput Correctly!");
            return null;
        }
        return resultset;
    }
    
    //String sql=null;
        //ConnectMSSQL cnObj = new ConnectMSSQL();
        //cnObj.executeUpdate(sql);
    
    public void establishConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ACMS;selectMethod=cursor", "sa", "123456");
            
            Statement statement = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginCon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginCon.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
