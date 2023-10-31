package Ejercicio_6_Clasificacion_DAO;

public class MainDAO {
    public static void main(String[] args) {
        ClasificacionDAO clasificacionDAO = new ClasificacionDAO();
        Clasificiacion clasificacion = new Clasificiacion("Barcelona", 10, 5);

        clasificacionDAO.saveToObject(clasificacion);

    }
}
