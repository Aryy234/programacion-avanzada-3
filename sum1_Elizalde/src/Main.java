//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import utilidades.CalculadoraImpuestos;
import utilidades.Estudiantes;
import utilidades.Function;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("LITERAL 1");

        // Función que devuelve el cuadrado de cada elemento en una lista
        Function<List<Integer>, List<Integer>> cuadradoFunc = list -> {
            List<Integer> result = new ArrayList<>();
            for (Integer number : list) {
                result.add(number * number);
            }
            return result;
        };

        // Función que devuelve la suma de los elementos de una lista
        Function<List<Integer>, Integer> sumFunc = list -> {
            int sum = 0;
            for (Integer number : list) {
                sum += number;
            }
            return sum;
        };

        // Lista de prueba
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Aplicación de ambas funciones por separado
        List<Integer> resultadoCuadrados = cuadradoFunc.apply(numbers);
        int resultadoSuma = sumFunc.apply(numbers);

        System.out.println("Suma de los números: " + resultadoSuma); // Salida esperada: 15
        System.out.println("Cuadrado de cada número: " + resultadoCuadrados); // Salida esperada: [1, 4, 9, 16, 25]

        System.out.println("======================================================");
        System.out.println();


        System.out.println("LITERAL 2");
        //Literal 2
        // Función curried para resolver la ecuación x*x + 4y + 7z
        Function<Integer, Function<Integer, Function<Integer, Integer>>> curriedFunction =
                x -> y -> z -> (x * x) + (4 * y) + (7 * z);

        // Aplicación de la función con valores específicos

        //Paso 1
        Function<Integer, Function<Integer, Integer>> paso1 = curriedFunction.apply(3); // x = 3

        //Paso 2
        Function<Integer, Integer> paso2 = paso1.apply(2); // y = 2

        //Resultado final
        int resultado2 = paso2.apply(5); // z = 5
        //Otra manera seria realizando apply directamente a lso 3

        System.out.println("Resultado: " + resultado2); // Salida esperada: 3*3 + 4*2 + 7*5 = 50

        System.out.println("======================================================");
        System.out.println();


        System.out.println("LITERAL 3");
        //Literal 3
        // Aplicación de la función curried con valores específicos
        Function<Double, Function<Double, Double>>
                calcularImpuestos = CalculadoraImpuestos.calcularTotalFuncional.apply(0.12);


        System.out.println("Total con impuestos: " + calcularImpuestos.apply(0.10).apply(100.0));
        // Salida esperada: 122.0

        System.out.println("======================================================");
        System.out.println();


        System.out.println("LITERAL 4");
        //Literal 4
        // Ejemplo de uso de la funcion compose
        // Generar una lista de estudiantes

        Estudiantes[] estudiantes = {
                new Estudiantes("Juan", "Pérez", 20, 85),
                new Estudiantes("Ana", "Gómez", 22, 90),
                new Estudiantes("Luis", "Martínez", 19, 78)
        };


        // Convertir las notas de int a double
        Function<Estudiantes, Double> convertirNota = estudiante -> (double) estudiante.getNota();

        // Crear una variable para almacenar el arreglo de notas de cada estudiante
        Double[] notas = new Double[estudiantes.length];
        for (int i = 0; i < estudiantes.length; i++) {
            notas[i] = convertirNota.apply(estudiantes[i]);
        }

        // Verificar notas matoyers a 80
        Function<Double, Boolean> esMayorA80 = nota -> nota > 80;

        // Crear una variable para almacenar el arreglo de booleanos
        Boolean[] mayoresA80 = new Boolean[notas.length];
        for (int i = 0; i < notas.length; i++) {
            mayoresA80[i] = esMayorA80.apply(notas[i]);
        }

        //Teniendo <T,U,V> Se aplica una tranformacion a <T,V>
        //Teniendo f = <T, U> y g = <U, V> respetando que ek dominio de g sea el codominio de f

        System.out.println("COMPOSICION DE FUNCIONES POR SEPARDADO");
        // Imprimir los resultados
        System.out.println("Notas de los estudiantes:");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println(estudiantes[i].getNombre() + " " + estudiantes[i].getApellido() + ": " + notas[i]);
        }
        System.out.println("¿Las notas son mayores a 80?");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println(estudiantes[i].getNombre() + " " + estudiantes[i].getApellido() + ": " + mayoresA80[i]);
        }
        System.out.println("======================================================");
        System.out.println();



    }
}
