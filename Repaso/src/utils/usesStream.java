package utils;

import models.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.nio.file.Paths;

public class usesStream {
    //Stream: FLUJO (una tuberia que fluye)
    // Es un paquete de componentes que se los puede utlizar en secuencia
    // incluye: paquetes, clases, interfaces etc.
    // Se lo puede utilizar para filtrar, iterar, transformar(convertir una estructura de objeto a otra), imprimir

    /*
    Componentes basicos:
        * Secuencia de elementos
        * Source: Fuente
        * Agregacion de Operaciones
        * Pipelining: Tuberias
        * Iteracion interna
     */

    // Insertar una array de  5 numeros y filtrar por los numeros pares, utiliza filter
    public static List<Integer> insertNumFilter(){
        List<Integer> numList = new ArrayList<Integer>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);

        return numList.stream().filter(i -> i%2 == 0).toList();
    }

    // Generar una lista de estudiantes donde se muestren solo el id y las notas de los estudiantes
    // antes y despues del dia de gracia
    public static String listStundentBeforeAfter (){
        List<Student> studentListBefore = new ArrayList<>();
        studentListBefore.add(new Student("1", "Ariel", 78));
        studentListBefore.add(new Student("2", "Bruno",     85));
        studentListBefore.add(new Student("3", "Carla",     92));
        studentListBefore.add(new Student("4", "Diego",     67));
        studentListBefore.add(new Student("5", "Elena",     74));
        studentListBefore.add(new Student("6", "Fernando",  88));
        studentListBefore.add(new Student("7", "Gabriela",  95));
        studentListBefore.add(new Student("8", "Hugo",      81));
        studentListBefore.add(new Student("9", "Isabel",    69));
        studentListBefore.add(new Student("10","Javier",    90));

        List<Student> studentListAfter = studentListBefore
                .stream()
                .map(s -> new Student(
                        s.getId(),
                        s.getNombre(),
                        s.getNote() + 6
                )).toList();

        StringBuilder sb = new StringBuilder();
        sb.append("Antes\tDespues\n");
        String body = IntStream.range(0, studentListBefore.size()).
                mapToObj(i -> {
                    Student a = studentListBefore.get(i);
                    Student b = studentListAfter.get(i);
                    return String.format("%s (%d)\t%s (%d)",
                            b.getNombre(), b.getNote(),
                            a.getNombre(), a.getNote());
                }).collect(Collectors.joining("\n"));

        return sb + body;
    }

    // Realiza una funcion que convierta las palabras que tenga longitud de 5 en mayusculas

    public static List<String>
    upperAndFilterWords(Stream<String> listWords, int length){
        return listWords.filter(s -> s.length() == length).
                map(String::toUpperCase).toList();
    };

    public static String upperStrings(){
        String pathWords = "C:/Proyectos/study/7-semester/programacion-avanzada-3/Repaso/src/aditional/words.txt";
        final int lengthWord = 5;
        String result;
        try (Stream<String> lines
                = Files.lines(Paths.get(pathWords))){

            List<String> filterdStrings
                    = upperAndFilterWords(lines, lengthWord);
            result = "Texto con longitud 5 filtrado y colocado en mayusculas"
                    + filterdStrings;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return result;
    }

}
