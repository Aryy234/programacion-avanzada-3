package utilidades;

/**
 * Clase para representar una tupla de dos elementos.
 * @param <T1> Tipo del primer elemento
 * @param <T2> Tipo del segundo elemento
 */
public class Tuple<T1, T2> {
    public final T1 _1;
    public final T2 _2;
    
    public Tuple(T1 _1, T2 _2) {
        this._1 = _1;
        this._2 = _2;
    }
    
    @Override
    public String toString() {
        return "(" + _1 + ", " + _2 + ")";
    }
}
