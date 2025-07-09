import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        // Ejemplo de uso de la interfaz Transformar tomado de la clase vista
        List<String> nombres = Arrays.asList("Juan", "Pedro", "Maria", "Ana", "Luis");

        Function<String, String> fList = s -> s.toUpperCase();

        Transformar<String, String> transformar = (lista, func) -> 
            lista.stream().map(func).collect(Collectors.toList());
        
        List<String> nombresMayus = transformar.transformar(nombres, fList);
        System.out.println("Nombres en mayúsculas: " + nombresMayus); // [JUAN, PEDRO, MARIA, ANA, LUIS]
        System.out.println("=========================================");
        System.out.println();
        
        // 1. Lista de números enteros transformada al cubo
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        Function<Integer, Integer> funcionCuadrado = n -> n * n * n;

        Transformar<Integer, Integer> transformarNumeros = 
        (lista, func) -> lista.stream().map(func).collect(Collectors.toList());

        List<Integer> numerosCuadrados = transformarNumeros.transformar(numeros, funcionCuadrado);
        System.out.println("Números al cuadrado: " + numerosCuadrados); // [1, 4, 9, 16, 25]
        System.out.println("=========================================");
        
        // 2. Lista de números double transformada a String
        List<Double> decimales = Arrays.asList(1.0, 4.0, 9.0, 16.0, 25.0);

        Function<Double, String> funcionToString = s -> String.valueOf(s);
        
        Transformar<Double, String> transformarDecimales = (lista, func) -> {
            List<String> resultado = new ArrayList<>();
            for (var d : lista) {
                resultado.add(func.apply(d));
            }
            return resultado;
        };
        List<String> strings = transformarDecimales.transformar(decimales, funcionToString);
        System.out.println("Números como strings: " + strings); // [1.0, 4.0, 9.0, 16.0, 25.0]
        System.out.println("=========================================");
        
        // 3. Lista de booleanos transformada a strings descriptivos
        List<Boolean> condiciones = Arrays.asList(true, false, true, false, true);
        Function<Boolean, String> funcionDescribir = b -> b ? "Verdadero" : "Falso";
        Transformar<Boolean, String> transformarBooleanos = (lista, func) -> {
            List<String> resultado = new ArrayList<>();
            for (var b : lista) {
                resultado.add(func.apply(b));
            }
            return resultado;
        };
        List<String> descripcionesBool = transformarBooleanos.transformar(condiciones, funcionDescribir);
        System.out.println("Descripciones de booleanos: " + descripcionesBool); 
        System.out.println("=========================================");
        
        // 4. Lista de caracteres transformada a su código ASCII
        List<Character> caracteres = Arrays.asList('A', 'B', 'C', 'D', 'E');
        Function<Character, Integer> funcionAscii = c -> (int) c;
        Transformar<Character, Integer> transformarCaracteres = (lista, func) -> {
            List<Integer> resultado = new ArrayList<>();
            for (var c : lista) {
                resultado.add(func.apply(c));
            }
            return resultado;
        };
        List<Integer> codigosAscii = transformarCaracteres.transformar(caracteres, funcionAscii);
        System.out.println("Códigos ASCII: " + codigosAscii); // [65, 66, 67, 68, 69]
        System.out.println("=========================================");
        
        // 5. Lista de palabras transformada a objetos Palabra con información adicional
        List<String> palabras = Arrays.asList("Java", "Programacion", "Interfaz", "Funcional", "Genericos");
        Function<String, Palabra> funcionCrearPalabra = p -> new Palabra(p, p.length(), p.toLowerCase());
        Transformar<String, Palabra> transformarAPalabra = (lista, func) -> {
            List<Palabra> resultado = new ArrayList<>();
            for (var p : lista) {
                resultado.add(func.apply(p));
            }
            return resultado;
        };
        List<Palabra> objetosPalabra = transformarAPalabra.transformar(palabras, funcionCrearPalabra);
        System.out.println("Objetos Palabra: " + objetosPalabra);
        System.out.println("=========================================");
    }
    
    // Clase auxiliar para la quinta transformación
    static class Palabra {
        private final String texto;
        private final int longitud;
        private final String minusculas;
        
        public Palabra(String texto, int longitud, String minusculas) {
            this.texto = texto;
            this.longitud = longitud;
            this.minusculas = minusculas;
        }
        
        @Override
        public String toString() {
            return "Palabra [texto=" + texto + ", longitud=" + longitud + ", minusculas=" + minusculas + "]";
        }
    }
}