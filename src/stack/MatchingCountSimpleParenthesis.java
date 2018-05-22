package stack;

public class MatchingCountSimpleParenthesis {

    /*
     * Implement this function without using Stacks
     * Assume that you only the parenthesis ( and )
     * are present
     * If the number of parenthesis is out of balance,
     * throw an exception
     * If it is balanced, return the max depth
     */
    public static int depthSimple(String mystring) throws Exception {
        char c;
        int count = 0;
        int max = 0;

        // Implement this method
        for(int i = 0; i < mystring.length(); i++) {
            if(mystring.charAt(i) == '(') {
                count++; max++;
            }else if(mystring.charAt(i) == ')') {
                count--;
            }
        }

        if(count < 0) throw new Exception("This string does not have balaced parenthesis");

        return max;
    }

    public static void main(String args[]) {
        /*
         * This main program should print:
         * (((2+3)/6)-4)*5) has no balanced parenthesis
         * Depth = 3
         * ((2+3)/6)-4)*5 has no balanced parenthesis
         */
        try {
            System.out.println("Depth = " + depthSimple("(((2+3)/6)-4)*5)"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Depth = " + depthSimple("(((2+3)/6)-4)*5"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Depth = " + depthSimple("((2+3)/6)-4)*5"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
