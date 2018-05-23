import java.util.Stack;

public class Main {

    void test(Stack<Integer> s1) {
        Stack<String> s2 = new Stack<String>();
        int a = 0;
        while (!s1.isEmpty()) {
            int b = s1.pop();
            if(b>a) {
                s2.push("*");
            } else if(b<a) {
                s2.push("-");
            }
            a = b;
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop());
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Main o = new Main();
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(3);
        s.push(5);
        s.push(6);
        s.push(2);
        s.push(2);
        o.test(s);
    }
}
