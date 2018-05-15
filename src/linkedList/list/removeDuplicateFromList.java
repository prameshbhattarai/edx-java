package linkedList.list;

import java.util.ArrayList;
import java.util.List;

public class removeDuplicateFromList {

    private static void printList(List<Integer> mine){
        for(Integer s : mine)
            System.out.print(s+" ");
        System.out.println();
    }
    private static List<Integer> createRandomList(int size, int max){
        List<Integer> result = new ArrayList<>();

        for (int i=0; i< size; i++){
            result.add( (int)( Math.random()*max));
        }
        return result;
    }
    /*
     * You should implement this function without resorting to use HashSet
     * and maintaining the order of the List
     */
    private static void removeDuplicates(List<Integer> mine){
        List<Integer> setOfList = new ArrayList<>();
        for (int i = 0; i < mine.size()-1; i++) {
            if(setOfList.indexOf(mine.get(i)) < 0) {
                setOfList.add(mine.get(i));
            }
        }
        mine.clear();
        mine.addAll(setOfList);
    }

    public static void main(String args[]){
        List<Integer> myList = createRandomList(10,5);
        printList(myList);
        //remove Duplicates from myList
        removeDuplicates(myList);
        printList(myList);
    }
}
