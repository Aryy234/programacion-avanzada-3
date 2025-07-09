package utilidades;


public interface Function <T, U> {
    U apply(T t);
    // Composición de funciones    

    static <T, U, V> Function<T, V>
     compose(
            Function<T, U> f,
            Function<U, V> g) {
        return t -> g.apply(f.apply(t));
    }

    static <T, U, V> Function<T, V>
    andThen(
            Function<T, U> g,
            Function<U, V> f) {
        return t -> f.apply(g.apply(t));
    }
}

//5 ejerciciso comopose y and then utilizando las funciones FunctionPolimorfica
//enteros a reales
//string a enteros
