package deque.linkedList;

public interface Dqueue {

    void insertFirst(Object obj);

    void insertLast(Object obj);

    Object removeFirst();

    Object removeLast();

    int size();
}
