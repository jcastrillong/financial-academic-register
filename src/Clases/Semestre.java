package Clases;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Semestre implements Serializable {

    //Atributos propios
    @Id
    private byte numero;
    //Relaciones de asociacion uno a muchos
    @OneToMany
    private List<Asignatura> listadoAsignaturasSemestre;

    //Constructor vacio
    public Semestre() {
    }

    //Constructor
    public Semestre(byte numero) throws Exception {
        this.numero = numero;
        this.listadoAsignaturasSemestre = new LinkedList<>();
    }

    //Métodos de acceso
    public byte getNumero() {
        return numero;
    }

    public List<Asignatura> getListadoAsignaturasSemestre() {
        return listadoAsignaturasSemestre;
    }

    public void setNumero(byte numero) {
        this.numero = numero;
    }

    public void setListadoAsignaturasSemestre(List<Asignatura> listadoAsignaturasSemestre) {
        this.listadoAsignaturasSemestre = listadoAsignaturasSemestre;
    }

    //Métodos para añadir y eliminar elementos de una lista
    public void añadirAsignatura(Asignatura asignatura) {
        this.listadoAsignaturasSemestre.add(asignatura);
    }

    public void eliminarAsignatura(Asignatura asignatura) {
        this.listadoAsignaturasSemestre.remove(asignatura);
    }

}
