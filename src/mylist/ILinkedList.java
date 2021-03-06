package mylist;

import java.util.Iterator;

public interface ILinkedList<E> extends Iterable<E> {
    void add(E element);
    void add(int index, E element);
    void clear();
    E get(int index);
    int indexOf(E element);
    void remove(int index);
    void set(int index, E element);
    int size();
    String toString();
    E[] toArray();
}
