package Clases;

import Excepciones.*;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Estudiante extends Persona {

    //Atributos propios
    @Column(nullable = false)
    private int codigo;
    @Column(nullable = false)
    private String contraseña;
    //Relaciones de asociacion uno a uno
    @OneToOne(optional = false)
    private Programa programa;
    //Relaciones de asociacion uno a muchos
    @Column(nullable = false)
    @OneToMany
    private List<Deuda> listadoDeudas;
    @Column(nullable = false)
    @OneToMany
    private List<Tabulado> listadoTabulados;

    //constructor vacio
    public Estudiante() {
    }

    //Constructor
    public Estudiante(int codigo, String contraseña, Programa programa, int identificación, String nombre, String apellido) throws IllegalArgumentException {
        //Hago el llamado al constructor de la super clase,
        //con el objetivo de inicializar los atributos que se heredan
        super(identificación, nombre, apellido);

        this.codigo = codigo;
        this.contraseña = contraseña;
        this.programa = programa;
        this.listadoDeudas = new LinkedList<>();
        this.listadoTabulados = new LinkedList<>();
    }

    //Métodos de acceso
    public int getCodigo() {
        return codigo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Programa getPrograma() {
        return programa;
    }

    public List<Tabulado> getListadoTabulados() {
        return listadoTabulados;
    }

    public List<Deuda> getListadoDeudas() {
        return listadoDeudas;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public void setListadoDeudas(List<Deuda> listadoDeudas) {
        this.listadoDeudas = listadoDeudas;
    }

    public void setListadoTabulados(List<Tabulado> listadoTabulados) {
        this.listadoTabulados = listadoTabulados;
    }

    //Métodos para añadir y eliminar elementos de una lista
    //Deuda
    public void añadirDeuda(Deuda deuda) {
        this.listadoDeudas.add(deuda);
    }

    public void eliminarDeuda(Deuda deuda) {
        this.listadoDeudas.remove(deuda);
    }

    //Tabulado
    public void añadirTabulado(Tabulado tabulado) {
        this.listadoTabulados.add(tabulado);
    }

    public void eliminarTabulado(Tabulado tabulado) {
        this.listadoTabulados.remove(tabulado);
    }

    //otros métodos
    @Override
    public String toString() {
        return getNombre() + " " + getApellido();
    }

    public Tabulado buscarTabulado(Periodo p) throws ExcepcionObjetoNoEncontrado {
        //1.Se recorre la lista de tabulados
        for (Tabulado tab : listadoTabulados) {
            //2.Si el periodo del tabulado en la lista, es igual al periodo
            //que se ingesó entonces...
            if (tab.getPeriodo() == p) {
                //3.Devuelve el tabulado que cumple la condición
                return tab;
            }
        }
        throw new ExcepcionObjetoNoEncontrado("El tabulado no fue encontrado");
    }

}
