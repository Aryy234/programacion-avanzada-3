package com.programacionFuncional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.composicionClases.Transformar;

public class CurriedFunctions {

    /**
     * Función curriada que implementa f(x,y,z,w) = (x + y/5) * (z - 50) + w
     */
    public static Function<Integer, 
        Function<Integer, 
        Function<Integer, 
        Function<Integer, Double>>>> 
        getCurriedFunction() {
        return x -> y -> z -> w -> (x + y / 5.0) * (z - 50.0) + w;
    }

    /**
     * Función curriada que implementa f(x,y) = (x + y/5) * ((z - 50) + w) pero separada en 3 pasos
     */
    public static Function<Integer, Function<Integer, Double>>
    getFirstCurrFunction() {
        return x -> y -> (x + y / 5.0);
    }
    
    public static Function<Integer, Function<Integer, Double>>
    getSecondCurrFunction() {
        return z -> w -> (z - 50.0) + w;
    }
    
    public static Function<Double, Function<Double, Double>>
    getFinalCurrFunction() {
        return x -> y -> x * y;
    }

    /**
     * Función de orden superior que compone tres funciones
     */
    public static 
    
    Function<Function<Integer, Integer>, 
    Function<Function<Integer, Integer>, 
    Function<Function<Integer, Integer>, 
    Function<Integer, Integer>>>> 
    getCompositionFunction() {
        return a -> b -> c -> d -> a.apply(b.apply(c.apply(d)));
    }

    /**
     * Función para manipular cadenas mediante composición curriada
     */
    public static Function<Function<String, String>,
    Function<Function<String, String>,
    Function<Function<String, String>,
    Function<String, String>>>> 
    getStringCompositionFunction() {
        return a -> b -> c -> s -> a.apply(b.apply(c.apply(s)));
    }

    /**
     * Función para manipular enteros mediante composición curriada
     */
    public static Function<Function<Integer, Integer>,
    Function<Function<Integer, Integer>,
    Function<Function<Integer, Integer>,
    Function<Integer, Integer>>>>
    getIntegerCompositionFunction() {
        return a -> b -> c -> d -> a.apply(b.apply(c.apply(d)));
    }

    /**
     * Demuestra la transformación de listas usando funciones de orden superior
     */
    public static void demonstrateListTransformation() {
        System.out.println("7.8 Transformación de Listas:");
        
        // Ejemplos adicionales con transformación de listas
        List<String> nombres = Arrays.asList("Juan", "Pedro", "Maria", "Ana", "Luis");
        Function<String, String> fList = s -> s.toUpperCase();
        
        Transformar<String, String> transformar = (lista, func) -> {
            // Aplicar la función a cada elemento de la lista
            List<String> aux = new ArrayList<String>();
            for (var item : lista) {
                aux.add(func.apply(item));
            }
            return aux;
        };
        
        List<String> nombresMayus = transformar.transformar(nombres, fList);
        System.out.println("Nombres en mayúsculas: " + nombresMayus); // [JUAN, PEDRO, MARIA, ANA, LUIS]
        
        // Ejemplo adicional: Transformación con múltiples funciones
        System.out.println("\n7.9 Transformación con múltiples funciones:");
        
        Function<String, String> removerVocales = s -> s.replaceAll("[AEIOUaeiou]", "");
        Function<String, String> concatenar = s -> s + "_transformado";
        
        // Transformación en cadena usando composición de funciones
        Transformar<String, String> transformarCompuesto = (lista, func) -> {
            List<String> resultado = new ArrayList<>();
            for (var item : lista) {
                resultado.add(func.apply(item));
            }
            return resultado;
        };
        
        // Componer las funciones
        Function<String, String> funcionCompuesta = fList.andThen(removerVocales).andThen(concatenar);
        List<String> resultadoCompuesto = transformarCompuesto.transformar(nombres, funcionCompuesta);
        
        System.out.println("Transformación compuesta: " + resultadoCompuesto);
    }

