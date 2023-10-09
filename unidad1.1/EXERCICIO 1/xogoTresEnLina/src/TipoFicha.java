public enum TipoFicha {
        circulo ('0', 1),
        cruz('x', -1),
        vacia(' ', 0);

        private final char caracter;
        private final int valor ;

        private TipoFicha(char caracter, int valor){
                this.caracter = caracter;
                this.valor = valor;
        }
        public int getValor(){
                return valor;
        }

        public char getCaracter() {
                return caracter;
        }

        @Override
        public String toString() {
                return "TipoFicha{" +
                        "caracter=" + caracter +
                        ", valor=" + valor +
                        '}';
        }
}


