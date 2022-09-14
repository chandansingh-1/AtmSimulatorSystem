package ASimulatorSystem;

import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  // register the databse driver
            c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","root");   //creating connection 
            s = c.createStatement(); //creates a Statment instance for sending stattements to the database
           
        }catch(Exception e){
            System.out.println(e);
        }  
    }
    
   
}  