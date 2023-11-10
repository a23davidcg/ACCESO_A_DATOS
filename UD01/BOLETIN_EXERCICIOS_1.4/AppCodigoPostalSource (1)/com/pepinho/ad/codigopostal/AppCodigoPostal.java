/*
 *  Creado por Pepinho con fines educativos. Fai o queiras.
 *
 */
package com.pepinho.ad.codigopostal;

import com.pepinho.ad.codigopostal.control.CodigoPostalController;
import com.pepinho.ad.codigopostal.control.ICodigoPostalController;
import com.pepinho.ad.codigopostal.view.IVistaCodigoPostal;
import com.pepinho.ad.codigopostal.view.VentaCodigoPostal;


import javax.swing.*;

/**
 * @author pepecalo
 */
public class AppCodigoPostal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here

        SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            IVistaCodigoPostal vcp = new VentaCodigoPostal(null);
            ICodigoPostalController cpController = new CodigoPostalController(vcp);
            vcp.setController(cpController);
            vcp.mostrar();
        });


//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(CodigoPostal.class, new CodigoPostalTypeAdapter())
////                .registerTypeAdapter(Lugar.class, new LugarDeserializer())
//                .create();
//
//        URL url = new URI("https://api.zippopotam.us/es/30300").toURL();
//
//        BufferedReader br = new BufferedReader(
//                new InputStreamReader(url.openStream()));
////        String linha = null;
////        while( (linha=br.readLine())!=null){
////            System.out.println(linha);
////        }
//
//        CodigoPostal codigoPostal = gson.fromJson(br, CodigoPostal.class);
//
//        System.out.println(codigoPostal);
    }

}
