package Clases;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Curso implements Serializable {

    //Atributos propios
    @Id
    private short grupo;
    @Column(nullable = false) // El valor no puede ser nulo 
    private byte totalCupos;
    //relaciones de asociacion uno a uno
    @OneToOne(optional = false)
    private Asignatura asignatura;
    @OneToOne(optional = false)
    private Docente docente;
    //relaciones de asociacion uno a muchos
    @Column(nullable = false)
    @OneToMany
    private List<Estudiante> listadoEstudiantes;
    @Column(nullable = false)
    @OneToMany
    private List<Cupo> listadoCupos;
    @Column(nullable = false)
    @OneToMany
    private List<Horario> listadoHorarios;

    //Constructor vacio
    public Curso() {
    }

    //Constructor
    public Curso(short grupo, Asignatura asignatura, Docente docente) throws Exception {
        this.grupo = grupo;
        this.totalCupos = 0;
        this.asignatura = asignatura;
        this.docente = docente;
        this.listadoCupos = new LinkedList<>();
        this.listadoHorarios = new LinkedList<>();
        this.listadoEstudiantes = new LinkedList<>();
    }

    //Métodos de acceso
    public short getGrupo() {
        return grupo;
    }

    public byte getTotalCupos() {
        return totalCupos;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public Docente getDocente() {
        return docente;
    }

    public List<Estudiante> getListadoEstudiantes() {
        return listadoEstudiantes;
    }

    public List<Cupo> getListadoCupos() {
        return listadoCupos;
    }

    public List<Horario> getListadoHorarios() {
        return listadoHorarios;
    }

    public void setGrupo(short grupo) {
        this.grupo = grupo;
    }

    public void setTotalCupos(byte totalCupos) {
        this.totalCupos = totalCupos;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setListadoEstudiantes(List<Estudiante> listadoEstudiantes) {
        this.listadoEstudiantes = listadoEstudiantes;
    }

    public void setListadoCupos(List<Cupo> listadoCupos) {
        this.listadoCupos = listadoCupos;
    }

    public void setListadoHorarios(List<Horario> listadoHorarios) {
        this.listadoHorarios = listadoHorarios;
    }

    //Métodos para añadir y eliminar elementos de una lista
    //Cupos
    public void añadirCupos(Cupo cupo) {
        this.listadoCupos.add(cupo);

        totalCupos += cupo.getCantidad();
    }

    public void eliminarCupos(Cupo cupo) {
        this.listadoCupos.remove(cupo);
    }

    //Horario
    public void añadirHorario(Horario horario) {
        this.listadoHorarios.add(horario);
    }

    public void eliminarHorario(Horario horario) {
        this.listadoHorarios.remove(horario);
    }

    //Estudiante
    public void añadirEstudiante(Estudiante estudiante) {
        //Recorre la lista de cupos
        for (int i = 0; i <= listadoCupos.size(); i++) {
            //Si el codigo del programa del cupo es igual al codigo del programa
            //del estudiante entonces...

            if (listadoCupos.get(i).getDisponibles() == 0) {
                throw new IllegalArgumentException("No hay cupos disponibles para este curso");
            }

            if (listadoCupos.get(i).getPrograma().getCodigo() == estudiante.getPrograma().getCodigo()) {
                this.listadoEstudiantes.add(estudiante);

                short disponiblesActualizados = (short) (listadoCupos.get(i).getDisponibles() - 1);

                listadoCupos.get(i).setDisponibles(disponiblesActualizados);
                break;
            } else if (listadoCupos.get(i).getPrograma().getCodigo() != estudiante.getPrograma().getCodigo()
                    && i == listadoCupos.size() - 1) {
                throw new IllegalArgumentException("No hay cupos disponibles para su programa académico");
            }
        }
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        for (int i = 0; i <= listadoCupos.size(); i++) {
            //Si el codigo del programa del cupo es igual al codigo del programa
            //del estudiante entonces...

            if (listadoCupos.get(i).getPrograma().getCodigo() == estudiante.getPrograma().getCodigo()) {
                this.listadoEstudiantes.remove(estudiante);

                short disponiblesActualizados = (short) (listadoCupos.get(i).getDisponibles() + 1);

                listadoCupos.get(i).setDisponibles(disponiblesActualizados);
                break;
            }
        }
    }

    //Otros metodos
    public String mostrarCupos() {
        String cupos = "";

        for (Cupo cupo : listadoCupos) {
            cupos += cupo.toString();
        }
        return cupos;
    }

    @Override
    public String toString() {
        return "Grupo: " + grupo + ", totalCupos: " + totalCupos + "\n"
                + "Asignatura: " + getAsignatura() + "\n"
                + "Docente: " + getDocente() + "\n"
                + "Cupos: " + mostrarCupos()
                + "Horarios: " + getListadoHorarios() + "\n";
    }

}
