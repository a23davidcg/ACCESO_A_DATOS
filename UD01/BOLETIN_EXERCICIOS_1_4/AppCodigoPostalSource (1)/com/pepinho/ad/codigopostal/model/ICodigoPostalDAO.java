package com.pepinho.ad.codigopostal.model;

/**
 * Interface que deben implantar las clases de acceso a datos.
 * Creado por Pepinho con fines educativos. Fai o queiras.
 */
public interface ICodigoPostalDAO {

    /**
     * Obtiene un objeto CodigoPostal a partir de un código postal.
     * @param codigoPostal Código postal como cadena de texto.
     * @return Objeto CodigoPostal  o null si no se ha podido obtener.
     */
    public CodigoPostal getCodigoPostal(String codigoPostal);

    /**
     * Obtiene un objeto CodigoPostal a partir de un código postal y un país.
     * @param codigoPostal Código postal como cadena de texto.
     * @param pais       País como cadena de texto ("es", "fr", "us", etc.)
     * @return Objeto CodigoPostal  o null si no se ha podido obtener.
     */
    public CodigoPostal getCodigoPostal(String codigoPostal, String pais);
}
