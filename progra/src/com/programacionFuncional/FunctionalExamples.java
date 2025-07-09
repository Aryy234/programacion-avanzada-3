package com.programacionFuncional;

import java.util.List;
import java.util.function.Function;

public class FunctionalExamples {

    /**
     * Ejemplo de Function que procesa una lista, multiplicando cada elemento por 2
     * y filtrando valores mayores que 5
     */
    public static Function<List<Integer>, List<Integer>> getProcessNumbersFunction() {
        return list -> list.stream()
                .map(number -> number * 2)
                .filter(number -> number > 5)
                .toList();
    }

    /**
     * Devuelve una función que multiplica un número por 2
     */
    public static Function<Integer, Integer> getMultiplyByTwoFunction() {
        return number -> number * 2;
    }

    /**
     * Ejemplo que demuestra el uso de funciones como valores de primera clase
     */
    public static void demonstrateFunctionAsValues() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Utilizando una función predefinida para procesar números
        Function<List<Integer>, List<Integer>> processNumbers = getProcessNumbersFunction();
        List<Integer> processedNumbers = processNumbers.apply(numbers);
        System.out.println("Processed numbers: " + processedNumbers);

        // Utilizando función declarativa para multiplicar
        Function<Integer, Integer> multiplyByTwo = getMultiplyByTwoFunction();
        System.out.println("Using predefined function:");
        numbers.stream()
                .map(multiplyByTwo)
                .filter(number -> number > 5)
                .forEach(System.out::println);
    }
}
