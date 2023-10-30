package Ejercicio_3;

import java.time.LocalDateTime;
import java.util.List;

public class Examen {
    private String materia;
    private LocalDateTime fecha;
    public List<String> estudiantes;

    public Examen(String materia, LocalDateTime fecha, List<String> estudiantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.estudiantes = estudiantes;
    }

    public String getMateria() {
        return materia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public List<String> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<String> estudiantes) {
        this.estudiantes = estudiantes;
    }

    //Necesario darle formnato usando el stringbuilder en el toString porque lo indica el enunciado
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(materia).append(",");
        sb.append(fecha).append(",");
        sb.append(estudiantes).append(".");
        return sb.toString();

    }
}
