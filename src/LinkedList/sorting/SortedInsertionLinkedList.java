package LinkedList.sorting;

public class SortedInsertionLinkedList {

    public static void main(String args[]) {
        // Create a linked list using MyLinkedList<Integer>
        MyLinkedList<Integer> mine = new MyLinkedList<Integer>();
        // Insert 10 ints
        for (int i = 0; i < 10; i++) {
            int insert = (int) (100 * Math.random());
            System.out.println("inserting " + insert);
            mine.insert(insert);
        }

        //Print the whole list
        mine.print();
    }

}
