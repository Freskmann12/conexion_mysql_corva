package conexion_mysql_corva;

import java.sql.*;

public class conexion{
    public Connection conex;
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conex = DriverManager.getConnection("jdbc:mysql://localhost/conexion_mysql_corva","root","");
            System.out.println("conexion establecida.");
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
 
         return conex;
            
    }
}
