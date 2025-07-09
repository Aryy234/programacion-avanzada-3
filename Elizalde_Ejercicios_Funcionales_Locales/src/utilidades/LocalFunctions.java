package utilidades;

import java.util.List;
import java.util.function.Function;

public class LocalFunctions {

    
      public <T> Result<T> ifElse_(List<Boolean> conditions, List<T> ifTrue) {
        Function<Tuple<Boolean, T>, Boolean> f1 = y -> y._1;

        Function<List<Tuple<Boolean, T>>, Result<Tuple<Boolean, T>>> f2 = 
            x -> EnhancedList.of(x).first(f1);

        Function<Tuple<Boolean, T>, T> f3 = x -> x._2;
    
        return EnhancedList.of(conditions).zip(ifTrue)
            .flatMap(f2)
            .map(f3);
    }

    
    /**
     * Método que devuelve el valor correspondiente al primer false en la lista de condiciones.
     * @param <T> Tipo de los valores de retorno
     * @param conditions Lista de condiciones booleanas
     * @param ifFalse Lista de valores asociados a las condiciones
     * @return El valor correspondiente a la primera condición falsa
     */
    
    public <T> Result<T> ifElseFalse_(List<Boolean> conditions, List<T> ifFalse) {
        Function<Tuple<Boolean, T>, Boolean> f1 = y -> !y._1; // Negamos la condición para buscar false
        
        Function<List<Tuple<Boolean, T>>, Result<Tuple<Boolean, T>>> f2 = 
            x -> EnhancedList.of(x).first(f1);
            
        Function<Tuple<Boolean, T>, T> f3 = x -> x._2;
        
        return EnhancedList.of(conditions).zip(ifFalse)
            .flatMap(f2)
            .map(f3);
    }
}