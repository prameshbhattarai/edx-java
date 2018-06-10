package queue.linkedList;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> top;
    private Node<E> tail;
    private int size;

    public LinkedQueue() {
        top = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public E front() {
        E info;
        if (isEmpty()) {
            info = null;
        } else {
            info = top.getInfo();
        }
        return info;
    }

    public void enqueue(E info) {
        Node<E> n = new Node<E>(info, null);
        if (isEmpty()) {
            top = n;
        } else {
            tail.setNext(n);
        }
        tail = n;
        size++;
    }

    public E dequeue() {
        E info;
        if (!isEmpty()) {
            info = top.getInfo();
            top = top.getNext();
            size--;
            if (isEmpty()) {
                tail = null;
            }
        } else {
            info = null;
        }
        return info;
    }


    public static void main(String[] args) {
        LinkedQueue<Integer> q = new LinkedQueue<Integer>();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        System.out.println("Size: " + q.size());

        Integer e = q.front();
        System.out.println("Size: " + q.size());
        System.out.println(e);

        e = q.dequeue();
        e = q.dequeue();
        System.out.println("Size: " + q.size());

        e = q.dequeue();
        e = q.dequeue();
        e = q.dequeue();
        System.out.println("Size: " + q.size() + " isEmpty: " + q.isEmpty());


    }
}