    /**
     * Demuestra el uso de currificación en Java
     */
    public static void demonstrateCurriedFunctions() {
        System.out.println("7.1 Función curriada con 4 parámetros:");
        
        // 1. Función curriada con 4 parámetros
        Function<Integer, 
        Function<Integer, 
        Function<Integer, 
        Function<Integer, Double>>>> 
        curriedFunction = getCurriedFunction();
        
        double result = curriedFunction.apply(10).apply(20).apply(30).apply(40);
        System.out.println("Resultado de la función curriada: " + result);
        
        // 2. Función curriada separada en pasos
        System.out.println("\n7.2 Función curriada separada en pasos:");
        
        Function<Integer, Function<Integer, Double>> firstCurrFunction = getFirstCurrFunction();
        Function<Integer, Function<Integer, Double>> secondCurrFunction = getSecondCurrFunction();
        Function<Double, Function<Double, Double>> finalCurrFunction = getFinalCurrFunction();
        
        Double result2 = finalCurrFunction.apply(firstCurrFunction.apply(10).apply(20))
                        .apply(secondCurrFunction.apply(30).apply(40));
        System.out.println("Resultado de la función curriada separada: " + result2);
        
        // 3. Composición de funciones con orden superior
        System.out.println("\n7.3 Composición de funciones con orden superior:");
        
        Function<Function<Integer, Integer>, 
        Function<Function<Integer, Integer>, 
        Function<Function<Integer, Integer>, 
        Function<Integer, Integer>>>> pares = getCompositionFunction();
        
        Function<Integer, Integer> abcd = pares.apply(x -> x*x).apply(x -> 3*x).apply(x -> 2*x);
        System.out.println("Composición de funciones (2x → 3x → x²): " + abcd.apply(10));
        
        // 4. Manipulación de cadenas con funciones curriadas
        System.out.println("\n7.4 Manipulación de cadenas con funciones curriadas:");
        
        Function<String, String> convMay = s -> s.toUpperCase();
        Function<String, String> sinEsp = s -> s.trim();
        Function<String, String> reemplace = s -> s.replace("a", "e");
        
        Function<Function<String, String>,
        Function<Function<String, String>,
        Function<Function<String, String>,
        Function<String, String>>>> 
        tot = getStringCompositionFunction();
        
        String fin = tot.apply(reemplace).apply(convMay).apply(sinEsp).apply("  aaaaaa  ");
        System.out.println("Transformación curriada de cadena: " + fin);
        
        // 5. Comparación con método andThen
        System.out.println("\n7.5 Comparación con método andThen:");
        
        String resultado = reemplace.andThen(convMay).andThen(sinEsp).apply("  aaaaaa  ");
        System.out.println("Transformación con andThen: " + resultado);
        
        // 6. Operaciones matemáticas en cadena
        System.out.println("\n7.6 Operaciones matemáticas en cadena:");
        
        Function<Integer, Integer> suma = a -> a + 10;
        Function<Integer, Integer> multiplicar = a -> a * 2;
        Function<Integer, Integer> restar = a -> a - 5;
        
        Function<Integer, Integer> funcionCompuesta = getIntegerCompositionFunction()
        .apply(suma)
        .apply(multiplicar)
        .apply(restar);
        
        Integer resultadoOperaciones = funcionCompuesta.apply(5);
        System.out.println("Operaciones matemáticas encadenadas: " + resultadoOperaciones);
        
        // 7. División segura con Optional
        System.out.println("\n7.7 División segura con Optional:");
        
        Function<Integer, Integer> f = x -> 1/x;
        Function<Integer, Optional<Integer>> f2 = x -> Optional.of(x).filter(n -> n != 0).map(f);
        
        System.out.println("División segura con entrada 0: " + f2.apply(0));
        System.out.println("División segura con entrada 5: " + f2.apply(5));
        
        // 8. Transformación de listas
        System.out.println("\n7.8 Transformación de Listas:");
        demonstrateListTransformation();
    }
}