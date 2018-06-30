package sort.bubbleSort.efficient;

public class TestBubbleSort {

    /*
      Notice the difference on the number of Iterations.
      The "Traditional Bubble Sort" always performs 21 iterations.
      If the array is already sorted, the Optimized algorithm
      and the "More optimized" algorithm perform 6 iterations
      With {7,5,1,2,3,6,4}
      Both the Optimized and the "more optimized" algorithm
      perform 18 iterations
      However, with {2,3,4,1,5,6,7}
      the optimised algorithm performs 18 iterations
      whilst the "more optimised one"
      performs only 9
    */
    /* This is the algorithm from the video */
    public static void bubbleSort(int[] a) {
        int n = a.length;
        int num_iter = 0;
        int nSwaps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                num_iter++;
                if (a[j - 1] > a[j]) {
                    nSwaps++;
                    swap(a, j - 1, j);
                }
            }
        }
        System.out.println("Num iterations: " + num_iter + " Num Swaps: " + nSwaps);
    }

    public static void bubbleSortOptimized(int[] a) {
        int n = a.length;
        boolean swapped = true;
        int i = 0;
        int num_iter = 0;
        int nSwaps = 0;
        while ((i < n) && (swapped == true)) {
            swapped = false;
            for (int j = 1; j < (n - i); j++) {
                num_iter++;
                if (a[j - 1] > a[j]) {
                    nSwaps++;
                    swap(a, j - 1, j);
                    swapped = true;
                }
            }
            i++;
        }
        System.out.println("Num iterations: " + num_iter + " Num Swaps: " + nSwaps);
    }

    /* Possible solution to the exercise */
    public static void bubbleSortMoreOptimized(int[] a) {
        int n = a.length;
        int m;
        int nSwaps, num_iter;
        nSwaps = 0;
        num_iter = 0;
        while (n != 0) {
            m = 0;
            for (int i = 0; i < n - 1; i++) {
                num_iter++;
                if (a[i] > a[i + 1]) {
                    nSwaps++;
                    swap(a, i, i + 1);
                    m = i + 1;
                }
            }
            n = m;
        }
        System.out.println("Num iterations: " + num_iter + " Num Swaps: " + nSwaps);
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

        System.out.println("**********************************************");
        int array[] = {7, 5, 1, 2, 3, 6, 4};

        System.out.print("\t\t\tUnsorted Array: ");
        print(array);

        System.out.print("Traditional Bubble Sort: ");
        bubbleSort(array);
        System.out.print("\t\t\tFinal Output Bubble Sort: ");
        print(array);

        array = new int[]{7, 5, 1, 2, 3, 6, 4};

        System.out.print("Optimised Bubble Sort: ");
        bubbleSortOptimized(array);
        System.out.print("\t\t\tFinal Output Optimised Bubble Sort: ");
        print(array);

        array = new int[]{7, 5, 1, 2, 3, 6, 4};

        System.out.print("More Optimised Bubble Sort: ");
        bubbleSortMoreOptimized(array);
        System.out.print("\t\t\tFinal Output Optimised Bubble Sort: ");
        print(array);
        System.out.println("**********************************************");

        array = new int[]{2, 3, 4, 1, 5, 6, 7};
        System.out.print("\t\t\tUnsorted Array: ");
        print(array);

        System.out.print("Traditional Bubble Sort: ");
        bubbleSort(array);
        System.out.print("\t\t\tFinal Output Bubble Sort: ");
        print(array);

        array = new int[]{2, 3, 4, 1, 5, 6, 7};

        System.out.print("Optimised Bubble Sort: ");
        bubbleSortOptimized(array);
        System.out.print("\t\t\tFinal Output Optimised Bubble Sort: ");
        print(array);

        array = new int[]{2, 3, 4, 1, 5, 6, 7};

        System.out.print("More Optimised Bubble Sort: ");
        bubbleSortMoreOptimized(array);
        System.out.print("\t\t\tFinal Output Optimised Bubble Sort: ");
        print(array);
        System.out.println("**********************************************");

        array = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.print("\t\t\tUnsorted Array: ");
        print(array);

        System.out.print("Traditional Bubble Sort: ");
        bubbleSort(array);
        System.out.print("\t\t\tFinal Output Bubble Sort: ");
        print(array);

        array = new int[]{1, 2, 3, 4, 5, 6, 7};

        System.out.print("Optimised Bubble Sort: ");
        bubbleSortOptimized(array);
        System.out.print("\t\t\tFinal Output Optimised Bubble Sort: ");
        print(array);

        array = new int[]{1, 2, 3, 4, 5, 6, 7};

        System.out.print("More Optimised Bubble Sort: ");
        bubbleSortMoreOptimized(array);
        System.out.print("\t\t\tFinal Output Optimised Bubble Sort: ");
        print(array);
    }
}
