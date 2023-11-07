package Exercicio_2.Controlador;

import Exercicio_2.vista.IControladorChiste;
import Exercicio_2.vista.VistaChiste;

public class ControladorChiste implements IControladorChiste {
    private final ChisteDAO chisteDAO;
    private final VistaChiste vistaChiste;

    public ControladorChiste(ChisteDAO chisteDAO, VistaChiste vistaChiste) {
        this.chisteDAO = chisteDAO;
        this.vistaChiste = vistaChiste;
    }

    public String getRandomJoke() {
        return chisteDAO.getRandomJoke();

    }


}
