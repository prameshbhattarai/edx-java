package queue.circularQueue;

public class CircularArrayQueue {

    /**
     * Number of element in the queue
     */
    private int numElements;
    private int capacity;

    /**
     * Array to save elements
     **/
    private int elements[];

    /**
     * Indice to last element
     */
    private int head;
    private int tail;

    // Add one position and calculates if we must return the first position array.
    // Module operation (%) is very important for this.
    private int next(int pos) {
        return (pos + 1) % capacity;
    }


    /**
     * Constructor to init the state object
     */
    CircularArrayQueue(int capacity) throws QueueException {
        if (capacity <= 0) throw new QueueException("Capacity must be greater than 0");

        numElements = 0;
        tail = 0;
        head = 0;

        this.capacity = capacity;
        elements = new int[capacity];
    }

    /**
     * Insert an element in the queue
     */
    public void enqueue(int element) throws QueueException {
        if (this.isFull())
            throw new QueueException("Maximun queue capacity reached");
        elements[tail] = element;
        tail = next(tail);
        numElements++;
    }


    /**
     * Extract the element in the queue
     */
    public int dequeue() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Empty queue. You can't delete elements");

        int element;

        element = elements[head];
        head = next(head);
        numElements--;

        return element;
    }

    /**
     * Is empty the queue?
     */
    public boolean isEmpty() {
        return (tail == head);
    }

    /**
     * Is full the queue
     */
    public boolean isFull() {
        return (next(tail) == head);
    }

    /**
     * Returns the number of elements in the queue
     */
    public int numElements() {
        return this.numElements;
    }

    /**
     * Print the elements in the queue
     */
    public void print() {

        System.out.println("head: " + head + ", tail: " + tail + ", number of elements: " + this.numElements);

        // from head to tail
        int index = head;

        for (int count = 0; count < numElements; count++) {
            System.out.print(elements[index] + ".");
            index = next(index);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        try {
            CircularArrayQueue queue = new CircularArrayQueue(3);

            queue.enqueue(1);
            queue.enqueue(2);
            queue.print();

            int e = queue.dequeue();
            System.out.println(e);
            queue.print();

            queue.enqueue(3);
            queue.print();

            // queue.enqueue(4);
            e = queue.dequeue();
            System.out.println(e);
            queue.print();

            queue.enqueue(4);
            queue.print();

            e = queue.dequeue();
            e = queue.dequeue();
            queue.print();

            // e = queue.dequeue();

            queue.enqueue(1);
            queue.enqueue(2);
            queue.print();

        } catch (QueueException ex) {
            System.out.println(ex.getMessage());
        }

    } // main
}

/* Class Exception to manage errors */
class QueueException extends Exception {

    QueueException(String message) {
        super(message);
    }
}
