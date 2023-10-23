/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package org.example;

import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author pepecalo
 */
public class Sudoku implements Serializable {

    /*
    ===========================================================================
    CONSTANTES. ATRIBUTOS ESTÁTICOS Y FINALES.
    ===========================================================================
     */
    /**
     * Alfabeto por defecto.
     */
    public static final Set<Character> DEFAULT_ALFABET
            = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9'); // Java 9

//  // Stream: java 8
//    public final Set<Character> DEFAULT_ALFABET 
//      = Stream.of('1','2','3','4','5','6','7','8','9')
//      .collect(Collectors.toCollection(HashSet::new)); // Java 8
//    // Clase anónima:
//    Set<Character> DEFAULT_ALFABET = new HashSet<Character>() {
//        {
//            add('1');
//            add('2');
//            add('3');
//            add('4');
//            add('5');
//            add('6');
//            add('7');
//            add('8');
//            add('9');
//        }
//    };
//     new HashSet<>(Arrays.asList(
//            new Character[]{'1','2','3','4','5','6','7','8','9'}
//    ));
    /*======================================================================
     *   Constantes de ayuda 
     ======================================================================*/
    /**
     * Carácter de entrada o de archivo para una celda libre/vacía.
     */
    public static final char CARACTER_LIBRE = ' ';
    /**
     * Carácter almacenado cuando una celda está vacía.
     */
    public static final char CARACTER_NULO = 0;

    /**
     * Valor devuelto por el tamaño cuando no un tamaño válido o no es cuadrado.
     */
    public static final int NO_SQUARE_SIZE = -1;

    /**
     * Mensaje de error para tamaños no válidos.
     */
    public static final String NO_VALID_SIZE_MESSAGE = "Tamaño no válido";

    /*
    ===========================================================================
    ATRIBUTOS DE INSTANCIA
    ===============================================CARA============================
     */
    // Celdas del sudoku.
    private char[][] celdas;

    // Alfabeto del sudoku.
    private Set<Character> alfabeto;

    /*
    ===========================================================================
    CONSTRUCTORES
    ===========================================================================
     */
    /**
     * Construye un sudoku vacío con el alfabeto por defecto. Crea el array de
     * celdas de dos dimensiones con el tamaño del alfabeto. Cada celda tiene un
     * valor por defecto, valor número 0 (CARACTER_NULO)
     *
     * @see #DEFAULT_ALFABET
     */
    public Sudoku() {
        this.alfabeto = DEFAULT_ALFABET;
        celdas = new char[DEFAULT_ALFABET.size()][DEFAULT_ALFABET.size()];
    }

    /**
     * Construye un sudoku con el alfabeto recogido como array de carácteres. Si
     * el alfabeto no tiene el tamaño adecuado lanza una excepción. Para
     * facilitar se usa un método estático hasCorrectSize.
     *
     * @param alfabeto
     * @throws Exception
     * @see #hasCorrectSize(char[])
     */
    public Sudoku(char[] alfabeto) throws Exception {
        if (hasCorrectSize(alfabeto)) {
            this.alfabeto = new HashSet<>();
            for (char c : alfabeto) {
                this.alfabeto.add(c);
            }
            celdas = new char[this.alfabeto.size()][this.alfabeto.size()];
        } else {
            throw new Exception(NO_VALID_SIZE_MESSAGE);
        }
    }

    /**
     * Construye un Sudoku con las celdas recogidas. Si el array de celdas no es
     * cuadrado perfecto de dimensiones posibles lanza una excepción (de tipo
     * Exception) con el mensaje de “Tamaño de sudoku no válido”. Para facilitar
     * el código se emplea el método "setCeldas".
     *
     * @param celdas celdas del sudoku.
     * @throws Exception el tamaño de array no es válido.
     * @see #setCeldas(char[][])
     */
    public Sudoku(char[][] celdas) throws Exception {
        setCeldas(celdas);
    }

