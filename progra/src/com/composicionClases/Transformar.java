package com.composicionClases;

import java.util.List;
import java.util.function.Function;

public interface Transformar<T, R> {
    // Recibe una lista de objetos de tipo T y devuelve una lista de objetos de tipo R
    List<R> transformar(List<T> lista, Function<T, R> fun);

    
}
