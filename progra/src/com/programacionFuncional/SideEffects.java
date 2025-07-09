package com.programacionFuncional;

import java.util.function.Function;

public class SideEffects {
    
    public static void demonstrateSideEffects() {
        // Son modificaciones del estado de un objeto o variable
        // No puede ser modificable porque tiene que ser determinista
        final int  x = 10;
        //Tiene que ser determinista por lo que es final
        Function<Integer,Integer> op = a -> a+x;
        //La funcion depende de una variable externa x = 10
        //Por lo que no es pura y no tiene transparencia referencial
        //Evaluacion perezosa es cuando no se evalua la funcion hasta que se necesita
        System.out.println("Resultado de la función con efecto secundario: " + op.apply(5));

        //Ejemplo de Transparencia referencial
        //La funcion no depende de una variable externa por lo que no se modifica
        //Tiene un input y un output
        //Function recibe un solo parametro y devuelve un solo parametro
        int y = 3;
        Function<Integer, Function<Integer, Integer>>
                opDos = a -> b -> a + b;
        System.out.println("El resultado es: " + opDos.apply(5).apply(y));

        y = 7;
        System.out.println("El resultado es: " + opDos.apply(5).apply(y));
    }
}
