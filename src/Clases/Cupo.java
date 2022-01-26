package Clases;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Cupo implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk;

    //Atributos propios
    @Column(nullable = false) // El valor no puede ser nulo y tendrá una longitud máxima de 80 caracteres
    private short cantidad;
    @Column(nullable = false) // El valor no puede ser nulo y tendrá una longitud máxima de 80 caracteres
    private short disponibles;
    //Relaciones de asociacion uno a uno  
    @OneToOne
    private Programa programa;

    //Constructor vacio
    public Cupo() {
    }

    //Constructor
    public Cupo(short cantidad, short disponibles, Programa programa) throws Exception {
        this.cantidad = cantidad;
        this.disponibles = disponibles;
        this.programa = programa;
    }

    //Métodos de acceso
    public short getCantidad() {
        return cantidad;
    }

    public short getDisponibles() {
        return disponibles;
    }

    public Programa getPrograma() {
        return programa;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public void setDisponibles(short disponibles) {
        this.disponibles = disponibles;
    }

    //otros métodos
    @Override
    public String toString() {
        return "CantidadCupos: " + cantidad + ", CuposDisponibles: " + disponibles + "\n"
                + "Programa: " + getPrograma() + "\n";
    }

}
