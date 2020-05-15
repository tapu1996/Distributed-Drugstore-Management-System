/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drugstore;
import java.io.Serializable;
/**
 *
 * @author Tapu & Dev
 */
public class arraylistview implements Serializable{
String id; String name; String unitprice; String quantity; String shop;
   // private final String id;
    public arraylistview(String id, String name,  String quantity, String unitprice,String shop) {  
    this.id = id;  
    this.name = name;  
    this.quantity = quantity;  
    this.shop = shop;  
    this.unitprice = unitprice;  
}  
}
