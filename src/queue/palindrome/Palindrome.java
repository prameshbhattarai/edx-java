package queue.palindrome;

public class Palindrome {

    public static void main(String[] args) {
        LinkedStack<Character> s = new LinkedStack<Character>();
        LinkedQueue<Character> q = new LinkedQueue<Character>();


        // Spanish example
        //Dabale arroz a la zorra el abad
        //char [] phrase = {'d','a','b','a','l','e','a','r','r','o','z','a','l','a','z','o','r','r','a','e','l','a','b','a','d'};

        // Was it a car or a cat I saw?
        char[] phrase = {'w', 'a', 's', 'i', 't', 'a', 'c', 'a', 'r', 'o', 'r', 'a', 'c', 'a', 't', 'i', 's', 'a', 'w'};

        // Init values in stack and queue
        for (int i = 0; i < phrase.length; i++) {
            s.push(phrase[i]);
            q.enqueue(phrase[i]);
        }

        boolean isPalindrome = true;
        char cStack;
        char cQueue;


        while ((isPalindrome) &&
                (!s.isEmpty()) &&
                (!q.isEmpty())
                ) {
            cStack = s.pop();
            cQueue = q.dequeue();
            isPalindrome = (cStack == cQueue);

        }

        System.out.println("Palindrome is: ..." + isPalindrome);
    }
}
