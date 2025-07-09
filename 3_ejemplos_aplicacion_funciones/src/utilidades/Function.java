package utilidades;

public interface Function <T,U>{
    U apply(T t);

    static <T, U, V> Function<T, V>
    compose(Function<U,V> f,
            Function<T,U> g) {
        return t -> f.apply(g.apply(t));
    }

    static <T,U,V> Function<T,V>
    andThen(Function<T,U> f,
            Function<U,V> g) {
        return t -> g.apply(f.apply(t));
    }
}
