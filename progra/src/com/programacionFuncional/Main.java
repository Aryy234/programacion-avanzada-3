package com.programacionFuncional;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import com.utils.*;

import com.composicionClases.BinaryOperator;
import com.composicionClases.TernaryOperator;
import com.composicionClases.FunctionPolimorfica;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("EJEMPLOS DE PROGRAMACIÓN FUNCIONAL EN JAVA");
        System.out.println("=========================================\n");

        // 1. Ejemplos de operaciones con Streams
        System.out.println("1. OPERACIONES CON STREAMS");
        System.out.println("-------------------------");
        StreamOperations.demonstrateBasicStreamOperations();
        System.out.println("=========================================");
        System.out.println();

        // 2. Ejemplos de programación funcional
        System.out.println("2. EJEMPLOS DE PROGRAMACIÓN FUNCIONAL");
        System.out.println("-----------------------------------");
        FunctionalExamples.demonstrateFunctionAsValues();
        System.out.println("=========================================");
        System.out.println();

        // 3. Ejemplos de funciones de orden superior
        System.out.println("3. FUNCIONES DE ORDEN SUPERIOR");
        System.out.println("-----------------------------");
        HigherOrderFunctions.demonstrateHigherOrderFunctions();
        System.out.println("=========================================");
        System.out.println();

        // 4. Efectos secundarios
        System.out.println("4. EFECTOS SECUNDARIOS");
        System.out.println("-----------------------------");
        SideEffects.demonstrateSideEffects();
        System.out.println("=========================================");
        System.out.println();

        // 5. TRANSPARENCIA REFERENCIAL Y FUNCIONES PURAS
        System.out.println("5. TRANSPARENCIA REFERENCIAL Y FUNCIONES PURAS");
        System.out.println("--------------------------------------------");
        PureFunctionsExamples.demonstratePureFunctions();
        System.out.println("=========================================");
        System.out.println();

        // 6. FUNCIONES PARCIALES
        System.out.println("6. FUNCIONES PARCIALES");
        System.out.println("-----------------------------");
        PartialFunctions.demonstratePartialFunctions();
        System.out.println("=========================================");
        System.out.println();

        // 7. CURRIFICACIÓN
        System.out.println("7. CURRIFICACIÓN");
        System.out.println("-----------------------------");
        CurriedFunctions.demonstrateCurriedFunctions();
        System.out.println("=========================================");

        // 8. Ejemplos de programación funcional 2
        System.out.println("8. EJEMPLOS DE PROGRAMACIÓN FUNCIONAL 2");
        System.out.println("-----------------------------");
        FunctionalExamples2.demostracion();
        System.out.println("=========================================");

        // 9. Composición de funciones
        System.out.println("9. COMPOSICIÓN DE FUNCIONES");
        System.out.println("-----------------------------");
        FunctionComposition.demonstrateFunctionComposition();
        System.out.println("=========================================");

        // 10. Composición de funciones segunda parte
        System.out.println("10. COMPOSICIÓN DE FUNCIONES SEGUNDA PARTE");
        System.out.println("-----------------------------");
        FunctionComposition2.demonstrateFunctionComposition2();
        System.out.println("=========================================");

        // 11 Interfaces operadores composición de funciones
        System.out.println("11. INTERFACES OPERADORES COMPOSISION DE FUNCIONES");
        System.out.println("-----------------------------");
        BinaryOperator<Integer> binaryOperator = (a) -> (b) -> a + b;
        TernaryOperator<Integer> ternaryOperator = (a) -> (b) -> (c) -> a + b + c;
        System.out.println("BinaryOperator: " + binaryOperator.apply(2).apply(3)); // 5
        System.out.println("TernaryOperator: " + ternaryOperator.apply(2).apply(3).apply(4)); // 9
        System.out.println("=========================================");

        // 12. Composición de funciones tercera parte
        System.out.println("12. COMPOSICIÓN DE FUNCIONES CON INTERFACES");
        System.out.println("-----------------------------");
        // DEfinir dos funciones que representen una operación
        // de suma y multiplicación, y luego componerlas utilizando
        // la interfaz FunctionPolimorfica higherCompose,
        FunctionPolimorfica<Integer, Double> sumFunction = x -> x + 5.3;
        FunctionPolimorfica<Double, Double> multiplyFunction = x -> x / 2;

        // Function<> res =
        // higherCompose().apply(multiplyFunction.apply(sumFunction.apply(10)));
        // System.out.println("Resultado de la composición: " + res); // 7.65

        System.out.println("=========================================");

        // 12. Composición de funciones tercera parte
        System.out.println("13. CARACTERISTICAS FUNCIONES LOCALES");
        System.out.println("-----------------------------");

        List<Integer> datos = List.of(1, 2, 3, 4, 5);
        datos.stream()
                // declaracion de una función local
                .map(x -> x * 3).forEach(System.out::println);

        datos.stream()
                // declaracion de una función locales anonimas
                .reduce(0, (x, y) -> x + y);

        System.out.println("=========================================");

        // 12. Composición de funciones tercera parte
        System.out.println("14. CLOSURES");
        System.out.println("-----------------------------");

        final int[] contador = { 0 }; // Closure

        Runnable intContador = () -> {
            // Incrementa el contador
            contador[0]++;
            System.out.println("Contador: " + contador[0]);

        };

        intContador.run(); // Imprime 0
        intContador.run(); // Imprime 1

        FunctionPolimorfica<Integer, Integer> incrementar = x -> {
            contador[0] += x;
            return contador[0];
        };

        System.out.println(incrementar.apply(5)); // Imprime 5
        System.out.println(incrementar.apply(3)); // Imprime 8
        System.out.println(incrementar.apply(2)); // Imprime 10

        System.out.println("=========================================");

        // 15.
        System.out.println("15. Listas con funciones");
        System.out.println("-----------------------------");
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        // Usando la función add de ListUtils
        List<Integer> numerosConSeis = com.utils.ListUtils.add(numeros, 6);
        System.out.println("Lista original: " + numeros);
        System.out.println("Lista con 6 añadida: " + numerosConSeis);
        // es una lista inmutable, no se puede modificar

        //Utilizando la funcion reverse de ListUtils
        List<Integer> numerosInvertidos = com.utils.ListUtils.invertedL(numeros);
        System.out.println("Lista original: " + numeros);
        System.out.println("Lista invertida: " + numerosInvertidos);



        System.out.println("=========================================");

        System.out.println("16. Lista Stealed");
        System.out.println("-----------------------------");
        System.out.println("=========================================");

        System.out.println("17. Map (Tradicional y Funcional)");
        System.out.println("-----------------------------");
        System.out.println("=========================================");

        System.out.println("18. Reducing/Folding (Tradicional y Funcional)");
        System.out.println("-----------------------------");
        System.out.println("=========================================");




    }

}