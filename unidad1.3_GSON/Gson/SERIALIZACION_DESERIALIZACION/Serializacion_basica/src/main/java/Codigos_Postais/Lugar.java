package Codigos_Postais;

public class Lugar {
    private String codigoPostal;
    private String pais;

    private String abreviaturaPais;
    private String nombreCiudad;
    private double longitud;
    private String estado;
    private String abreviaturaEstado;
    private double latitud;

    public Lugar() {
    }

    public Lugar(String codigoPostal, String pais, String abreviaturaPais, String nombreCiudad, double longitud, String estado, String abreviaturaEstado, double latitud) {
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.abreviaturaPais = abreviaturaPais;
        this.nombreCiudad = nombreCiudad;
        this.longitud = longitud;
        this.estado = estado;
        this.abreviaturaEstado = abreviaturaEstado;
        this.latitud = latitud;
    }


}
