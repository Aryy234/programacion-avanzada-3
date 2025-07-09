import java.util.List;
import java.util.function.Function;

public interface Transformar<T,R> {
        List<R> transformar(List<T> lista, Function<T, R> fun);
}
