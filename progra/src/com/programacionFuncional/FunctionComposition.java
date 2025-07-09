package com.programacionFuncional;

import com.composicionClases.Function;
import com.composicionClases.FunctionPolimorfica;

/**
 * Clase que demuestra los conceptos de composición de funciones
 */
public class FunctionComposition {

    /**
     * Función que demuestra varios ejemplos de composición de funciones
     */
    public static void demonstrateFunctionComposition() {
        System.out.println("Ejemplo de composición de funciones:");
        Function comFunction = compose(triple, square);
        System.out.println("Composición de funciones: " + comFunction.apply(2)); // (2 * 2) * 3 = 12

        System.out.println("Ejemplo de composición de funciones polimorficas:");
        FunctionPolimorfica<Integer, Integer> comFunctionPolimorfica = composePolimorfico(triplePolimorfico, squarePolimorfico);
        System.out.println("Composición de funciones polimorficas: " + comFunctionPolimorfica.apply(2)); // (2 * 2) * 3 = 12

        System.out.println("Ejemplo de composición de funciones con lambda:");
        Function comFunctionLambda = composeLambda(tripleLambda, squareLambda);
        System.out.println("Composición de funciones con lambda: " + comFunctionLambda.apply(2)); // (2 * 2) * 3 = 12

        System.out.println("Ejemplo de composición de funciones polimorficas con lambda:");
        FunctionPolimorfica<Integer, Integer> comFunctionPolimorficaLambda = composePolimorficoLambda(triplePolimorficaLambda, squarePolimorficaLambda);
        System.out.println("Composición de funciones polimorficas con lambda: " + comFunctionPolimorficaLambda.apply(2)); // (2 * 2) * 3 = 12

        System.out.println("Ejemplo de composición de funciones que convierten de Integer a String:");
        FunctionPolimorfica<Integer, String> intToStringFunction = intToString((x) -> "El número es: " + x, (x) -> x * 2);

        System.out.println("Composición de funciones que convierten de Integer a String: " + intToStringFunction.apply(2)); // "El número es: 4"
        System.out.println("Ejemplo de composición de funciones que convierten de Integer a String y luego a Integer:");
        FunctionPolimorfica<Integer, String> intToStringAndThenFunction = intToStringAndThen((x) -> x * 2, (x) -> "El número es: " + x);
        System.out.println("Composición de funciones que convierten de Integer a String y luego a Integer: " + intToStringAndThenFunction.apply(2)); // "El número es: 4"
    
        // Ejemplo de composición de funciones múltiple
        System.out.println("\nEjemplo de composición encadenada de funciones:");
        Function f = (x) -> 10 * x;
        Function g = s -> s * s;
        Function fg1 = compose2(f, g);
        Function fg2 = compose2(fg1, g);
        Function fg3 = compose2(fg2, g);
        System.out.println("Composición encadenada: f(g(g(g(5)))) = " + fg3.apply(5));
    }

    // Ejemplo de funciones normales
    // Implementacion de clases anónimas para las funciones
    static Function triple = new Function() {
        @Override
        public int apply(int x) {
            return x * 3;
        }   
    };

    static Function square = new Function() {
        @Override
        public int apply(int x) {
            return x * x;
        }
    };

    static Function compose(Function f, Function g) {
        return new Function() {
            @Override
            public int apply(int x) {
                return f.apply(g.apply(x));
            }
        };
    }

    // Se puedes omitir la implementación de la clase anónima cuando se utiliza una expresión lambda
    static Function tripleLambda = (x) -> x * 3;
    static Function squareLambda = (x) -> x * x;
    static Function composeLambda(Function f, Function g) {
        return (x) -> f.apply(g.apply(x));
    }

    // Ejemplo de funciones polimorficas
    // Implementacion de clases anónimas para las funciones
    static FunctionPolimorfica<Integer, Integer> triplePolimorfico = new FunctionPolimorfica<>() {
        @Override
        public Integer apply(Integer x) {
            return x * 3;
        }
    };

    static FunctionPolimorfica<Integer, Integer> squarePolimorfico = new FunctionPolimorfica<>() {
        @Override
        public Integer apply(Integer x) {
            return x * x;
        }
    };

    static FunctionPolimorfica<Integer, Integer> 
    composePolimorfico(FunctionPolimorfica<Integer, Integer> f, FunctionPolimorfica<Integer, Integer> g) {
        return new FunctionPolimorfica<>() {
            @Override
            public Integer apply(Integer x) {
                return f.apply(g.apply(x));
            }
        };
    }

    // Se puedes omitir la implementación de la clase anónima cuando se utiliza una expresión lambda
    static FunctionPolimorfica<Integer, Integer> triplePolimorficaLambda = (x) -> x * 3;
    static FunctionPolimorfica<Integer, Integer> squarePolimorficaLambda = (x) -> x * x;

    static FunctionPolimorfica<Integer, Integer> 
    composePolimorficoLambda(FunctionPolimorfica<Integer, Integer> f, FunctionPolimorfica<Integer, Integer> g) {
        return (x) -> f.apply(g.apply(x));
    }

    //Crear una funcion que una funcion vaya de los Integers a los Strings y otra de Integer a Integer
    // y que la funcion de Integer a String sea la que se aplique primero con expresion lambda
    static FunctionPolimorfica<Integer, String>
    intToString(FunctionPolimorfica<Integer, String> f,
        FunctionPolimorfica<Integer, Integer> g) {
        return (x) -> f.apply(g.apply(x));
        }

    static FunctionPolimorfica<Integer, String>
    intToStringAndThen(FunctionPolimorfica<Integer, Integer> f,
        FunctionPolimorfica<Integer, String> g) {
        return (x) -> g.apply(f.apply(x));
    }

    // Método para componer varias funciones en cadena
    public static com.composicionClases.Function compose2(com.composicionClases.Function f, com.composicionClases.Function g) {
        return new com.composicionClases.Function() {
            @Override
            public int apply(int x) {
                return f.apply(g.apply(x));
            }
        };
    }
}
