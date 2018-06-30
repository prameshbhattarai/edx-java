package sort.heapSort;

public class TestHeapSort {

    private static void swap(int a[], int pos1, int pos2) {
        int tmp = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = tmp;
    }

    private static void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static void printPiece(int a[], int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static void printHeap(int a[], int start, int end) {

        StringBuilder sb = new StringBuilder();
        int size = end - start + 1;
        int maxblank = 0;
        maxblank = (int) (Math.log(size) / Math.log(2));

        sb.append(" ");

        for (int i = 0; i <= maxblank; i++) {
            for (int j = 0; (j < Math.pow(2, i)) && (j + Math.pow(2, i) <= size); j++) {
                for (int k = 0; (k < maxblank / ((int) Math.pow(2, i))); k++) {
                    sb.append(" ");
                }
                sb.append(a[j + (int) Math.pow(2, i) - 1] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    /*We neeed to create a min-heap instead of a max-heap*/
    /*This method is unchanged*/
    public static void heapsort(int[] a) {
        int count = a.length;

        System.out.println("\tInitial Heap from: 0 to " + (count - 1));
        printHeap(a, 0, (count - 1));
        heapify(a, count);


        int end = count - 1;

        while (end > 0) {
            System.out.println("\tHeap from: 0 to " + end + " Min-heap order:");
            System.out.print("Array: ");
            printPiece(a, 0, end);
            System.out.println("Heap Representation: ");
            printHeap(a, 0, end);
            swap(a, 0, end);
            System.out.println("\t\tSwapped min value with last element of the heap: ");
            printHeap(a, 0, end);

            System.out.print("Sorted: [" + end + ", " + (count - 1) + "] :");
            printPiece(a, end, count - 1);

            siftDown(a, 0, end - 1);
            end--;
        }
    }

    /*This method remains unchanged */
    public static void heapify(int[] a, int count) {
        int start = (count - 2) / 2; //it is a binary heap
        while (start >= 0) {
            //sift down the node at index start to the proper place
            //such that all nodes below the start index are in max-heap
            //order
            siftDown(a, start, count - 1);
            start--;
        }
        //after sifting down the root all nodes/elements are in heap order
    }

    /* We need only to change this method */
    public static void siftDown(int[] a, int start, int end) {
        //end represents the limit of how far down the heap to sift
        int root = start;
        while ((root * 2 + 1) <= end) {
            int child = root * 2 + 1; // left child
            //if the child has a sibling and the child's value is less than
            //its sibling's...
            /* we change this line (the a[child] > a[child + 1])*/
            if (child + 1 <= end && a[child] > a[child + 1])
                child = child + 1; //right child
            /*and this line a[root] > a[child]*/
            if (a[root] > a[child]) {     //out of min-heap order
                swap(a, root, child);
                //repeat to continue sifting down the child now
                root = child;
            } else
                return;
        }
    }

    public static void main(String args[]) {

        int array[] = {7, 5, 1, 2, 3, 6, 4};
        System.out.print("Unsorted Array: ");
        print(array);
        heapsort(array);
        System.out.println("Heapsort. Sorted Array: ");
        print(array);
    }
}
