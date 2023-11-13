package com.pepinho.ad.codigopostal.view;

import com.pepinho.ad.codigopostal.control.ICodigoPostalController;

/**
 * Created by pepec on 18/11/2016.
 * Esta interfaz es la que se encarga de mostrar los datos al usuario.
 * Se ha declarado esta interfaz para poder cambiar la vista fácilmente y poder implementar una vista gráfica o
 * una vista de texto, por ejemplo, sin tener que modificar el controlador.
 * Creado por Pepinho con fines educativos. Fai o queiras.
 *
 */
public interface IVistaCodigoPostal  {
    // Métodos para mostrar los datos al usuario
    /**
     * Muestra un mensaje de error en la vista.
     */
    void mostrarError(String mensaje);

    /**
     * Muestra añade un lugar a la lista de lugares de la vista.
     */
    public void addLugar(String lugar);

    /**
     * Borra la lista de lugares de la vista.
     */
    public void deleteLugares();

    /**
     * Añade un código postal a la lista de códigos postales de la vista.
     */
    public void setLugares(String lugares);

    /**
     * Asigna un controlador a la vista.
     * @param controller Controlador a asignar.
     */
    public void setController(ICodigoPostalController controller);

    /**
     * Muestrea la vista
     */
    public void mostrar();
}
