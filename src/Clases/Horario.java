package Clases;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.*;

@Entity
public class Horario implements Serializable {

    //Atributos
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk;
    //Relaciones de asociación uno a uno
    @Column(nullable = false) // El valor no puede ser nulo
    @Temporal(TemporalType.TIME)
    private LocalTime horaInicio;
    @Column(nullable = false) // El valor no puede ser nulo
    @Temporal(TemporalType.TIME)
    private LocalTime horaFinalizacion;
    //Atributos propios
    @Column(nullable = false)
    private DiasSemana dia;

    //Constructor vacio
    public Horario() {
    }

    //Constructor
    public Horario(LocalTime horaInicio, LocalTime horaFinalizacion, DiasSemana dia) throws Exception {
        this.horaInicio = horaInicio;
        this.horaFinalizacion = horaFinalizacion;
        this.dia = dia;
    }

    //Métodos de acceso
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFinalizacion() {
        return horaFinalizacion;
    }

    public DiasSemana getDia() {
        return dia;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFinalizacion(LocalTime horaFinalizacion) {
        this.horaFinalizacion = horaFinalizacion;
    }

    public void setDia(DiasSemana dia) {
        this.dia = dia;
    }

}
