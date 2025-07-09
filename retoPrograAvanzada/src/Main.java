public class Main {
    public static void main(String[] args) {
        int w = 7;
        int h = 16;
        double probabilidad = 0.25; // Ajusta la probabilidad según lo desees
        boolean[][] tablero = Buscaminas.generarTablero.apply(w, h, probabilidad);
        String[][] numeros = Buscaminas.calcularNumeros.apply(tablero);
        System.out.println("Tablero de minas:");
        Buscaminas.imprimirTableroMinas.apply(tablero);
        System.out.println("\nTablero de números:");
        Buscaminas.imprimirTableroNumeros.apply(numeros);
    }
}