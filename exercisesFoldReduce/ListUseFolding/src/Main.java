import utils.Funcion;
import utils.Lista;

import service.Mathe;

public class Main {

    public static void main(String[] args) {

        //Mostrar el total de la suma de una lista utlizando fold
        Lista<Integer> listNum = Lista.of(1, 2, 3, 4, 5);

        Funcion<Lista<Integer>, Integer> total =
                x -> x.fold(0, a -> b -> a+b);

        //Calcular el factorial de un numero utilizando recursion
        int num = 4;
        int resFact = Mathe.factorial.apply(num);
        int resFibo = Mathe.fibonacci.apply(num);


        System.out.println("La suma de la lista es: " + total.apply(listNum));
        System.out.println("Factorial de: " + num + " es " + resFact);
        System.out.println("Fibonacci de: " + num + " es " + resFibo);

        //Realizar la siguiente operacion de composición de funciones:
        // fx = x + 2
        // gx = x * 3
        // Realizar f(g(x)) y g(f(x))

        Funcion<Integer, Integer> f = x -> x + 2;
        Funcion<Integer, Integer> g = x -> x * 3;
        Funcion<Integer, Integer> fg = Funcion.compose(f, g);
        Funcion<Integer, Integer> gf = Funcion.andThen(f, g);
        int x = 5;
        int resFg = fg.apply(x);
        int resGf = gf.apply(x);
        System.out.println("f(g(" + x + ")) = " + resFg);
        System.out.println("g(f(" + x + ")) = " + resGf);
        
    }
}