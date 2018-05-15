package arraysTest;

public class arrayTest {

    private static void print(String name, int a[]) {
        System.out.print(name + " = [");
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length - 1] + "]");
    }

    private static int indexMin(int[] array) {
        int var = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[var]) {
                var = i;
            }
        }
        return var;
    }

    private static int min(int[] array) {
        int var = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < var) {
                var = array[i];
            }
        }
        return var;
    }

    public static void main(String args[]) {
        int[] arrayA = new int[]{0, 1, 2, 3, 4, 5};
        int[] arrayB = new int[10];

        for (int i = 0; i < 10; i++) {
            arrayB[i] = (int) (Math.random() * 100);
        }

        print("A", arrayA);
        // This sentence behaves exactly the same as the previous method call
        System.out.println("A = " + java.util.Arrays.toString(arrayA));
        print("B", arrayB);
        System.out.println("B = " + java.util.Arrays.toString(arrayB));

        System.out.println("min(A) = " + min(arrayA));
        System.out.println("indexMin(A) = " + indexMin(arrayA));

        System.out.println("min(B) = " + min(arrayB));
        System.out.println("indexMin(B) = " + indexMin(arrayB));
    }
}
