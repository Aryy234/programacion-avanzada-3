
package com.utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface ListUtils {

    public static <T> List<T> add(List<T> list, T element) {
        List<T> tmp = new ArrayList<T>(list);
        tmp.add(element);
        return Collections.unmodifiableList(tmp);
    }

    public static <T> List<T> remove(List<T> list, T element) {
        List<T> tmp = new ArrayList<T>(list);
        tmp.remove(element);
        return Collections.unmodifiableList(tmp);
    }

    public static <T> List<T> clear(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        tmp.clear();
        return Collections.unmodifiableList(tmp);
    }

    //Creacion de metodo, que devuelve una lista invertida
    public static <T> List<T> reverse(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        Collections.reverse(tmp);
        return Collections.unmodifiableList(tmp);
    }

    //Creacion de metodo prepend, que añade un elemento al principio de la lista
    //inverted list iterator
    public static <T> List<T> invertedL(List<T> list){
        List<T> temp = new ArrayList<T>();
        for (int i = list.size() - 1; i >= 0; i--) {
            temp.add(list.get(i));
        }
        return temp;
    }

    //Creacion de metodo append, que añade un elemento al final de la lista
    public static <T> List<T> append(T t, List<T> lis) {
        List<T> tmp = new ArrayList<T>(lis);
        tmp.add(t);
        for(var it: lis) {
            tmp.add(it);
        }
        return tmp;

    }

}
