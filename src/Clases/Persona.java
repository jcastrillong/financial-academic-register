package Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona implements Serializable {

    //Atributos
    @Id
    private Long identificación;
    @Column(nullable = false, length = 80) // El valor no puede ser nulo y tendrá una longitud máxima de 80 caracteres
    private String nombre;
    @Column(nullable = false, length = 80)
    private String apellido;

    //Constructor vacio
    public Persona() {
    }

    //Constructor
    public Persona(long identificación, String nombre, String apellido) throws IllegalArgumentException {
        //Manejo de Excepciones
        if (identificación <= 0) {
            throw new IllegalArgumentException("El número de identificación es incorrecto");
        }
        if (nombre == null || "".equals(nombre.trim())) {
            throw new IllegalArgumentException("El nombre no fue ingresado o no es correcto");
        }
        if (apellido == null || "".equals(apellido.trim())) {
            throw new IllegalArgumentException("El apellido no fue ingresado o no es correcto");
        }

        this.identificación = identificación;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Métodos de acceso
    public long getIdentificación() {
        return identificación;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setIdentificación(Long identificación) {
        this.identificación = identificación;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
