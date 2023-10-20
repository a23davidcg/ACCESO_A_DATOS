package Ejercicio_ClasificacionDAO;
public class Main {
    public static void main(String[] args) {
        ClasificacionDAO clasificacionDAO = new ClasificacionDAO();

        Clasificacion clasificacion = new Clasificacion("Barcelona", 10, 5);

        //Metodo que nos garda a clasificacion no destino que xa se especificou no metodo
        clasificacionDAO.saveToJson(clasificacion);

       //Metodo que devolve a clasificacion dende o ficheiro JSONFILE
        Clasificacion clasificacion1 = clasificacionDAO.getFromJSON();
        System.out.println(clasificacion1);

        //Metodo que garda a clasificacion no destino que se lle indica no main


        clasificacionDAO.saveToJSon(clasificacion, "OMeuDestino.json");

        //Metodo para gardar a clasificacion nun objeto

        clasificacionDAO.saveToObject(clasificacion);


        //Metodo para obtener la clasificacion desde el fichero json en concreto

        Clasificacion clasificacion2 = clasificacionDAO.getFromJSON("OMeuDestino");
        System.out.println(clasificacion2);

        //metodo para obtener la clasificacion desde el archivo objeto
        Clasificacion clasificacion3 = clasificacionDAO.getFromObject();
        System.out.println(clasificacion3);







        //TODO: Probar todos os metodos para ver se funciona



    }
}