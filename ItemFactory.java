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
public class ItemFactory {
    public Item getItem(int indexNumber,String name,int quantity,double price,String storeLocation,String bookAuthor,String bookPublisher,String bookCategory,int bookYear) {
        Item obj = new Book(indexNumber,name,quantity,price,storeLocation,bookAuthor,bookPublisher,bookCategory,bookYear);
        return obj;
    }
     public Item getItem(int indexNumber,String name,int quantity,double price,String storeLocation,String stationeryType,String manufacturer) {
        Item obj = new Stationery(indexNumber,name,quantity,price,storeLocation,stationeryType,manufacturer);
        return obj;
     }
}
