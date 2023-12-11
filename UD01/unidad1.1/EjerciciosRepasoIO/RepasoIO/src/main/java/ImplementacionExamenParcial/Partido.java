package ImplementacionExamenParcial;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * {
 *       "id": 857369,
 *       "date": "2022-10-20T00:00:00.000Z",
 *       "home_team": {
 *         "id": 14,
 *         "abbreviation": "LAL",
 *         "city": "Los Angeles",
 *         "conference": "West",
 *         "division": "Pacific",
 *         "full_name": "Los Angeles Lakers",
 *         "name": "Lakers"
 *       },
 *       "home_team_score": 97,
 *       "period": 4,
 *       "postseason": false,
 *       "season": 2022,
 *       "status": "Final",
 *       "time": "Final",
 *       "visitor_team": {
 *         "id": 13,
 *         "abbreviation": "LAC",
 *         "city": "LA",
 *         "conference": "West",
 *         "division": "Pacific",
 *         "full_name": "LA Clippers",
 *         "name": "Clippers"
 *       },
 *       "visitor_team_score": 103
 *     }
 */
public class Partido implements Comparable<Partido>, Serializable {
    private int idPartido;
    private LocalDate fecha;
    private Equipo equipoLocal;
    private int puntosLocal;
    private int periodo;
    private boolean postemporada;
    private int temporada;
    private String estado;
    private String tiempo;
    private Equipo equipoVisitante;
    private int puntosVisitante;


    public Partido() {
    }

    public Partido(int idPartido, LocalDate fecha, Equipo equipoLocal, int puntosLocal,
                   int periodo, boolean postemporada, int temporada,
                   String estado, String tiempo, Equipo equipoVisitante, int puntosVisitante) {

        this.idPartido = idPartido;
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.puntosLocal = puntosLocal;
        this.periodo = periodo;
        this.postemporada = postemporada;
        this.temporada = temporada;
        this.estado = estado;
        this.tiempo = tiempo;
        this.equipoVisitante = equipoVisitante;
        this.puntosVisitante = puntosVisitante;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public boolean isPostemporada() {
        return postemporada;
    }

    public void setPostemporada(boolean postemporada) {
        this.postemporada = postemporada;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    /**
     * Devuelve el equipo ganador del partido.
     * Escribe en la cabecera la fecha y el resultado del partido, indicando en una línea los puntos del equipo que juega en casa, seguido de los datos del equipo
     * en la siguiente línea los puntos del equipo visitante, seguido de los datos del equipo visitante.
     * Emplea String.format para dar formato a la salida.
     * @return fichero con el resultado del partido.
     */

    @Override
    public String toString() {
        return String.format("%s %s %d - %d %s", fecha, equipoLocal.getNombre(), puntosLocal, puntosVisitante, equipoVisitante.getNombre());

    }


    @Override
    public int compareTo(Partido o) {
        // compara por fecha
        if (this.fecha.isBefore(o.fecha)) {
            return 1;
        } else if (this.fecha.isAfter(o.fecha)) {
            return -1;
        }
        return 0;
    }
}
