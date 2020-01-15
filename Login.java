/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryapp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Vicky
 */
public class Login {
    private User user;
    
    public Login(User user){
        //AGGREGATION
        this.user=user;
    }
    public boolean verifyLogin(){
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        ResultSet rst;
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rst = ps.executeQuery();
            if(rst.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
