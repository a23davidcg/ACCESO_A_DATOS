package Ejercicio_5;

import java.util.Date;
import java.util.List;

public class Examen_1 {
    private String materia;
    private Date fecha;
    private List<String> estudiantes;

    public Examen_1(String materia, Date fecha, List<String> estudiantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.estudiantes = estudiantes;
    }

    public Examen_1() {
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<String> getEstudiantes() {
        return estudiantes;
    }

    //Metodo para agregar estudiantes

    public void agregarEstudiantes (String estudiante){
        estudiantes.add(estudiante);
    }

    @Override
    public String toString() {
        return "Examen{" +
                "materia='" + materia + '\'' +
                ", fecha=" + fecha +
                ", estudiantes=" + estudiantes +
                '}';
    }
}
