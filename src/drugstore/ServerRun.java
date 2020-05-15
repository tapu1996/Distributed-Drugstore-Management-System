/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugstore;

import com.mysql.cj.protocol.Resultset;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 *
 * @author Tapu & Dev
 */
public class ServerRun {
    public static void main(String[] args)    throws IOException, ClassNotFoundException, SQLException {
        while(true){
         ServerSocket ss=new ServerSocket(8080);  
Socket s=ss.accept();  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());

ObjectOutputStream obj = new ObjectOutputStream(s.getOutputStream());
  //  OutputStream = s.getOutputStream();
        ObjectOutputStream objectOutputStream =  new ObjectOutputStream(s.getOutputStream());
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 Class.forName("com.mysql.cj.jdbc.Driver");
         Connection    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/drugstore","drugstore","1234");

String type = din.readUTF();

    
            System.out.println(type);
     int med_id,unit_price,quantity;
String med_name,mfg_date,expiry_date;


   


     if(type.equalsIgnoreCase("store1sell")) {   
         System.err.println("sdsdsd");
            
  String id = din.readUTF();     
         System.err.println(id);  
String sql = "select * from drugstore1 where med_id=?";
PreparedStatement pst=con.prepareStatement(sql);
//int a=Integer.parseInt(jTextField6.getText());
pst.setString(1, id);
    
ResultSet rs= pst.executeQuery();
//String sql="select * from kkkk where Id=?";
System.err.println("dssds");
if(rs.next())
{
//    obj.reset();
med_id =rs.getInt("med_id");
dout.writeUTF(String.valueOf(id));
//obj.writeObject(med_id);
//obj.reset();
  System.err.println(id);
//jTextField1.setText(String.valueOf(med_id));
med_name=rs.getString("med_name");
    System.err.println(med_name);
//obj.writeObject(med_name);
//obj.reset();
    dout.writeUTF(String.valueOf(med_name));
//jTextField2.setText(med_name);
mfg_date=rs.getString("mfg_date");
  System.err.println(mfg_date);
  //obj.writeObject(mfg_date);
  //obj.reset();
dout.writeUTF(String.valueOf(mfg_date));
//jTextField3.setText(mfg_date);
expiry_date=rs.getString("expiry_date");
  System.err.println(expiry_date);
//  obj.writeObject(expiry_date);
 // obj.reset();
dout.writeUTF(String.valueOf(expiry_date));
//jTextField4.setText(expiry_date);
quantity=rs.getInt("quantity");
  System.err.println(quantity);
//  obj.writeObject(quantity);
  //obj.reset();
dout.writeUTF(String.valueOf(quantity));
//jTextField5.setText(String.valueOf(quantity));
unit_price = rs.getInt("unit_price"); 
dout.writeUTF(String.valueOf(unit_price));
//obj.writeObject(unit_price);
//obj.reset();
 System.err.println(unit_price);
//dout.flush();
 System.err.println(unit_price);
 obj.close();
}
ss.close();

s.close();
din.close();
dout.close();

//jTextField7.setText(String.valueOf(unit_price))
}
     else if(type.equalsIgnoreCase("store1search")){
         ArrayList<arraylistview>a = new ArrayList<arraylistview>();
          String name = din.readUTF();    
          System.err.println(name);
          
          String sql = "select * from drugstore2 where med_name = '" + name + "'";
          System.err.println(sql);
          Statement st = con.createStatement();
          ResultSet  rs = st.executeQuery(sql);
          while(rs.next()){
               String id  = String.valueOf(rs.getInt(1));
               String m_name = rs.getString(2);
               String unitprice =String.valueOf(rs.getInt("unit_price")) ;
               String m_quantity =String.valueOf(rs.getInt("quantity")) ;
               String shop = "Shop2";
               System.err.println(m_quantity);
               //String id, String name,  String quantity, String unitprice,String shop
               arraylistview aa = new arraylistview(id, m_name, m_quantity,unitprice , shop);
               
               a.add(aa);
               System.err.println("ssssss");
             /*  a.add(String.valueOf(id));
               a.add(name);
               a.add(String.valueOf(unitprice));
               a.add(String.valueOf(m_quantity));
               a.add(shop);*/
               
               
          }
          sql = "select * from drugstore3 where med_name = '" + name + "'";
          rs = st.executeQuery(sql);
          while(rs.next()){
               String id  = String.valueOf(rs.getInt(1));
               String m_name = rs.getString(2);
               String unitprice =String.valueOf(rs.getInt("unit_price")) ;
               String m_quantity =String.valueOf(rs.getInt("quantity")) ;
               String shop = "Shop3";
               //String id, String name,  String quantity, String unitprice,String shop
               arraylistview aa = new arraylistview(id, m_name, m_quantity,unitprice , shop);
               a.add(aa);
             /*  a.add(String.valueOf(id));
               a.add(name);
               a.add(String.valueOf(unitprice));
               a.add(String.valueOf(m_quantity));
               a.add(shop);*/
               
               
          }
          if(a.size()>0)
          objectOutputStream.writeObject(a);
          
  
          
         
         
         
     }
     
   //  new ServerRun().main(args);
}

    
    }
     
}
