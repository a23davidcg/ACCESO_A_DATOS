package JAVA_NIO2;

public class Persoa {
    private String nome;
    private int edad;

    public Persoa(String nome, int edad) {
        this.nome = nome;
        this.edad = edad;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persoa{" +
                "nome='" + nome + '\'' +
                ", edad=" + edad +
                '}';
    }
}
