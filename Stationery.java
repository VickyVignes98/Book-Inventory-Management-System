/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryapp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vicky
 */
public class Stationery extends Item{
    private String stationeryType, manufacturer;
    private Calendar warrantyStart;
    
    public Stationery(int indexNumber,String name,int quantity,double price,String storeLocation,String stationeryType,String manufacturer){
        super(indexNumber,name,quantity,price,storeLocation);
        this.stationeryType=stationeryType;
        this.manufacturer=manufacturer;
    }
    
    public Stationery(){
        super();
    }
    
    @Override
    public void details(){
         System.out.println(indexNumber+"\t"+name+"t"+quantity+"\t"+price+"\t"+storeLocation+"\t"+stationeryType+"\t"+manufacturer);
    }
    public void getSt(JTable table) {
        int rIndex = table.getSelectedRow();
        Object[] row;
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        ResultSet rst;
        
        String sql = "SELECT * FROM stationery";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            rst = ps.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            while(rst.next()) {
                row = new Object[7];
                row[0] = rst.getInt(1);
                row[1] = rst.getString(2);
                row[2]=rst.getInt(3);
                row[3]=rst.getFloat(4);
                row[4]=rst.getString(5);
                row[5]=rst.getString(6);
                row[6]=rst.getString(7);

                
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Stationery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public boolean addSt() {
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        
        String sql = "INSERT INTO stationery VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            ps.setInt(1, indexNumber);
            ps.setString(2, name);
            ps.setInt(3,quantity);
            ps.setDouble(4,price);
            ps.setString(5,storeLocation);
            ps.setString(6,stationeryType);
            ps.setString(7,manufacturer);

            if(ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Stationery.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public void searchSt(JTable table, String keyword){
        int rIndex = table.getSelectedRow();
        Object[] row;
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        ResultSet rst;
        
        String sql = "SELECT * FROM stationery WHERE name LIKE ?";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rst = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            row = new Object[7];
            if(rst.next()) {
                row[0] = rst.getInt(1);
                row[1] = rst.getString(2);
                row[2]=rst.getInt(3);
                row[3]=rst.getFloat(4);
                row[4]=rst.getString(5);
                row[5]=rst.getString(6);
                row[6]=rst.getString(7);


                tableModel.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Stationery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean moveSt(int id,String storeLocation){
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        
        String sql = "UPDATE stationery SET store_location = ? WHERE id = ?";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            ps.setString(1, storeLocation);
            ps.setInt(2,id);
            if(ps.executeUpdate() > 0) {
                return true;
            } else{
                return false;
            }
        }catch (SQLException ex) {
           Logger.getLogger(Stationery.class.getName()).log(Level.SEVERE, null, ex);
           return false;
        }
        
    }
           
    public boolean subQuantity(int id, int value) {
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        
        String sql = "UPDATE stationery SET quantity = quantity - ? WHERE id = ?";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            ps.setInt(1, value);
            ps.setInt(2, id);
            if(ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
           Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
           return false;
        }
    }

      public void deleteSt(int id){
        Object[] row;
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        ResultSet rst;
        
        String sql = "DELETE FROM stationery WHERE id = ?";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rst = ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
      
      public boolean addQuantiy(int id, int value){
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        
        String sql = "UPDATE stationery SET quantity = quantity + ? WHERE id = ?";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            ps.setInt(1, value);
            ps.setInt(2, id);
            if(ps.executeUpdate() > 0) {
                return true;
            } else{
                return false;
            }
        }catch (SQLException ex) {
           Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
           return false;
        }
        
    }
      
    public void searchBookById(JTable table, int id) {
        Object[] row;
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        ResultSet rst;
        
        String sql = "SELECT * FROM stationery WHERE id = ?";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rst = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            row = new Object[7];
            if(rst.next()) {
                row[0] = rst.getInt(1);
                row[1] = rst.getString(2);
                row[2]=rst.getInt(3);
                row[3]=rst.getFloat(4);
                row[4]=rst.getString(5);
                row[5]=rst.getString(6);
                row[6]=rst.getString(7);

                tableModel.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registerWarranty(int year, int month, int date){
        warrantyStart.set(year, month, date);
    }
    
    public int calcDayWarrantyLeft(){
        return 0;
    }
    
    public String getStationeryType(){
        return stationeryType;
    }
    
    public String getManufacturer(){
        return manufacturer;
    }
}
