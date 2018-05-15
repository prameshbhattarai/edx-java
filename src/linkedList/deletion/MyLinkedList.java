package linkedList.deletion;

public class MyLinkedList<E> {

    private Node<E> first;

    public MyLinkedList() {
        this.first = null;
    }

    /*
     * Insertion at the beginning
     */
    public void insert(E info) {
        Node<E> newNode = new Node<E>(info);
        newNode.setNext(first);
        first = newNode;
    }

    /*
     * Delete the first occurrence of a value
     * Return a boolean stating if the delete was successful
     */
    public boolean deleteFirstOccurrence(E info) {
        boolean success = false;
        Node<E> current = first;
        if(current.getInfo() == info) {
            first = current.getNext();
            success = true;
        } else {
            Node<E> nextNode = current.getNext();
            while(nextNode != null) {
                if(nextNode.getInfo() == info) {
                    Node<E> nextToNextNode = nextNode.getNext();
                    current.setNext(nextToNextNode);
                    success = true;
                }
                current = nextNode;
                nextNode = nextNode.getNext();
            }
        }
        return success;
    }

    /*
     * Delete all the occurrences of a value
     * Returns the number of deleted nodes
     * You can use deleteFirstOccurrence
     */
    public int deleteAll(E info) {
        int number = 0;
        while(deleteFirstOccurrence(info)) {
            number++;
        }
        return number;
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
