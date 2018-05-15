package linkedList.insertion;

public class CreateLinkedList {

    public static void main(String args[]) {
        // Create a linked list using MyLinkedList<Integer>
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();

        // Insert the first 10 ints at the beginning
        for (int i = 0; i < 10; i++) {
            myLinkedList.insert(i);
        }
        //Print the whole list
        myLinkedList.print();

        // Create another linked list using MyLinkedList<Integer>
        MyLinkedList<Integer> anotherLinkedList = new MyLinkedList<Integer>();

        // Insert 10 ints at the end
        for (int i = 0; i < 10; i++) {
            anotherLinkedList.insertEnd(i);
        }
        //Print the whole second list
        anotherLinkedList.print();

    }

}
