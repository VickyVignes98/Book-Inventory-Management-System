/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vicky
 */
public class MyConnection {
    public Connection createConnection() {
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project?serverTimezone=UTC","root","");
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        
        return connection;
    }
}
