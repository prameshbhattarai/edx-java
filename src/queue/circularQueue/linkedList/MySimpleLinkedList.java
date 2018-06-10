package queue.circularQueue.linkedList;

public class MySimpleLinkedList {

    // the reference to the first node is enough
    // to characterize a list
    protected Node first;

    // a list is created in an empty state
    public MySimpleLinkedList() {
        first = null;
    }

    // the new element is located before the
    // former first node
    public void insert(Object o) {

        // step by step code. Could be done in less lines
        // a node that stores the object and links nowhere
        Node tmp = new Node(o, null);

        // the following sentence has no problem with null values of "first"
        tmp.setNext(first);
        // we move the "first" reference
        first = tmp;
    }

    // extracts the first element and returns its object
    public Object extract() {
        Object out = null;

        // if first is null, you cannot call its methods
        if (!isEmpty()) {
            out = first.getInfo();
            first = first.getNext();
        }

        // if the list is empty, null should be returned, but this is
        // the default value of "out"
        return out;
    }

    public void print(int n) {
        // if the list is empty, do nothing
        if (!isEmpty()) {
            Node tmp = first;

            // iterates until i reaches n or the list is finished.
            for (int i = 0; i < n; i++) {
                tmp = tmp.getNext();
                if (tmp == null)
                    return; // the list is finished
            }
            System.out.println(tmp.getInfo());
        }
    }

    public void print() {
        // if the list is empty, do nothing
        if (!isEmpty()) {
            Node tmp = first;
            // iterates until the list is finished
            while (tmp != null) {
                System.out.println(tmp.getInfo());
                tmp = tmp.getNext();
            }
        }
    }

    public boolean isEmpty() {
        if (first == null)
            return true;
        else
            return false;
    }
}
