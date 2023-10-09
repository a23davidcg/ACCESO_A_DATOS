import java.io.*;

public class Ejercicio_3 {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        //Programa que recoja el nombre de un ficehro y muestre su contenido si existe o cree un nuevo en el que puedas escribir si no existe
        //En primer lugar hacemos la parte que recoja el nombre del fichero

        File leer_nombre = new File("D:\\MaquinasVirtuais\\AD\\pepe.txt");
        //Mostramos por la pantalle el nombre del archivo sin ser la ruta completa del mismo en donde se encuentra
        System.out.println("Nombre del fichero .txt " + leer_nombre.getName());

        //
        BufferedReader in = null;
        BufferedWriter out = null;

        if (!leer_nombre.exists()) { //Si el nombre del archivo no existe se hace un bufferedwriter par qqu se cree el archivo nuevo,y se escriba contenido en el mismo
            try {
                out = new BufferedWriter(new FileWriter(leer_nombre));

                boolean bol =leer_nombre.createNewFile();

                out.write("Hola mundo.\n ");
                out.close();

            } catch (IOException e) {

            }

            //Se crea nuevo fichero porque no existe y no se puede escribir en el
        } else {
            try (leer_nombre) { //Si ponemos el objeto entre paréntesis no es necesario poner el bloque finally o el elemento el objeto close
                in = new BufferedReader(new FileReader(leer_nombre));
                    PrintWriter escribir = new PrintWriter(new FileWriter("\"D:\\MaquinasVirtuais\\AD\\Java_Editor_Proba.txt\""));
                String s;

                while ((s = in.readLine()) != null){

                };
            }


        }


        //BufferedReader bf = new BufferedReader(new FileReader(leer_nombre));

    }

}
