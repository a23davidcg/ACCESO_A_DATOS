package Exercicio_2;

public enum Flag {
    //sE CREA LA ENUMERACION DE FLAG PARA DELIMTAR LOS POSIBLES VALORES QUE PUEDE TENER


    NFSW("trabajo"), RELIGIOUS("religión"), SEXIST("sexista"), EXPLICIT("explicito");
    private String nome;

    private Flag (String nome) {
        this.nome = nome;

    }



//    "nsfw": false,
//            "religious": false,
//            "political": false,
//            "racist": false,
//            "sexist": false,
//            "explicit": false

}
