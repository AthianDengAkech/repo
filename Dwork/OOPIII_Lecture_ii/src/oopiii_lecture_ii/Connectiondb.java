/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopiii_lecture_ii;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Athian Deng Akech
 */
public class Connectiondb {
    
    static Connection conn = null;
    public static Connection dbConnect(){
    
        try{
    
   // Class.forName("com.mysql.jdbc.Driver");
    
    conn = DriverManager.getConnection("jdbc:mysql://localhost/javadb", "root","");
    
        String  url = "'jdbc:mysql://lacolhost/javadb','root', ''";
        
        return conn;
        
        } catch(Exception e){
         JOptionPane.showMessageDialog(null, e);

        return conn;
        }
        
        }

}
    
    
    


