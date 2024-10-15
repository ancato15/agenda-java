package controlador;

import javax.swing.JOptionPane;
import modelo.usuario;
import vista.frmlogin;
import vista.frmmenu;

public class usuarioController{

    public final usuario modeloUsuario;
    public final frmlogin vistaLogin;

    public usuarioController(usuario modeloUsuario, frmlogin vistaLogin) {
        this.modeloUsuario = modeloUsuario;
        this.vistaLogin = vistaLogin;
    }

    public void iniciarSesion() {
        String username = vistaLogin.txtusuario.getText();
        String password = vistaLogin.txtpassword.getText();
        if (modeloUsuario.validarUsuario(username, password)) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!");
            frmmenu menu = new frmmenu();
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
            this.vistaLogin.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
        }
    }
}
