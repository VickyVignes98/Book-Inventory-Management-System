/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryapp;

/**
 *
 * @author Vicky
 */
abstract class Item{
    protected int indexNumber,quantity;
    protected String name,storeLocation;
    protected double price;
    
    public Item() {
        
    }
    
    public Item(int indexNumber,String name,int quantity,double price,String storeLocation){
        this.indexNumber=indexNumber;
        this.name=name;
        this.quantity=quantity;
        this.price=price;
        this.storeLocation=storeLocation;
    }
    
//    public boolean addQuantity(int n){
//        quantity=quantity+n;
//        return true;
//    }
    
    public void subtractQuantity(int n){
        quantity=quantity-n;
    }
    
    public abstract void details();   
      
        
    public int getIndexNumber(){
        return indexNumber;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getStoreLocation(){
        return storeLocation;
    }
    
    public void setStoreLocation(String storeLocation){
       this.storeLocation=storeLocation;
    }
    
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
}
