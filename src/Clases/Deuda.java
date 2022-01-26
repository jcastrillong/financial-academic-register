package Clases;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Deuda implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk;

    //Atributos propios
    @Column(nullable = false) // El valor no puede ser nulo 
    private String descripcion;
    //Relaciones de asociacion uno a uno
    //@Column(nullable = false) // El valor no puede ser nulo 
    @OneToOne
    private Periodo periodo;

    //Constructor vacio
    public Deuda() {
    }

    //Constructor
    public Deuda(String descripcion, Periodo periodo) throws Exception {
        this.descripcion = descripcion;
        this.periodo = periodo;
    }

    //Métodos de acceso
    public Periodo getPeriodo() {
        return periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

}
