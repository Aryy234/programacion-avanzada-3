package service;

import utils.Funcion;
import utils.Lista;

public class Mathe {

    public static Funcion<Integer, Integer> factorial;
    public static Funcion<Integer, Integer> fibonacci;

    /*
     * Mas funciones matematicas a implementar:
     * 
     * - Recursivas: 
     *   - Potencia
     *   - Suma Naturales
     *   - Producto Naturales
     * 
     * - Combinatorias:
     *   - Combinaciones
     *   - Permutaciones
     */

    public static Funcion<Integer, Funcion<Integer, Integer>> potencia;
    public static Funcion<Integer, Integer> sumCuadradoNaturales;
    public static Funcion<Lista<Integer>, Lista<Integer>> getNumPrimos;
    public static Funcion<Integer, Integer> raizCuadrada;
    public static Funcion<Integer, Boolean> esPrimo;
    public static Funcion<Lista<Integer>, Lista<Integer>> factLista;

    static {
        factorial = n -> n == 0 ? 1 : n * factorial.apply(n - 1);
    }

    static {
        fibonacci = n -> 
        n == 0 ? 0 : 
        (n == 1 ? 1 : 
        fibonacci.apply(n - 1) + fibonacci.apply(n - 2));
    }

    //Forma iterativa
/*    static {
        potencia = n -> m -> {
           int p =1;
           int aux =0;
           while (aux < m){
               aux++;
               p *= n;
           }

          return p;
        };
    }
 */
    static{
        potencia = n -> m -> {
            // tener en cuenta que m es cuantas veces vas a mult n,
            // y el -1 es para ir reduciendo hasta el 0;
            return m == 0 ? 1: n * potencia.apply(n).apply(m - 1);
        };
    }

    /*
1. Suma de los cuadrados de los primeros N números naturales
Problema: Calcula la suma de los cuadrados de los primeros N números naturales (1² + 2² + ... + N²)
usando funciones y listas.
     */

    static{
        sumCuadradoNaturales = n -> {
          return n == 0 ? 0: n*n + sumCuadradoNaturales.apply(n-1);
        };
    }
    /*
    2. Realizar la raiz cuadrada
     */

    static {
        raizCuadrada = n -> {
            if(n<0) throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo");
            if(n == 0 || n==1) return 0;
            int x = n;
            int y = (x+n/x)/2;
            while (y < x) {
                x = y;
                y = (x + n/x) / 2;
            }
            return x;
        };
    }

    /*
3. Filtrar números primos en una lista
Problema: Dada una lista de enteros, utiliza una función para filtrar y obtener solo los números primos.
     */

    static {
        esPrimo = n -> {
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
    }

    static {
        getNumPrimos = lista ->
                lista.fold(Lista.<Integer>empty(), (Lista<Integer> accu) -> (Integer elem) -> esPrimo.apply(elem) ? accu.append(elem) : accu);
    }

    static {
        factLista = lista -> {
          return lista.fold(Lista.<Integer>empty(), accu -> elem -> accu.append(factorial.apply(elem)));
        };

    }

}
