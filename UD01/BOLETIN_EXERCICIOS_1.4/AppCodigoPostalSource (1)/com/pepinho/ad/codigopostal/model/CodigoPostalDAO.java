package com.pepinho.ad.codigopostal.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Clase DAO de acceso a datos para la clase CodigoPostal.
 * Implementa la interfaz ICodigoPostalDAO, con el fin de que se puedan crear otras clases DAO que implementen
 * dicha interfaz.
 *
 *  Creado por Pepinho con fines educativos. Fai o queiras.
 */
public class CodigoPostalDAO implements ICodigoPostalDAO {

    // Objeto Gson para parsear JSON de la API de zippopotam.us
    private Gson gson;

    // URL base de la API de zippopotam.us
    private final String URL_BASE = "https://api.zippopotam.us/";

    // URL de la API de zippopotam.us para obtener un objeto CodigoPostal
    private final String URL_CODIGO_POSTAL = URL_BASE + "{pais}/{codigoPostal}";

    // Constructor
    public CodigoPostalDAO() {
        // Inicializa el objeto Gson por medio de un GsonBuilder con formato bonito y registrando los adaptadores
        // de tipo CodigoPostal y Lugar.
        // Los adaptadores de tipo se encargan de parsear los objetos JSON a objetos Java y viceversa.
        // Podrían haberse empleado una clase anónima o una clase interna anónima, pero se ha preferido crear
        // una clase externa para cada adaptador.
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(CodigoPostal.class, new CodigoPostalTypeAdapter())
                .registerTypeAdapter(Lugar.class, new LugarDeserializer())
                .create();
    }

    /**
     * Obtiene un objeto CodigoPostal a partir de un código postal recogido como cadena de texto.
     * Por defecto el país es España ("es").
     * La lista de países se puede consultar en https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2
     * y los del api en https://api.zippopotam.us/
     *
     * @param codigoPostal Código postal como cadena de texto
     * @return Objeto CodigoPostal  o null si no se ha podido obtener
     */

    public CodigoPostal getCodigoPostal(String codigoPostal){
        // Invocamos al método getCodigoPostal(String codigoPostal, String pais) con el país por defecto "es"
        return getCodigoPostal(codigoPostal, "es");
    }

    /**
     * Obtiene un objeto CodigoPostal a partir de un código postal y un país.
     * @param codigoPostal Código postal como cadena de texto
     * @param pais      País como cadena de texto ("es", "fr", "us", etc.)
     * @return        Objeto CodigoPostal o null si no se ha podido obtener
     */
    public CodigoPostal getCodigoPostal(String codigoPostal, String pais) {
        CodigoPostal cp = null;
        try {
            URI url = new URI(URL_CODIGO_POSTAL
                    .replace("{pais}", pais)
                    .replace("{codigoPostal}", codigoPostal));
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(url.toURL().openStream()));
            cp = gson.fromJson(br, CodigoPostal.class);
        } catch (IOException e) {
            System.err.println("Error al obtener el código postal");
            return null;
        } catch (URISyntaxException e) {
            System.err.println("Error al obtener el código postal");
            return null;
        }
        return cp;
    }


}
