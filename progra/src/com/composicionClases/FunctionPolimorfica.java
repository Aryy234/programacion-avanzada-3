package com.composicionClases;

public interface FunctionPolimorfica <T, U> {
    U apply(T t);
    // Composición de funciones    

    static <T, U, V> FunctionPolimorfica<T, V>
     compose(
            FunctionPolimorfica<T, U> f,
            FunctionPolimorfica<U, V> g) {
        return t -> g.apply(f.apply(t));
    }

    static <T, U, V> FunctionPolimorfica<T, V>
    andThen(
            FunctionPolimorfica<T, U> g,
            FunctionPolimorfica<U, V> f) {
        return t -> f.apply(g.apply(t));
    }

    static <T, U, V> FunctionPolimorfica<
            FunctionPolimorfica<U, V>,
            FunctionPolimorfica<FunctionPolimorfica<T, U>, 
            FunctionPolimorfica<T, V>>> higherCompose() {
        return x -> y -> z -> x.apply(y.apply(z));
    }
}

//5 ejerciciso comopose y and then utilizando las funciones FunctionPolimorfica
//enteros a reales
//string a enteros

