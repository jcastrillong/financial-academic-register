package Clases;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Programa implements Serializable {

    //Atributos propios
    @Id
    private int codigo;
    @Column(nullable = false, length = 80) // El valor no puede ser nulo y tendrá una longitud máxima de 80 caracteres
    private String nombre;
    @Column(nullable = false, length = 80) // El valor no puede ser nulo y tendrá una longitud máxima de 80 caracteres
    private Jornada jornada;
    //Relaciones de asociacion uno a muchos
    @OneToMany (cascade = CascadeType.ALL)
    private List<Semestre> listadoSemestres;

    //constructor vacio
    public Programa() {
    }

    //Constructor
    public Programa(int codigo, String nombre, Jornada jornada) throws Exception {
        this.codigo = codigo;
        this.nombre = nombre;
        this.jornada = jornada;
        this.listadoSemestres = new LinkedList<>();
    }

    //Métodos de acceso
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public List<Semestre> getListadoSemestres() {
        return listadoSemestres;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public void setListadoSemestres(List<Semestre> listadoSemestres) {
        this.listadoSemestres = listadoSemestres;
    }

    //Métodos para añadir y eliminar elementos de una lista
    public void añadirSemestre(Semestre semestre) {
        this.listadoSemestres.add(semestre);
    }

    public void eliminarSemestre(Semestre semestre) {
        this.listadoSemestres.remove(semestre);
    }

    //otros metodos
    @Override
    public String toString() {
        return codigo + " - " + jornada + " - " + nombre;
    }

}
