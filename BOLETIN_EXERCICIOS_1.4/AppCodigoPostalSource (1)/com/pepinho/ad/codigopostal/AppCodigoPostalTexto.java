package com.pepinho.ad.codigopostal;

import com.pepinho.ad.codigopostal.control.CodigoPostalController;
import com.pepinho.ad.codigopostal.control.ICodigoPostalController;
import com.pepinho.ad.codigopostal.view.IVistaCodigoPostal;
import com.pepinho.ad.codigopostal.view.VistaTextoCodigoPostal;

/**
 * Aplicación que permite consultar los códigos postales de España, empleando la vista ConsultaCodigoPostal
 * y el controlador CodigoPostalController.
 */
public class AppCodigoPostalTexto {

    public static void main(String[] args) {
        ICodigoPostalController controller = new CodigoPostalController();
        IVistaCodigoPostal vista = new VistaTextoCodigoPostal(controller);
        controller.setVista(vista);
        vista.mostrar();
    }


}
