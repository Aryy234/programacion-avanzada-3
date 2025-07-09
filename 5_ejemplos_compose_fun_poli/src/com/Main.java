import utilidades.Function;
import utilidades.Estudiantes;


public class Main {
    public static void main(String[] args) {
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
        Double[] notas = java.util.Arrays.stream(estudiantes)
            .map(convertirNota::apply)
            .toArray(Double[]::new);

        Function<Double, Boolean> esMayorA80 = nota -> nota > 80;
        // Crear una variable para almacenar el arreglo de booleanos
        Boolean[] mayoresA80 = new Boolean[notas.length];
        for (int i = 0; i < notas.length; i++) {
            mayoresA80[i] = esMayorA80.apply(notas[i]);
        }
        
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



        System.out.println("COMPOSICION DE FUNCIONES EN UN SOLO PASO UTILIZANDO COMPOSE");
        // Composición de funciones implementando compose de Function yendo de T -> U -> V en uno solo paso
        Function<Estudiantes, Boolean> esMayorA80compose = Function.compose(convertirNota, esMayorA80);

        // Crear una variable para almacenar el arreglo de booleanos
        Boolean[] mayoresA80Compose = new Boolean[estudiantes.length];
        for (int i = 0; i < estudiantes.length; i++) {
            mayoresA80Compose[i] = esMayorA80compose.apply(estudiantes[i]);
        }
        // Imprimir los resultados
        System.out.println("¿Las notas son mayores a 80? (composición de funciones)");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println(estudiantes[i].getNombre() + " " + estudiantes[i].getApellido() + ": " + mayoresA80Compose[i]);
        }
        System.out.println("======================================================");
        System.out.println();

        System.out.println("COMPOSICION DE FUNCIONES EN UN SOLO PASO UTILIZANDO ANDTHEN");
        // Composición de funciones implementando andThen de Function yendo de T -> U -> V en uno solo paso
        Function<Estudiantes, Boolean> esMayorA80andThen = Function.andThen(convertirNota, esMayorA80);
        // Crear una variable para almacenar el arreglo de booleanos
        Boolean[] mayoresA80AndThen = new Boolean[estudiantes.length];
        for (int i = 0; i < estudiantes.length; i++) {
            mayoresA80AndThen[i] = esMayorA80andThen.apply(estudiantes[i]);
        }
        // Imprimir los resultados
        System.out.println("¿Las notas son mayores a 80? (composición de funciones)");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println(estudiantes[i].getNombre() + " " + estudiantes[i].getApellido() + ": " + mayoresA80AndThen[i]);
        }
        System.out.println("======================================================");
        System.out.println();
        








        
        // NOTA: En f(g(x)) el codomino de g(x) es el dominio de f(x)
        // F -> D
        // G -> C
        // C -> B

        // Function(Estudiantes, Double) f = convertirNota;
        // Function(Double, Boolean) g = esMayorA80;
        

    }
}