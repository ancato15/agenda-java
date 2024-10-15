package modelo;

import java.sql.*;

public class contacto {

    conexion con;

    public contacto() {
        con = new conexion();
    }

    /*obtenemos todos los datos de la tabla*/
    public Object[][] getContacto() {
        int registro = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            String sql = "SELECT count(1) as total FROM contacto ";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            res.next();
            registro = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        //la variable registro y cuantos datos son
        Object[][] datos = new Object[registro][6];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try {
            String sql = "SELECT * FROM contacto ORDER BY idcontacto";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            int i = 0; //Contador
            while (res.next()) {
                int idcontacto = res.getInt("idcontacto");
                long cedula = res.getLong("cedula");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String direccion = res.getString("direccion");
                long celular = res.getLong("celular");
                datos[i][0] = idcontacto;
                datos[i][1] = cedula;
                datos[i][2] = nombre;
                datos[i][3] = apellido;
                datos[i][4] = direccion;
                datos[i][5] = celular;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }

    /*Añade un nuevo registro*/
    public void AgregarContacto(long cedula, String nombre, String apellido, String direccion, long celular) {
        String sql = "insert into contacto (cedula, nombre, apellido, direccion, celular) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setLong(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, direccion);
            ps.setLong(5, celular);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public boolean existeCedula(long cedula) {
        String sql = "SELECT COUNT(*) FROM contacto WHERE cedula = ?";
        try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {
            ps.setLong(1, cedula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getLong(1) > 0; // Retorna true si hay al menos un registro
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar la cédula: " + e.getMessage());
        }
        return false; // Retorna false si ocurre un error o no hay registros
    }

    /*Modifica un registro existente*/
    public void ModificarContacto(int id, long cedula, String nombre, String apellido, String direccion, long celular) {
        String sql = "UPDATE contacto SET cedula=?, nombre=?, apellido=?, direccion=?, celular=? WHERE idcontacto=?";
        try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {
            ps.setLong(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, direccion);
            ps.setLong(5, celular);
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Object[][] buscarContactoPorCedula(long cedulaBuscada) {
        Object[][] datos = null;
        try {
            // Primero, obtenemos la cantidad de registros que coinciden con la cédula
            String sql = "SELECT count(1) as total FROM contacto WHERE cedula = ?";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setLong(1, cedulaBuscada);
            ResultSet res = ps.executeQuery();
            res.next();
            int registro = res.getInt("total");
            res.close();
            // Si hay registros, los obtenemos
            if (registro > 0) {
                datos = new Object[registro][6];
                sql = "SELECT * FROM contacto WHERE cedula = ? ORDER BY idcontacto";
                ps = con.getConnection().prepareStatement(sql);
                ps.setLong(1, cedulaBuscada);
                res = ps.executeQuery();
                int i = 0; // Contador
                while (res.next()) {
                    int idcontacto = res.getInt("idcontacto");
                    String nombre = res.getString("nombre");
                    String apellido = res.getString("apellido");
                    String direccion = res.getString("direccion");
                    long celular = res.getInt("celular");
                    datos[i][0] = idcontacto;
                    datos[i][1] = cedulaBuscada; // Usamos la cédula buscada
                    datos[i][2] = nombre;
                    datos[i][3] = apellido;
                    datos[i][4] = direccion;
                    datos[i][5] = celular;
                    i++;
                }
                res.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }

}
