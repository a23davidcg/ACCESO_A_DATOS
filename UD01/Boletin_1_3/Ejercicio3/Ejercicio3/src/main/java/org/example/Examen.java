package org.example;

import java.time.LocalDateTime;

public class Examen {
    private String materia;
    private LocalDateTime localDateTime;
    private String[] estudiantes;

    public Examen(String materia, LocalDateTime localDateTime, String[] estudiantes) {

        this.materia = materia;
        this.localDateTime = localDateTime;
        this.estudiantes = estudiantes;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String[] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(String[] estudiantes) {
        this.estudiantes = estudiantes;
    }
}
