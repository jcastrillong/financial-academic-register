package Clases;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.*;

@Entity
public class Matricula implements Serializable {

    //Atributos
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk;
    //Relaciones de asociación uno a uno(cero a uno)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalTime horaMatriculada;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalTime horaCancelada;
    @OneToOne(optional = false)
    private Curso curso;

    //Constructor vacios
    public Matricula() {
    }

    //Constructor
    public Matricula(LocalTime horaMatriculada, Curso curso) throws Exception {
        this.horaMatriculada = horaMatriculada;
        this.horaCancelada = null;
        this.curso = curso;
    }

    //Métodos de acceso
    public LocalTime getHoraMatriculada() {
        return horaMatriculada;
    }

    public LocalTime getHoraCancelada() {
        return horaCancelada;
    }

    public Curso getCurso() {
        return curso;
    }

    public long getPk() {
        return pk;
    }

    public void setHoraCancelada(LocalTime horaCancelada) {
        this.horaCancelada = horaCancelada;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public void setHoraMatriculada(LocalTime horaMatriculada) {
        this.horaMatriculada = horaMatriculada;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