    /*
    ===========================================================================
    MÉTODOS ESTÁTICOS DE UTILIDAD (NO SE PIDEN)
    ===========================================================================
     */
    /**
     * No se pide, indica si un array es cuadrado. Devuelve el tamaño si es
     * cuadrado o -1 (NO_SQUARE_SIZE) si no lo es.
     *
     * @param celas array de dos dimensiones de celdas.
     * @return tamanho del array o -1 si no es cuadrado.
     */
    public static int isSquare(char[][] celas) {
        if (celas == null) {
            return NO_SQUARE_SIZE;
        }
        int tamanho = celas.length;
        // Se recorre cada fila de array, pues no necesariamente es rectangular:
        for (char[] cela : celas) {
            if (cela == null || cela.length != tamanho) {
                return NO_SQUARE_SIZE;
            }
        }
        return tamanho;
    }

    /**
     * No se pide; método de utilidad que recoge un array de dos dimensiones de
     * carácteres y devuelve el conjunto de elementos diferentes, el alfabeto.
     *
     * @param celas array de dos dimensiones de caracteres.
     * @return conjunto de elementos diferentes del array.
     */
    public static Set<Character> getAlfabeto(char[][] celas) {
        Set<Character> alfabeto = new HashSet<>();
        // si el array es nulo, el número de filas es 0 el número de columnas es cero
        int tamanho;
        if ((tamanho = isSquare(celas)) == NO_SQUARE_SIZE || tamanho == 0) {
            return alfabeto;
        }
        for (char[] cela : celas) {
            for (int j = 0; j < cela.length; j++) {
                // Sólo se guardan en el Sudoku los caracteres no vacíos.
                if (cela[j] != CARACTER_LIBRE && cela[j] != CARACTER_NULO) {
                    alfabeto.add(cela[j]);
                }
            }
        }
        return alfabeto;
    }

    /**
     * Comprueba si el tamaño del alfabeto recogido por argumento es un cuadrado
     * perfecto.<br>
     * Antes comprueba que no sea nulo y que la longitud sea distinta de cero.
     * En ese caso devuelve <code>false</code>.
     *
     * Por ejemplo, son sólo válidos tamaño de alfabeto: 1, 4 (2*2), 9 (3*3), 16
     * (4*4), etc. Si el alfabeto es nulo o la longitud es cero devuelve
     * <code>false</code>. En caso contrario comprueba que el tamaño sea un raíz
     * perfecta. Esto es, que la raíz cuadrada del tamaño sea un número entero.
     *
     * @param alfabeto array del que quiero comprobar el tamaño.
     * @return verdadero si el tamaño del alfabeto es un cuadrado perfecto.
     */
    public static final boolean hasCorrectSize(char[] alfabeto) {
        if (alfabeto == null || alfabeto.length == 0) {
            return false;
        }
        double raiz = Math.sqrt(alfabeto.length);
        return raiz == (int) raiz;
    }

    /**
     * Clona las celdas, fila a fila con clone(), para hacer copias del sudoku
     * sin tener que trabajar con el original.
     *
     * @return copia array de dos dimensiones de las celdas originales.
     */
    public char[][] clonarArrayCeldas() {
        char[][] c = new char[celdas.length][];
        for (int r = 0; r < celdas.length; r++) {
            c[r] = celdas[r].clone();
        }
        return c;
    }

    /**
     * Clona las celdas, fila a fila con Arrays.copyOf(...).
     * No se usa.
     *
     * @return copia array de dos dimensiones de las celdas originales.
     */
    public char[][] clonarArrayCeldasV2() {
        char[][] copia = new char[celdas.length][];
        for (int i = 0; i < celdas.length; i++) {
            char[] array = celdas[i];
            copia[i] = Arrays.copyOf(array, array.length);
        }
        return copia;
    }

