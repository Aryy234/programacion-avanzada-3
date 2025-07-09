package utilidades;

import java.util.function.Function;

/**
 * Clase genérica para representar un resultado que puede contener un valor de tipo T.
 * @param <T> Tipo de dato que contiene el resultado
 */
public class Result<T> {
    private final T value;
    
    public Result(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    /**
     * Aplica una función al valor contenido en este Result y retorna un nuevo Result
     * con el resultado de aplicar la función.
     * @param <R> Tipo de retorno de la función
     * @param mapper La función a aplicar
     * @return Un nuevo Result con el resultado de aplicar la función
     */
    public <R> Result<R> map(Function<T, R> mapper) {
        return new Result<>(mapper.apply(value));
    }
    
    /**
     * Representación del Result como String
     */
    @Override
    public String toString() {
        return "Result{" + value + "}";
    }
}
