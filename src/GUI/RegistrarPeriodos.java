package GUI;

import Clases.Periodo;
import Clases.Universidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RegistrarPeriodos extends javax.swing.JInternalFrame {

    private Universidad universidad;

    public RegistrarPeriodos(Universidad universidad) {
        //Inicializar variables
        this.universidad = universidad;

        initComponents();
        CancelarListener cancelarListener = new CancelarListener();
        botonCancelar.addActionListener(cancelarListener);

        botonGuardar.addActionListener(new GuardarListener());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtmesInicial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        txtmesFinal = new javax.swing.JTextField();
        txtañoInicial = new javax.swing.JTextField();
        txtañoFinal = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREACIÓN DE PERIODOS ACADÉMICOS");

        jLabel2.setText("Inicia :");

        txtmesInicial.setText("Mes Inicial");
        txtmesInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmesInicialActionPerformed(evt);
            }
        });

        jLabel3.setText("Finaliza :");

        botonGuardar.setText("Guardar");
        botonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtmesFinal.setText("Mes Final");

        txtañoInicial.setText("Año Inicial");

        txtañoFinal.setText("Año Final");

        botonCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtañoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtmesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtmesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtañoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtañoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtañoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmesInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmesInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmesInicialActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtañoFinal;
    private javax.swing.JTextField txtañoInicial;
    private javax.swing.JTextField txtmesFinal;
    private javax.swing.JTextField txtmesInicial;
    // End of variables declaration//GEN-END:variables

    public class CancelarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            txtmesInicial.setText("");
            txtmesFinal.setText("");
            txtañoInicial.setText("");
            txtañoFinal.setText("");
        }

    }

    public class GuardarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //Obtener la información de los componentes gráficos
                String mesInicial = txtmesInicial.getText();
                String mesFinal = txtmesFinal.getText();
                short añoInicial = Short.parseShort(txtañoInicial.getText());
                short añoFinal = Short.parseShort(txtañoFinal.getText());

                //Crear el objeto periodo con la información
                Periodo periodo = new Periodo(mesInicial, mesFinal, añoInicial , añoFinal);

                //Agregar el periodo a la listas de periodos de la universidad;
                //Universidad universidad = new Universidad(121212, "UniValle", "Calle 5");
                universidad.añadirPeriodo(periodo);

                //Mostrar un mensaje informando que el periodo fue creado y agregado
                //a la universidad
                JOptionPane.showMessageDialog(RegistrarPeriodos.this, "El periodo fue creado y agregado con éxito");

            } catch (Exception ex) {
                Logger.getLogger(RegistrarPeriodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
