/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugstore;

import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tapu & Dev
 */
public class Drugstore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/drugstore","drugstore","1234");
//here sonoo is database name, root is username and password
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from a");
while(rs.next())
    System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Drugstore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
