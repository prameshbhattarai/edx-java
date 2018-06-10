package deque.linkedList;

public class DQQueue implements Queue {

    private Dqueue data;

    public DQQueue() {
        data = new DLDqueue();
    }

    public void enqueue(Object obj) {
        data.insertFirst(obj);
    }

    public Object dequeue() {
        return data.removeLast();
    }

    public int size() {
        return data.size();
    }

    public String toString() {
        return data.toString();
    }

    public static void main(String[] args) {
        DQQueue queue = new DQQueue();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println("Printing queue: " + queue);

        int s = queue.size();
        System.out.println("Printing size: " + queue.size());

        Object o = queue.dequeue();
        System.out.println("Deque element = " + o);

        System.out.println("Printing queue: " + queue);

    }
}
