package controlador;

import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.contacto;
import vista.frmcontacto; 

public class contactoController implements ActionListener {

    public final contacto modeloContacto;
    public final frmcontacto vistaContacto;
    Object[][] datosContacto;
    int fila = -1;

    public contactoController(contacto modeloContacto, frmcontacto vistaContacto) {
        this.modeloContacto = modeloContacto;
        this.vistaContacto = vistaContacto;
        this.vistaContacto.btnguardar.addActionListener(this);
        this.vistaContacto.btnactualizar.addActionListener(this);
        this.vistaContacto.btnlimpiar.addActionListener(this);
        this.vistaContacto.btnbuscar.addActionListener(this);
        //Para deshabilitar la modificacion de la tabla
        this.vistaContacto.tbcontacto.setDefaultEditor(Object.class, null);

    }

    public void updateTabla() {
        Object[] columna = {"ID", "Cedula", "Nombres", "Apellidos", "Dirección", "Celular"};
        // se utiliza la funcion
        datosContacto = modeloContacto.getContacto();
        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(datosContacto, columna);
        vistaContacto.tbcontacto.setModel(datos);
    }

    public void limpiar() {
        vistaContacto.txtID.setText(null);
        vistaContacto.txtcedula.setText(null);
        vistaContacto.txtnombre.setText(null);
        vistaContacto.txtapellido.setText(null);
        vistaContacto.txtdireccion.setText(null);
        vistaContacto.txtcelular.setText(null);
        vistaContacto.txtbuscar.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Metodo de Guardar y Validacion de cedulas
        if (e.getSource() == vistaContacto.btnguardar) {
            long cedula, celular = 0;
            String nombre = vistaContacto.txtnombre.getText();
            String apellido = vistaContacto.txtapellido.getText();
            String direccion = vistaContacto.txtdireccion.getText();
            if (vistaContacto.txtcedula.getText().isEmpty() || nombre.isEmpty()
                    || apellido.isEmpty() || direccion.isEmpty() || vistaContacto.txtcelular.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            } else {
                try {
                    cedula = Long.parseLong(vistaContacto.txtcedula.getText());
                    // Verificar si la cédula o el celular ya existen
                    if (modeloContacto.existeCedula(cedula)) {
                        JOptionPane.showMessageDialog(null, "Error: La cédula ya está registrada.");
                    } else {
                        // Agregar nuevo contacto
                        modeloContacto.AgregarContacto(cedula, nombre, apellido, direccion, celular);
                        JOptionPane.showMessageDialog(null, "Registro guardado correctamente.");
                        this.limpiar();
                        this.updateTabla();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un número de cédula válido.");
                }
            }

        }

        //Metodo de Actualizar
        if (e.getSource() == vistaContacto.btnactualizar) {
            fila = vistaContacto.tbcontacto.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para actualizar.");
                return;
            }
            int id = Integer.parseInt(vistaContacto.tbcontacto.getValueAt(fila, 0).toString());
            long cedula = Long.parseLong(vistaContacto.txtcedula.getText());
            String nombre = vistaContacto.txtnombre.getText();
            String apellido = vistaContacto.txtapellido.getText();
            String direccion = vistaContacto.txtdireccion.getText();
            long celular = Long.parseLong(vistaContacto.txtcelular.getText());
            modeloContacto.ModificarContacto(id, cedula, nombre, apellido, direccion, celular);
            JOptionPane.showMessageDialog(null, "Se ha modificado correctamente el dato");
            this.updateTabla();
        }
        //Metodo para buscar por cedula
        if (e.getSource() == vistaContacto.btnbuscar) {
            try {
                long cedula = Long.parseLong(vistaContacto.txtbuscar.getText());
                Object[][] resultados = modeloContacto.buscarContactoPorCedula(cedula);
                if (resultados != null && resultados.length > 0) {
                    Object[] columna = {"ID", "Cedula", "Nombres", "Apellidos", "Dirección", "Celular"};
                    datosContacto = modeloContacto.buscarContactoPorCedula(cedula);
                    DefaultTableModel datos = new DefaultTableModel(datosContacto, columna);
                    vistaContacto.tbcontacto.setModel(datos);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron contactos con esa cédula.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número de cédula válido.");
            }
        }
        //Metodo para limpiar
        if (e.getSource() == vistaContacto.btnlimpiar) {
            this.limpiar();
        }
    }
}
