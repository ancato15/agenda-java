
package modelo;


import java.awt.*;
import java.sql.*;


public class conexion {
    public static String bd = "agenda";
    public static String user = "root";
    public static String password = "12345678";
    public static String url = "jdbc:mariadb://localhost:3306/"+bd;
    
    Connection con ;

    public conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
            if (con!=null) {
                System.out.println("Conexion a Base de datos "+bd);
               // JOptionPane.showMessageDialog(null,"Conexion a Base de datos "+bd);
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    
    public void desconectar(){
        con = null;
    }

    
}
