package Ejercicio_8_Examen_LocalDate_Serializer_Deserializer;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

import java.time.LocalDateTime;
import java.util.List;

public class Examen {
    private String materia;
    private LocalDateTime fecha;
    private List<String> participoantes;


    public Examen(String materia, LocalDateTime fecha, List<String> participoantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participoantes = participoantes;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<String> getParticipoantes() {
        return participoantes;
    }

    public void setParticipoantes(List<String> participoantes) {
        this.participoantes = participoantes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MAteria: ").append(materia)
                .append("\nFecha: ").append(fecha)
                .append("\nParticipantes: ").append(participoantes);
        return sb.toString();
    }
}
