/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Vicky
 */
public class Inventory {
    //COMPOSITION
    private Item[] items;

    public Inventory(){
        //Array of Items
        items= new Item[100];
        items[0]= new ItemFactory().getItem(0,"Mencari Fauzan",100,15.5,"Gambang","Tahir Bukhari","Panching Publishing","Horror",2019);
        items[1]= new ItemFactory().getItem(1,"Azamudin Menyerang",5,200,"Pelabuhan","Iqmal Hisham","Conan Publishing","Adventure",2019);
        items[2]= new ItemFactory().getItem(2,"Castell Eraser",100,2.5,"Kuantan","Eraser","Castell");
        items[3]= new ItemFactory().getItem(3,"Mentari Panas",15,30.0,"Gambang","Tahir Bukhari","Panching Publishing","Romance",2019);
        
        MyConnection conn = new MyConnection();
        PreparedStatement ps;
        ResultSet rst;
        String sql = "SELECT * FROM stationery";
        try {
            ps = conn.createConnection().prepareStatement(sql);
            rst = ps.executeQuery();
            int i = 0;
            while(rst.next()) {
                items[i] = new ItemFactory().getItem(rst.getInt("id"), rst.getString("name"), rst.getInt("quantity"), rst.getFloat("price(RM)"), rst.getString("store_location"), rst.getString("type"),rst.getString("manufacturer"));
                i++;
            }
            
            sql = "SELECT * FROM book";
            ps = conn.createConnection().prepareStatement(sql);
            rst = ps.executeQuery();
            i = 0;
            while(rst.next()) {
                items[i] = new ItemFactory().getItem(rst.getInt("id"), rst.getString("name"), rst.getInt("quantity"), rst.getFloat("price(RM)"), rst.getString("store_location"), rst.getString("author"),rst.getString("publisher"),rst.getString("Category"),Integer.valueOf(rst.getString("year")));
                i++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void searchInventory(){
        String keywordInput;
        
        Scanner newScanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("<< SEARCH INVENTORY >>");
            System.out.print("Input search keyword:");
            keywordInput = newScanner.nextLine();  
            System.out.println("<<SEARCH RESULT>>");
            for(int i=0;i<items.length;i++){
                if(items[i]!=null){
                    if(keywordInput.equals(items[i].getName())){
                        items[i].details();
                    }
                }
            }
    }
    
    public void addInventory(){
        int quantity,emptyArray = 100,choice,bookYear;
        String name,storeLocation,bookAuthor,bookPublisher,bookCategory,stationeryType,manufacturer;
        double price;
        for(int i=0;i<items.length;i++){
            if(items[i]==null){
                emptyArray=i;
                break;
            }
        }
        Scanner newScanner = new Scanner(System.in);
        System.out.println("<< ADD INVENTORY >>");
        System.out.println("1:Book");
        System.out.println("2:Stationery");
        System.out.println("3:Cancel");
        System.out.print("What do you want to add?:");
        choice = Integer.parseInt(newScanner.nextLine());
        switch (choice) {
            case 1:
                System.out.print("Name:");
                name=newScanner.nextLine();

                System.out.print("Quantity:");
                quantity=Integer.parseInt(newScanner.nextLine());
                
                System.out.print("Price:");
                price=Double.parseDouble(newScanner.nextLine());
                
                System.out.print("Location:");
                storeLocation=newScanner.nextLine();
                
                System.out.print("Author:");
                bookAuthor=newScanner.nextLine();
                
                System.out.print("Publisher:");
                bookPublisher=newScanner.nextLine();
                
                System.out.print("Category:");
                bookCategory=newScanner.nextLine();
                
                System.out.print("Year:");
                bookYear=Integer.parseInt(newScanner.nextLine());
                
                items[emptyArray]=new ItemFactory().getItem(emptyArray,name,quantity,price,storeLocation,bookAuthor,bookPublisher,bookCategory,bookYear);
                break;
            case 2:
                System.out.print("Name:");
                name=newScanner.nextLine();

                System.out.print("Quantity:");
                quantity=Integer.parseInt(newScanner.nextLine());
                
                System.out.print("Price:");
                price=Double.parseDouble(newScanner.nextLine());
                
                System.out.print("Location:");
                storeLocation=newScanner.nextLine();
                
                System.out.print("Type:");
                stationeryType=newScanner.nextLine();
                
                System.out.print("Manufacturer:");
                manufacturer=newScanner.nextLine();
               
                
                items[emptyArray]=new ItemFactory().getItem(emptyArray,name,quantity,price,storeLocation,stationeryType,manufacturer);
                break;
            default:
                break;
        }
        viewInventory();
        
        
    }
    
    public void deleteInventory(){
        int indexDelete;
        Scanner newScanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("<< DELETE INVENTORY >>");
        System.out.print("Input index number to delete:");
        indexDelete= newScanner.nextInt();
        if(indexDelete>=0 && indexDelete <items.length){
            if(items[indexDelete]!=null){
                items[indexDelete]=null;
                System.out.println("Inventory deleted");
            }
            else{
                System.out.println("Inventory not found");
            }
                
        }
        else{
            System.out.println("Inventory not exist");
        }
        viewInventory();
    }
    
    public void moveInventory(){
        int moveIndex,moveQuantity,emptyArray = 0,locationNumber;
        String moveLocation;
        Scanner newScanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("<< MOVE INVENTORY >>");
        System.out.print("Input index number to move:");
        moveIndex=Integer.parseInt(newScanner.nextLine());
        System.out.println("1:Pekan");
        System.out.println("2:Gambang");
        System.out.println("3:Kuantan");
        System.out.print("Where to move?:");
        locationNumber=Integer.parseInt(newScanner.nextLine());
        switch (locationNumber) {
            case 1:
                moveLocation="Pekan";
                break;
            case 2:
                moveLocation="Gambang";
                break;
            default:
                moveLocation="Kuantan";
                break;
        }
        System.out.print("Quantity to move:");
        moveQuantity=Integer.parseInt(newScanner.nextLine());
        if(moveLocation.equals(items[moveIndex].getStoreLocation())){
            System.out.println("The Inventory is already there");
        }
        else{
            if(moveQuantity==items[moveIndex].getQuantity()){
                items[moveIndex].setStoreLocation(moveLocation);
            }
            else{
                for(int i=0;i<items.length;i++){
                    if(items[i]==null){
                        emptyArray=i;
                        break;
                    }
                }
                //Downcasting
                if(items[moveIndex] instanceof Book){
                    Book downcaster = (Book) items[moveIndex];
                    items[emptyArray]= new ItemFactory().getItem(emptyArray,items[moveIndex].getName(),moveQuantity,items[moveIndex].getPrice(),moveLocation,downcaster.getBookAuthor(),downcaster.getBookPublisher(),downcaster.getBookCategory(),downcaster.getBookYear());
                }
                else if(items[moveIndex] instanceof Stationery){
                    Stationery downcaster = (Stationery) items[moveIndex];
                    items[emptyArray]= new ItemFactory().getItem(emptyArray,items[moveIndex].getName(),moveQuantity,items[moveIndex].getPrice(),moveLocation,downcaster.getStationeryType(),downcaster.getManufacturer());
                }
                items[moveIndex].subtractQuantity(moveQuantity);
            }
        }
        viewInventory();
        
    }
    
    public void viewInventory(){
        System.out.println("");
        System.out.println("<< VIEW INVENTORY >>");
        String leftAlignFormat = "| %-8d | %-26s | %-9d | RM %-7.2f | %-13s |%n";

        System.out.format("+----------+----------------------------+-----------+------------+---------------+%n");
        System.out.format("| IndexNum | Name                       | Quantity  | Unit Price | Location      |%n");
        System.out.format("+----------+----------------------------+-----------+------------+---------------+%n");
        for (int i = 0; i < items.length; i++) {
            if(items[i]!=null){
                String type;
                if(items[i] instanceof Book) type = "Book";
                else type = "Stationery";
                System.out.format(leftAlignFormat, items[i].getIndexNumber(),items[i].getName(),items[i].getQuantity(),items[i].getPrice(),items[i].getStoreLocation(), type);
            }
        }
        System.out.format("+----------+----------------------------+-----------+------------+---------------+%n");
    }

    
}
