package ImplementacionExamenParcial;

import java.io.Serializable;

/**
 * {
 *       "id": 2,
 *       "abbreviation": "BOS",
 *       "city": "Boston",
 *       "conference": "East",
 *       "division": "Atlantic",
 *       "full_name": "Boston Celtics",
 *       "name": "Celtics"
 *     }
 */
public class Equipo implements Serializable {
    private int idEquipo;
    private String abreviatura;
    private String ciudad;
    private Conferencia conferencia;
    private Division division;
    private String nombreCompleto;
    private String nombre;

    public Equipo() {
    }

    public Equipo(int idEquipo, String abreviatura, String ciudad, Conferencia conferencia, Division division, String nombreCompleto, String nombre) {
        this.idEquipo = idEquipo;
        this.abreviatura = abreviatura;
        this.ciudad = ciudad;
        this.conferencia = conferencia;
        this.division = division;
        this.nombreCompleto = nombreCompleto;
        this.nombre = nombre;
    }

    public Equipo(int idEquipo, String abreviatura, String ciudad, String conferencia, String division, String nombreCompleto, String nombre) {
        this.idEquipo = idEquipo;
        this.abreviatura = abreviatura;
        this.ciudad = ciudad;
        this.conferencia = Conferencia.getConferencia(conferencia);
        this.division = Division.getDivision(division);
        this.nombreCompleto = nombreCompleto;
        this.nombre = nombre;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }

    public String getConferenciaAsString() {
        return this.conferencia.getNombre();
    }

    public void setConferencia(String conferencia) {
        this.conferencia = Conferencia.getConferencia(conferencia);
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getDivisionAsString() {
        return (division!=null) ? this.division.getNombre() : "";
    }

    public void setDivision(String division) {
        this.division = Division.getDivision(division);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo equipo)) return false;

        return (idEquipo != equipo.idEquipo);
    }

    @Override
    public int hashCode() {
        return idEquipo;
    }

    /**
     * Sobrescribimos el método toString para que nos muestre los datos del objeto, en una línea, con el nombre en
     * mayúsculas. Además, usamos el método String.format para darle un formato a la salida.
     * @return String con los datos del objeto.
     * @see String#format(String, Object...)
     * @see String#toUpperCase()
     * @see String#trim()
     * @see String#replaceAll(String, String)
     */
    @Override
    public String toString() {
        return String.format("%-3d %-3s %-20s %-10s %-10s %-30s %-20s",
                idEquipo, abreviatura, ciudad, conferencia.getNombre(), division, nombreCompleto, nombre);
    }
}
