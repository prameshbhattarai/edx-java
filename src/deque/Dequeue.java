package deque;

public interface Dequeue {

    void insertFirst(Object obj);

    void insertLast(Object obj);

    Object removeFirst();

    Object removeLast();

    int size();
}
