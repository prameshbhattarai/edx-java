package stack;

import java.util.Stack;

public class RPNCalculator {

    /*
     * Implement a simple RPN calculator
     * with an Stack
     * this is a possible solution, others are
     * also possible
     */
    public static int calculate(String ops[]) {
        int result = 0;
        int x, y;
        String operators = new String("+-/*");
        Stack<Integer> mine = new Stack<Integer>();
        for (String op : ops) {
            if (!operators.contains(op)) {
                mine.push(Integer.parseInt(op));
            } else {
                x = mine.pop();
                y = mine.pop();
                switch (op) {
                    case "+":
                        mine.push(x + y);
                        break;
                    case "-":
                        mine.push(y - x);
                        break;
                    case "*":
                        mine.push(x * y);
                        break;
                    case "/":
                        mine.push(y / x);
                }
            }
        }
        if (!mine.empty())
            result = mine.pop();
        return result;
    }

    public static void main(String args[]) {
        /*
	     * The main program should print
	        5 3 + =8
            5 3 - = 2
            2 1 12 3 / - + = -1
            3 2 * 11 - = -5
	    */

        String[] argu = new String[]{"5", "3", "+"};
        int result = calculate(argu);
        System.out.println("5" + " 3" + " +" + " =" + result);
        result = calculate(new String[]{"5", "3", "-"});
        System.out.println("5" + " 3" + " -" + " = " + result);
        result = calculate(new String[]{"2", "1", "12", "3", "/", "-", "+"});
        System.out.println("2" + " 1" + " 12" + " 3" + " /" + " -" + " +" + " = " + result);
        result = calculate(new String[]{"3", "2", "*", "11", "-"});
        System.out.println("3" + " 2" + " *" + " 11" + " -" + " = " + result);

    }
}
