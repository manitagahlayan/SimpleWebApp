package demo;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
/**
 *
 * @author DELL
 */
public class SampleDBConnection {
    
    public static void main(String[] args)throws Exception{
        
        getConnection();
        
    }
    public static Connection getConnection() throws Exception{
        
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/database1";
            String username ="root";
            String password ="root";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
           
            Statement stmt = conn.createStatement();
            //insert statement
            String sql = "insert into database1.employeeinfo"+
                    "(EmployeeID,First_Name,Last_Name,Age)"+ "values ('12','Jyoti','Thakur','65')";
            //update statement
            String sql1 ="update database1.employeeinfo set Last_Name"+"='Thakur'" +"where EmployeeID='11'";
            
            int result = stmt.executeUpdate(sql);
            int result1 = stmt.executeUpdate(sql1);
            
            System.out.println("Rows Affected:"+ result);
            System.out.println("Rows Affected:"+ result1);
            return conn;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
        
    }
}

