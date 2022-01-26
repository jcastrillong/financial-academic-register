package GUI;

import Clases.*;
import Excepciones.ExcepcionObjetoNoEncontrado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.AEADBadTagException;
import javax.swing.JOptionPane;

public class RegistrarDeudas extends javax.swing.JInternalFrame {
    
    private Universidad universidad;
    private Estudiante estudiante;

    public RegistrarDeudas(Universidad universidad) {
        //Inicializar los atributos
        this.estudiante = null;
        this.universidad = universidad;

        initComponents();
        
        txtPeriodo.setText(this.universidad.getPeriodoActual().getInicia() + " - " 
                + this.universidad.getPeriodoActual().getAnioInicio() + " / " 
                + this.universidad.getPeriodoActual().getFin() + " - " 
                + this.universidad.getPeriodoActual().getAnioInicio());
        
        botonBuscarEstudiantes.addActionListener(new BuscarEstudiante());
        
        botonRegistrarDeuda.addActionListener(new RegistrarDeuda());
        
        botonCancelar.addActionListener(new CancelarListener());
        
    }
    
    public class BuscarEstudiante implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {                
                int codigo = Integer.parseInt(txtCodigo.getText());
                
                estudiante = universidad.buscarEstudiante(codigo);

//                txtNombreEstudiante.setText(estudiante.getPrograma().getCodigo() + 
//                        " - " + estudiante.getPrograma().getJornada() + " - " + 
//                        estudiante.getPrograma().getNombre() + " - " + estudiante.getNombre() +
//                        " " + estudiante.getApellido());    
                txtNombreEstudiante.setText(estudiante.toString());
                
                txtInfoPrograma.setText(estudiante.getPrograma().toString());
                //txtNombreEstudiante.setText(buscar);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegistrarDeudas.this, "Fallo en conversión del código del estudiante");
            } catch (ExcepcionObjetoNoEncontrado ex) {
                JOptionPane.showMessageDialog(RegistrarDeudas.this, ex.getMessage());                
            } catch (Exception ex) {
                Logger.getLogger(RegistrarDeudas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }    
    
    public class RegistrarDeuda implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                //Se obtiene el elemento del JComboBox
                String seleccion = (String) desplegableDeudas.getSelectedItem();

                //Se obtiene el código del estudiante que se ingresó
                //int codigo = Integer.parseInt(txtCodigo.getText());
                //Se hace un llamado al método que busca el estudiante
                //Estudiante estudiante = universidad.buscarEstudiante(codigo);
                //Se crea la deuda
                Deuda deuda = new Deuda(seleccion, universidad.getPeriodoActual());

                //Se añade la deuda al estudiante
                estudiante.añadirDeuda(deuda);

                //Se muestra un mensaje de que la deuda se registró con éxito
                JOptionPane.showMessageDialog(RegistrarDeudas.this, "El registro de la deuda fue hecho\n Razón: "
                        + seleccion);
                
            } catch (Exception ex) {
                Logger.getLogger(RegistrarDeudas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public class CancelarListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            txtCodigo.setText("");
            txtNombreEstudiante.setText("");
            txtInfoPrograma.setText("");
            estudiante = null;
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPeriodo = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtNombreEstudiante = new javax.swing.JTextField();
        desplegableDeudas = new javax.swing.JComboBox<>();
        botonRegistrarDeuda = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        botonBuscarEstudiantes = new javax.swing.JButton();
        txtInfoPrograma = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRAR DEUDAS");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Periodo : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Código :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Deuda :");

        txtPeriodo.setText("Periodo");

        txtCodigo.setText("Código de Estudiante");

        txtNombreEstudiante.setText("Nombre de Estudiante");

        desplegableDeudas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Documento de Identidad", "Biblioteca (Multa)", "Biblioteca (Libro no entregado)" }));
        desplegableDeudas.setToolTipText("");

        botonRegistrarDeuda.setText("Registrar Deuda");

        botonCancelar.setText("Cancelar");

        botonBuscarEstudiantes.setText("...");

        txtInfoPrograma.setText("Programa del Estudiante");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(botonRegistrarDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGap(26, 26, 26))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(36, 36, 36)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(desplegableDeudas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreEstudiante)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(botonBuscarEstudiantes))
                                .addComponent(txtInfoPrograma)
                                .addComponent(txtPeriodo))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtInfoPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desplegableDeudas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarEstudiantes;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonRegistrarDeuda;
    private javax.swing.JComboBox<String> desplegableDeudas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtInfoPrograma;
    private javax.swing.JTextField txtNombreEstudiante;
    private javax.swing.JTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables

}
