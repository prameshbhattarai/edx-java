package sort.quickSort.anotherPivot;

public class TestQuickSort {

    /* Lomuto Partition */
    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low;
        for (int j = low; j <= (high - 1); j++) {
            if (a[j] <= pivot) {
                System.out.print(i + " <-> " + j + ": ");
                swap(a, i, j);
                print(a);
                i = i + 1;
            }
        }
        System.out.print(i + " <-> " + high + ": ");
        swap(a, i, high);
        print(a);
        return i;
    }

    /* Lomuto Partition */
    private static int partitionMed(int[] a, int low, int high) {

        int middle = (low + high) / 2;
        /* Swap here only the elements placed at
        low, high and middle to obtain:
        the smallest placed at the position low,
        the highest placed at position high,
        the one at the middle placed at position middle
        */

        /*Your code here*/
        if (a[middle] < a[low]) {
            System.out.print(middle + " <-> " + low + ": ");
            swap(a, low, middle);
            print(a);
        }
        if (a[high] < a[low]) {
            System.out.print(high + " <-> " + low + ": ");
            swap(a, low, high);
            print(a);
        }
        if (a[high] < a[middle]) {
            System.out.print(middle + " <-> " + high + ": ");
            swap(a, middle, high);
            print(a);
        }
        /*Once done that, swap the element at the position middle
        with high-1*/
        System.out.print(middle + " <-> " + (high - 1) + ": ");
        swap(a, middle, high - 1);
        print(a);
        /*Your code here*/

        /* We will use high-1 as pivot*/
        int pivot = a[high - 1];
        /* We will start the loop at low+1*/
        int i = low + 1;
        /* And we will finish the loop at high-2 */
        for (int j = low + 1; j <= (high - 2); j++) {
            if (a[j] <= pivot) {
                System.out.print(i + " <-> " + j + ": ");
                swap(a, i, j);
                print(a);
                i = i + 1;
            }
        }
        System.out.print(i + " <-> " + (high - 1) + ": ");
        /* We swap i with high-1, the one chosen as pivot */
        swap(a, i, high - 1);
        print(a);
        return i;
    }

    private static void quicksort(int[] a, int low, int high) {
        int p;
        if ((a == null) || (a.length == 0))
            return;
        if (low >= high)
            return;
        if (low < high) {
            p = partition(a, low, high);
            quicksort(a, low, p - 1);
            quicksort(a, p + 1, high);
        }
    }

    /*It is exactly the same method as the previous one,
        but invoking quicksortMed and partitionMed*/
    private static void quicksortMed(int[] a, int low, int high) {
        int p;
        if ((a == null) || (a.length == 0))
            return;
        if (low >= high)
            return;
        if (low < high) {
            p = partitionMed(a, low, high);
            quicksortMed(a, low, p - 1);
            quicksortMed(a, p + 1, high);
        }
    }

    public static void quicksorting(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    /*It is exactly the same method as the previous one, but invoking quicksortMed*/
    public static void quicksortingMedian(int[] a) {
        quicksortMed(a, 0, a.length - 1);
    }

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

    public static void main(String args[]) {

        int array[] = {7, 5, 4, 3, 6, 2, 1};
        System.out.println("***************************************");
        System.out.println("Selecting as pivot the one at the highest position");
        System.out.println("***************************************");
        System.out.print("Unsorted Array: ");
        print(array);
        quicksorting(array);
        System.out.println("Quicksort. Sorted Array: ");
        print(array);
        System.out.println("***************************************");
        array = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.print("Unsorted Array: ");
        print(array);
        quicksorting(array);
        System.out.println("Quicksort. Sorted Array: ");
        print(array);

        System.out.println("***************************************");
        System.out.println("Selecting as pivot the one the median between the highest, the one at the middle and the lowest position");
        System.out.println("***************************************");
        array = new int[]{7, 5, 4, 3, 6, 2, 1};
        System.out.print("Unsorted Array: ");
        print(array);
        quicksortingMedian(array);
        System.out.println("Quicksort. Sorted Array: ");
        print(array);
        System.out.println("***************************************");
        array = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.print("Unsorted Array: ");
        print(array);
        quicksortingMedian(array);
        System.out.println("Quicksort. Sorted Array: ");
        print(array);
    }
}
