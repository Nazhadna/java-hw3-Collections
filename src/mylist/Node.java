package mylist;

public class Node<E> {
    private E element;
    private Node<E> prevNode;
    private Node<E> nextNode;

    public Node(E element) {
        this.element = element;
    }

    public Node(E element, Node<E> prevNode, Node<E> nextNode) {
        this.element = element;
        this.prevNode = prevNode;
        this.nextNode = nextNode;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getPrevNode() {
        return prevNode;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setPrevNode(Node<E> prevNode) {
        this.prevNode = prevNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    public void unlinkAndClear() {
        if (prevNode != null)
            prevNode.setNextNode(nextNode);
        if (nextNode != null)
            nextNode.setPrevNode(prevNode);
        clear();
    }

    public void clear() {
        element = null;
        prevNode = null;
        nextNode = null;
    }
}
