package utils;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CaracteristicsPF {

    //1. Funciones como elementos relevantes (First-Class Functions)

    //Ejemplo
    // Obtener el cuadrado de un numero
    // Obtener el doble de un numero

    // Una funcion se la puede pasar como argumentos a metodos o funciones
    public static int aplicarFuncion(Function<Integer, Integer> fn, int x){

        // Puede retornar en un metodo o funcion
        return fn.apply(x);
    }

    // Puede ser una variable
    Function<Integer, Integer> square = x -> x * x;
    Function<Integer, Integer> doble = x -> x * 2;

    int resultadoSquare = aplicarFuncion(square, 3);
    int resultadoDoble = aplicarFuncion(doble, 5);


    //2. Funciones anonimas
    // Tambien conocidas como LAMBDAS, son funciones que se declaran en el momento y no tienen nombre

    // Esto es una funcion anonima con lambdas
    Function<Integer, String> transText = x -> x+"TEXTO";
    int num = 8;
    String numToText = transText.apply(num);


    //3. Closures
    // Recuerda el entorno en la que fue creada, incluso si el contexto ya no existe

    // AQUI SE APLICA CLOUSURE
    // recibe el argumento x que es la variable que guarda y (y) que es la que aplica la suma en las siguiente implementaciones
    public static Function<Integer, Integer> makeAdder(int x){
        return (Integer y) -> y + x;
    }

    Function<Integer, Integer> suma = makeAdder(10);
    int resul1 = suma.apply(5); //recuerda la variable makeAdder aunque ya no exista print 15
    int result2 = suma.apply(20); // print 30


    //4. Composicion de funciones
    // Enlaza funciones: la salida de una funcion es la entrada de otra funcion: f(g(x)) o g(f(x))
    // podemos utilizar andThen o compose

    //ejemplo 1re f(x): x + 2x, 2da g(x): 3x + x*x
    //implementa f(g(x)) y g(f(x))
    Function<Integer, Integer> fx = x -> x + 2*x;
    Function<Integer, Integer> gx = x -> 3 + x*x;

    // Realiza de adentro hacia afuera: 1ro gx y luego fx
    Function<Integer, Integer> fgx = fx.compose(gx);
    int result3 = fgx.apply(4);

    // Realiza de afuera hacia adentro: 1ro fx y luego gx
    Function<Integer, Integer> gfx = fx.andThen(gx);
    int result4 = gfx.apply(4);


    //5. Currying
    // transforma un metodo con varios argumentos f(a, b, c, ...) en una funcion con un dato de
    // entrada y salida f(a) -> f(b) -> f(c) -> ... -> resultado
    // Ejemplo realizar operaciones con 4 variables
    Function<Integer,
            Function<Integer,
                    Function<Integer,
                            Function<Integer, String>>>>
            operacion = x -> y -> w -> z -> (x + " " + y + " " + z + " " + w);
    // RECUERDA las referencias: 1:x, 2:y, 3w y 4z
    String result5 = operacion.apply(1).apply(2).apply(3).apply(4); //resultado 1 2 4 3


    //6. Funciones de orden superior
    //Una funcion de orden superior es aquella funcion que recibe como parametros otra funcion
    //Ejemplo: crear una funcion que realice cualquier operacion y reciba una funcion
    Function<Integer, Function<Integer, Integer>>
            multiplicar = x -> y -> x*y;
    Function<Integer, Function<Integer, Integer>> sumar = x -> y -> x+y;

    //Metodo Operacion
    public static int operacion(Function<Integer,Function<Integer, Integer>> op, int num1, int num2){
        return op.apply(num1).apply(num2);
    }


    //7. Evaluacion Tardia (Lazy Evaluation)
    // NO SE EVALUA DE INMEDIATO, solo se evalua cuando se necesita el valor

    //Ejemplo genera un numero random y no se evalua hasta que lo llamamos con el get utilizando Supplier
    Supplier<Double> numRandom = Math::random;
    String result6 = "Numero aleatorio" + numRandom.get();

    //Ejemplo generando numeros de 1 al ... y luego filtrando los 5 primeros pares
    Stream<Integer> numPares = Stream.iterate(1, x -> x+1)
            .filter(x -> x%2 == 0)
            .limit(5);
    //String getResult7 = numPares.forEach(System.out::println); //Se evalua hasta que se llama al forEach


    // 8. Polimorfismo Parametrico (Genericos)
    // Genera funciones o estructuras que funcionan con cualquier tipo de dato o objeto
    // Ejemplo funcion que devuelve cualquier cosa

    /**
     * Devuelve el mayor de dos valores a y b.
     * Función pura y genérica: no modifica nada y para los mismos a, b siempre devolverá el mismo resultado.
     *
     * @param a   primer valor
     * @param b   segundo valor
     * @param <T> cualquier tipo que implemente Comparable<T>
     * @return   el valor mayor según compareTo
     */

    public static <T extends Comparable<T>> T max(T a, T b){
        //compareTo funciona de la siguiente manera:
        // < 0 si a < b
        // > 0 si a > b
        // 0 si a == b

        //realiza un if si es mayor 0 devuelve a caso contrario devuelve b
        return (a.compareTo(b) >= 0) ? a:b;
    }

    String compareText = max("Ariel", "Marcelo");
    int compareNum = max(90, 30);
    String result7 = "El texto maximo es: " + compareText + "y el numero maximo es: " + compareNum;













}
