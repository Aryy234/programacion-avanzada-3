package service;

import utils.Funcion;

public class Mathe {

    public static Funcion<Integer, Integer> factorial;
    public static Funcion<Integer, Integer> fibonacci;

    static {
        factorial = n -> n == 0 ? 1 : n * factorial.apply(n - 1);
    }

    static {
        fibonacci = n -> 
        n == 0 ? 0 : 
        (n == 1 ? 1 : 
        fibonacci.apply(n - 1) + fibonacci.apply(n - 2));
    }

}
