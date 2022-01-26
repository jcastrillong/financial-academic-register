package GUI;

import Clases.Periodo;
import Clases.Universidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class ConsultarlProgAcademica extends javax.swing.JInternalFrame {

    Universidad universidad;

    public ConsultarlProgAcademica(Universidad universidad) {
        this.universidad = universidad;
        
        initComponents();
        
        desplegablePeriodos.setModel(new MostrarPeriodoComboBox());
        
        desplegablePeriodos.addActionListener(new MostrarProgramacionAcademica());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        desplegablePeriodos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtProgramAcadem = new javax.swing.JTextArea();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CONSULTAR PROGRAMACIÓN ACADÉMICA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Periodo académico: ");

        txtProgramAcadem.setColumns(20);
        txtProgramAcadem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtProgramAcadem.setRows(5);
        jScrollPane1.setViewportView(txtProgramAcadem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(desplegablePeriodos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 169, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(desplegablePeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Periodo> desplegablePeriodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtProgramAcadem;
    // End of variables declaration//GEN-END:variables


    public class MostrarPeriodoComboBox implements ComboBoxModel<Periodo> {

        public Object selecion;
        
        @Override
        public Object getSelectedItem() {
            return this.selecion;
        }
        
        @Override
        public void setSelectedItem(Object anItem) {
            this.selecion = anItem;
        }


        @Override
        public int getSize() {
            return universidad.getListadoPeriodos().size();
        }

        @Override
        public Periodo getElementAt(int index) {
            return universidad.getListadoPeriodos().get(index);
        }

        @Override
        public void addListDataListener(ListDataListener l) {
        }

        @Override
        public void removeListDataListener(ListDataListener l) {
        }
        
    }
    
    public class MostrarProgramacionAcademica implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Periodo selecion = (Periodo) desplegablePeriodos.getSelectedItem();
            
            txtProgramAcadem.setText(selecion.mostrarCursos());
       } 
    }

}
