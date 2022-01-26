package Principal;

import Clases.*;
import GUI.VentanaPrincipal;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String args[]) throws Exception {

        Universidad universidad = null;

        if (universidad == null) {
            universidad = new Universidad(3322, "Universidad del Valle", "Calle 5ta");
            //Instancia Periodo
            Periodo periodo20211 = new Periodo("Febrero", "Junio", (short) 2021, (short) 2021);
            Periodo periodo20212 = new Periodo("Agosto", "Diciembre", (short) 2021, (short) 2021);
            Periodo periodo20221 = new Periodo("Febrero", "Junio", (short) 2022, (short) 2022);

            //Instancia Docente
            Docente docente1 = new Docente("Ingeniería en Sistemas", 122222, "Antonio", "Sanchez");
            Docente docente2 = new Docente("Ingeniería Matemática", 133333, "Felipe", "Ordoñez");
            Docente docente3 = new Docente("Ingeniería Matemática", 144444, "Andrés", "Ortega");
            Docente docente4 = new Docente("Ingeniería en Sistemas", 155555, "Cristian", "Gonzalez");
            
            //Instancia Programas
            Programa p2711 = new Programa(2711, "Tecnologia en Sistemas de Informacion", Jornada.NOCTURNA);
            Programa p2611 = new Programa(2611, "Tecnologia Electrónica", Jornada.DIURNA);
            Programa p2311 = new Programa(2311, "Tecnologia en Alimentos", Jornada.DIURNA);

            //Instancia Asigantura
            Asignatura progInteractiva = new Asignatura("11111M", "Programacion Interactiva", (byte) 4, (byte) 4);
            Asignatura calculo1 = new Asignatura("22222M", "Calculo I", (byte) 4, (byte) 5);
            Asignatura calculo2 = new Asignatura("22221M", "Cáculo II", (byte) 4, (byte) 5);
            Asignatura baseDatos = new Asignatura("33333M", "Base de Datos", (byte) 3, (byte) 4);

            //Instancia Semestre
            Semestre semestre1 = new Semestre((byte)1);
            Semestre semestre2 = new Semestre((byte)2);
            Semestre semestre3 = new Semestre((byte)3);
            
            //Instancia Cupo
            Cupo cupo1 = new Cupo((short) 10, (short) 10, p2711);
            Cupo cupo2 = new Cupo((short) 5, (short) 5, p2611);
            Cupo cupo3 = new Cupo((short) 5, (short) 5, p2311);
            Cupo cupo4 = new Cupo((short) 1, (short) 1, p2711);
            Cupo cupo5 = new Cupo((short) 15, (short) 15, p2611);
            Cupo cupo6 = new Cupo((short) 10, (short) 10, p2311);
            Cupo cupo7 = new Cupo((short) 3, (short) 3, p2311);

            //Instancia Curso
            Curso curso1 = new Curso((short) 50, progInteractiva, docente1);
            Curso curso2 = new Curso((short) 51, calculo1, docente2);
            Curso curso3 = new Curso((short) 52, calculo1, docente3);
            Curso curso4 = new Curso((short) 51, calculo2, docente2);
            Curso curso5 = new Curso((short) 52, calculo2, docente3);
            Curso curso6 = new Curso((short) 50, baseDatos, docente4);

            //Instacia Matricula
            LocalTime horaM = LocalTime.now();
            Matricula matricula1 = new Matricula(horaM, curso1);

            //Instancia Tabulado
            Tabulado tabulado1 = new Tabulado(periodo20221);

            //Instancia Estudiantes
            Estudiante estudiante1 = new Estudiante(202058598, "123", p2711, 1006050741, "Jhonatan", "Castrillon Gonzalez");
            Estudiante estudiante2 = new Estudiante(202058512, "123", p2611, 1006050742, "Alejandro", "Ortiz");
            Estudiante estudiante3 = new Estudiante(202058513, "123", p2711, 1006050743, "Armando", "Paredes");
            Estudiante estudiante4 = new Estudiante(202058514, "123", p2311, 1006050744, "Carmensa", "Gomez");
            Estudiante estudiante5 = new Estudiante(202058515, "123", p2611, 1006050745, "Paquita", "Gonzalez");

            //Añadir cupos a cursos
            curso1.añadirCupos(cupo1);
            curso1.añadirCupos(cupo7);

            curso2.añadirCupos(cupo2);

            curso3.añadirCupos(cupo3);

            curso4.añadirCupos(cupo4);

            curso5.añadirCupos(cupo5);

            curso6.añadirCupos(cupo6);

            //Añadir estudiantes a cursos
            curso1.añadirEstudiante(estudiante1);

            //Añadir matricula a tabulado
            tabulado1.añadirMatricula(matricula1);

            //Añadir tabulado a estudiante
            estudiante1.añadirTabulado(tabulado1);

            //Añadir Asignaturas a Semestre
//            semestre1.añadirAsignatura(baseDatos);
//            semestre2.añadirAsignatura(calculo1);
//            semestre3.añadirAsignatura(progInteractiva);
            
            //Añadir semestres a Programa
//            p2311.añadirSemestre(semestre1);
//            p2611.añadirSemestre(semestre2);
//            p2711.añadirSemestre(semestre3);
            
            //Añadir cursos a periodo
            //2021-1
            periodo20211.añadirCurso(curso1);
            periodo20211.añadirCurso(curso2);
            periodo20211.añadirCurso(curso3);
            periodo20211.añadirCurso(curso4);
            periodo20211.añadirCurso(curso5);
            periodo20211.añadirCurso(curso6);
            //2021-2
            periodo20212.añadirCurso(curso1);
            periodo20212.añadirCurso(curso2);
            periodo20212.añadirCurso(curso3);
            periodo20212.añadirCurso(curso4);
            periodo20212.añadirCurso(curso5);
            periodo20212.añadirCurso(curso6);
            //2022-1
            periodo20221.añadirCurso(curso1);
            periodo20221.añadirCurso(curso2);
            periodo20221.añadirCurso(curso3);
            periodo20221.añadirCurso(curso4);
            periodo20221.añadirCurso(curso5);
            periodo20221.añadirCurso(curso6);

            //Añadir estudiantes a la universidad
            universidad.añadirEstudiante(estudiante1);
            universidad.añadirEstudiante(estudiante2);
            universidad.añadirEstudiante(estudiante3);
            universidad.añadirEstudiante(estudiante4);
            universidad.añadirEstudiante(estudiante5);
            
            //Añadir docentes a la universidad
//            universidad.añadirDocente(docente1);
//            universidad.añadirDocente(docente2);
//            universidad.añadirDocente(docente3);
//            universidad.añadirDocente(docente4);

            //Añadir programas a la universidad
//            universidad.añadirPrograma(p2311);
//            universidad.añadirPrograma(p2611);
//            universidad.añadirPrograma(p2711);
            
            //Añadir periodos a la universidad
            universidad.añadirPeriodo(periodo20211);
            universidad.añadirPeriodo(periodo20212);
            universidad.añadirPeriodo(periodo20221);

            //Añadir asignaturas a la universidad
//            universidad.añadirAsignatura(progInteractiva);
//            universidad.añadirAsignatura(calculo1);
//            universidad.añadirAsignatura(calculo2);
//            universidad.añadirAsignatura(baseDatos);
        }

        try {
            new VentanaPrincipal(universidad).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
