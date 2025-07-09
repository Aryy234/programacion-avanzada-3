package com.programacionFuncional;

import java.util.function.Function;
import java.util.function.Predicate;

import com.composicionClases.Prueba;

public class FunctionalExamples2 {
    
    public static Res sumar(int a, int b) {
        while (b > 0) {
            a++;
            b--;
        }
        Res r = new Res(a, "La suma es: ");
        return r;
    }
    
    public static Prueba suma(Prueba x, Prueba y) {
        int op = x.met(5) + y.met(6);
        return s -> s + op;
    }
    
    public static int mult(int a, int b) {
        return a * b;
    }
    
    public static int test(Prueba p, int y) {
        int res = p.met(y) * 5;
        return res;
    }
    
    /**
     * Método que demuestra todas las funcionalidades de la clase
     */
    public static void demostracion() {
        
        // Demostración del método sumar
        final Res r = sumar(2, 3);
        System.out.println("Resultado de sumar(2, 3):");
        System.out.println(r.msn);
        System.out.println(r.suma);
        System.out.println();
        
        // Demostración de predicados
        Predicate<Res> p = s -> r.suma > 5;
        System.out.println("¿La suma es mayor que 5? " + p.test(r));
        System.out.println();
        
        // Demostración de implementaciones de interfaces funcionales
        Prueba pr = new Prueba() {
            @Override
            public int met(int x) {
                return x + 10;
            }
        };
        System.out.println("Implementación con clase anónima: " + pr.met(5));
        
        // Demostración con expresión lambda
        Prueba pr2 = s -> s + 5;
        System.out.println("Implementación con lambda: " + pr2.met(5));
        System.out.println();
        
        // Demostración del método test
        int respuesta = test(s -> s + 5, 3);
        System.out.println("Resultado de test(s -> s + 5, 3): " + respuesta);
        
        // Demostración del método suma con funciones
        Prueba sum = suma(s -> s * 2, s -> s + 5);
        System.out.println("Resultado de suma(s -> s * 2, s -> s + 5).met(3): " + sum.met(3));
        
        // Demostración de currificación
        Function<Integer, Function<Integer, Integer>> funcionSuma = a -> b -> a + b;
        Function<Integer, Integer> suma5 = funcionSuma.apply(5);
        System.out.println("Resultado de currificación (suma5.apply(10)): " + suma5.apply(10));
        
        // Demostración de multiplicación
        System.out.println("Resultado de mult(5, 7): " + mult(5, 7));
        
    }
    
    // Clase interna Res
    static class Res {
        final int suma;
        final String msn;
        
        public Res(int s, String m) {
            this.suma = s;
            this.msn = m;
        }
        
        @Override
        public String toString() {
            return msn + suma;
        }
    }
}