    /*
    ===========================================================================
    MÉTODOS DE IMPLANTACIÓN
    ===========================================================================
     */
    /**
     * Devuelve el tamaño del sudoku (número de filas o columnas). Es cuadrado y
     * debe coincidir con el tamaño del alfabeto.
     *
     * @return tamaño del alfabeto o número de columnas/filas del sudoku.
     */
    public int getSize() {
        return (celdas != null) ? celdas.length : 0;
    }

    /**
     * Devuelve el array con las celdas del sudoku.
     *
     * @return array de celdas del sudoku.
     */
    public char[][] getCeldas() {
        return celdas;
        // Si quiero clonarlas las celdas:
//        return Arrays.stream(celdas).map(char[]::clone).toArray(char[][]::new);
    }

    /**
     * Asigna el carácter c a la posición i, j del Sudoku. Debe comprobar que no
     * excede los límites del Sudoku.
     *
     * @param i índice de la fila (0...tamaño-1)
     * @param j índice de la columna (0...tamaño-1).
     * @param c carácter a poner en la posición.
     */
    public void setCelda(int i, int j, char c) {
        int tamanho = getSize();
        if ((i < tamanho) && (j < tamanho)) {
            celdas[i][j] = c;
        }
    }

    /**
     * Asigna las celdas al sudoku. Si el array de celdas no es cuadrado
     * perfecto de dimensiones posibles lanza una excepción (de tipo Exception)
     * con el mensaje de "Tamaño de sudoku no válido".
     *
     * @param celdas celdas del sudoku.
     * @throws Exception cuando el tamaño no es válido.
     */
    public final void setCeldas(char[][] celdas) throws Exception {
        this.alfabeto = getAlfabeto(celdas); // No se pide
        if (alfabeto.isEmpty() || isSquare(celdas) == NO_SQUARE_SIZE) {
            throw new Exception(NO_VALID_SIZE_MESSAGE);
        }
        this.celdas = celdas;
    }

    /**
     * Recoge las coordenadas y devuelve el carácter que está en esa posición.
     * Debe comprobar que no excede los límites del Sudoku, en cuyo caso debe
     * devolver 0.
     *
     * @param i índice de fila.
     * @param j índice de columna.
     * @return carácter que está en esa posición o CARACTER_NULO.
     * @see #CARACTER_NULO
     */
    public char getCelda(int i, int j) {
        int tamanho = getSize();
        return ( celdas!=null && (i < tamanho) && (j < tamanho))
                ? celdas[i][j] : CARACTER_NULO;
    }

