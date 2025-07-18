package util;

public interface Result<T> {
    void bind(Effect<T> success, Effect<T> failure);
    static <T> Result<T> success(T value){
        return new Success<>(value);
    }
    static<T> Result<T> failure(T mensaje){
        return new Failure<>(mensaje);
    }
}
class Success<T> implements Result<T>{
    private final T value;
    public Success(T t) {
        this.value = t;
    }
    @Override
    public void bind(Effect<T> success, Effect<T> failure) {
        success.apply(value);
    }
}
class Failure<T> implements Result<T>{
    private final T msg;
    public Failure(T msg) {
        this.msg = msg;
    }
    @Override
    public void bind(Effect<T> success, Effect<T> failure) {
        failure.apply(msg);
    }
}
