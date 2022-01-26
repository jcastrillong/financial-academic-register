package Clases;

import Excepciones.*;
import Persistencia.*;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Universidad implements Serializable {

    // Definir como atributos objetos de tipo EntityManagerFactory y PersonaJpaController.
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("Castrillon-CasoDeEstudioPU"); // Crear solo un objeto de este tipo
    private PersonaJpaController personaJpaController = new PersonaJpaController(factory);
    private DocenteJpaController docenteJpaController = new DocenteJpaController(factory);
    private AsignaturaJpaController asignaturaJpaController = new AsignaturaJpaController(factory);
    private ProgramaJpaController programaJpaController = new ProgramaJpaController(factory);
    //Atributos propios
    private int nit;
    private String nombre;
    private String direccion;
    //Relaciones de asociacion uno a uno
    private Periodo periodoActual;
    //Relaciones de asociacion uno a muchos
    private List<Periodo> listadoPeriodos;
    private List<Estudiante> listadoEstudiantes;

    //Contructor vacio
    public Universidad() {
    }

    //Constructor
    public Universidad(int nit, String nombre, String direccion) throws Exception {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.periodoActual = null;
        this.listadoEstudiantes = new LinkedList<>();
        this.listadoPeriodos = new LinkedList<>();
    }

    //Métodos de acceso
    public int getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Periodo getPeriodoActual() {
        return periodoActual;
    }

    public List<Periodo> getListadoPeriodos() {
        return listadoPeriodos;
    }

    public void setPeriodoActual(Periodo periodoActual) {
        this.periodoActual = periodoActual;
    }

    //Métodos para añadir y eliminar elementos de una lista
    //Asignaturas
    public void añadirAsignatura(Asignatura asignatura) throws Exception {
        this.asignaturaJpaController.create(asignatura);
    }

    public void eliminarAsignatura(Asignatura asignatura) throws NonexistentEntityException {
        this.asignaturaJpaController.destroy(asignatura.getCodigo());
    }

    //Docentes
    public void añadirDocente(Docente docente) throws Exception {
        this.docenteJpaController.create(docente);
    }

    public void eliminarDocente(Docente docente) throws NonexistentEntityException {
        this.docenteJpaController.destroy(docente.getIdentificación());
    }

    //Estudiantes
    public void añadirEstudiante(Estudiante estudiante) throws Exception {

        for (Estudiante est : listadoEstudiantes) {
            if (estudiante.getCodigo() == est.getCodigo()) {
                throw new Exception("El estudiante que desea agregar ya fue agregado antes");
            }
        }

        this.listadoEstudiantes.add(estudiante);
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        this.listadoEstudiantes.remove(estudiante);
    }

    //Periodos
    public void añadirPeriodo(Periodo periodo) {
        //Agregar el periodo academico
        this.listadoPeriodos.add(periodo);

        //Se asigna el periodo agregado como periodo actual
        this.setPeriodoActual(periodo);
    }

    public void eliminarPeriodo(Periodo periodo) {
        this.listadoPeriodos.remove(periodo);
    }
    
    //Programas
    public void añadirPrograma(Programa programa) throws Exception {
        this.programaJpaController.create(programa);
    }
    
    public void eliminarPrograma(Programa programa) throws NonexistentEntityException {
        this.programaJpaController.destroy(programa.getCodigo());
    }

    //Otros metodos
    //Método que permite buscar un estudiante
    public Estudiante buscarEstudiante(int codigo) throws ExcepcionObjetoNoEncontrado {

        //Estudiante resultadoEncontrado = null;
        for (Estudiante e : this.listadoEstudiantes) {
            if (codigo == e.getCodigo()) {
                return e;
            }
        }
        throw new ExcepcionObjetoNoEncontrado("El estudiante no fue encontrado");
    }

    //método para buscar una asignatura con su codigo
    public Asignatura buscarAsignatura(String codigoAsignatura) throws ExcepcionObjetoNoEncontrado {
        return this.asignaturaJpaController.findAsignatura(codigoAsignatura);
    }
}