    /**
     * Devuelve si el Sudoku tiene todas las celdas ocupadas.
     *
     * @return si ninguna fila tiene el valor CARACTER_NULO o CARACTER_LIBRE
     * @see #CARACTER_NULO
     * @see #CARACTER_LIBRE
     */
    public boolean isCompleted() {
        if (celdas != null) {
            int tamanho = getSize();
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    if (celdas[i][j] == CARACTER_NULO
                            || celdas[i][j] == CARACTER_LIBRE) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Devuelve verdadero y el Sudoku no tiene valores repetidos en filas,
     * columnas y bloques. Se realiza comprobando primero las filas, luego las
     * columnas y finalmente los bloques.
     *
     * @return verdadero si no tiene valores repetidos en filas, columnas o
     * bloques.
     */
    public boolean isValid() {
        // SI no es cuadreado devuelve false (nunca lo será)
        if (isSquare(celdas) == NO_SQUARE_SIZE) {
            return false;
        }

        // Recorrido por filas para comprobación.
        HashSet<Character> elementos = new HashSet<>(); // elementos de la fila.
        for (char[] fila : celdas) {
            for (char c : fila) {
                if (c != CARACTER_NULO
                        && c != CARACTER_LIBRE && !elementos.add(c)) { // Si ya lo contiene devuelve "false" el método "add"
                    System.out.println("Ya con tiene el carácter: " + c);
                    return false;
                }
            }
            elementos.clear(); // Cambio de fila.
        }

        // Recorrido por columnas:
        for (int j = 0; j < celdas[0].length; j++) {
            for (char[] fila : celdas) {
                char c = fila[j];
                if (c != CARACTER_NULO
                        && c != CARACTER_LIBRE && !elementos.add(c)) { // Si ya lo contiene devuelve "false" el método "add"
                    System.out.println("La columna " + j
                            + " ya tiene el carácter: " + c);
                    return false;
                }
            }
            elementos.clear(); // Cambio de columna.
        }

        // Bloques
        // número de bloques por fil y columna es la raíz cuadrada del tamaño.
        int tamanho = (int) Math.sqrt(getSize());

        // iBloque y jBloque son los índices de bloque. Para un 9x9 van de 0..2
        for (int iBloque = 0; iBloque < tamanho; iBloque++) {
            for (int jBloque = 0; jBloque < tamanho; jBloque++) {
                int filaInicio = iBloque * tamanho;
                int columnaInicio = jBloque * tamanho;
                // Se recorre el bloque iBloque, jBloque
                for (int i = filaInicio; i < filaInicio + tamanho; i++) {
                    for (int j = columnaInicio; j < columnaInicio + tamanho; j++) {
                        if (celdas[i][j] != CARACTER_NULO
                                && celdas[i][j] != CARACTER_LIBRE
                                && !elementos.add(celdas[i][j])) { // Si ya lo contiene devuelve "false" el método "add"
                            return false;
                        }
                    }
                }
                elementos.clear(); // Cambio de bloque y limpiamos el conjunto de elementos
            }
        }
        return true;
    }

    /**
     * Devuelve las coordenadas de la primera celda vacía, aquella con el
     * carácter 0.
     *
     * @return Coordenadas de la siguiente posición vacía o null si no hay
     * ninguna
     * @see #CARACTER_NULO
     * @see #CARACTER_LIBRE
     */
    public Point getNextVoidCell() {
        if (isSquare(celdas) == NO_SQUARE_SIZE) {
            return null;
        }
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                if (celdas[i][j] == CARACTER_NULO
                        || celdas[i][j] == CARACTER_LIBRE) {
//                    System.out.println("Próxima libre = " + i + ", " + j);
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    /**
     * Devuelve una lista de Sudoku válidos a partir de la siguiente celda
     * vacía.
     *
     * @return @throws Exception
     */
    public List<Sudoku> getChildren() throws Exception {
        
        Point p = getNextVoidCell(); // Coordenadas de la siguiente celda vacía.
        if(p==null)
            return null;
        
        List<Sudoku> sudokus = new ArrayList<>();
        int fila = p.x;
        int columna = p.y;

        // Se crea una conjunto copia con el alfabeto,
        // y se van aliminado los valores que ya están en el bloque, fila y columna:
//        Set<Character> caracteresPosiblesHijos = Set.copyOf(alfabeto);
        Set<Character> caracteresPosiblesHijos = new HashSet<>(alfabeto);
        // Borro los que están en esa fila:
        for (int j = 0; j < celdas[fila].length; j++) {
            if (celdas[fila][j] != CARACTER_NULO && celdas[fila][j] != CARACTER_LIBRE) {
                caracteresPosiblesHijos.remove(celdas[fila][j]);
            }
        }
        // Se borra los que están en esa columna.
        for (int i = 0; i < celdas[columna].length; i++) {
            if (celdas[i][columna] != CARACTER_NULO && celdas[i][columna] != CARACTER_LIBRE) {
                caracteresPosiblesHijos.remove(celdas[i][columna]);
            }
        }

        int tamanho = (int) Math.sqrt(getSize());
        int iBloque = (fila / tamanho) * tamanho, // indice inicial fila bloque
                jBloque = (columna / tamanho) * tamanho; // indice inicial columna bloque
        for (int i = iBloque; i < iBloque + tamanho; i++) {
            for (int j = jBloque; j < jBloque + tamanho; j++) {
                if (celdas[i][j] != CARACTER_NULO && celdas[i][j] != CARACTER_LIBRE) {
                    caracteresPosiblesHijos.remove(celdas[i][j]);
                }
            }
        }

//        System.out.println("hijos = " + caracteresPosiblesHijos);
        for (Character hijo : caracteresPosiblesHijos) {
            // Hay que clonarr el array, para no trabajar en el array original y hacer cambios en él:
            Sudoku sudoku = new Sudoku(clonarArrayCeldas());
            sudoku.setAlfabeto(alfabeto); // El alfabrerto es el mismo.
            sudoku.setCelda(fila, columna, hijo);
            sudokus.add(sudoku);
        }

        // Cömo copiar conjuntos:
        // https://www.baeldung.com/java-copy-sets
        // https://www.baeldung.com/java-difference-between-sets
//        Set<Character> caracteresPosiblesHijos
//                = alfabeto.stream().filter(e -> !eFila.contains(e)).collect(Collectors.toSet());
//        caracteresPosiblesHijos = caracteresPosiblesHijos.stream().filter(e -> !eColumna.contains(e)).collect(Collectors.toSet());
//        caracteresPosiblesHijos = caracteresPosiblesHijos.stream().filter(e -> !eBloque.contains(e)).collect(Collectors.toSet());
        return sudokus;
    }


     /**
     * Método que guarda un sudoku de un fichero binario como objeto.
     * ObjectOutputStream es una clase que crea un flujo de salida para escribir
     * objetos en un flujo, en este caso un archivo.
     *
     * @param ruta ruta al fichero binario.
     * @return si ha podido guardar el objeto
     * @see #loadSudoku(String)
     */
    public boolean saveSudoku(String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(ruta)));) {
            oos.writeObject(this);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

//
    /**
     * Muestra la representación visual del Sudoku. En la primera línea muestra
     * el alfabeto. Por ejemplo:
     * <pre>
     * Alfabeto {1, 2, 3, 4, 5, 6, 7, 8, 9}
     * =========================
     * 513876492
     * 789243651
     * 246915783
     * 328654917
     * 974182536
     * 165397248
     * 697438125
     * 851729364
     * 432561879
     * </pre>
     *
     * @return representación del Sudoku como cadea.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(alfabeto.toString());
        sb.append(System.lineSeparator());
        sb.append("=========================\n");
        for (char[] fila : celdas) {
            for (char celda : fila) {
                sb.append(celda);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    /*
    ===========================================================================
    Los siguientes métodos no se piden, pero pueden ayudaros a entender conceptos.
    ===========================================================================
     */
    /**
     * No se pide: devuelve el alfabeto. Método get de alfabeto.
     *
     * @return alfabeto del sudoku.
     */
    public Set<Character> getAlfabeto() {
        return alfabeto;
    }
    
    /**
     * Método set del alfabeto pero que hace una copia. No se pide.
     * @param alfabeto 
     */
    private void setAlfabeto(Set<Character> alfabeto) {
        this.alfabeto = new HashSet<>(alfabeto);
    }

    /**
     * Método que escribe un sudoku de un fichero binario como objeto.
     * ObjectInputStream es una clase que crea un flujo de entrada para leer
     * objetos de un flujo, en este caso un archivo.
     *
     * @param ruta ruta al fichero binario.
     * @return Sudoku guardado en el archivo binario
     * @see #saveSudoku(String)
     */
    public Sudoku loadSudoku(String ruta) {
        Sudoku sudo = null;
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(ruta)));) {
            sudo = (Sudoku) ois.readObject();
        } catch (Exception e) {
            System.out.println("Erro ó leer o sudoku: " + e.getMessage());
        }
        return sudo;
    }

