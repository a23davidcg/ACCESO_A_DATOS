public class Equipo implements Comparable <Equipo> {
    //Declaramos los atributos necesarios

    String nombre;
    int victorias;
    int derrotas;
    int puntosFavor;
    int puntosContra;
    int puntos;
    int partidosJugados;
    int diferenciaDePuntos = puntosFavor - puntosContra;


    //Creamos los getters y modificamos los puntos para indicar que son la diferencia entre los puntos ganados menos los puntos en contra


    public String getNombre() {
        return nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getPuntosFavor() {
        return puntosFavor;
    }

    public int getPuntosContra() {
        return puntosContra;
    }


    public int getpuntos(){
        return puntos;
    }

    public int getPartidosJugados(){
        return partidosJugados;
    }
    public int getDiferenciaDePuntos(){
        return getDiferenciaDePuntos();

    }


    @Override
    public int compareTo(Equipo o) {
        return 0;
    }
}


