import utils.Effect;
import utils.Executable;
import utils.Funcion;
import utils.Lista;
//Posible de prueba: pasar de algo imperativo a funcional OJOOO
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

        //Aplicar potencia creada en class Mathe
        int n = 4;
        int m = 3;
        int resPot1 = Mathe.potencia.apply(2).apply(3);
        System.out.println("El resultado de: " + n +"^"+ m + " es: " + resPot1);

        //Aplicar potencia creada en class Mathe
        int resPot2 = Mathe.sumCuadradoNaturales.apply(n);
        System.out.println("El resultado de los " + n + " numeros en secuencia al cuadrado es: " + resPot2);

        //Aplicar raizCuadrada creada en class Mathe
        int resPot3 = Mathe.raizCuadrada.apply(n);
        System.out.println("La raiz de " + n + " es: " + resPot3);

        //Aplicar fold y reduce para realizar distintas operacienes
        Lista<Integer> listaNum2 = Lista.of(1,2,3,4,5,6,7,8,9,10);

        Lista<Integer> listaPrimos = Mathe.getNumPrimos.apply(listaNum2);
        Lista<Integer> listaFact = Mathe.factLista.apply(listaNum2);
        int resultProducList = Mathe.producLista.apply(listaNum2);
        Lista<Integer> listFibonacci = Mathe.listFibonacci.apply(4);

        System.out.println("Aplicando Fold a listas");
        System.out.println("Lista inicial: " + listaNum2.toStringRepresentation());

        System.out.println("Lista de primos: " + listaPrimos.toStringRepresentation());
        System.out.println("Lista de factoriales: " + listaFact.toStringRepresentation());
        System.out.println("Product de numeros de una lista: " + resultProducList);
        System.out.println("Lista de los " + num + " primeros numeros de Fibonacci: " + listFibonacci.toStringRepresentation());

        //Funcion para imprimir utilizando executable

        //implementar printInteger OJO no es funcion pura solucionar
        Effect<Integer> printInteger = xExec->{
            System.out.printf("d%", x);
            System.out.println();
        };

        Funcion<Executable, Funcion<Integer, Executable>>
                fn = ex -> elem -> () ->{
            ex.exec();
            printInteger.apply(elem);
        };

        Funcion<Executable, Funcion<Integer, Executable>>
                fn1 = ex -> elem ->{
            ex.exec();
            return () -> {
              printInteger.apply(elem);
            };
        };

        //Implementacion de execute teniendo en cuenta efectos secundarios
        Executable exec0 = () ->{};
        Executable exec1 = ()-> {
          exec0.exec();
            System.out.println(1);
        };
        Executable exec2 = ()-> {
            exec1.exec();
            System.out.println(2);
        };
        Executable exec3 = ()-> {
            exec2.exec();
            System.out.println(3);
        };

        //para imprimir exec
        exec3.exec();

    }
}