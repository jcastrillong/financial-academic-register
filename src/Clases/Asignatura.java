package Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Asignatura implements Serializable {

    //Atributos
    @Id
    private String codigo;
    @Column(nullable = false, length = 80) // El valor no puede ser nulo y tendrá una longitud máxima de 80 caracteres
    private String nombre;
    @Column(nullable = false)
    private byte creditos; //El número de créditos que tiene la asignatura
    @Column(nullable = false)
    private byte intensidad; //Intensidad horaria de la asignatura

    //Constructor vacio
    public Asignatura() {
    }

    //Constructor
    public Asignatura(String codigo, String nombre, byte creditos, byte intensidad) throws IllegalArgumentException {
        //Manejo de Excepciones
        if (codigo == null || "".equals(codigo.trim())) {
            throw new IllegalArgumentException("El código de la asignatura no fue ingresado o es incorrecto");
        }
        if (nombre == null || "".equals(nombre.trim())) {
            throw new IllegalArgumentException("El nombre de la asignatura no fue ingresado o es incorrecto");
        }
        if (creditos <= 0) {
            throw new IllegalArgumentException("EL número de créditos de la asignatura no deben ser menores o iguales a 0");
        }
        if (intensidad <= 0) {
            throw new IllegalArgumentException("La intensidad horaria de la asignatura no debe ser menor o igual a 0");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.intensidad = intensidad;
    }

    //Métodos de acceso
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public byte getCreditos() {
        return creditos;
    }

    public byte getIntensidad() {
        return intensidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(byte creditos) {
        this.creditos = creditos;
    }

    public void setIntensidad(byte intensidad) {
        this.intensidad = intensidad;
    }

    //Otros métodos
    @Override
    public String toString() {
        return "codigo: " + codigo + ", nombre: " + nombre + ", creditos: " + creditos + ", intensidad: " + intensidad;
    }

}
