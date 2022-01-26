package GUI;

import Clases.*;
import Excepciones.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {

    private Universidad universidad;

    public VentanaPrincipal(Universidad universidad) {
        this.universidad = universidad;
        initComponents();
        this.menuConsultarProgamacion.addActionListener(new MostrarMenuConsulProgram());
        this.menuRealizarMatricula.addActionListener(new MostrarMenuMatriculaAcadem());
        this.menuRegistrarDeuda.addActionListener(new MostrarMenuRegistrarDeudas());
        this.menuRegistrarPeriodo.addActionListener(new MostrarMenuRegistrarPeriodos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuConsultarProgamacion = new javax.swing.JMenuItem();
        menuRealizarMatricula = new javax.swing.JMenuItem();
        menuRegistrarDeuda = new javax.swing.JMenuItem();
        menuRegistrarPeriodo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopPane1Layout = new javax.swing.GroupLayout(desktopPane1);
        desktopPane1.setLayout(desktopPane1Layout);
        desktopPane1Layout.setHorizontalGroup(
            desktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 743, Short.MAX_VALUE)
        );
        desktopPane1Layout.setVerticalGroup(
            desktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        getContentPane().add(desktopPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Programacion");

        menuConsultarProgamacion.setText("Consultar Programacion Académica");
        jMenu1.add(menuConsultarProgamacion);

        menuRealizarMatricula.setText("Realizar Matricula Académica");
        jMenu1.add(menuRealizarMatricula);

        menuRegistrarDeuda.setText("Registrar Deuda");
        jMenu1.add(menuRegistrarDeuda);

        menuRegistrarPeriodo.setText("Registrar Periodo Académico");
        jMenu1.add(menuRegistrarPeriodo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuConsultarProgamacion;
    private javax.swing.JMenuItem menuRealizarMatricula;
    private javax.swing.JMenuItem menuRegistrarDeuda;
    private javax.swing.JMenuItem menuRegistrarPeriodo;
    // End of variables declaration//GEN-END:variables

    //Muestra la ventana consultar programacion académica en desktopPanel al presionar el menu item
    public class MostrarMenuConsulProgram implements ActionListener {

        private ConsultarlProgAcademica ui = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (this.ui == null) {
                this.ui = new ConsultarlProgAcademica(universidad);
                desktopPane1.add(ui);
            }
            ui.setVisible(true);
        }

    }

    //Muestra la ventana matricula academica y autenticacion de usuario
    //en desktopPanel al presionar el menu item
    public class MostrarMenuMatriculaAcadem implements ActionListener {

        private MatriculaAcademica ui = null;

        @Override
        public void actionPerformed(ActionEvent e) {

            boolean repetir = false;
            AutenticacionUsuario autUs = new AutenticacionUsuario();
            try {
                Estudiante est = null;
                do {
                    int opcion = JOptionPane.showConfirmDialog(VentanaPrincipal.this,
                            autUs, "Autenticar Usuario", JOptionPane.OK_CANCEL_OPTION);

                    if (opcion == JOptionPane.CANCEL_OPTION) {
                        return;
                    }

                    int codigo = Integer.parseInt(autUs.getCodigo());
                    est = universidad.buscarEstudiante(codigo);

                    if (!est.getContraseña().equals(autUs.getContraseña())) {
                        JOptionPane.showMessageDialog(VentanaPrincipal.this, "La contraseña es incorrecta",
                                "Autenticacion", JOptionPane.INFORMATION_MESSAGE);
                        repetir = true;
                    } else {
                        repetir = false;
                    }
                } while (repetir == true);

                Tabulado tab;
                try {
                    tab = est.buscarTabulado(universidad.getPeriodoActual());
                } catch (ExcepcionObjetoNoEncontrado ex) {
                    tab = new Tabulado(universidad.getPeriodoActual());
                    est.añadirTabulado(tab);
                }

                this.ui = new MatriculaAcademica(universidad, tab, est);
                desktopPane1.add(ui);
                //}
                ui.setVisible(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(VentanaPrincipal.this, ex.getMessage(),
                        "Se generó un error: ", JOptionPane.WARNING_MESSAGE);
            } catch (ExcepcionObjetoNoEncontrado ex) {
                JOptionPane.showMessageDialog(VentanaPrincipal.this, ex.getMessage(),
                        "Se generó un error: ", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(VentanaPrincipal.this, "Se generó un error inesperado",
                        "Se generó un error: ", JOptionPane.ERROR_MESSAGE);
                Logger.getAnonymousLogger().log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

    //Muestra la ventana registar deudas en desktopPanel al presionar el menu item
    public class MostrarMenuRegistrarDeudas implements ActionListener {

        private RegistrarDeudas ui = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (this.ui == null) {
                this.ui = new RegistrarDeudas(universidad);
                desktopPane1.add(ui);
            }
            ui.setVisible(true);
        }
    }

    //Muestra la ventana registar periodos en desktopPanel al presionar el menu item
    public class MostrarMenuRegistrarPeriodos implements ActionListener {

        RegistrarPeriodos ui = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (this.ui == null) {
                this.ui = new RegistrarPeriodos(universidad);
                desktopPane1.add(ui);
            }
            ui.setVisible(true);

        }
    }

}
