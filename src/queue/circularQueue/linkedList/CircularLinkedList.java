package queue.circularQueue.linkedList;

public class CircularLinkedList {

    // in a circle there is no "first", so we change the name
    private Node position;

    // a list is always created in an empty state
    protected CircularLinkedList() {
        position = null;
    }

    // if we need position in classes that extend this one
    protected Node getPosition() {
        return position;
    }

    // simple and self-explained code. Worth to reuse it
    public boolean isEmpty() {
        if (position == null)
            return true;
        else
            return false;
    }

    // we insert after position, just because we had
    // to decide where to insert, but no special reason
    public void insert(Object o) {
        if (isEmpty()) {
            // in a list with a single node, the "next" reference
            // links the node to itself
            position = new Node(o, null);
            position.setNext(position);
        } else {
            // we cannot left null "next" references
            Node tmp = new Node(o, position.getNext());
            position.setNext(tmp);
        }
    }

    public Object extract() {
        // look carefully which value is returned in each case
        //
        // 1 - if the list is empty, return null
        // 2 - if the list has only one value,
        // return the value and state that the list is empty
        // 3 - if the list has more than one value,
        // return the value that is next to 'position' and
        // the Node that contained the returned Object.
        //
        // Look that in the third case, instead of returning the value of
        // position, it is returned the next in the list. Why? Because it was
        // easier to implement, nothing else. (draw it for a better understanding)
        Object out = null;
        if (!isEmpty() && position.getNext() == position) {
            out = position.getInfo();
            position = null;
        } else if (!isEmpty() && position.getNext() != position) {
            out = position.getNext().getInfo();
            position.setNext(position.getNext().getNext());
        }
        return out;
    }

    public static CircularLinkedList getExample() {
        CircularLinkedList out = new CircularLinkedList();

        // a random int value from 0 to 9 (random never returns 1)
        int numberOfElements = (int) (Math.random() * 10);

        // the list is filled with Integer values
        //
        // note: the Integer class is the object oriented representation of a int
        // value
        for (int i = 0; i < numberOfElements; i++) {
            // the value ranges from -25 to 25
            int value = (int) (Math.random() * 51) - 25;
            out.insert(new Integer(value));
        }
        // printing this to stdout is not required. I do it just to track the code
        System.out.println("Generada una CircularLinkedList de " + numberOfElements
                + " elementos");
        return out;
    }

    public String toString() {
        // I could have reused size() and just do a loop,
        // but it would have been so boring...
        String out = "";
        Node tmp = getPosition();
        if (tmp == null) {
            return null;
        } else if (tmp.getNext() == tmp) {
            return tmp.getInfo().toString();
        } else {
            do {
                out = out + tmp.getInfo().toString() + " ";
                tmp = tmp.getNext();
            } while (tmp != getPosition());
        }
        return out.trim();
    }

    public int size() {
        int out = 0;
        if (!isEmpty()) {
            if (getPosition() == getPosition().getNext()) {
                out = 1;
            } else {
                Node tmp = getPosition();
                do {
                    tmp = tmp.getNext();
                    out++;
                } while (tmp != getPosition());
            }
        }
        return out;
    }

    public Object[] toArray() {

        // pay attention to the initialization of the array
        Object[] out = new Object[size()];

        Node tmp = getPosition();
        for (int i = 0; i < out.length; i++) {
            out[i] = tmp.getInfo();
            tmp = tmp.getNext();
        }
        return out;
    }

    public MySimpleLinkedList toSimpleLinkedList() {
        MySimpleLinkedList tmpList = new MySimpleLinkedList();
        MySimpleLinkedList out = new MySimpleLinkedList();
        int size = size();

        Node tmp = getPosition();
        for (int i = 0; i < size; i++) {
            tmpList.insert(tmp.getInfo());
            tmp = tmp.getNext();
        }

        // note that a SimpleLinkedList behaves like a Stack.
        // Then, we have to reverse it.
        for (int i = 0; i < size; i++) {
            out.insert(tmpList.extract());
        }
        return out;
    }
}
