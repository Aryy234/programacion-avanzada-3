package com.utils;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
 
public sealed interface ListaSealedMapFoldingReduce<T> permits Const, Empty {
	T head();
	ListaSealedMapFoldingReduce<T> tail();
	boolean isEmpty();
	ListaSealedMapFoldingReduce Empty = new Empty();
	public static<T> ListaSealedMapFoldingReduce<T> of(T head, ListaSealedMapFoldingReduce<T> tail){
		return new Const(head, tail);
	}
    
    @SafeVarargs
	public static<T> ListaSealedMapFoldingReduce<T> of(T... values){
		ListaSealedMapFoldingReduce<T> fin = Empty;
		for(int i = values.length-1; i >= 0; i--) {
			ListaSealedMapFoldingReduce<T> tmp = ListaSealedMapFoldingReduce.of(values[i], fin);
			fin = tmp;
		}
		return fin;
	}
	default ListaSealedMapFoldingReduce<T> invert(){
		var tmp = this;
		ListaSealedMapFoldingReduce<T> ret = Empty;
		while(!tmp.isEmpty()) {
			ret = ListaSealedMapFoldingReduce.of(tmp.head(), ret);
			tmp = tmp.tail();
		}
		return ret;
	}

	default ListaSealedMapFoldingReduce<T> invertFold() {
		return fold(ListaSealedMapFoldingReduce.Empty, ls -> ls.prepend(t));
	}

	default Integer countFold(){
		return fold(0, count -> head -> count + 1);
	}

    // realizar el remoeveFirst
	default ListaSealedMapFoldingReduce<T> removeFirst(){
		return this.tail();
	}

	//IMPORTANTE
	default T reduce(T valInit, Function<T, Function<T, T>> fn) {
		T acum = valInit;
		var tmp = this;
		while(!tmp.isEmpty()){
			acum = fn.apply(acum).apply(tmp.head());
			tmp = tmp.tail();
		}
		return acum;
	}

	//IMPORTANTE
	default <U> U fold(U valInit, Function<U, Function<T, U>> fn) {
		U acum = valInit;
		var tmp = this;
		while(!tmp.isEmpty()){
			acum = fn.apply(acum).apply(tmp.head());
			tmp = tmp.tail();
		}
		return acum;
	}
	

	default void forEach(Consumer<T> con) {
		if(!this.isEmpty()) {
			con.accept(this.head());
			this.tail().forEach(con);
		}
	}
	default ListaSealedMapFoldingReduce<T> prepend(T value){
		return ListaSealedMapFoldingReduce.of(value, this);
	}

	default ListaSealedMapFoldingReduce<T> append(T value){
		return this.invert().prepend(value).invert();
		/*return this.isEmpty()?
				Lista.of(value):
					Lista.of(head(), tail().append(value));*/
	}
	default int count() {
		return isEmpty()? 0: 1 + tail().count();
	}

    default <U> ListaSealedMapFoldingReduce<U> map(Function<T,U> fn){
        // var tmp = this;
        // Lista<U> tmpLis = Lista.Empty;
        // while(!tmp.isEmpty()){
        //     var u = fn.apply(tmp.head());
        //     tmpLis = tmpLis.prepend(u);

        // }
        // return tmpLis.invert();

        return this.isEmpty()
            ? ListaSealedMapFoldingReduce.Empty
            : ListaSealedMapFoldingReduce.of(fn.apply(head()), tail().map(fn));
    }
}
record Const<T>(T head, ListaSealedMapFoldingReduce<T> tail) implements ListaSealedMapFoldingReduce<T>{
 
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String toString() {
		return String.format("[%s,%s]", head,tail);
	}
}
final class Empty implements ListaSealedMapFoldingReduce {
 
	@Override
	public Object head() {
		return null;
	}
 
	@Override
	public ListaSealedMapFoldingReduce tail() {
		return null;
	}
	@Override
	public boolean isEmpty() {
		return true;
	}
	@Override
	public String toString() {
		return "Empty";
	}
}
