/*
 *  Creado por Pepinho con fines educativos. Fai o queiras.
 *
 */
package com.pepinho.ad.codigopostal.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author pepecalo
 */
// Lugar.java
public class CodigoPostal {

    private String codigoPostal;
    private String pais;
    private String abreviaturaPais;
    private List<Lugar> lugares;

    public CodigoPostal() {
        lugares = new ArrayList<>();
    }

    public CodigoPostal(String codigoPostal, String pais, String abreviaturaPais) {
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.abreviaturaPais = abreviaturaPais;
        lugares = new ArrayList<>();
    }

    public void addLugar(Lugar lugar) {
        lugares.add(lugar);
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAbreviaturaPais() {
        return abreviaturaPais;
    }

    public void setAbreviaturaPais(String abreviaturaPais) {
        this.abreviaturaPais = abreviaturaPais;
    }

    /**
     * Devuelve la lista de lugares como HTML, empleando un forEach para concatenar los lugares.
     * El método forEach recibe un Consumer, que es una interfaz funcional que tiene un método
     * abstracto accept() que recibe un objeto de tipo T y no devuelve nada (void).
     *
     * @return cadena de texto con los lugares en formato HTML
     */
    public String getLugaresAsHTML() {
        StringBuilder sb = new StringBuilder("<html><body>");
        lugares.forEach(lugar -> {
            sb.append(lugar.toHTML()).append("<br>");
        });
        sb.append("</body></html>");
        return sb.toString();
    }

    /**
     * Método que devuelve la lista de lugares como HTML, empleando un forEach para concatenar los lugares.
     * El método forEach recibe un Consumer, que es una interfaz funcional que tiene un método
     * abstracto accept() que recibe un objeto de tipo T y no devuelve nada (void).
     *
     * @param asTable boolean que indica si quiero devolver los lugares en formato fila de una tabla HTML.
     * @return  cadena de texto con los lugares en formato HTML
     */
    public String getLugaresAsHTML(boolean asTable) {
        StringBuilder sb = new StringBuilder("<html><body>");
        if (asTable) {
            sb.append("<table border=\"1\">");
            sb.append("<tr style=\"background-color: #cccccc\">");
            sb.append("<th>Lugar</th>");
            sb.append("<th>Longitud</th>");
            sb.append("<th>Latitud</th>");
            sb.append("<th>Comunidad</th>");
            sb.append("<th>Abreviatura Comunidad</th>");
            sb.append("</tr>");
            lugares.forEach(lugar -> {
                sb.append(lugar.toHTML(true));
            });
            sb.append("</table>");
        } else {
            lugares.forEach(lugar -> {
                sb.append(lugar.toHTML()).append("<br>");
            });
        }
        sb.append("</body></html>");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Código Postal: '"
                + codigoPostal + System.lineSeparator()
                + "Pais: '" + pais + System.lineSeparator()
                + "AbreviaturaPais: " + abreviaturaPais + System.lineSeparator());
        lugares.forEach(lugar -> {
            sb.append(lugar).append(System.lineSeparator());
        });
        // Versión no funcional:
//        for (Lugar lugar : lugares) {
//        for (Lugar lugar : lugares) {
//            sb.append(lugar);
//        }
        return sb.toString();
    }

    /**
     * Método que devuelve un número entero que representa el objeto. Dos objetos igauales devuelven el mismo número.
     * Se emplea para tablas hash en las que se almacenan los objetos, como HashMap, HashSet, etc.
     *
     * @return
     */
    @Override
    public int hashCode() {
        return 89 * 5 + Objects.hashCode(this.codigoPostal);
    }

    /**
     * Método que compara dos objetos. Dos objetos son iguales si tienen el mismo código postal.
     *
     * @param cp Objeto a comparar
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object cp) {
        if (this == cp) {
            return true;
        }
        if (cp == null || getClass() != cp.getClass()) {
            return false;
        }
        final CodigoPostal other = (CodigoPostal) cp;
        return Objects.equals(this.codigoPostal, other.codigoPostal);
    }

}
