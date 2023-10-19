package Ejercicio_ClasificacionDAO;

public class Main {

    public static void main(String[] args) {
        ClasificacionDAO clasificacionDAO = new ClasificacionDAO();

        Clasificacion clasificacion = new Clasificacion("Barcelona", 10, 5);

        clasificacionDAO.saveToJSON(clasificacion);

        Clasificacion clasificacion1 = clasificacionDAO.getFromJSON();
        System.out.println(clasificacion1);

        //TODO: Probar todos os metodos para ver se funciona
    }
}