package LinkedList.linkedListHeadAndTail;

public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /*
     * Insertion at the beginning
     */
    public void insert(E info) {
        Node<E> newNode = new Node<E>(info);
        newNode.setNext(head);
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }
    /*
     * Insertion at the end
     * Implement this method
     */

    public void insertEnd(E info){
        Node<E> newNode = new Node<E>(info);
        Node<E> nextNode = head;
        Node<E> prevNode = null;
        if (head == null) {
            head = newNode;
        } else {
            while(nextNode != null) {
                prevNode = nextNode;
                nextNode = nextNode.getNext();
            }
            prevNode.setNext(newNode);
            tail = newNode;
        }
    }

    /*
     * Extraction of the first node
     */
    public E extract() {
        E data = null;
        if (head != null) {
            data = head.getInfo();
            head = head.getNext();
        }
        return data;
    }

    /*
     * Extraction of the last node
     * Implement this method
     */
    public E extractEnd() {
        E data = null;
        Node<E> current = head;
        while(current.getNext() != null) {
            if(current.getNext().getNext() == null) {
                data = current.getNext().getInfo();
                tail = current;
                tail.setNext(null);
                break;
            }
            current = current.getNext();
        }
        return data;
    }

    /*
     * Print all list
     */
    public void print() {
        Node<E> current = head;

        while (current != null) {
            System.out.print(current.getInfo() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
