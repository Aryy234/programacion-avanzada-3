import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Lista de ejemplo mencionada en el problema
        List<Integer> listaOriginal = Arrays.asList(12, 10, 16, 11, 9, 7);
        
        System.out.println("Lista original: " + listaOriginal);
        
        // Aplicar insertionSort funcional y recursivo con Function
        Function<List<Integer>, List<Integer>> insertionSortFunc = Main::insertionSortRecursivo;
        List<Integer> listaOrdenada = insertionSortFunc.apply(listaOriginal);
        
        System.out.println("Lista ordenada: " + listaOrdenada);
    }
    
    /**
     * Método auxiliar para iniciar el proceso de ordenamiento
     * @param lista La lista a ordenar
     * @return Una nueva lista ordenada
     */
    private static List<Integer> insertionSortRecursivo(List<Integer> lista) {
        return ordenarLista(lista);
    }
    
    /**
     * Implementación recursiva del algoritmo Insertion Sort
     * @param lista La lista a ordenar
     * @return Una nueva lista ordenada
     */
    private static List<Integer> ordenarLista(List<Integer> lista) {
        // Caso base: una lista vacía o con un solo elemento ya está ordenada
        if (lista.size() <= 1) {
            return lista;
        }
        
        // Obtener el primer elemento y ordenar el resto
        int primerElemento = lista.get(0);
        List<Integer> resto = lista.subList(1, lista.size());
        
        // Ordenar recursivamente el resto
        List<Integer> restoOrdenado = ordenarLista(resto);
        
        // Insertar el primer elemento en la posición correcta
        return insertar(primerElemento, restoOrdenado);
    }
    
    /**
     * Inserta un elemento en la posición correcta de una lista ordenada
     * @param elemento El elemento a insertar
     * @param listaOrdenada La lista ordenada donde insertar el elemento
     * @return Una nueva lista con el elemento insertado en la posición correcta
     */
    private static List<Integer> insertar(int elemento, List<Integer> listaOrdenada) {
        // Utilizando una Function para la operación de inserción
        Function<List<Integer>, List<Integer>> insertarFunc = lista -> {
            if (lista.isEmpty()) {
                return List.of(elemento);
            }
            
            if (elemento <= lista.get(0)) {
                List<Integer> resultado = new ArrayList<>();
                resultado.add(elemento);
                resultado.addAll(lista);
                return resultado;
            }
            
            int primero = lista.get(0);
            List<Integer> resto = lista.subList(1, lista.size());
            List<Integer> resultadoParcial = insertar(elemento, resto);
            
            List<Integer> resultado = new ArrayList<>();
            resultado.add(primero);
            resultado.addAll(resultadoParcial);
            return resultado;
        };
        
        return insertarFunc.apply(listaOrdenada);
    }
}