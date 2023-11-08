package Davan;

public class Main {
    public static void main(String[] args) {
        Persoa p = new Persoa("David", 84);
        PersoaDAO.writeFileTXT(p);
        PersoaDAO.leerArchivo(p);


    }
}
