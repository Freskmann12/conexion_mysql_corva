
package conexion_mysql_corva;
import conexion_mysql_corva.conexion_mysql_corva.corvaPOA;
import java.sql.*;

import conexion_mysql_corva.tercero.*;
import javax.swing.JOptionPane;
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
    

    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet cargarTercero(){
        ResultSet resultado = null;
        try {
            String sql = "Select nombre, apellido, telefono from conexion_mysql_corva";
            objConec.conectar();
            Statement st = objConec.conex.createStatement();
            resultado = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+ e.getMessage());
        }
        return resultado;
    }
    
    
}
