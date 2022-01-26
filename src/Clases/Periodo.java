package Clases;

import Excepciones.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Periodo implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk;

    //atributos propios
    @Column(nullable = false, length = 80) // El valor no puede ser nulo y tendrá una longitud máxima de 80 caracteres
    private String inicia;
    @Column(nullable = false, length = 80)
    private String fin;
    @Column(nullable = false)
    private Short anioInicio;
    @Column(nullable = false)
    private Short anioFin;
    //relaciones de asociacion uno a muchos
    @Column(nullable = false)
    @OneToMany
    private List<Curso> listadoCursos;

    //Constructor vacio
    public Periodo() {
    }

    //Constructor
    public Periodo(String inicia, String fin, short anioInicio, short anioFin) {
        this.inicia = inicia;
        this.fin = fin;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        listadoCursos = new LinkedList<>();
    }

    //Métodos de acceso
    public String getInicia() {
        return inicia;
    }

    public String getFin() {
        return fin;
    }

    public short getAnioInicio() {
        return anioInicio;
    }

    public short getAnioFin() {
        return anioFin;
    }

    public long getPk() {
        return pk;
    }

    public List<Curso> getListadoCursos() {
        return listadoCursos;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public void setInicia(String inicia) {
        this.inicia = inicia;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public void setAnioInicio(Short anioInicio) {
        this.anioInicio = anioInicio;
    }

    public void setAnioFin(Short anioFin) {
        this.anioFin = anioFin;
    }

    public void setListadoCursos(List<Curso> listadoCursos) {
        this.listadoCursos = listadoCursos;
    }

    //Métodos para añadir y eliminar elementos de una lista
    public void añadirCurso(Curso curso) {
        this.listadoCursos.add(curso);
    }

    public void eliminarCurso(Curso curso) {
        this.listadoCursos.remove(curso);
    }

    //otros metodos
    @Override
    public String toString() {
        return inicia + " - " + anioInicio + " / " + fin + " - " + anioFin;
    }

    public String mostrarCursos() {

        String programAcadem = "";

        for (Curso curso : listadoCursos) {
            programAcadem += ("Programación: \n" + curso.toString());
        }
        return programAcadem;
    }

    public Curso buscarCurso(String codigoAsignatura, short grupo) throws ExcepcionObjetoNoEncontrado {

        for (Curso c : listadoCursos) {
            if (grupo == c.getGrupo()) {
                if (codigoAsignatura.equals(c.getAsignatura().getCodigo())) {
                    return c;
                }
            }
        }

        throw new ExcepcionObjetoNoEncontrado("El curso no está en el periodo actual");
    }

}
