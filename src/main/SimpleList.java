package main;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public interface SimpleList extends List<Object> {
    Object get(int index);
    Object set(int index, Object element);
    void add(int index, Object element);
    Object remove(int index);
    int size();
    boolean isEmpty();
    boolean add(Object o);
    boolean remove(Object o);
    void clear();
    boolean contains(Object o);
    Object[] toArray();
    boolean containsAll(Collection<?> c);
    boolean addAll(Collection<?> c);
    boolean removeAll(Collection<?> c);
    boolean retainAll(Collection<?> c);
    int indexOf(Object o);
    int lastIndexOf(Object o);

    //////////
    default Iterator<Object> iterator() {
        throw new UnsupportedOperationException("Not Implemented");
    };

    default <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not Implemented");
    };    

    default boolean addAll(int index, Collection<?> c) {
        throw new UnsupportedOperationException("Not Implemented");
    };    

    default void replaceAll(UnaryOperator<Object> operator) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    default void sort(Comparator<? super Object> c) {
        throw new UnsupportedOperationException("Not Implemented");
    }    

    default ListIterator<Object> listIterator() {
        throw new UnsupportedOperationException("Not Implemented");
    };

    default ListIterator<Object> listIterator(int index) {
        throw new UnsupportedOperationException("Not Implemented");
    };

    default List<Object> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException("Not Implemented");
    };

    default Spliterator<Object> spliterator() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    default boolean removeIf(Predicate<? super Object> filter) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    default Stream<Object> stream() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    default Stream<Object> parallelStream() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    default void forEach(Consumer<? super Object> action) {
        throw new UnsupportedOperationException("Not Implemented");
    }
}
