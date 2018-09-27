
package conexion_mysql_corva;
import java.sql.*;

import conexion_mysql_corva.tercero.*;
public class tercero extends corvaPOA{
    conexion objConec = new conexion();

    @Override
    public boolean insertarcorva(String nombre, String apellido, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarcorva(int id, String nombre, String apellido, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarcorva(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String consultarcorva(int id) {
        String resultado ="";
        
        try {
            String sqlConsultar ="Select * from conexion_mysql_corva where id ="+id;
            objConec.conectar();
            Statement st = objConec.conex.createStatement();
            ResultSet rs = st.executeQuery(sqlConsultar);
            while(rs.next()){
                resultado += rs.getString(2)+ "_"
                        +rs.getString(3)+"_"
                        +rs.getString(4);
            }
            
            
        } catch (Exception e) {
        }
        
        return resultado;
   
    }
    

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
