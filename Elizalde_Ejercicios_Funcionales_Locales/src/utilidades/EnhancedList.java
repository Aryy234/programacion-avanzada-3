package utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Clase que extiende la funcionalidad de una lista estándar de Java
 * añadiendo operaciones funcionales.
 * @param <T> Tipo de los elementos en la lista
 */
public class EnhancedList<T> {
    private final List<T> list;
    
    public EnhancedList(List<T> list) {
        this.list = new ArrayList<>(list);
    }
    
    /**
     * Combina esta lista con otra lista, creando una lista de tuplas.
     * @param <U> Tipo de los elementos de la otra lista
     * @param other La otra lista a combinar
     * @return Una nueva EnhancedList que contiene tuplas de elementos de ambas listas
     */
    public <U> EnhancedList<Tuple<T, U>> zip(List<U> other) {
        List<Tuple<T, U>> result = new ArrayList<>();
        int minSize = Math.min(list.size(), other.size());
        
        for (int i = 0; i < minSize; i++) {
            result.add(new Tuple<>(list.get(i), other.get(i)));
        }
        
        return new EnhancedList<>(result);
    }
    
    /**
     * Encuentra el primer elemento que satisface un predicado.
     * @param predicate El predicado a evaluar
     * @return Un Result que contiene el primer elemento que satisface el predicado
     */
    public Result<T> first(Predicate<T> predicate) {
        for (T item : list) {
            if (predicate.test(item)) {
                return new Result<>(item);
            }
        }
        
        // Si no se encuentra ningún elemento, se podría manejar de diferentes formas.
        // Por simplicidad, en este caso retornamos null, pero en una implementación real
        // sería mejor usar Optional o algún mecanismo similar.
        return null;
    }
    
    /**
     * Encuentra el primer elemento para el cual la función devuelve true.
     * @param function La función a evaluar que retorna un booleano
     * @return Un Result que contiene el primer elemento para el cual la función devuelve true
     */
    public Result<T> first(Function<T, Boolean> function) {
        for (T item : list) {
            if (function.apply(item)) {
                return new Result<>(item);
            }
        }
        
        // Si no se encuentra ningún elemento, se podría manejar de diferentes formas.
        // Por simplicidad, en este caso retornamos null, pero en una implementación real
        // sería mejor usar Optional o algún mecanismo similar.
        return null;
    }
    
    /**
     * Aplica una función a cada elemento y aplana los resultados en una sola lista.
     * @param <R> Tipo de los elementos resultantes
     * @param mapper La función a aplicar
     * @return Una nueva EnhancedList con los resultados
     */
    public <R> Result<R> flatMap(Function<List<T>, Result<R>> mapper) {
        return mapper.apply(list);
    }
    
    /**
     * Método utilitario para convertir una List estándar a EnhancedList
     */
    public static <T> EnhancedList<T> of(List<T> list) {
        return new EnhancedList<>(list);
    }
    
    /**
     * Acceso a la lista interna
     */
    public List<T> getList() {
        return new ArrayList<>(list);
    }
}
