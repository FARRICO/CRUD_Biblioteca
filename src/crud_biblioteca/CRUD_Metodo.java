/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author FARRICO
 */
public class CRUD_Metodo {
    
    //public static void main(String[] args) {
    //ConsultWind re = new ConsultWind();
    //re.setVisible(false);
    //}
    
    private static Connection Conexion;
    
    int Co=0;

    public void MySQLConnection(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD_Metodo.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "Error al conectar");
            System.out.println("Error al conectar");
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_Metodo.class.getName()).log(Level.SEVERE, null, ex);
                        Co=1;
			JOptionPane.showMessageDialog(null, "Error al conectar");
            System.out.println("Error al conectar");
        }
        
        
    }
    
    public void closeConnection() {
        try {
            Conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");

        } catch (SQLException ex) {
            Logger.getLogger(CRUD_Metodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void insertData(String table_name,String columnas, String ID, String name, String Sname, String dir, String tlf) {
        try {
            String Query = "INSERT INTO " + table_name + columnas + " VALUES("
                    + "\"" + ID + "\", "
                    + "\"" + name + "\", "
                    + "\"" + Sname + "\", "
                    + "\"" + dir + "\", "
                    + "\"" + tlf + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }
        

        

    
    public void deleteRecord(String table_name, String ID) {
        try {
            String Query = "DELETE FROM " + table_name + " WHERE CI = \"" + ID + "\"";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos borrados de forma exitosa");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }    

}
