/*
 *  Creado por Pepinho con fines educativos. Fai o queiras.
 * 
 */
package com.pepinho.ad.codigopostal.model;

/**
 *
 * @author pepecalo
 */
// Lugar.java
public class Lugar {

    private String nome;
    private double longitud;
    private double latitud;
    private String estado;
    private String abreviaturaEstado;

    public Lugar() {
    }

    public Lugar(String nome, double longitud, double latitud, String estado, String abreviaturaEstado) {
        this.nome = nome;
        this.longitud = longitud;
        this.latitud = latitud;
        this.estado = estado;
        this.abreviaturaEstado = abreviaturaEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAbreviaturaEstado() {
        return abreviaturaEstado;
    }

    public void setAbreviaturaEstado(String abreviaturaEstado) {
        this.abreviaturaEstado = abreviaturaEstado;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    /**
     * Método que devuelve un String con los datos del lugar en formato HTML con colores.
     * @return String con los datos del lugar en formato HTML con colores.
     */
    public String toHTML() {
        return "<h1>" + nome + "</h1>"
                + "Longitud: " + longitud + "<br/>"
                + "Latitud: " + latitud + "<br/>"
                + "Comunidad: " + estado + "<br/>"
                + "Abreviatura Comunidad: " + abreviaturaEstado + "<br/>";
    }

    /**
     * Método que recoge un boolean si quiero devolver el lugar en formato fila de una tabla HTML.
     * Devuelve un String con los datos del lugar en formato HTML con colores.
     * Si está en una fila de una tabla HTML, el fondo de la fila es de color gris.
     * @param fila boolean que indica si quiero devolver el lugar en formato fila de una tabla HTML.
     */
    public String toHTML(boolean fila) {
        return (fila) ? "<tr style=\"background-color: #cccccc\">"
                + "<td>" + nome + "</td>"
                + "<td>" + longitud + "</td>"
                + "<td>" + latitud + "</td>"
                + "<td>" + estado + "</td>"
                + "<td>" + abreviaturaEstado + "</td>"
                + "</tr>"
                : "<h1>" + nome + "</h1>"
                + "Longitud: " + longitud + "<br/>"
                + "Latitud: " + latitud + "<br/>"
                + "Comunidad: " + estado + "<br/>"
                + "Abreviatura Comunidad: " + abreviaturaEstado + "<br/>";
    }

    /**
     * Método que devuelve un String con los datos del lugar en formato texto.
     * @return String con los datos del lugar en formato texto.
     */

    @Override
    public String toString() {
        return " Lugar: " + nome + System.lineSeparator()
                + " Longitud: " + longitud + System.lineSeparator()
                + " Latitud: " + latitud + System.lineSeparator()
                + " Comunidad: " + estado + System.lineSeparator()
                + " Abreviatura Comunidad: " + abreviaturaEstado + System.lineSeparator();
    }

    /**
     * Método que devuelve un int con el código hash del objeto. Dos objetos con la misma latitud y
     * longitud devuelven el mismo código hash. Debe ser consistente con el método equals, es decir, si dos objetos
     * son iguales, deben devolver el mismo código hash (no al contrario, aunque recomendable).
     * @return int con el código hash del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 97 *
                (97 * 7 + (int) (Double.doubleToLongBits(this.longitud) ^
                        (Double.doubleToLongBits(this.longitud) >>> 32))) +
                    (int) (Double.doubleToLongBits(this.latitud) ^ (Double.doubleToLongBits(this.latitud) >>> 32));
        return hash;
    }


    /**
     * Método que devuelve un boolean que indica si dos objetos son iguales. COnsideramos que dos objetos son iguales si
     * tienen la misma latitud y longitud.
     * @param obj   Objeto a comparar
     * @return  boolean que indica si dos objetos son iguales.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Lugar other = (Lugar) obj;
        if (Double.doubleToLongBits(this.longitud) != Double.doubleToLongBits(other.longitud)) {
            return false;
        }
        return Double.doubleToLongBits(this.latitud) == Double.doubleToLongBits(other.latitud);
    }

}
