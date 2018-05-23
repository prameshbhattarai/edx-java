package stack.printStackRecursive;

public interface Stack<E> {

    boolean isEmpty();

    int size();

    void push(E info);

    E pop();

    E top();

}
