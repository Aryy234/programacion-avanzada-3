package utils;

import java.util.function.Consumer;
import java.util.function.Function;

public sealed interface Lista <T> permits Empty, Const{

    T head();
    boolean isEmpty();
    Lista<T> tail();
    static <T> Lista<T> empty() {
        return new Empty<T>();
    }

    public static <T> Lista<T> of(T head, Lista<T> tail) {
        return new Const<>(head, tail);
    }

    @SafeVarargs
    public static<T> Lista<T> of(T ... values){
        Lista<T> fin = new Empty<T>();
        for(int i = values.length - 1; i >= 0; i--){
            Lista<T> tmp = Lista.of(values[i], fin);
            fin = tmp;
        }
        return fin;
    }


    // Implementación alternativa de append utilizando fold
    // Sería: return this.invert().prepend(elem).invert();
    /*
    default public Lista<T> append(T elem){
        return this.invert().prepend(elem).invert();
    }
    */

    default public Lista<T> prepend(T elem){
        return Lista.of(elem, this);
    }

    default Lista<T> invert (){
        var tmp = this;
        Lista<T> res = Lista.empty();
        while(!tmp.isEmpty()){
            res = Lista.of(tmp.head(), res);
            tmp = tmp.tail();
        }
        return res;
    }

    default Lista<T> removeFirst(){
        return this.tail();
    }
    default void forEach (Consumer<T> con){
        if (!this.isEmpty()) {
            con.accept(this.head());
            this.tail().forEach(con);
        }
    }

    default int count(){
        return isEmpty()? 0: 1 + tail().count();
    }

    default <U> Lista<U> map(Function<T,U> fn){
//        var tmp = this;
//        Lista<U> tmpLis = Lista.empty();
//        while(!tmp.isEmpty()){
//            var u = fn.apply(tmp.head());
//            tmpLis = tmpLis.prepend(u);
//            tmp = tmp.tail();
//        }
//        return tmpLis.invert();
        return this.isEmpty()? Lista.empty():
                Lista.of(fn.apply(this.head()), this.tail().map(fn));
    }

    default <U> Lista<U> mapFold(Function<T, U> fn){
        Lista<U> empty = Lista.empty();
        return fold(empty, acc -> elem -> acc.prepend(fn.apply(elem))).invert();
    }

    default <U> Lista<U> mapFoldRigth(Function<T,U> fn){
        Lista<U> empty = Lista.empty();
        return foldRigth(empty, t -> ls -> ls.prepend(fn.apply(t)));
    }


    default T reduce(T valInit, Function<T,Function<T,T>> fn){
        T acum = valInit;
        var tmp = this;
        while(!tmp.isEmpty()){
            acum = fn.apply(acum).apply(tmp.head());
            tmp = tmp.tail();
        }
        return acum;
    }

    default T reduce(Function<T, Function<T, T>> fn){
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Lista vacía, no se puede reducir");
        }
        return this.tail().fold(this.head(),
                acc -> elem -> fn.apply(acc).apply(elem));
    }

    default <U> U fold(U valInit, Function<U, Function<T, U>> fn) {
        U acum = valInit;
        var tmp = this;
        while (!tmp.isEmpty()) {
            acum = fn.apply(acum).apply(tmp.head());
            tmp = tmp.tail();
        }
        return acum;
    }

    default <U> U foldRigth(U valInit, Function<T,Function<U, U>> fn ){
        return this.isEmpty()?
                valInit
                : fn.apply(this.head()).apply(this.tail().foldRigth(valInit, fn));
    }

    default Lista<T> invertFold() {
        Lista<T> empty = Lista.empty();
        return this.fold(empty, acc-> elem -> acc.prepend(elem));
    }

    default Lista<T> append(T elem){
        return this.isEmpty() ? 
            Lista.of(elem, Lista.empty()) : 
            Lista.of(head(), tail().append(elem));
    }

    default Lista<T> extraerElement(int n){
        if (n < 0) {
            throw new IllegalArgumentException("n debe ser mayor o igual a 0");
        }
        Lista<T> empty = Lista.empty();
        return fold(empty,
                ls -> t -> ls.count() < n ? ls.append(t) : ls);
    }

    default String toStringRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        var tmp = this;
        while (!tmp.isEmpty()) {
            sb.append(tmp.head());
            tmp = tmp.tail();
            if (!tmp.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    default int countFold() {
        return this.<Integer>fold(0, acc -> elem -> acc + 1);
    }
}

final class Empty<T> implements Lista<T>{
    @Override
    public T head() {
        throw new IllegalStateException("No se puede obtener el head de una lista vacía");
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Lista<T> tail() {
        throw new IllegalStateException("No se puede obtener el tail de una lista vacía");
    }
}

record Const<T>(T head, Lista<T> tail) implements Lista<T> {

    @Override
    public T head() {
        return head;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Lista<T> tail() {
        return tail;
    }
}