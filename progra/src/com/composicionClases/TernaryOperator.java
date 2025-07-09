package com.composicionClases;
import java.util.function.Function;

////interfaz operador ternario
public interface TernaryOperator<T> extends Function<T, Function<T, Function<T,T>>>{
    
}
