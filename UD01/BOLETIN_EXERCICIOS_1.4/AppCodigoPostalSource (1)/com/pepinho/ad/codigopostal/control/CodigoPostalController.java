package com.pepinho.ad.codigopostal.control;


import com.pepinho.ad.codigopostal.model.CodigoPostal;
import com.pepinho.ad.codigopostal.model.CodigoPostalDAO;
import com.pepinho.ad.codigopostal.model.ICodigoPostalDAO;
import com.pepinho.ad.codigopostal.view.IVistaCodigoPostal;

/**
 * Created by Pepinho el 18/11/2016.
 * Esta clase es la que se encarga de controlar la aplicación
 * y de realizar las peticiones al modelo.
 * Creado por Pepinho con fines educativos. Fai o queiras.
 */
public class CodigoPostalController implements ICodigoPostalController {
    // El controlador debe tener una referencia al modelo y a la vista.

    private ICodigoPostalDAO codigoPostalDAO;
    private IVistaCodigoPostal vistaCodigoPostal;

    // Constructor que recoge la referencia al modelo
    public CodigoPostalController(ICodigoPostalDAO codigoPostalDAO, IVistaCodigoPostal vistaCodigoPostal) {
        this.codigoPostalDAO = codigoPostalDAO;
        this.vistaCodigoPostal = vistaCodigoPostal;
    }

    public CodigoPostalController(IVistaCodigoPostal vistaCodigoPostal) {
        codigoPostalDAO = new CodigoPostalDAO();
        this.vistaCodigoPostal = vistaCodigoPostal;
    }

    public CodigoPostalController() {
        codigoPostalDAO = new CodigoPostalDAO();
    }

    @Override
    public String getLugares(String codigoPostal, boolean asHTML) {
        CodigoPostal cp = codigoPostalDAO.getCodigoPostal(codigoPostal);
        if (cp == null) {
            vistaCodigoPostal.mostrarError("No se ha encontrado el código postal");
            return "";
        }
        return (asHTML) ? cp.getLugaresAsHTML(true) : cp.getLugares().toString();
    }

    /**
     * Obtiene un objeto CodigoPostal a partir de un código postal y un país.
     * @param codigoPostal Código postal como cadena de texto
     * @param pais       País como cadena de texto ("es", "fr", "us", etc.)
     * @param asHTML
     * @return
     */
    @Override
    public String getLugares(String codigoPostal, String pais, boolean asHTML) {
        CodigoPostal cp = codigoPostalDAO.getCodigoPostal(codigoPostal, pais);
        if (cp == null) {
//            vistaCodigoPostal.mostrarError("No se ha encontrado el código postal");
            return "No se ha encontrado el código postal";
        }
        return (asHTML) ? cp.getLugaresAsHTML(true) : cp.getLugares().toString();
    }

    @Override
    public void setLugares(String codigoPostal, boolean asHTML) {
        CodigoPostal cp = codigoPostalDAO.getCodigoPostal(codigoPostal);
        if (cp == null) {
            vistaCodigoPostal.mostrarError("No se ha encontrado el código postal");
            vistaCodigoPostal.setLugares("No se ha encontrado el código postal");
        }
        if (asHTML) vistaCodigoPostal.setLugares(cp.getLugaresAsHTML(true));
        else vistaCodigoPostal.setLugares(cp.getLugares().toString());

    }

    @Override
    public void setVista(IVistaCodigoPostal vista) {
        this.vistaCodigoPostal = vista;
    }
}
