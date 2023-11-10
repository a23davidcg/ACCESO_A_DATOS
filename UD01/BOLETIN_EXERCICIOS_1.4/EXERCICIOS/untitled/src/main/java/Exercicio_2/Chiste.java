package Exercicio_2;

import java.util.List;

public class Chiste {

    private String categoria;
    private String tipo;
    private String chiste; //setup
    private String respuesta;//delivery
    private List<Flag> banderas; //flags

    private String lang ;

    private long id;

    public Chiste() {
    }



    public Chiste(String categoria, String tipo, String chiste, String respuesta, String lang, long id) {
        this.categoria = categoria;
        this.tipo = tipo;
        this.chiste = chiste;
        this.respuesta = respuesta;
        this.lang = lang;
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getChiste() {
        return chiste;
    }

    public void setChiste(String chiste) {
        this.chiste = chiste;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public List<Flag> getBanderas() {
        return banderas;
    }

    public void setBanderas(List<Flag> banderas) {
        this.banderas = banderas;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Chiste{" +
                "categoria ='" + categoria + System.lineSeparator() +
                ", tipo ='" + tipo + '\'' +
                ", chiste ='" + chiste + '\'' +
                ", respuesta ='" + respuesta + '\'' +
                ", lenguaje ='" + lang + '\'' +
                ", id =" + id);

        banderas.forEach(b -> sb.append(b.toString()).append(System.lineSeparator()));


        return sb.toString();
    }

    //    {
//        "error": false,
//            "category": "Programming",
//            "type": "twopart",
//            "setup": "¿Por qué C consigue todas las chicas y Java no
//        tiene ninguna?",
//        "delivery": "Porque C no las trata como objetos.",
//            "flags": {
//        "nsfw": false,
//                "religious": false,
//                "political": false,
//                "racist": false,
//                "sexist": false,
//                "explicit": false
//    },
//        "safe": true,
//            "id": 6,
//            "lang": "es"
//    }


}
