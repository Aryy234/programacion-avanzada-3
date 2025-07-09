package com.programacionFuncional;

import java.util.function.Function;

public class PureFunctionsExamples {

    // Función pura que recibe un parámetro y devuelve otra función (Currying)
    //Funcion que reciba 3 parametros
    // y cumpla las condiciones anteriores: No tenga efectos secundarios sea transparencia referencial y pura
    // (definida como funcion que solo recibe un parametro)
    public static Function<Integer, Function<Integer, Function<Integer, Integer>>> addThreeNumbers() {
        return a -> b -> c -> (a + b) / c;
    }

    // Funciones puras para operaciones matemáticas
    public static Function<Integer, Integer> sum() {
        return x -> x + 3;
    }
    public static Function<Integer, Integer> mult() {
        return y -> y * 3;
    }


    // Composición de funciones utilizando `compose` y `andThen`
    public static Function<Integer, Integer> composedFunction() {
        return sum().compose(mult()); // Primero multiplica y luego suma
    }
    public static Function<Integer, Integer> andThenFunction() {
        return sum().andThen(mult()); // Primero suma y luego multiplica
    }

    // Metodo para demostrar el uso de estas funciones en Main
    public static void demonstratePureFunctions() {
        int a = 6, b = 10, c = 2;

        // Aplicando la función pura `addThreeNumbers`
        int result = addThreeNumbers().apply(a).apply(b).apply(c);
        System.out.println("El resultado de la operación matemática es: " + result);

        // Aplicando funciones compuestas
        int resultComp = composedFunction().apply(5);
        System.out.println("Resultado de compose: " + resultComp);

        resultComp = andThenFunction().apply(5);
        System.out.println("Resultado de andThen: " + resultComp);
    }
}