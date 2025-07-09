package com.programacionFuncional;

import java.util.Optional;
import java.util.function.Function;

public class PartialFunctions {

    /**
     * Ejemplo de una función parcial que calcula el inverso de un número
     * No está definida para el valor 0
     */
    public static Function<Integer, Optional<Integer>> getInverseFunction() {
        return x -> {
            if (x == 0)
                return Optional.empty();
            else
                return Optional.of(1 / x);
        };
    }

    /**
     * Función curriada que implementa f(x,y) = (x/100) * (y + 100)
     */
    public static Function<Double, Function<Double, Double>> getCurriedFunction() {
        return a -> b -> (a/100) * (b + 100);
    }

    /**
     * Implementación alternativa de la función f(x,y) = (x/100) * (y + 100)
     * separada en dos partes
     */
    public static Function<Integer, Integer> getFx() {
        return x -> 100 + x;
    }

    public static Function<Integer, Function<Integer, Double>> getFxy() {
        return x -> y -> (x / 100.0) * getFx().apply(y);
    }

    /**
     * Ejemplo de composición de funciones con diferentes tipos
     */
    public static Function<Integer, String> getIntToStringFunction() {
        return c -> "h " + c;
    }

    public static Function<String, Function<Integer, String>> getStringAppender() {
        return c -> d -> c + d;
    }

    /**
     * Demuestra el uso de funciones parciales
     */
    public static void demonstratePartialFunctions() {
        // Ejemplo de función parcial
        Function<Integer, Optional<Integer>> f = getInverseFunction();
        Optional<Integer> result = f.apply(0);
        // isPresent() devuelve true si el valor está presente, false si no lo está
        if (result.isPresent()) {
            System.out.println("Resultado de la función parcial: " + result.get());
        } else {
            System.out.println("La función parcial no está definida para el argumento 0");
        }

        // Primera implementación de f(x,y) = (x/100) * (y + 100)
        Function<Double, Function<Double, Double>> curriedFunction = getCurriedFunction();
        double a = 50.0;
        double b = 20.0;
        double resultCurried = curriedFunction.apply(a).apply(b);
        System.out.println("Resultado de la función curriada: " + resultCurried);

        // Segunda implementación de f(x,y) = (x/100) * (y + 100)
        Function<Integer, Integer> fx = getFx();
        int x = 50;
        int fxResult = fx.apply(x);

        Function<Integer, Function<Integer, Double>> fxy = getFxy();
        int y = 20;
        double resultFxy = fxy.apply(fxResult).apply(y);
        System.out.println("Resultado de la función fxy: " + resultFxy);

        // Función que transforma un tipo int en String
        Function<Integer, String> intToString = getIntToStringFunction();
        Function<String, Function<Integer, String>> j = getStringAppender();
        System.out.println(j.apply(intToString.apply(3)).apply(5));
    }
}