package queue.circularQueue.linkedList;

public class CircularLinkedListTest {

    public static void printArray(Object[] o) {
        String s = "";
        for (int i = 0; i < o.length; i++) {
            s = s + o[i].toString() + " ";
        }
        System.out.println(s.trim());
    }

    public static void main(String args[]) {
        CircularLinkedList cll = CircularLinkedList.getExample();
        System.out.println(cll);
        System.out.println(cll.size());
        printArray(cll.toArray());
        System.out.println(cll.toSimpleLinkedList());
    }
}
