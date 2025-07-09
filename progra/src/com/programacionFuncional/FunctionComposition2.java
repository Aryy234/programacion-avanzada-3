package com.programacionFuncional;

import com.composicionClases.Function;
import java.util.function.BiFunction;

/**
 * Clase que demuestra conceptos avanzados de composición de funciones (segunda parte)
 */
public class FunctionComposition2 {

    /**
     * Método para demostrar conceptos avanzados de composición de funciones
     */
    public static void demonstrateFunctionComposition2() {
        System.out.println("Composición de funciones - Segunda parte");
        System.out.println("---------------------------------------");
        
        // Ejemplo 1: Composición imperativa vs funcional
        System.out.println("1. Composición imperativa vs funcional:");
        int resultado1 = compose1(5); // Enfoque imperativo
        System.out.println("   Enfoque imperativo: " + resultado1);
        
        Function f1 = x -> x * 3;
        Function f2 = x -> x * x;
        Function composedF = compose(f1, f2);
        System.out.println("   Enfoque funcional: " + composedF.apply(5));
        
        // Ejemplo 2: Composición encadenada
        System.out.println("\n2. Composición encadenada de funciones:");
        Function f = x -> x * 10;
        Function g = x -> x * x;
        Function h = x -> x + 2;
        
        Function fg = compose(f, g);
        Function fgh = compose(fg, h);
        System.out.println("   f(g(h(5))) = " + fgh.apply(5)); // f(g(h(5))) = f(g(7)) = f(49) = 490
        
        // Ejemplo 3: Usando APIs estándar de Java
        System.out.println("\n3. Composición usando API estándar de Java:");
        java.util.function.IntUnaryOperator tripleJava = x -> x * 3;
        java.util.function.IntUnaryOperator squareJava = x -> x * x;
        java.util.function.IntUnaryOperator composedJava = squareJava.andThen(tripleJava);
        System.out.println("   square.andThen(triple).apply(4) = " + composedJava.applyAsInt(4)); // (4^2)*3 = 48
        
        // Ejemplo 4: Composición con funciones de diferentes tipos
        System.out.println("\n4. Composición con funciones de diferentes tipos:");
        java.util.function.Function<Integer, String> intToString = x -> "El número es: " + x;
        java.util.function.Function<String, String> addExclamation = s -> s + "!";
        java.util.function.Function<Integer, String> intToStringWithExclamation = intToString.andThen(addExclamation);
        System.out.println("   " + intToStringWithExclamation.apply(42)); // El número es: 42!
        
        // Ejemplo 5: Composición con BiFunction
        System.out.println("\n5. Composición con BiFunction:");
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        java.util.function.Function<Integer, Integer> addFive = x -> x + 5;
        BiFunction<Integer, Integer, Integer> multiplyThenAddFive = multiply.andThen(addFive);
        System.out.println("   multiply.andThen(addFive).apply(4, 3) = " + multiplyThenAddFive.apply(4, 3)); // (4*3)+5 = 17
          // Ejemplo 6: Demostración desde el código original en Main
        System.out.println("\n6. Demostración de funciones puras vs impuras:");
        
        // Esto esta mal porque no es una función pura
        System.out.println("   Función no pura fg(5) = " + fg(5));
        
        // Esto es una función pura porque no depende de ninguna otra función
        // y no tiene efectos secundarios
        MainFunction fpura = new MainFunction() {
            @Override
            public int apply(int x) {
                return 10 * x;
            }
        };

        MainFunction gpura = s -> s * s;
        
        // Convertimos las funciones locales a las funciones de la clase de composición
        com.composicionClases.Function fExternal = new com.composicionClases.Function() {
            @Override
            public int apply(int x) {
                return fpura.apply(x);
            }
        };
        
        com.composicionClases.Function gExternal = new com.composicionClases.Function() {
            @Override
            public int apply(int x) {
                return gpura.apply(x);
            }
        };
        
        // Ejemplo usando la composición de la nueva clase
        System.out.println("   Usando el método compose2 con funciones puras: " + 
                          FunctionComposition.compose2(fExternal, gExternal).apply(5));
    }
    
    /**
     * Ejemplo de composición imperativa de funciones
     */
    private static int compose1(int x) {
        return triple(square(x));
    }
    
    /**
     * Composición de funciones en estilo funcional
     */
    private static Function compose(Function f, Function g) {
        return new Function() {
            @Override
            public int apply(int x) {
                return f.apply(g.apply(x));
            }
        };
    }
    
    /**
     * Interfaz interna para representar funciones al estilo de Main.java
     */
    interface MainFunction {
        int apply(int x);
    }
    
    /**
     * Función cuadrado
     */
    public static int square(int x) {
        return x * x;
    }
    
    /**
     * Función triple
     */
    public static int triple(int x) {
        return x * 3;
    }
    
    /**
     * Ejemplo de función que no es pura, ya que depende de las funciones square y triple
     */
    public static int fg(int x) {
        return square(triple(x));
    }
    
    /**
     * Clases de implementación para demostraciones
     */
    static class Triple implements MainFunction {
        // Implementación de la función triple
        @Override
        public int apply(int x) {
            return x * 3;
        }
    }
    
    static class Square implements MainFunction {
         // Implementación de la función cuadrado
         @Override
        public int apply(int x) {
            return x * x;
        }
    }
}
