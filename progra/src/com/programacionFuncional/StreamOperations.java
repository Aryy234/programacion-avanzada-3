package com.programacionFuncional;

import java.util.List;

public class StreamOperations {

    /**
     * Multiplica cada elemento de una lista por 2
     */
    public static List<Integer> multiplyListByTwo(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * 2)
                .toList();
    }

    /**
     * Filtra los números mayores a 5 de una lista
     */
    public static List<Integer> filterNumbersGreaterThanFive(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 5)
                .toList();
    }

    /**
     * Muestra ejemplos de operaciones básicas con streams
     */
    public static void demonstrateBasicStreamOperations() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> multipliedNumbers = multiplyListByTwo(numbers);
        List<Integer> filteredNumbers = filterNumbersGreaterThanFive(multipliedNumbers);

        System.out.println("Original List: " + numbers);
        System.out.println("Multiplied List: " + multipliedNumbers);
        System.out.println("Filtered List: " + filteredNumbers);
    }
}
