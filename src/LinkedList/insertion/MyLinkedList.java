package LinkedList.insertion;

public class MyLinkedList<E> {

    private Node<E> first;

    public MyLinkedList() {
        this.first = null;
    }

    // this method will insert in stack way
    // on top of other
    /*
     * Insertion at the beginning
     */
    public void insert(E info) {
        Node<E> newNode = new Node<E>(info);
        newNode.setNext(first);
        first = newNode;
    }

    /*
     * Insertion at the end
     * Implement this method
     */
    public void insertEnd(E info) {
        if(first == null) {
            first = new Node<E>(info);
        } else {
            Node<E> current = first;
            while(current != null) {
                if(current.getNext() == null) {
                    current.setNext(new Node<E>(info));
                    return;
                }
                current = current.getNext();
            }
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
