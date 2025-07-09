package com.programacionFuncional;

import java.util.function.Function;

public class HigherOrderFunctions {

    /**
     * Devuelve una función que suma dos enteros mediante currificación
     * Ejemplo de función de orden superior y ejecución perezosa
     */
    public static Function<Integer, Function<Integer, Integer>>
    getSumFunction() {
        return x -> y -> x + y;
    }

    /**
     * Demuestra el uso de funciones de orden superior con currificación
     */
    public static void demonstrateHigherOrderFunctions() {
        // Sumar dos números (x, y) mediante Function con currificación
        Function<Integer, Function<Integer, Integer>> sum = getSumFunction();
        int resultSum = sum.apply(5).apply(3);
        System.out.println("Sum of 5 and 3: " + resultSum);

        // Ejemplo adicional: crear una función de suma parcialmente aplicada
        Function<Integer, Integer> addFive = getSumFunction().apply(5);
        System.out.println("5 + 7 = " + addFive.apply(7));
        System.out.println("5 + 10 = " + addFive.apply(10));
    }
}
