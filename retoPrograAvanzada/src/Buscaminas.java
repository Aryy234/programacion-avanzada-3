import java.util.Random;
import java.util.function.Function;

public class Buscaminas {
    // Genera un tablero de minas aleatorio usando BiFunction
    public static final TriFunction<Integer, Integer, Double, boolean[][]> generarTablero = (w, h, probabilidad) -> {
        boolean[][] tablero = new boolean[h][w];
        Random rand = new Random();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                tablero[i][j] = rand.nextDouble() < probabilidad;
            }
        }
        return tablero;
    };

    // Calcula la matriz de números de minas adyacentes usando Function
    public static final Function<boolean[][], String[][]> calcularNumeros = (tablero) -> {
        int h = tablero.length;
        int w = tablero[0].length;
        String[][] numeros = new String[h][w];
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (tablero[i][j]) {
                    numeros[i][j] = "B";
                } else {
                    int cuenta = 0;
                    for (int d = 0; d < 8; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni >= 0 && ni < h && nj >= 0 && nj < w && tablero[ni][nj]) {
                            cuenta++;
                        }
                    }
                    numeros[i][j] = Integer.toString(cuenta);
                }
            }
        }
        return numeros;
    };

    // Imprime el tablero de minas usando Function
    public static final Function<boolean[][], Void> imprimirTableroMinas = (tablero) -> {
        for (boolean[] fila : tablero) {
            for (boolean celda : fila) {
                System.out.print(celda ? "* " : ". ");
            }
            System.out.println();
        }
        return null;
    };

    // Imprime el tablero de números usando Function
    public static final Function<String[][], Void> imprimirTableroNumeros = (numeros) -> {
        for (String[] fila : numeros) {
            for (String celda : fila) {
                System.out.print((celda.equals("B") ? "B " : celda + " "));
            }
            System.out.println();
        }
        return null;
    };

    // Interfaz funcional para tres argumentos
    @FunctionalInterface
    public interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }
}
