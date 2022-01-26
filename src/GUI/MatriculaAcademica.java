package GUI;

import Clases.*;
import Excepciones.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class MatriculaAcademica extends javax.swing.JInternalFrame {

    private Universidad universidad;
    private Estudiante estudiante;
    private Tabulado tabulado;
    private Curso curso;

    public MatriculaAcademica(Universidad universidad, Tabulado tabulado, Estudiante estudiante) {
        this.universidad = universidad;
        this.estudiante = estudiante;
        this.tabulado = tabulado;
        this.curso = null;

        initComponents();

        this.txtPeriodoAcademico.setText(universidad.getPeriodoActual().toString());
        this.txtNombreEstudiante.setText(estudiante.toString());
        this.tablaMatriculaAcademica.setModel(new CursosTableModel());
        this.tablaMatriculaAcademica.getSelectionModel().addListSelectionListener(new SelecionarFila_Cancelar());
        this.botonCancelar.addActionListener(new BotonCancelar());
        this.botonMatricular.addActionListener(new BotonMatricular());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPeriodoAcademico = new javax.swing.JTextField();
        txtNombreEstudiante = new javax.swing.JTextField();
        txtCodigoAsignatura = new javax.swing.JTextField();
        formattedTxtGrupo = new javax.swing.JFormattedTextField();
        botonMatricular = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMatriculaAcademica = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("MATRICULA ACADÉMICA");

        jLabel2.setText("Periodo : ");

        jLabel3.setText("Estudiante :");

        jLabel4.setText("Asignatura :");

        txtPeriodoAcademico.setEditable(false);
        txtPeriodoAcademico.setText("jTextField1");

        txtNombreEstudiante.setEditable(false);
        txtNombreEstudiante.setText("jTextField2");

        txtCodigoAsignatura.setText("Código Asignatura");

        formattedTxtGrupo.setText("Grupo");

        botonMatricular.setText("Matricular");

        botonCancelar.setText("Cancelar");
        botonCancelar.setEnabled(false);

        tablaMatriculaAcademica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tablaMatriculaAcademica.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaMatriculaAcademica);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPeriodoAcademico)
                            .addComponent(txtNombreEstudiante)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigoAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formattedTxtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonMatricular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                                .addComponent(botonCancelar))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPeriodoAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigoAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formattedTxtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMatricular)
                    .addComponent(botonCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonMatricular;
    private javax.swing.JFormattedTextField formattedTxtGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMatriculaAcademica;
    private javax.swing.JTextField txtCodigoAsignatura;
    private javax.swing.JTextField txtNombreEstudiante;
    private javax.swing.JTextField txtPeriodoAcademico;
    // End of variables declaration//GEN-END:variables

    public class SelecionarFila_Cancelar implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            int seleccion = tablaMatriculaAcademica.getSelectedRow();
            if (seleccion < 0) {
                botonCancelar.setEnabled(false);
            } else {
                botonCancelar.setEnabled(true);
            }
        }
    }

    public class BotonCancelar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Se obtiene la fila que se ha seleccionado
            int seleccion = tablaMatriculaAcademica.getSelectedRow();
            //Se obtiene la matricula
            Matricula matricula = tabulado.getListadoMatricula().get(seleccion);

            //Se lanza un cuadro de confirmación
            int opcion = JOptionPane.showConfirmDialog(MatriculaAcademica.this, "Seguro desea cancelar "
                    + matricula.getCurso().getAsignatura().getCodigo() + " - "
                    + matricula.getCurso().getAsignatura().getNombre(), "Atención", JOptionPane.OK_CANCEL_OPTION);
            if (opcion == JOptionPane.CANCEL_OPTION) {
                return;
            }

            try {
                //Si la matricula ya tiene hora de cancelacion entonces...
                if (matricula.getHoraCancelada() != null) {
                    //Se arroja una excepcion diciendo que ya fue cancelado antes
                    tablaMatriculaAcademica.clearSelection();
                    throw new IllegalArgumentException("El curso ya fue cancelado antes");
                }

                //Se asigna una hora de cancelacion a la matricula
                matricula.setHoraCancelada(LocalTime.now());
                //Simplifico la obtención del codigo y grupo para después buscar el curso
                String codigo = matricula.getCurso().getAsignatura().getCodigo();
                Short grupo = matricula.getCurso().getGrupo();
                //Se busca el curso
                curso = universidad.getPeriodoActual().buscarCurso(codigo, grupo);
                //Se elimina el estudiante del curso
                curso.eliminarEstudiante(estudiante);

                //Se arroja un mensaje de que el curso fue cancelado
                JOptionPane.showMessageDialog(MatriculaAcademica.this, "Cancelada");

                //Se actualiza el JTable
                tablaMatriculaAcademica.updateUI();
                //Se quita la seleccion que se tenía
                tablaMatriculaAcademica.clearSelection();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(MatriculaAcademica.this, ex.getMessage());
            } catch (ExcepcionObjetoNoEncontrado ex) {
                JOptionPane.showMessageDialog(MatriculaAcademica.this, ex.getMessage());
            }
        }
    }

    public class BotonMatricular implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Se obtiene el periodo actual
            Periodo peridoActual = universidad.getPeriodoActual();
            //Se obtiene el codigo de la asignatura del campo de texto
            String codigoAsignatura = txtCodigoAsignatura.getText();
            //Se obtiene el grupo del curso del campo de texto
            short grupoCurso = Short.parseShort(formattedTxtGrupo.getText());

            try {
                //Se hace llamado al método para que busca si hay alguna asignatura en la universidad
                //con el codigo ingresado
                universidad.buscarAsignatura(codigoAsignatura);
                //Hago llamado al método para buscar el curso
                curso = peridoActual.buscarCurso(codigoAsignatura, grupoCurso);
                //Se lanza un cuadro de confirmación
                int opcion = JOptionPane.showConfirmDialog(MatriculaAcademica.this, "Seguro desea matricular "
                        + curso.getAsignatura().getCodigo() + " - " + curso.getAsignatura().getNombre()
                        + " - " + curso.getGrupo(), "Atención", JOptionPane.OK_CANCEL_OPTION);

                if (opcion == JOptionPane.CANCEL_OPTION) {
                    return;
                }

                //Verifica si el curso ya está matriculado
                tabulado.VerificarCurso(codigoAsignatura);

                //Coloca los cuadros de texto en vacios
                txtCodigoAsignatura.setText("");
                formattedTxtGrupo.setText("");

                //Se crea una matricula con el curso buscado y se asigna la hora de matricula
                Matricula matricula = new Matricula(LocalTime.now(), curso);
                //Se agrega el estudiante al listado de estudiantes del curso
                curso.añadirEstudiante(estudiante);
                //Se agrega la matricula al tabulado del estudiante
                tabulado.añadirMatricula(matricula);
                //Se actualiza el JTable
                tablaMatriculaAcademica.updateUI();

            } catch (ExcepcionObjetoNoEncontrado ex) {
                JOptionPane.showMessageDialog(MatriculaAcademica.this, ex.getMessage());
            } catch (ExceptionInInitializerError ex) {
                JOptionPane.showMessageDialog(MatriculaAcademica.this, ex.getMessage());
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(MatriculaAcademica.this, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(MatriculaAcademica.this, "Se generó un error inesperado",
                        "Se generó un error", JOptionPane.ERROR_MESSAGE);
                Logger.getAnonymousLogger().log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

//Modelo del JTable
    public class CursosTableModel implements TableModel {

        private String[] numeroColumnas = {"Código", "Asignatura", "Grupo", "Créditos", "Intensidad"};
        private Class[] claseColumnas = {String.class, String.class, Byte.class, Byte.class, Byte.class};

        @Override
        public int getRowCount() {
            if (tabulado == null) {
                return 0;
            }
            return tabulado.getListadoMatricula().size();
        }

        @Override
        public int getColumnCount() {
            return this.numeroColumnas.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return this.numeroColumnas[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return this.claseColumnas[columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Matricula matricula = tabulado.getListadoMatricula().get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return matricula.getCurso().getAsignatura().getCodigo();
                case 1:
                    return matricula.getCurso().getAsignatura().getNombre();
                case 2:
                    return matricula.getCurso().getGrupo();
                case 3:
                    return matricula.getCurso().getAsignatura().getCreditos();
                case 4:
                    return matricula.getCurso().getAsignatura().getIntensidad();
            }
            return "";
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {}
        @Override
        public void addTableModelListener(TableModelListener l) {}
        @Override
        public void removeTableModelListener(TableModelListener l) {}
    }
    
}
