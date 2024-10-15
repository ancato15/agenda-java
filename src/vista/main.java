package vista;

import com.formdev.flatlaf.themes.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class main {


    public static void main(String[] args) throws UnsupportedLookAndFeelException {
           UIManager.setLookAndFeel(new FlatMacLightLaf());
           frmlogin login = new frmlogin();
           login.setVisible(true);
           login.setLocationRelativeTo(null);
           login.setTitle("Inicio de Sesion");
    }

}
