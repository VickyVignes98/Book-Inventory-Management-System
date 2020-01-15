/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vicky
 */
public class Book extends Item {
    private String bookAuthor,bookPublisher,bookCategory;
    private int bookYear;
   
    
   public Book(int indexNumber,String name,int quantity,double price,String storeLocation,String bookAuthor,String bookPublisher,String bookCategory,int bookYear){
       //INHERITANCE
       super(indexNumber,name,quantity,price,storeLocation);
       this.bookAuthor=bookAuthor;
       this.bookPublisher=bookPublisher;
       this.bookCategory=bookCategory;
       this.bookYear=bookYear;
        
    }

    public Book() {
        super();
    }
    
   @Override
    public void details(){
        System.out.println(indexNumber+"\t"+name+"\t"+quantity+"\t"+price+"\t"+bookAuthor+"\t"+bookPublisher+"\t"+bookCategory+"\t"+bookYear);
    } 
    
    public void getBooks(JTable table) {
        int rIndex = table.getSelectedRow();
        Object[] row;
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        ResultSet rst;
        
        String sql = "SELECT * FROM book";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            rst = ps.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            while(rst.next()) {
                row = new Object[9];
                row[0] = rst.getInt(1);
                row[1] = rst.getString(2);
                row[2]=rst.getInt(3);
                row[3]=rst.getFloat(4);
                row[4]=rst.getString(5);
                row[5]=rst.getString(6);
                row[6]=rst.getString(7);
                row[7]=rst.getString(8);  
                row[8]=rst.getInt(9);
                
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean subQuantity(int id, int value) {
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        
        String sql = "UPDATE book SET quantity = quantity - ? WHERE id = ?";
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
    
    public boolean addBook() {
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        
        String sql = "INSERT INTO book VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            ps.setInt(1, indexNumber);
            ps.setString(2, name);
            ps.setInt(3,quantity);
            ps.setDouble(4,price);
            ps.setString(5,storeLocation);
            ps.setString(6,bookAuthor);
            ps.setString(7,bookPublisher);
            ps.setString(8,bookCategory);
            ps.setInt(9,bookYear);
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
    
    public void searchBookById(JTable table, int id) {
        Object[] row;
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        ResultSet rst;
        
        String sql = "SELECT * FROM book WHERE id = ?";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rst = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            row = new Object[9];
            if(rst.next()) {
                row[0] = rst.getInt(1);
                row[1] = rst.getString(2);
                row[2]=rst.getInt(3);
                row[3]=rst.getFloat(4);
                row[4]=rst.getString(5);
                row[5]=rst.getString(6);
                row[6]=rst.getString(7);
                row[7]=rst.getString(8);  
                row[8]=rst.getInt(9);

                tableModel.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void searchBook(JTable table, String keyword){
        Object[] row;
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        ResultSet rst;
        
        String sql = "SELECT * FROM book WHERE name LIKE ?";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            ps.setString(1,"%"+ keyword + "%");
            rst = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            row = new Object[9];
            if(rst.next()) {
                row[0] = rst.getInt(1);
                row[1] = rst.getString(2);
                row[2]=rst.getInt(3);
                row[3]=rst.getFloat(4);
                row[4]=rst.getString(5);
                row[5]=rst.getString(6);
                row[6]=rst.getString(7);
                row[7]=rst.getString(8);  
                row[8]=rst.getInt(9);

                tableModel.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public boolean deleteBook(int id){
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        
        String sql = "DELETE FROM book WHERE id = ?";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
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
    
     public boolean moveBook(int id,String storeLocation){
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        
        String sql = "UPDATE book SET store_location = ? WHERE id = ?";
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
           Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
           return false;
        }
        
    }
    
    
    public boolean addQuantiy(int id, int value){
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        
        String sql = "UPDATE book SET quantity = quantity + ? WHERE id = ?";
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
    
    
    public String getBookAuthor(){
        return bookAuthor;
    }
    
    public String getBookPublisher(){
        return bookPublisher;
    }
    
    public String getBookCategory(){
        return bookCategory;
    }
    
    public int getBookYear(){
        return bookYear;
    }
        
}
