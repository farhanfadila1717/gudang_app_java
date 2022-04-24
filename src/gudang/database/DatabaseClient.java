/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gudang.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Parking
 */
public abstract class DatabaseClient {
    final String databaseName = "penjualan";
    public Connection con;
    public Statement statement;
    
    
    public void start() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // INISIALISASI CONNECTION
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, "root", "");
            createStatement();
            System.out.println("Database Started");
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println("DATABASE ERROR" + ex);
        }
    }
    
    public ResultSet executeQuery(String query) {
       ResultSet rs = null;
       if(statement == null) {
           try {
               createStatement();
           } catch (SQLException ex) {
               Logger.getLogger(DatabaseClient.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
        try {
           rs = statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rs;
    }
    
       
    public void  executeQuery2(String query) {
       if(statement == null) {
           try {
               createStatement();
           } catch (SQLException ex) {
               Logger.getLogger(DatabaseClient.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private void createStatement() throws SQLException {
        if(con == null) {
            start();
        }
        
        // INISIALISASI STATEMENT
        statement = con.createStatement();
    }
    
    public String objectToString(Object[] objects) { 
        String query = "(";
        for(int i = 0; i < objects.length; i++) {
            Object o = objects[i];
            boolean isLast = i == objects.length - 1;
            if(isLast) {
                query+= "'" + o + "')";
            } else {
                query+= "'" + o + "',";
            }
        }
        return query;
    }
}
