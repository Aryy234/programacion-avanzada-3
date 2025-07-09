import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso con una lista de estudiantes
        List<Estudiante> estudiantes = Arrays.asList(
            new Estudiante("Juan", 85),
            new Estudiante("María", 90),
            new Estudiante("Pedro", 75),
            new Estudiante("Ana", 95),
            new Estudiante("Carlos", 80)
        );

        List<Estudiante> estudiantes2 = Arrays.asList(
            new Estudiante("Juan", 50),
            new Estudiante("María", 30),
            new Estudiante("Pedro", 25),
            new Estudiante("Ana", 55),
            new Estudiante("Carlos", 88)
        );


        
        double promedio = calcularPromedioIterativo(estudiantes);
        System.out.println("El promedio de notas es: " + promedio);
        
        // Ejemplo usando el método funcional para estudiantes
        Function<Double, Function<List<Estudiante>, Double>> calculadoraPromedioEstudiantes = 
            calcularPromedioEstudiantesFuncional();
        
        System.out.println("El promedio de notas (funcional) es: " + 
            calculadoraPromedioEstudiantes.apply(0.0).apply(estudiantes));

        // Ejemplo de uso con la suma de listas de estudiantes
        List<Estudiante> listaSumada = sumarListasImperativa(estudiantes, estudiantes2);
        System.out.println("Lista sumada (imperativa):");
        for (Estudiante estudiante : listaSumada) {
            System.out.println(estudiante.getNombre() + ": " + estudiante.getNota());
        }
        // Ejemplo de uso con la suma de listas de estudiantes de manera funcional
        Function<List<Estudiante>, Function<List<Estudiante>, List<Estudiante>>> sumarListasFuncional = 
            sumarListasFuncional();
        List<Estudiante> listaSumadaFuncional = sumarListasFuncional.apply(estudiantes).apply(estudiantes2);
        System.out.println("Lista sumada (funcional):");
        for (Estudiante estudiante : listaSumadaFuncional) {
            System.out.println(estudiante.getNombre() + ": " + estudiante.getNota());
        }
    }
    
    /**
     * Calcula el promedio de notas de una lista de estudiantes de manera iterativa
     */
    public static double calcularPromedioIterativo(List<Estudiante> estudiantes) {
        if (estudiantes == null || estudiantes.isEmpty()) {
            return 0.0;
        }
        
        double suma = 0.0;
        
        // Recorremos la lista de estudiantes de manera iterativa y sumamos sus notas
        for (Estudiante estudiante : estudiantes) {
            suma += estudiante.getNota(); // Sumamos la nota de cada estudiante
        }
        
        // El promedio es la suma dividida entre el número de estudiantes
        return suma / estudiantes.size();
    }
    
    /**
     * Método que devuelve una función para calcular el promedio de notas de estudiantes
     * de manera funcional, siguiendo el patrón Function<Double, Function<List<Estudiante>, Double>>
     */
    public static Function<Double, Function<List<Estudiante>, Double>> calcularPromedioEstudiantesFuncional() {
        return valorInicial -> listaEstudiantes -> {
            if (listaEstudiantes == null || listaEstudiantes.isEmpty()) {
                return 0.0;
            }
            
            Double acumulador = valorInicial;
            for (var estudiante : listaEstudiantes) {
                int nota = estudiante.getNota();
                acumulador += nota;
            }
            
            return acumulador / listaEstudiantes.size();
        };
    }

    /**
     * Metodo que suma dos listas de estudiantes y devuelve una lista con los estudiantes en el mismo orden
     * de manera Imperativa
     */
    public static List<Estudiante> sumarListasImperativa(List<Estudiante> lista1, List<Estudiante> lista2) {
        if (lista1 == null || lista2 == null) {
            return null;
        }
        
        // Creamos una nueva lista para almacenar los estudiantes sumados
        List<Estudiante> listaSumada = new ArrayList<>();
        
        // Recorremos ambas listas y sumamos los estudiantes
        for (int i = 0; i < Math.min(lista1.size(), lista2.size()); i++) {
            Estudiante estudiante1 = lista1.get(i);
            Estudiante estudiante2 = lista2.get(i);
            
            // Sumamos las notas de los estudiantes
            int sumaNota = estudiante1.getNota() + estudiante2.getNota();
            
            // Creamos un nuevo estudiante con la suma de las notas
            Estudiante nuevoEstudiante = new Estudiante(estudiante1.getNombre(), sumaNota);
            
            // Añadimos el nuevo estudiante a la lista sumada
            listaSumada.add(nuevoEstudiante);
        }
        
        return listaSumada;
    }

    /**
     * Metodo que suma dos listas de estudiantes y devuelve una lista con los estudiantes en el mismo orden
     * de manera Funcional utilizando Function 
     */
    public static Function<List<Estudiante>, Function<List<Estudiante>, List<Estudiante>>> sumarListasFuncional() {
        return lista1 -> lista2 -> {
            if (lista1 == null || lista2 == null) {
                return null;
            }
            
            // Creamos una nueva lista para almacenar los estudiantes sumados
            List<Estudiante> listaSumada = new ArrayList<>();
            
            // Recorremos ambas listas y sumamos los estudiantes
            for (int i = 0; i < Math.min(lista1.size(), lista2.size()); i++) {
                Estudiante estudiante1 = lista1.get(i);
                Estudiante estudiante2 = lista2.get(i);
                
                // Sumamos las notas de los estudiantes
                int sumaNota = estudiante1.getNota() + estudiante2.getNota();
                
                // Creamos un nuevo estudiante con la suma de las notas
                Estudiante nuevoEstudiante = new Estudiante(estudiante1.getNombre(), sumaNota);
                
                // Añadimos el nuevo estudiante a la lista sumada
                listaSumada.add(nuevoEstudiante);
            }
            
            return listaSumada;
        };
    }

    
}
