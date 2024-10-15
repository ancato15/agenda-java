package modelo;

import java.sql.*;

public class usuario {
    
    conexion con;

    public usuario() {
        con = new conexion();
    }

    public boolean validarUsuario(String username, String password) {
        try{
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND password = ?";
        PreparedStatement ps = con.getConnection().prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        return rs.next(); // Si hay un resultado, el usuario es válido
        } catch (SQLException e) {
            System.out.println(e); // Imprime el error en la consola
            return true;
        }
    }

}
