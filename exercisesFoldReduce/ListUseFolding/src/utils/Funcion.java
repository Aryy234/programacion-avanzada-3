package utils;

/**
 * Interfaz funcional personalizada para representar una función que acepta un argumento y produce un resultado.
 * Similar a java.util.function.Function, pero implementada para propósitos educativos.
 * 
 * @param <T> el tipo del argumento de entrada
 * @param <U> el tipo del resultado
 */
public interface Funcion<T, U> {
    
    /**
     * Aplica esta función al argumento dado.
     * 
     * @param t el argumento de la función
     * @return el resultado de la función
     */
    U apply(T t);
    
    /**
     * Compone dos funciones de manera que se aplique f(g(x)).
     * Primero se evalúa la función 'inner' (g) y luego se aplica 'outer' (f) al resultado.
     * Equivale a: outer(inner(x))
     * 
     * @param <T> tipo de entrada de la función interna
     * @param <U> tipo intermedio (salida de inner, entrada de outer)
     * @param <V> tipo de salida de la función externa
     * @param outer la función externa (f) que se aplica al resultado
     * @param inner la función interna (g) que se evalúa primero
     * @return una función compuesta que aplica inner y luego outer
     */
    static <T, U, V> Funcion<T, V> compose(
            Funcion<U, V> outer,
            Funcion<T, U> inner) {
        return t -> outer.apply(inner.apply(t));
    }

    /**
     * Evalúa las funciones en orden secuencial: primero 'first', luego 'after'.
     * Equivale a: after(first(x))
     * Es lo opuesto a compose - aquí el orden de los parámetros refleja el orden de ejecución.
     * 
     * @param <T> tipo de entrada de la primera función
     * @param <U> tipo intermedio (salida de first, entrada de after)
     * @param <V> tipo de salida de la función 'after'
     * @param first la función que se aplica primero
     * @param after la función que se aplica después del resultado de 'first'
     * @return una función compuesta que aplica first y luego after
     */
    static <T, U, V> Funcion<T, V> andThen(
            Funcion<T, U> first,
            Funcion<U, V> after) {
        return t -> after.apply(first.apply(t));
    }

    /**
     * Composición de funciones de orden superior.
     * Retorna una función que toma una función f y retorna otra función que 
     * toma una función g y retorna una tercera función que aplica la composición f(g(x)).
     * 
     * Esto permite un estilo de programación más funcional donde se pueden
     * componer funciones de manera curried.
     * 
     * Uso: composeHigherOrder().apply(f).apply(g).apply(x) === f(g(x))
     * 
     * @param <T> tipo de entrada de la función más interna
     * @param <U> tipo intermedio
     * @param <V> tipo de salida final
     * @return una función de orden superior para composición curried
     */
    static <T, U, V> Funcion<
            Funcion<U, V>,
                Funcion<Funcion<T, U>,
                    Funcion<T, V>>> composeHigherOrder() {
        return outer -> inner -> input -> outer.apply(inner.apply(input));
    }
}