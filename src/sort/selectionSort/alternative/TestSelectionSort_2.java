package sort.selectionSort.alternative;

public class TestSelectionSort_2 {

    /*This implementation searches the biggest and places it on the right*/
    public static void selectionSort(int a[]) {
        int n = a.length;
        int numSwaps = 0;
        int numIter = 0;
        for (int i = 0; i < (n - 1); i++) {
            int m = 0;
            numSwaps++;
            System.out.println(numSwaps + ": storing the biggest at " + (n - i - 1));
            System.out.println("\t\t\tLooking for the biggest one from 0 to "
                    + (n - i - 2));
            System.out.println("\t\t\t\tThe biggest is a[" + m + "] = " + a[m]);
            for (int j = 1; j < (n - i); j++) {
                numIter++;
                if (a[j] > a[m]) {
                    m = j;
                    System.out.println("\t\t\t\tThe biggest is a[" + m + "] = " + a[m]);
                }
            }
            if (n - 1 - i != m) {
                swap(a, n - 1 - i, m);
                System.out.print("\t\t\tSwap " + numSwaps + "(" + (n - 1 - i) + "<->" + m + ")"
                        + ": ");
                print(a);
            }
        }
        System.out.println("Num swaps: " + numSwaps + " Num iterations: " + numIter);
    }

    /*
     Implement this method selecting the smallest one and placing it on the left
     and the largest and placing on the right in the same iteration */
    public static void selectionSortMinMax(int a[]) {
        int n = a.length;
        int numIter = 0;
        int numSwaps = 0;
        for (int i = 0; i < n - i; i++) {
            int mBig = 0;
            int mSmall = n - i - 1;
            System.out.println(i + ": storing the biggest at " + (n - i - 1));
            System.out.println(i + ": storing the smallest at " + (i));
            System.out.println("\t\t\t\tThe biggest is a[" + mBig + "] = " + a[mBig]);
            System.out.println("\t\t\t\tThe smallest is a[" + mSmall + "] = " + a[mSmall]);
            for (int j = i; j < (n - i); j++) {
                numIter++;
                if (a[j] > a[mBig]) {
                    mBig = j;
                    System.out.println("\t\t\t\tThe biggest is a[" + mBig + "] = " + a[mBig]);
                }
                if (a[j] < a[mSmall]) {
                    mSmall = j;
                    System.out.println("\t\t\t\tThe smallest is a[" + mSmall + "] = " + a[mSmall]);
                }
            }
            if (i != mSmall) {
                swap(a, i, mSmall);
                numSwaps++;
                System.out.print("\t\t\tSwap " + numSwaps + "(" + i + "<->" + mSmall + ")" + ": ");
                print(a);
            }
            /*
             * Here you should notice that if mBig== i you already changed
             * mSmall <-> i So, now mBig is located at mSmall
             */
            if (mBig == i) {
                mBig = mSmall;
            }
            if (n - i - 1 != mBig) {
                numSwaps++;
                swap(a, n - i - 1, mBig);
                System.out.print("\t\t\tSwap " + numSwaps + "(" + (n - 1 - i) + "<->" + mBig + ")" + ": ");
                print(a);
            }
        }
        System.out.println("Num swaps: " + numSwaps + " Num iterations: " + numIter);
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

        int array[] = {7, 5, 1, 2, 3, 6, 4};
        System.out.print("Unsorted Array: ");
        print(array);
        selectionSort(array);
        System.out.print("Final Output SelectionSort: ");
        print(array);
        /* Comment out the following lines to test your code */

        array = new int[]{7, 5, 1, 2, 3, 6, 4};
        System.out.print("Unsorted Array: ");
        print(array);
        selectionSortMinMax(array);
        System.out.print("Final Output SelectionSort: ");
        print(array);

        array = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.print("Unsorted Array: ");
        print(array);
        selectionSort(array);
        System.out.print("Final Output SelectionSort: ");
        print(array);
        /* Comment out the following lines to test your code */

        array = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.print("Unsorted Array: ");
        print(array);
        selectionSortMinMax(array);
        System.out.print("Final Output SelectionSort: ");
        print(array);
    }
}