    /**
     * Método que lee un sudoku de un fichero de texto. BufferedReader es una
     * clase que crea un flujo de entrada con buffer para leer caracteres de un
     * flujo, en este caso un archivo binario.
     *
     * @param ruta ruta al fichero de texto.
     * @return Sudoku guardado en el archivo de texto.
     * @throws Exception
     */
    public static Sudoku loadSudokuFromTXT(String ruta) throws Exception {
        int fila = 0;
        char[][] celas = null;
        try (BufferedReader br
                = new BufferedReader(new FileReader(ruta));) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (fila == 0) {
                    celas = new char[linha.length()][linha.length()];
                }
                celas[fila++] = linha.toCharArray();
            }

        } catch (Exception e) {
            System.out.println("Erro ó leer o sudoku: " + e.getMessage());
        }
        return new Sudoku(celas);
    }


    /**
     * Si la celda está vacía (no se pide ni se usa). Este método indica si la
     * celda tiene un carácter nulo o libre.
     *
     * @param i índice de fila
     * @param j índice de columna
     * @return si la celdas está vacía.
     */
    public boolean isEmpty(int i, int j) {
        int tamanho = getSize();
        return celdas != null
                && (i < tamanho) && (j < tamanho)
                && celdas[i][j] == CARACTER_NULO
                && celdas[i][j] == CARACTER_LIBRE;

    }

    /**
     * Devuelve el siguiente índice a un índice recogido como argumento (no se
     * pide ni se usa). Cambio de fila si es la última columna.
     *
     * @param i índice de fila.
     * @param j índice de columna.
     * @return Coordenadas del siguiente índice.
     */
    public Point getNextIndex(int i, int j) {
        int tamanho = getSize();
        if (j < tamanho - 1) {
            return new Point(i, j + 1);
        } else if (i < tamanho - 1) {
            return new Point(i + 1, 0);
        }
        return null;
    }

    /**
     * Devuelve el conjunto de elementos no nulos ni libres de la fila.
     *
     * @param i índice de fila
     * @return conjunto de elementos no nulos de la fila
     */
    public Set<Character> getElementosFila(int i) {
        Set<Character> caracteres = new HashSet<>();
        for (int j = 0; j < celdas[i].length; j++) {
            if (celdas[i][j] != CARACTER_NULO && celdas[i][j] != CARACTER_LIBRE) {
                caracteres.add(celdas[i][j]);
            }
        }
        System.out.println("caracteres Fila " + i + "= " + caracteres);
        return caracteres;
    }

    /**
     * Devuelve el conjunto de elementos no nulos ni libres de la columna.
     *
     * @param j índice de la columna
     * @return conjunto de elementos no nulos de la columna
     */
    public Set<Character> getElementosColumna(int j) {
        Set<Character> caracteres = new HashSet<>();
        for (char[] celda : celdas) {
            if (celda[j] != CARACTER_NULO && celda[j] != CARACTER_LIBRE) {
                caracteres.add(celda[j]);
            }
        }
        System.out.println("caracteres Columna " + j + "= " + caracteres);
        return caracteres;
    }

    /**
     * Devuelve el conjunto de elementos del bloque con valores no vacíos.
     *
     * @param fila índice del bloque
     * @param columna índice de la columna
     * @return conjunto de elementos no nulos de la columna
     */
    public Set<Character> getElementosBloque(int fila, int columna) {
        Set<Character> caracteres = new HashSet<>();
        // tamaño de cada bloque, usualmente 3.
        int tamanho = (int) Math.sqrt(getSize());
        int iBloque = (fila / tamanho) * tamanho, // indice inicial fila bloque
                jBloque = (columna / tamanho) * tamanho; // indice inicial columna bloque
        for (int i = iBloque; i < iBloque + tamanho; i++) {
            for (int j = jBloque; j < jBloque + tamanho; j++) {
                if (celdas[i][j] != CARACTER_NULO && celdas[i][j] != CARACTER_LIBRE) {
                    caracteres.add(celdas[i][j]);
                }
            }
        }
        System.out.println("caracteres bloque = " + caracteres);
        return caracteres;
    }

}
