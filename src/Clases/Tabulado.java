package Clases;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Tabulado implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk;
    //Atributos propios
    @Column(nullable = false) // El valor no puede ser nulo y tendrá una longitud máxima de 80 caracteres
    private int creditosMatriculados;
    //Relaciones de asocioacion uno a uno
    @OneToOne(optional = false)
    private Periodo periodo;
    //Relaciones de asociacion uno a muchos
    @OneToMany
    private List<Matricula> listadoMatricula;

    //Constructor vacio
    public Tabulado() {
    }

    //Constructor
    public Tabulado(Periodo periodo) throws Exception {
        this.periodo = periodo;
        this.listadoMatricula = new LinkedList<>();
    }

    //Métodos de acceso
    public Periodo getPeriodo() {
        return periodo;
    }

    public List<Matricula> getListadoMatricula() {
        return listadoMatricula;
    }

    public long getPk() {
        return pk;
    }

    public int getCreditosMatriculados() {
        return creditosMatriculados;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public void setCreditosMatriculados(int creditosMatriculados) {
        this.creditosMatriculados = creditosMatriculados;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public void setListadoMatricula(List<Matricula> listadoMatricula) {
        this.listadoMatricula = listadoMatricula;
    }

    //Métodos para añadir y eliminat elementos de una lista
    public void añadirMatricula(Matricula matricula) {
        int creditos = matricula.getCurso().getAsignatura().getCreditos() + this.creditosMatriculados;

        if (creditos > 20) {
            throw new IllegalArgumentException("Está excediendo la cantidad de créditos");
        }

        this.listadoMatricula.add(matricula);

        this.creditosMatriculados += matricula.getCurso().getAsignatura().getCreditos();
    }

    public void eliminarMatricula(Matricula matricula) {
        int creditos = this.creditosMatriculados - matricula.getCurso().getAsignatura().getCreditos();

        if (creditos < 7) {
            throw new IllegalArgumentException("No puede cancelar la materia, debe cumplir con los créditos mínimos");
        }

        this.listadoMatricula.remove(matricula);
        matricula.setHoraCancelada(LocalTime.now());
        this.creditosMatriculados -= matricula.getCurso().getAsignatura().getCreditos();
    }

    //otros metodos
    public void VerificarCurso(String codigoAsignatura) {
        for (Matricula mat : listadoMatricula) {
            if (codigoAsignatura.equals(mat.getCurso().getAsignatura().getCodigo())) {
                throw new ExceptionInInitializerError("El curso que desea matricular ya lo tiene matriculado");
            }
        }
    }

}
