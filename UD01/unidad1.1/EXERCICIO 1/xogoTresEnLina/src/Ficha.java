public class Ficha implements Comparable<Ficha> {
    private final TipoFicha Tipo;

    public Ficha() {
        this.Tipo = TipoFicha.vacia;
    }

    public Ficha(TipoFicha tipo) {
        this.tipo = tipo;

    }

    public TipoFicha getTipo() {
        return tipo;
    }

    public boolean isEmpty() {
        return this.tipo == null || this.tipo == TipoFicha.vacia;
    }

    public int hashCode() {
        return Objects.hashCode(this.tipo);
    }


}
