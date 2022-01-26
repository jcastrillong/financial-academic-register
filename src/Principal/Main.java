package Principal;

import Clases.*;
import GUI.VentanaPrincipal;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String args[]) throws Exception {

        Universidad universidad = new Universidad(3322, "Universidad del Valle", "Calle 5ta");

        try {
            new VentanaPrincipal(universidad).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
