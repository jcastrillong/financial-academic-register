package Clases;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Docente extends Persona {

    //Atributos
    @Column(nullable = false, length = 80) // El valor no puede ser nulo y tendrá una longitud máxima de 80 caracteres
    private String profesion;

    //constructor vacio
    public Docente() {
    }

    //Constructor
    public Docente(String profesion, int identificación, String nombre, String apellido) throws IllegalArgumentException {
        //Hago el llamado al constructor de la super clase,
        //con el objetivo de inicializar los atributos que se heredan
        super(identificación, nombre, apellido);

        if (profesion == null || "".equals(profesion.trim())) {
            throw new IllegalArgumentException("La profesión del Docente no fue ingresada");
        }
        this.profesion = profesion;
    }

    //Métodos de acceso
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " " + "Apellido: " + getApellido();
    }

}
