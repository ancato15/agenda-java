package controlador;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.cita;
import vista.frmcita;

public class citaController implements ActionListener {

    public final cita modeloCita;
    public final frmcita vistaCita;
    Object[][] datosCita;
    int fila = -1;

    public citaController(cita modeloCita, frmcita vistaCita) {
        this.modeloCita = modeloCita;
        this.vistaCita = vistaCita;
        this.vistaCita.btnguardar.addActionListener(this);
        this.vistaCita.btnlimpiar.addActionListener(this);

    }

    public void limpiar() {
        vistaCita.txtcontacto.setText(null);
        vistaCita.txtfecha.setText(null);
        vistaCita.txthora.setText(null);
        vistaCita.cboconsultorio.setSelectedIndex(0);
        vistaCita.txtdescripcion.setText(null);
        vistaCita.cbousuario.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Metodo de Guardar y Validacion de cedulas
        if (e.getSource() == vistaCita.btnguardar) {
            try {
                /*Paseo de fecha*/
                String formateoFecha = vistaCita.txtfecha.getText();
                SimpleDateFormat f_fecha = new SimpleDateFormat("dd-MM-yyyy"); // Cambia el formato según sea necesario
                Date fecha = f_fecha.parse(formateoFecha);
                /*Parseo de hora*/
                String formateoHora = vistaCita.txthora.getText();
                SimpleDateFormat f_hora = new SimpleDateFormat("HH:mm");
                Date hora = f_hora.parse(formateoHora);
                /*Variables*/
                int idcontacto = 0;
                String consultorio = vistaCita.cboconsultorio.getSelectedItem().toString();
                String descripcion = vistaCita.txtdescripcion.getText();
                int idusuario = 0;
                vistaCita.cbousuario.getSelectedIndex();
                modeloCita.cargarComboBox(idusuario);
                if (vistaCita.txtcontacto.getText().isEmpty() || fecha.toString().isEmpty()
                        || hora.toString().isEmpty() || consultorio.isEmpty() || descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                } else {
                    modeloCita.AgregarCita(idcontacto, fecha, hora, consultorio, descripcion, idusuario);
                    JOptionPane.showMessageDialog(null, "Registro guardado correctamente.");
                    this.limpiar();
                }
            } catch (ParseException ex) {
                Logger.getLogger(citaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == vistaCita.btnlimpiar) {
            this.limpiar();
            JOptionPane.showMessageDialog(null, "Se ha limpiado correctamente...!");
        }
    }

}
