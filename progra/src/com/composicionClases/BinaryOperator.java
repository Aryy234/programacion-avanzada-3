package com.composicionClases;
import java.util.function.Function;

public interface BinaryOperator<T> extends Function<T, Function<T,T>>{

	
}


