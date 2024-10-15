package modelo;

import java.sql.*;
import java.util.Date;

public class cita {

    conexion con;

    public cita() {
        con = new conexion();
    }

    /*obtenemos todos los datos de la tabla*/
    public Object[][] getCita() {
        int registro = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            String sql = "SELECT count(1) as total FROM cita ";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            res.next();
            registro = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        //la variable registro y cuantos datos son
        Object[][] datos = new Object[registro][7];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try {
            String sql = "SELECT * FROM cita ORDER BY idcita";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            int i = 0; //Contador
            while (res.next()) {
                int idcita = res.getInt("idcita");
                int idcontacto = res.getInt("idcontacto");
                Date fecha = res.getDate("fecha");
                Time hora = res.getTime("hora");
                String consultorio = res.getString("consultorio");
                String descripcion = res.getString("descripcion");
                int idusuario = res.getInt("idusuario");
                datos[i][0] = idcita;
                datos[i][1] = idcontacto;
                datos[i][2] = fecha;
                datos[i][3] = hora;
                datos[i][4] = consultorio;
                datos[i][5] = descripcion;
                datos[i][6] = idusuario;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }

    /*Añade un nuevo registro*/
    public void AgregarCita(int idcontacto, java.util.Date fecha, java.util.Date hora, String consultorio, String descripcion, int idusuario) {
        String sql = "insert into cita (idcontacto, fecha, hora, consultorio, descripcion, idusuario) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, idcontacto);
            ps.setDate(2, (Date) fecha);
            ps.setDate(3, (Date) hora);
            ps.setString(4, consultorio);
            ps.setString(5, descripcion);
            ps.setInt(6, idusuario);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    /*Modifica un registro existente*/
    public void ModificarCita(int idcita, int idcontacto, java.sql.Date fecha, java.sql.Date hora, String consultorio, String descripcion, int idusuario) {
        String sql = "UPDATE cita SET idcontacto=?, fecha=?, hora=?, consultorio=?, descripcion=?, idusuario=? WHERE idcita=?";
        try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {
            ps.setInt(1, idcontacto);
            ps.setDate(2, fecha);
            ps.setDate(3, hora);
            ps.setString(4, consultorio);
            ps.setString(5, descripcion);
            ps.setInt(6, idusuario);
            ps.setInt(7, idcita);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void cargarComboBox(int idUsuario) {
        try {
            String sql = "SELECT * FROM usuario WHERE idusuario = ?"; // Filtrar por idcontacto
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, idUsuario); // Asignar el valor de idContacto
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                res.getInt("idcita"); // Agregar idcita al JComboBox
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    

}
