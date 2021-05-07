package mylist;

import java.lang.reflect.Array;
import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> startN;
    private Node<E> endN;
    private int size;

    public MyLinkedList() { }

    private boolean isIndex(int index) {
        return index >= 0 && index < size;
    }

    private Node<E> getNode(int index){
        Node<E> currentNode;
        if (index<size/2) {
            currentNode = startN;
            for (int i=0; i<index; i++)
                currentNode = currentNode.getNextNode();
        } else {
            currentNode = endN;
            for (int i=size-1; i>index; i--)
                currentNode = currentNode.getPrevNode();
        }
        return currentNode;
    }

    @Override
    public void add(E element) {
        Node<E> currentEndNode = endN;
        Node<E> newNode = new Node(element, currentEndNode, null);
        endN = newNode;
        if (currentEndNode == null)
            startN = newNode;
        else
            currentEndNode.setNextNode(newNode);
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (!isIndex(index))
            throw new IndexOutOfBoundsException();
        if (index == size) {
            add(element);
        } else if (index == 0) {
            Node<E> newNode = new Node<>(element, null, startN);
            startN.setPrevNode(newNode);
            startN = newNode;
            size++;
        } else {
            Node<E> movingNode = getNode(index);
            Node<E> newNode = new Node<>(element, movingNode.getPrevNode(), movingNode);
            movingNode.getPrevNode().setNextNode(newNode);
            movingNode.setPrevNode(newNode);
            size++;
        }
    }

    @Override
    public void clear() {
        for (Node<E> x = startN; x != null; ) {
            Node<E> next = x.getNextNode();
            x.clear();
            x = next;
        }
        startN = null;
        endN = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (!isIndex(index))
            throw new IndexOutOfBoundsException();
        return getNode(index).getElement();
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> x = startN; x != null; x = x.getNextNode()) {
                if (x.getElement() == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = startN; x != null; x = x.getNextNode()) {
                if (element.equals(x.getElement()))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if (!isIndex(index))
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            if (size == 1) {
                startN.clear();
                startN = null;
                endN = null;
            } else {
                Node<E> newStart = startN.getNextNode();
                startN.unlinkAndClear();
                startN = newStart;
            }
        } else if (index == size-1) {
            Node<E> newEnd = endN.getPrevNode();
            endN.unlinkAndClear();
            endN = newEnd;
        } else {
            getNode(index).unlinkAndClear();
        }
        size--;
    }

    @Override
    public void set(int index, E element) {
        if (!isIndex(index))
            throw new IndexOutOfBoundsException();
        getNode(index).setElement(element);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("MyLinkedList: ");
        for (E el: this)
            str.append(el + "; ");
        return str.toString();
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) Array.newInstance(startN.getElement().getClass(), size);
        int i = 0;
        for (E el: this)
            array[i++] = el;
        return array;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                Node<E> currentNode = getNode(currentIndex);
                currentIndex++;
                return currentNode.getElement();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
