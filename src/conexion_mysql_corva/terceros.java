
package conexion_mysql_corva;

import java.sql.*;
import javax.swing.JOptionPane;
import conexion_mysql_corva.terceros.*;

public class terceros extends corvaPOA {
    conexion objConec = new conexion();
    

    @Override
    public boolean insertarcorva(String nombre, String apellido, String telefono) {
        boolean resultado = false;
        
        try {
            String sql= "insert into terceros (nombres,apellidos,telefono)values('"+nombre+"','"+apellido+"','"+telefono+"')";
            objConec.conectar();
            Statement st = objConec.conex.createStatement();
            int valor = st.executeUpdate(sql);
            if (valor>0){
                resultado = true;
            }
            objConec.conex.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar. "+e.getMessage());
        }
        return resultado;
        
        
    }

    @Override
    public boolean actualizarcorva(int id, String nombre, String apellido, String telefono) {
        
        boolean resultado = false;
        
        try {
            String sql = "update tercero set nombres = '"+nombre+"',apellidos = '"+apellido+"',telefono = '"+telefono+"' where id = '"+id+"'";
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar. "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarcorva(int id) {
        boolean resultado = false;
        
        try {
            String sql = "Delete from terceros where id = "+id;
            objConec.conectar();
            Statement st = objConec.conex.createStatement();
            int valor = st.executeUpdate(sql);
            if (valor>0){
                resultado = true;
            }
            objConec.conex.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar. "+e.getMessage());
        }

        return resultado;
    }

    @Override
    public String consultarcorva(int id) {
        
        String resultado = "";
        
            try {
                String sqlConsultar = "Select * from terceros where id = "+ id;
                objConec.conectar();
                Statement st = objConec.conex.createStatement();
                ResultSet rs = st.executeQuery(sqlConsultar);
                    while (rs.next()) {
                        resultado += rs.getString(2) + " - "
                        + rs.getString(3) + " - "
                        + rs.getString(4);
            }
            //Se cierran las conexiones
            rs.close();
            objConec.conex.close();
        } catch (Exception e) {
              //  System.out.println("Error: "+ e.getMessage);
        }
        
        return resultado; 
        
        
    }
    
    
    public ResultSet cargarTercero(){
        ResultSet resultado = null;
        try {
            String sql = "Select nombres, apellidos, telefono from terceros";
            objConec.conectar();
            Statement st = objConec.conex.createStatement();
            resultado = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+ e.getMessage());
        }
        return resultado;
    }

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
