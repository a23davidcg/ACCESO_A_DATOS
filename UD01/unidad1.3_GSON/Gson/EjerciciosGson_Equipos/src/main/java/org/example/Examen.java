package org.example;

import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Examen {
    private String materia;

    @Expose(serialize = true, deserialize = true)private Date fecha;

    private List<String> participantes;

    public Examen(String materia, Date fecha, List<String> participantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;


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

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "materia='" + materia + '\'' +
                ", fecha=" + fecha +
                ", participantes=" + participantes +
                '}';
    }

}
