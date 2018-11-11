/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mate_
 */
public class Conexion {
    
    public Connection connect(){
        Connection con = null;
        String URL = "jdbc:sqlserver://localhost:1433;databaseName = CinemaMorgan";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             con = DriverManager.getConnection(URL, "Skrillmau", "1234");
             System.out.println("Conexion con la base de datos establecida");
            
        }catch(ClassNotFoundException | SQLException e){
            System.err.println("Error estableciendo conexion con la base de datos");
            System.err.println(e.getMessage());
        }
        return con;
    }
            
}
