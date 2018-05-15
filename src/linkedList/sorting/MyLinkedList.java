package linkedList.sorting;

public class MyLinkedList<E extends Comparable<E>> {
    // Notice that stating E extends Comparable<E> is needed, as we should use
    // compareTo for inserting in a sorted way
    private Node<E> first;

    public MyLinkedList() {
        this.first = null;
    }

    /*
     * Insertion at the beginning
     * Change this method to insert the values in a sorted way
     */

    public void insert(E info) {
        Node<E> newNode = new Node<E>(info);
        if (first == null || first.getInfo().compareTo(info) <= 0) {
            newNode.setNext(first);
            first = newNode;
        } else {
            Node<E> nextNode = first, prevNode = null;
            while (nextNode.getInfo().compareTo(info) > 0) {
                prevNode = nextNode;
                nextNode = nextNode.getNext();
                if (nextNode == null) {
                    break;
                }
            }
            prevNode.setNext(newNode);
            newNode.setNext(nextNode);
        }
    }

    /*
     * Extraction of the first node
     */
    public E extract() {
        E data = null;
        if (first != null) {
            data = first.getInfo();
            first = first.getNext();
        }
        return data;
    }

    /*
     * Print all list
     */
    public void print() {
        Node<E> current = first;

        while (current != null) {
            System.out.print(current.getInfo() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
