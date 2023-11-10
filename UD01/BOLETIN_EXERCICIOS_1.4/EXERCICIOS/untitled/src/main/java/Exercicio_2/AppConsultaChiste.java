package Exercicio_2;

import Exercicio_2.Controlador.ChisteDAO;
import Exercicio_2.Controlador.ControladorChiste;
import Exercicio_2.vista.IControladorChiste;
import Exercicio_2.vista.VistaChiste;
import Exercicio_2.vista.VistaChisteSwing;

public class AppConsultaChiste {
    public static void main(String[] args) {
        ChisteDAO chisteDAO = new ChisteDAO();
        VistaChiste vistaChiste = new VistaChisteTexto();
        IControladorChiste iControladorChiste = new ControladorChiste (chisteDAO, vistaChiste);
        vistaChiste.setController(controlador);

    }
}
